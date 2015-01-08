/**
 * 
 */
package fr.gfi.alan.delahaye.edition.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gfi.alan.delahaye.beans.EntreePerimetreBean;
import fr.gfi.alan.delahaye.beans.PerimetreBean;
import fr.gfi.alan.delahaye.core.manager.PerimetreManager;
import fr.gfi.alan.delahaye.edition.ExportExcel;
import fr.gfi.alan.delahaye.utils.FloatUtils;

/**
 * @author adelahaye
 *
 */
@Service
public class ExportExcelImpl implements ExportExcel {

	private Logger logger = LogManager.getLogger(ExportExcelImpl.class);

	@Autowired
	private PerimetreManager perimetreManager;

	private PerimetreBean perimetreBean;

	private float cumulConso;

	private float cumulPassage;

	private float tempsMoyenTraitement;

	private float rafImmediat;

	private float nombreMoyenCreation;

	private float rafProjection;

	private float variation;

	private int ratio;

	@Override
	public OutputStream exporterPerimetre(long idPerimetre) {
		perimetreBean = perimetreManager.recupererPerimetreComplet(idPerimetre);
		calculerDonnees();
		return creerDocument();
	}

	private OutputStream creerDocument() {
		Workbook wb;

		wb = new HSSFWorkbook();

		Map<String, CellStyle> styles = createStyles(wb);

		genereFeuilleTDB(wb,styles);
		genereFeuilleDetail(wb,styles);
		
		// Write the output to a file
		OutputStream out;
		try {
			out = new ByteArrayOutputStream();
			wb.write(out);
			out.flush();
			return out;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void genereFeuilleTDB(Workbook wb, Map<String, CellStyle> styles) {
		Sheet sheet = wb.createSheet("TDB Général");
		SheetConditionalFormatting scf = sheet.getSheetConditionalFormatting();
		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);

		// title row
		Row titleRow = sheet.createRow(0);
		titleRow.setHeightInPoints(45);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(perimetreBean.getNomPerimetre());
		titleCell.setCellStyle(styles.get("title"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$S$1"));

		// header row
		Row headerRow = sheet.createRow(2);
		Cell headerCell = headerRow.createCell(1);
		headerCell.setCellValue("SITUATION ACTUELLE");
		headerCell.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$3:$I$4"));
		setBoldBorder(CellRangeAddress.valueOf("$B$3:$I$4"), sheet, wb);

		Cell header2Cell = headerRow.createCell(12);
		header2Cell.setCellValue("PROJECTION");
		header2Cell.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$M$3:$R$4"));
		setBoldBorder(CellRangeAddress.valueOf("$M$3:$R$4"), sheet, wb);

		// Premiere ligne cartouche
		Row cartouche1Row = sheet.createRow(6);
		Cell cartouche1 = cartouche1Row.createCell(1);
		cartouche1.setCellValue("Charge Init. DEV");
		cartouche1.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$7:$B$8"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$B$7:$B$8"), sheet, wb);

		Cell cartouche1Data = cartouche1Row.createCell(2);
		cartouche1Data.setCellValue(perimetreBean.getChargeInitDeveloppement());
		cartouche1Data.setCellStyle(styles.get("dataInit"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$C$7:$C$8"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$C$7:$C$8"), sheet, wb);

		Cell cartouche2 = cartouche1Row.createCell(4);
		cartouche2.setCellValue("Ratio DEV/Ano");
		cartouche2.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$E$7:$E$8"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$E$7:$E$8"), sheet, wb);

		Cell cartouche2Data = cartouche1Row.createCell(5);
		cartouche2Data.setCellValue(ratio);
		cartouche2Data.setCellStyle(styles.get("success"));

		ConditionalFormattingRule cfrRatio = scf
				.createConditionalFormattingRule(
						CFRuleRecord.ComparisonOperator.GT,
						Integer.toString(perimetreBean.getRatioDevAnomalie()));
		PatternFormatting formattingRatio = cfrRatio.createPatternFormatting();
		formattingRatio.setFillBackgroundColor(IndexedColors.CORAL.getIndex());
		CellRangeAddress[] cellulleRatio = { CellRangeAddress.valueOf("$F$7") };
		scf.addConditionalFormatting(cellulleRatio, cfrRatio);

		sheet.addMergedRegion(CellRangeAddress.valueOf("$F$7:$F$8"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$F$7:$F$8"), sheet, wb);

		Cell cartouche3 = cartouche1Row.createCell(7);
		cartouche3.setCellValue("Nombre Moyen TRT");
		cartouche3.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$H$7:$H$8"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$H$7:$H$8"), sheet, wb);

