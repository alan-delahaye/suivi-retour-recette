/**
 * 
 */
package fr.gfi.alan.delahaye.edition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 







import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test { 

 private static final String[] titles = {
         "Person",	"ID", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun",
         "Total\nHrs", "Overtime\nHrs", "Regular\nHrs"
 };

 private static Object[][] sample_data = {
         {"Yegor Kozlov", "YK", 5.0, 8.0, 10.0, 5.0, 5.0, 7.0, 6.0},
         {"Gisella Bronzetti", "GB", 4.0, 3.0, 1.0, 3.5, null, null, 4.0},
 };

public static void main(String[] args) throws Exception {
//    Workbook wb;
//
//     wb = new HSSFWorkbook();
//
//    Map<String, CellStyle> styles = createStyles(wb);
//
//    Sheet sheet = wb.createSheet("Timesheet");
//    PrintSetup printSetup = sheet.getPrintSetup();
//    printSetup.setLandscape(true);
//    sheet.setFitToPage(true);
//    sheet.setHorizontallyCenter(true);
//
//    //title row
//    Row titleRow = sheet.createRow(0);
//    titleRow.setHeightInPoints(45);
//    Cell titleCell = titleRow.createCell(0);
//    titleCell.setCellValue("Weekly Timesheet");
//    titleCell.setCellStyle(styles.get("title"));
//    sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$L$1"));
//
//    //header row
//    Row headerRow = sheet.createRow(1);
//    headerRow.setHeightInPoints(40);
//    Cell headerCell;
//    for (int i = 0; i < titles.length; i++) {
//        headerCell = headerRow.createCell(i);
//        headerCell.setCellValue(titles[i]);
//        headerCell.setCellStyle(styles.get("header"));
//    }
//
//    int rownum = 2;
//    for (int i = 0; i < 10; i++) {
//        Row row = sheet.createRow(rownum++);
//        for (int j = 0; j < titles.length; j++) {
//            Cell cell = row.createCell(j);
//            if(j == 9){
//                //the 10th cell contains sum over week days, e.g. SUM(C3:I3)
//                String ref = "C" +rownum+ ":I" + rownum;
//                cell.setCellFormula("SUM("+ref+")");
//                cell.setCellStyle(styles.get("formula"));
//            } else if (j == 11){
//                cell.setCellFormula("J" +rownum+ "-K" + rownum);
//                cell.setCellStyle(styles.get("formula"));
//            } else {
//                cell.setCellStyle(styles.get("cell"));
//            }
//        }
//    }
//
//    //row with totals below
//    Row sumRow = sheet.createRow(rownum++);
//    sumRow.setHeightInPoints(35);
//    Cell cell;
//    cell = sumRow.createCell(0);
//    cell.setCellStyle(styles.get("formula"));
//    cell = sumRow.createCell(1);
//    cell.setCellValue("Total Hrs:");
//    cell.setCellStyle(styles.get("formula"));
//
//    for (int j = 2; j < 12; j++) {
//        cell = sumRow.createCell(j);
//        String ref = (char)('A' + j) + "3:" + (char)('A' + j) + "12";
//        cell.setCellFormula("SUM(" + ref + ")");
//        if(j >= 9) cell.setCellStyle(styles.get("formula_2"));
//        else cell.setCellStyle(styles.get("formula"));
//    }
//    rownum++;
//    sumRow = sheet.createRow(rownum++);
//    sumRow.setHeightInPoints(25);
//    cell = sumRow.createCell(0);
//    cell.setCellValue("Total Regular Hours");
//    cell.setCellStyle(styles.get("formula"));
//    cell = sumRow.createCell(1);
//    cell.setCellFormula("L13");
//    cell.setCellStyle(styles.get("formula_2"));
//    sumRow = sheet.createRow(rownum++);
//    sumRow.setHeightInPoints(25);
//    cell = sumRow.createCell(0);
//    cell.setCellValue("Total Overtime Hours");
//    cell.setCellStyle(styles.get("formula"));
//    cell = sumRow.createCell(1);
//    cell.setCellFormula("K13");
//    cell.setCellStyle(styles.get("formula_2"));
//
//    //set sample data
//    for (int i = 0; i < sample_data.length; i++) {
//        Row row = sheet.getRow(2 + i);
//        for (int j = 0; j < sample_data[i].length; j++) {
//            if(sample_data[i][j] == null) continue;
//
//            if(sample_data[i][j] instanceof String) {
//                row.getCell(j).setCellValue((String)sample_data[i][j]);
//            } else {
//                row.getCell(j).setCellValue((Double)sample_data[i][j]);
//            }
//        }
//    }
//
//    //finally set column widths, the width is measured in units of 1/256th of a character width
//    sheet.setColumnWidth(0, 30*256); //30 characters wide
//    for (int i = 2; i < 9; i++) {
//        sheet.setColumnWidth(i, 6*256);  //6 characters wide
//    }
//    sheet.setColumnWidth(10, 10*256); //10 characters wide
//
//    // Write the output to a file
//    String file = "C:/timesheet-2.xls";
//    FileOutputStream out = new FileOutputStream(file);
//    wb.write(out);
//    out.close();
	
	  Workbook wb;

	     wb = new HSSFWorkbook();

	    Map<String, CellStyle> styles = createStyles(wb);

	    Sheet sheet = wb.createSheet("TDB Général");
	    PrintSetup printSetup = sheet.getPrintSetup();
	    printSetup.setLandscape(true);
	    sheet.setFitToPage(true);
	    sheet.setHorizontallyCenter(true);

	    //title row
	    Row titleRow = sheet.createRow(0);
	    titleRow.setHeightInPoints(45);
	    Cell titleCell = titleRow.createCell(0);
	    titleCell.setCellValue("Lot 3 P3");
	    titleCell.setCellStyle(styles.get("title"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$S$1"));
	    
	    //header row
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

	    //Premiere ligne cartouche 
	    Row cartouche1Row = sheet.createRow(6);
	    Cell cartouche1 = cartouche1Row.createCell(1);
	    cartouche1.setCellValue("Charge Init. DEV");
	    cartouche1.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$B$7:$B$8"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$B$7:$B$8"), sheet, wb);

	    Cell cartouche2 = cartouche1Row.createCell(4);
	    cartouche2.setCellValue("Ratio DEV/Ano");
	    cartouche2.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$E$7:$E$8"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$E$7:$E$8"), sheet, wb);
	    
	    Cell cartouche3 = cartouche1Row.createCell(7);
	    cartouche3.setCellValue("Nombre Moyen TRT");
	    cartouche3.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$H$7:$H$8"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$H$7:$H$8"), sheet, wb);
	    
	    Cell cartouche4 = cartouche1Row.createCell(12);
	    cartouche4.setCellValue("Nombre Moyen CRE");
	    cartouche4.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$M$7:$M$8"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$M$7:$M$8"), sheet, wb);
	    
	    Cell cartouche5 = cartouche1Row.createCell(15);
	    cartouche5.setCellValue("RAF global Prév.");
	    cartouche5.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$P$7:$P$8"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$P$7:$P$8"), sheet, wb);
	    
	  //2nd ligne cartouche 
	    Row cartouche2Row = sheet.createRow(9);
	    Cell cartouche1L2 = cartouche2Row.createCell(1);
	    cartouche1L2.setCellValue("Charge Init. RE7");
	    cartouche1L2.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$B$10:$B$11"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$B$10:$B$11"), sheet, wb);

	    Cell cartouche2L2 = cartouche2Row.createCell(4);
	    cartouche2L2.setCellValue("Consommé");
	    cartouche2L2.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$E$10:$E$11"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$E$10:$E$11"), sheet, wb);
	    
	    Cell cartouche3L2 = cartouche2Row.createCell(7);
	    cartouche3L2.setCellValue("RAF prév.");
	    cartouche3L2.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$H$10:$H$11"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$H$10:$H$11"), sheet, wb);
	    
	    Cell cartouche4L2 = cartouche2Row.createCell(12);
	    cartouche4L2.setCellValue("RAF RE7");
	    cartouche4L2.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$M$10:$M$11"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$M$10:$M$11"), sheet, wb);
	    
	    Cell cartouche5L2 = cartouche2Row.createCell(15);
	    cartouche5L2.setCellValue("Total");
	    cartouche5L2.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$P$10:$P$11"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$P$10:$P$11"), sheet, wb);
	    
	    //3rd ligne cartouche 
	    Row cartouche3Row = sheet.createRow(12);
	    Cell cartouche1L3 = cartouche3Row.createCell(1);
	    cartouche1L3.setCellValue("Nombre Max Ano");
	    cartouche1L3.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$B$13:$B$14"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$B$13:$B$14"), sheet, wb);
	    
	    Cell cartouche2L3 = cartouche3Row.createCell(4);
	    cartouche2L3.setCellValue("Nombre total Ano");
	    cartouche2L3.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$E$13:$E$14"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$E$13:$E$14"), sheet, wb);
	    
	    Cell cartouche5L3 = cartouche3Row.createCell(15);
	    cartouche5L3.setCellValue("Variation");
	    cartouche5L3.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$P$13:$P$14"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$P$13:$P$14"), sheet, wb);
	    
	    //4th ligne cartouche 
	    Row cartouche4Row = sheet.createRow(15);
	    
	    Cell cartouche2L4 = cartouche4Row.createCell(4);
	    cartouche2L4.setCellValue("Nombre total Ano (Régul)");
	    cartouche2L4.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$E$16:$E$17"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$E$16:$E$17"), sheet, wb);
	    
	    //5th ligne cartouche 
	    Row cartouche5Row = sheet.createRow(18);
	    
	    Cell cartouche2L5 = cartouche5Row.createCell(4);
	    cartouche2L5.setCellValue("Stock actuel");
	    cartouche2L5.setCellStyle(styles.get("header"));
	    sheet.addMergedRegion(CellRangeAddress.valueOf("$E$19:$E$20"));
	    setBoldBorderThinRight(CellRangeAddress.valueOf("$E$19:$E$20"), sheet, wb);

	    miseEnPage(sheet);
	    
	    Map<Integer, List<Integer>> cellules = getCellulesFondTdb();
	    setBackground(sheet, styles, cellules);
	    
	    // Write the output to a file
	    String file = "C:/timesheet-1.xls";
	    FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			wb.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
}