		Cell cartouche3Data = cartouche1Row.createCell(8);
		cartouche3Data.setCellValue(FloatUtils.arrondir(tempsMoyenTraitement));
		cartouche3Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$I$7:$I$8"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$I$7:$I$8"), sheet, wb);

		Cell cartouche4 = cartouche1Row.createCell(12);
		cartouche4.setCellValue("Nombre Moyen CRE");
		cartouche4.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$M$7:$M$8"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$M$7:$M$8"), sheet, wb);

		Cell cartouche4Data = cartouche1Row.createCell(13);
		cartouche4Data.setCellValue(FloatUtils.arrondir(nombreMoyenCreation));
		cartouche4Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$N$7:$N$8"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$N$7:$N$8"), sheet, wb);

		Cell cartouche5 = cartouche1Row.createCell(15);
		cartouche5.setCellValue("RAF global Prév.");
		cartouche5.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$P$7:$P$8"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$P$7:$P$8"), sheet, wb);

		Cell cartouche5Data = cartouche1Row.createCell(16);
		// cartouche5Data.setCellValue(FloatUtils.arrondir(rafProjection));
		cartouche5Data.setCellFormula("(($N$7*$N$10)+$F$19)/$I$7");
		cartouche5Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$7:$Q$8"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$Q$7:$Q$8"), sheet, wb);

		// 2nd ligne cartouche
		Row cartouche2Row = sheet.createRow(9);
		Cell cartouche1L2 = cartouche2Row.createCell(1);
		cartouche1L2.setCellValue("Charge Init. RE7");
		cartouche1L2.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$10:$B$11"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$B$10:$B$11"), sheet,
				wb);

		Cell cartouche1L2Data = cartouche2Row.createCell(2);
		cartouche1L2Data.setCellValue(perimetreBean.getChargeRetourRecette());
		cartouche1L2Data.setCellStyle(styles.get("dataInit"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$C$10:$C$11"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$C$10:$C$11"), sheet,
				wb);

		Cell cartouche2L2 = cartouche2Row.createCell(4);
		cartouche2L2.setCellValue("Consommé");
		cartouche2L2.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$E$10:$E$11"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$E$10:$E$11"), sheet,
				wb);

		Cell cartouche2L2Data = cartouche2Row.createCell(5);
		cartouche2L2Data.setCellValue(FloatUtils.arrondir(cumulConso));
		cartouche2L2Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$F$10:$F$11"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$F$10:$F$11"), sheet,
				wb);

		Cell cartouche3L2 = cartouche2Row.createCell(7);
		cartouche3L2.setCellValue("RAF prév.");
		cartouche3L2.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$H$10:$H$11"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$H$10:$H$11"), sheet,
				wb);

		Cell cartouche3L2Data = cartouche2Row.createCell(8);
		// cartouche3L2Data.setCellValue(FloatUtils.arrondir(rafImmediat));
		cartouche3L2Data.setCellFormula("$F$19/$I$7");
		cartouche3L2Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$I$10:$I$11"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$I$10:$I$11"), sheet,
				wb);

		Cell cartouche4L2 = cartouche2Row.createCell(12);
		cartouche4L2.setCellValue("RAF RE7");
		cartouche4L2.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$M$10:$M$11"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$M$10:$M$11"), sheet,
				wb);

		Cell cartouche4L2Data = cartouche2Row.createCell(13);
		cartouche4L2Data.setCellValue(FloatUtils.arrondir(perimetreBean
				.getRafPassage()));
		cartouche4L2Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$N$10:$N$11"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$N$10:$N$11"), sheet,
				wb);

		Cell cartouche5L2 = cartouche2Row.createCell(15);
		cartouche5L2.setCellValue("Total");
		cartouche5L2.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$P$10:$P$11"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$P$10:$P$11"), sheet,
				wb);

		Cell cartouche5L2Data = cartouche2Row.createCell(16);
		// cartouche5L2Data.setCellValue(FloatUtils.arrondir(cumulConso +
		// rafProjection));
		cartouche5L2Data.setCellFormula("$F$10 + $Q$7");
		cartouche5L2Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$10:$Q$11"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$Q$10:$Q$11"), sheet,
				wb);

		// 3rd ligne cartouche
		Row cartouche3Row = sheet.createRow(12);
		Cell cartouche1L3 = cartouche3Row.createCell(1);
		cartouche1L3.setCellValue("Nombre Max Ano");
		cartouche1L3.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$13:$B$14"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$B$13:$B$14"), sheet,
				wb);

		Cell cartouche1L3Data = cartouche3Row.createCell(2);
		cartouche1L3Data.setCellValue((int) ((perimetreBean
				.getChargeInitDeveloppement() * perimetreBean
				.getRatioDevAnomalie()) / 100));
		cartouche1L3Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$C$13:$C$14"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$C$13:$C$14"), sheet,
				wb);

		Cell cartouche2L3 = cartouche3Row.createCell(4);
		cartouche2L3.setCellValue("Nombre total Ano");
		cartouche2L3.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$E$13:$E$14"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$E$13:$E$14"), sheet,
				wb);

		Cell cartouche2L3Data = cartouche3Row.createCell(5);
		cartouche2L3Data.setCellValue(perimetreBean.getNombreAnoSansRegul());
		cartouche2L3Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$F$13:$F$14"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$F$13:$F$14"), sheet,
				wb);

		Cell cartouche5L3 = cartouche3Row.createCell(15);
		cartouche5L3.setCellValue("Variation");
		cartouche5L3.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$P$13:$P$14"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$P$13:$P$14"), sheet,
				wb);

		Cell cartouche5L3Data = cartouche3Row.createCell(16);
		// cartouche5L3Data.setCellValue(FloatUtils.arrondir(variation));
		cartouche5L3Data.setCellFormula("$Q$10 - $C$10");
		cartouche5L3Data.setCellStyle(styles.get("success"));

		ConditionalFormattingRule cfrVariation = scf
				.createConditionalFormattingRule(
						CFRuleRecord.ComparisonOperator.GT, "0");
		PatternFormatting formattingVariation = cfrVariation
				.createPatternFormatting();
		formattingVariation.setFillBackgroundColor(IndexedColors.CORAL
				.getIndex());
		CellRangeAddress[] cellulleVariation = { CellRangeAddress
				.valueOf("$Q$13") };
		scf.addConditionalFormatting(cellulleVariation, cfrVariation);

		sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$13:$Q$14"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$Q$13:$Q$14"), sheet,
				wb);

		// 4th ligne cartouche
		Row cartouche4Row = sheet.createRow(15);

		Cell cartouche2L4 = cartouche4Row.createCell(4);
		cartouche2L4.setCellValue("Nombre total Ano (Régul)");
		cartouche2L4.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$E$16:$E$17"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$E$16:$E$17"), sheet,
				wb);

		Cell cartouche2L4Data = cartouche4Row.createCell(5);
		cartouche2L4Data.setCellValue(perimetreBean.getNombreAnoTotal());
		cartouche2L4Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$F$16:$F$17"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$F$16:$F$17"), sheet,
				wb);

		// 5th ligne cartouche
		Row cartouche5Row = sheet.createRow(18);

		Cell cartouche2L5 = cartouche5Row.createCell(4);
		cartouche2L5.setCellValue("Stock actuel");
		cartouche2L5.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$E$19:$E$20"));
		setBoldBorderThinRight(CellRangeAddress.valueOf("$E$19:$E$20"), sheet,
				wb);

		Cell cartouche2L5Data = cartouche5Row.createCell(5);
		cartouche2L5Data.setCellValue(perimetreBean.getNombreAnoTotal()
				- perimetreBean.getNombreAnoCorrigee());
		cartouche2L5Data.setCellStyle(styles.get("header"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$F$19:$F$20"));
		setBoldBorderThinLeft(CellRangeAddress.valueOf("$F$19:$F$20"), sheet,
				wb);

		miseEnPage(sheet);

		Map<Integer, List<Integer>> cellules = getCellulesFondTdb();
		setBackground(sheet, styles, cellules);
	}

	private void genereFeuilleDetail(Workbook wb, Map<String, CellStyle> styles) {
		Sheet sheet = wb.createSheet("Détails");
		SheetConditionalFormatting scf = sheet.getSheetConditionalFormatting();
		PrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		sheet.setFitToPage(true);
		sheet.setHorizontallyCenter(true);

		// title row
		Row titleRow = sheet.createRow(0);
		titleRow.setHeightInPoints(45);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(perimetreBean.getNomPerimetre());
		titleCell.setCellStyle(styles.get("title"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$S$1"));

		// header row
		Row headerRow = sheet.createRow(2);
		Cell headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Date");
		headerCell.setCellStyle(styles.get("headerTab"));

		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("Stock init.");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("Retour KO");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(4);
		headerCell.setCellValue("Création");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(5);
		headerCell.setCellValue("Corrigée");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(6);
		headerCell.setCellValue("Cloturée");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(7);
		headerCell.setCellValue("Charge");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(8);
		headerCell.setCellValue("Stock final");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(10);
		headerCell.setCellValue("Variation");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		headerCell = headerRow.createCell(12);
		headerCell.setCellValue("Charge passage");
		headerCell.setCellStyle(styles.get("headerTab"));
		
		if(perimetreBean.getContenu() != null){
			int indexLigne = 3;
			for(EntreePerimetreBean entreePerimetreBean : perimetreBean.getContenu()){
				Row dataLigne = sheet.createRow(indexLigne);
				Cell dataCell = dataLigne.createCell(1);
				String templateSuffix = "impaire";
				if((indexLigne%2) == 0){
					templateSuffix = "paire";
				}
				indexLigne ++;

				dataCell.setCellValue(entreePerimetreBean.getDateSaisie());
				dataCell.setCellStyle(styles.get("dateFormat"+templateSuffix));

				dataCell = dataLigne.createCell(2);
				dataCell.setCellValue(entreePerimetreBean.getStockInitial());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(3);
				dataCell.setCellValue(entreePerimetreBean.getNombreRetourKO());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(4);
				dataCell.setCellValue(entreePerimetreBean.getNombreCreation());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(5);
				dataCell.setCellValue(entreePerimetreBean.getNombreCorrection());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(6);
				dataCell.setCellValue(entreePerimetreBean.getNombreCloture());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(7);
				dataCell.setCellValue(entreePerimetreBean.getChargeTraitement());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(8);
				dataCell.setCellValue(entreePerimetreBean.getStockFinal());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(10);
//				dataCell.setCellValue(entreePerimetreBean.getVariation());
				dataCell.setCellFormula("$I$"+indexLigne+"-$C$"+indexLigne);
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
				dataCell = dataLigne.createCell(12);
				dataCell.setCellValue(entreePerimetreBean.getChargeRecette());
				dataCell.setCellStyle(styles.get("data"+templateSuffix));
				
			}
			setBoldBorder(CellRangeAddress.valueOf("$B$4:$I$"+indexLigne), sheet,
				wb);
			setBoldBorder(CellRangeAddress.valueOf("$K$4:$K$"+indexLigne), sheet,
					wb);
			setBoldBorder(CellRangeAddress.valueOf("$M$4:$M$"+indexLigne), sheet,
					wb);
			// Total
			Row dataLigne = sheet.createRow(indexLigne);
			indexLigne++;
			Cell dataCell = dataLigne.createCell(1);
			dataCell.setCellValue("Total");
			dataCell.setCellStyle(styles.get("headerTab"));
			sheet.addMergedRegion(CellRangeAddress.valueOf("$B$"+indexLigne+":$C$"+indexLigne));
			setBoldBorderThinRight(CellRangeAddress.valueOf("$B$"+indexLigne+":$C$"+indexLigne), sheet,
					wb);
			
			dataCell = dataLigne.createCell(3);
			dataCell.setCellFormula("SUM($D$4:$D$"+(indexLigne-1)+")");
			dataCell.setCellStyle(styles.get("dataimpaire"));
			
			dataCell = dataLigne.createCell(4);
			dataCell.setCellFormula("SUM($E$4:$E$"+(indexLigne-1)+")");
			dataCell.setCellStyle(styles.get("dataimpaire"));
			
			dataCell = dataLigne.createCell(5);
			dataCell.setCellFormula("SUM($F$4:$F$"+(indexLigne-1)+")");
			dataCell.setCellStyle(styles.get("dataimpaire"));
			
			dataCell = dataLigne.createCell(6);
			dataCell.setCellFormula("SUM($G$4:$G$"+(indexLigne-1)+")");
			dataCell.setCellStyle(styles.get("dataimpaire"));
			
			dataCell = dataLigne.createCell(7);
			dataCell.setCellFormula("SUM($H$4:$H$"+(indexLigne-1)+")");
			dataCell.setCellStyle(styles.get("dataimpaire"));
			
			dataCell = dataLigne.createCell(12);
			dataCell.setCellFormula("SUM($M$4:$M$"+(indexLigne-1)+")");
			dataCell.setCellStyle(styles.get("dataimpaire"));
			
			setBoldBorderThinLeft(CellRangeAddress.valueOf("$D$"+indexLigne+":$H$"+indexLigne), sheet,
					wb);
			setBoldBorder(CellRangeAddress.valueOf("$M$"+indexLigne+":$M$"+indexLigne), sheet,
					wb);
			
		}
	}
	
	private void calculerDonnees() {
		cumulConso = 0;
		cumulPassage = 0;

		if (perimetreBean.getContenu() != null) {
			for (EntreePerimetreBean bean : perimetreBean.getContenu()) {
				cumulConso = cumulConso + bean.getChargeTraitement();
				cumulPassage = cumulPassage + bean.getChargeRecette();
			}
		}
		tempsMoyenTraitement = perimetreBean.getNombreAnoCorrigee()
				/ cumulConso;
		logger.warn("Temps Moyen de traitement = "
				+ perimetreBean.getNombreAnoCorrigee() + "/" + cumulConso
				+ " = " + tempsMoyenTraitement);

		rafImmediat = (perimetreBean.getNombreAnoTotal() - perimetreBean
				.getNombreAnoCorrigee()) / tempsMoyenTraitement;
		logger.warn("RAF immediat = " + "(" + perimetreBean.getNombreAnoTotal()
				+ "-" + perimetreBean.getNombreAnoCorrigee() + ") / "
				+ tempsMoyenTraitement + " = " + rafImmediat);

		nombreMoyenCreation = perimetreBean.getNombreAnoTotal() / cumulPassage;
		logger.warn("Nombre moyen création = "
				+ perimetreBean.getNombreAnoTotal() + "/" + cumulPassage
				+ " = " + nombreMoyenCreation);

		float anomaliesAVenir = perimetreBean.getRafPassage()
				* nombreMoyenCreation;
		logger.warn("Nombre anomalies à venir = "
				+ perimetreBean.getRafPassage() + "*" + nombreMoyenCreation
				+ " = " + anomaliesAVenir);

		rafProjection = ((perimetreBean.getNombreAnoTotal() - perimetreBean
				.getNombreAnoCorrigee()) + anomaliesAVenir)
				/ tempsMoyenTraitement;
		logger.warn("Raf Projection = " + "(("
				+ perimetreBean.getNombreAnoTotal() + "-"
				+ perimetreBean.getNombreAnoCorrigee() + ") +"
				+ anomaliesAVenir + ")" + "/" + tempsMoyenTraitement + " = "
				+ rafProjection);

		variation = (cumulConso + rafProjection)
				- perimetreBean.getChargeRetourRecette();

		ratio = (int) ((perimetreBean.getNombreAnoTotal() * 100) / perimetreBean
				.getChargeInitDeveloppement());
		logger.warn("Ratio = " + "((" + perimetreBean.getNombreAnoTotal()
				+ "* 100) / " + perimetreBean.getChargeInitDeveloppement()
				+ ") = " + ratio);
	}

	private static void setBoldBorder(CellRangeAddress cellRangeAddress,
			Sheet sheet, Workbook wb) {
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
	}

	private static void setBoldBorderThinLeft(
			CellRangeAddress cellRangeAddress, Sheet sheet, Workbook wb) {
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
	}

	private static void setBoldBorderThinRight(
			CellRangeAddress cellRangeAddress, Sheet sheet, Workbook wb) {
		RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
		RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, cellRangeAddress,
				sheet, wb);
	}

	private static void miseEnPage(Sheet sheet) {
		// Bordure des tdb
		sheet.setColumnWidth(0, 2 * 256);
		sheet.setColumnWidth(9, 2 * 256);
		sheet.setColumnWidth(11, 2 * 256);
		sheet.setColumnWidth(18, 2 * 256);

		// Entre tableau
		sheet.setColumnWidth(10, (int) (2.5 * 256));

		// Entete cartouche 1 4 7 12 15
		sheet.setColumnWidth(1, 12 * 256);
		sheet.setColumnWidth(4, 12 * 256);
		sheet.setColumnWidth(7, 12 * 256);
		sheet.setColumnWidth(12, 12 * 256);
		sheet.setColumnWidth(15, 12 * 256);

		// Valeur cartouche 2 5 8 13 16
		sheet.setColumnWidth(2, 9 * 256);
		sheet.setColumnWidth(5, 9 * 256);
		sheet.setColumnWidth(8, 9 * 256);
		sheet.setColumnWidth(13, 9 * 256);
		sheet.setColumnWidth(16, 9 * 256);
	}

	private static Map<Integer, List<Integer>> getCellulesFondTdb() {
		Map<Integer, List<Integer>> cellules = new HashMap<Integer, List<Integer>>();
		// Lig 1
		List<Integer> cels = new ArrayList<Integer>();
		for (int i = 0; i <= 18; i++) {
			cels.add(i);
		}
		cels.remove(10);
		cellules.put(1, cels);

		// Lig 4 5 8 11 14 17 20
		cellules.put(4, cels);
		cellules.put(5, cels);
		cellules.put(8, cels);
		cellules.put(11, cels);
		cellules.put(14, cels);
		cellules.put(17, cels);
		cellules.put(20, cels);

		// Lig 2
		cels = new ArrayList<Integer>();
		cels.add(0);
		cels.add(9);
		cels.add(11);
		cels.add(18);
		cellules.put(2, cels);
		// Lig 3
		cellules.put(3, cels);

		// Lig 6
		cels = new ArrayList<Integer>();
		cels.add(0);
		cels.add(3);
		cels.add(6);
		cels.add(9);
		cels.add(11);
		cels.add(14);
		cels.add(17);
		cels.add(18);
		cellules.put(6, cels);

		// Lig 7 9 10
		cellules.put(7, cels);
		cellules.put(9, cels);
		cellules.put(10, cels);

		// Lig 12 13
		cels = new ArrayList<Integer>();
		cels.add(0);
		cels.add(3);
		cels.add(6);
		cels.add(9);
		cels.add(11);
		cels.add(14);
		cels.add(17);
		cels.add(18);
		cels.add(7);
		cels.add(8);
		cels.add(12);
		cels.add(13);
		cellules.put(12, cels);
		cellules.put(13, cels);

		// Lig 15 16 18 19
		cels = new ArrayList<Integer>();
		cels.add(0);
		cels.add(3);
		cels.add(6);
		cels.add(9);
		cels.add(11);
		cels.add(14);
		cels.add(17);
		cels.add(18);
		cels.add(7);
		cels.add(8);
		cels.add(12);
		cels.add(13);
		cels.add(1);
		cels.add(2);
		cels.add(15);
		cels.add(16);
		cellules.put(15, cels);
		cellules.put(16, cels);
		cellules.put(18, cels);
		cellules.put(19, cels);

		return cellules;
	}

	private static void setBackground(Sheet sheet,
			Map<String, CellStyle> styles, Map<Integer, List<Integer>> cellules) {
		for (int i : cellules.keySet()) {
			Row rowFondTdb = sheet.getRow(i);
			if (rowFondTdb == null) {
				rowFondTdb = sheet.createRow(i);
			}
			for (int j : cellules.get(i)) {
				Cell cellFondTdb = rowFondTdb.getCell(j);
				if (cellFondTdb == null) {
					cellFondTdb = rowFondTdb.createCell(j);
				}
				cellFondTdb.setCellStyle(styles.get("fondTDB"));
			}
		}
	}

	/**
	 * Create a library of cell styles
	 */
	private static Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		CellStyle style;
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 18);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFont(titleFont);
		styles.put("title", style);

		Font boldFont = wb.createFont();
		boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		DataFormat dataFormat = wb.createDataFormat();
		
		style = wb.createCellStyle();
		style.setWrapText(true);
		style.setDataFormat(dataFormat.getFormat("dd/mm/yy"));
		styles.put("dateFormatimpaire", style);
		
		style = wb.createCellStyle();
		style.setWrapText(true);
		styles.put("dataimpaire", style);
		
		style = wb.createCellStyle();
		style.setWrapText(true);
		style.setDataFormat(dataFormat.getFormat("dd/mm/yy"));
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styles.put("dateFormatpaire", style);
		
		style = wb.createCellStyle();
		style.setWrapText(true);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styles.put("datapaire", style);

		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(boldFont);
		style.setWrapText(true);
		styles.put("header", style);
		
		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_MEDIUM);
		style.setBorderTop(CellStyle.BORDER_MEDIUM);
		style.setBorderLeft(CellStyle.BORDER_MEDIUM);
		style.setBorderRight(CellStyle.BORDER_MEDIUM);
		style.setFont(boldFont);
		style.setWrapText(true);
		styles.put("headerTab", style);

		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.TURQUOISE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(boldFont);
		style.setWrapText(true);
		styles.put("dataInit", style);

		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.CORAL.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(boldFont);
		style.setWrapText(true);
		styles.put("warn", style);

		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(boldFont);
		style.setWrapText(true);
		styles.put("success", style);

		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		styles.put("fondTDB", style);

		return styles;
	}
}