private static void setBoldBorder(CellRangeAddress cellRangeAddress, Sheet sheet, Workbook wb){
	RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
}

private static void setBoldBorderThinLeft(CellRangeAddress cellRangeAddress, Sheet sheet, Workbook wb){
	RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderRight(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
}

private static void setBoldBorderThinRight(CellRangeAddress cellRangeAddress, Sheet sheet, Workbook wb){
	RegionUtil.setBorderLeft(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderRight(CellStyle.BORDER_THIN, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderTop(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
	RegionUtil.setBorderBottom(CellStyle.BORDER_MEDIUM, cellRangeAddress, sheet, wb);
}

private static void miseEnPage(Sheet sheet){
    // Bordure des tdb
    sheet.setColumnWidth(0, 2*256);
    sheet.setColumnWidth(9, 2*256); 
    sheet.setColumnWidth(11, 2*256); 
    sheet.setColumnWidth(18, 2*256);
    
    // Entre tableau
    sheet.setColumnWidth(10,(int)(2.5*256));
    
    // Entete cartouche 1 4 7 12 15
    sheet.setColumnWidth(1,12*256);
    sheet.setColumnWidth(4,12*256);
    sheet.setColumnWidth(7,12*256);
    sheet.setColumnWidth(12,12*256);
    sheet.setColumnWidth(15,12*256);
    
    // Valeur cartouche 2 5 8 13 16
    sheet.setColumnWidth(2,9*256);
    sheet.setColumnWidth(5,9*256);
    sheet.setColumnWidth(8,9*256);
    sheet.setColumnWidth(13,9*256);
    sheet.setColumnWidth(16,9*256);
}

private static Map<Integer, List<Integer>> getCellulesFondTdb() {
	 Map<Integer, List<Integer>> cellules = new HashMap<Integer, List<Integer>>();
	 // Lig 1
	 List<Integer> cels = new ArrayList<Integer>();
	 for(int i = 0; i<=18; i++){
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

private static void setBackground(Sheet sheet,  Map<String, CellStyle> styles,Map<Integer, List<Integer>> cellules){
	for(int i : cellules.keySet()){
		Row rowFondTdb = sheet.getRow(i);
	    if(rowFondTdb == null){
	    	rowFondTdb = sheet.createRow(i);
	    }
	    for(int j : cellules.get(i)){
	    	Cell cellFondTdb = rowFondTdb.getCell(j);
	    	if(cellFondTdb == null){
	    		cellFondTdb = rowFondTdb.createCell(j);
	    	}
	    	cellFondTdb.setCellStyle(styles.get("fondTDB"));
	    }
	}
}

/**
 * Create a library of cell styles
 */
private static Map<String, CellStyle> createStyles(Workbook wb){
    Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
    CellStyle style;
    Font titleFont = wb.createFont();
    titleFont.setFontHeightInPoints((short)18);
    titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
    style = wb.createCellStyle();
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    style.setFont(titleFont);
    styles.put("title", style);

    style = wb.createCellStyle();
    Font headerFont = wb.createFont();
    headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
    style.setFont(headerFont);
    style.setWrapText(true);
    styles.put("header", style);

    style = wb.createCellStyle();
    style.setAlignment(CellStyle.ALIGN_CENTER);
    style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
    styles.put("fondTDB", style);

    return styles;
 }
}

