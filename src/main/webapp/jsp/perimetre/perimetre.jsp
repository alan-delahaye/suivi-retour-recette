<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="gore" tagdir="/WEB-INF/tags/"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Périmètre</title>
<s:head />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="lineicons/style.css">
<link href="css/morris.css" rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">

<script src="js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<gore:urls />
</head>

<body>
	<section id="container"> 
	
	<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<gore:header />
	<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<gore:menu elementMenu="perimetre" />
	
	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> 
	<section id="main-content"> <section
		class="wrapper">

	<div class="row">
		<div class="col-lg-9 main-chart" style="margin-top:5%;">

			<div class="row mtbox">
				<div class="showback" style="text-align: center;">
					<h4>
						<i class="fa fa-angle-right"></i> Choix du périmètre
					</h4>
					<div class="btn-group">
						<button type="button" class="btn btn-theme03">Choisir un
							périmètre</button>
					<!-- Split button -->
						<button type="button" class="btn btn-theme03 dropdown-toggle"
							data-toggle="dropdown">
							<span class="caret"></span> <span class="sr-only">Toggle
								Dropdown</span>
						</button>
						<ul class="dropdown-menu" role="menu">

				<s:iterator value="lesPerimetre">
					<s:url id="perimetreAAfficher" action="perimetre">  
          				<s:param name="idPerimetre" value="%{idPerimetre}" />  
       				</s:url> 
					<li><a href="${perimetreAAfficher}"><s:property value="nomPerimetre" /></a></li>
					<!-- <li class="divider"></li> -->
				</s:iterator>
						</ul>
					</div>
				</div>
			</div>
			
			<s:if test="perimetreBean.idPerimetre > 0">
				<div class="row">
					<s:url id="fileDownload" namespace="/" action="download" >  
          				<s:param name="idPerimetre" value="perimetreBean.idPerimetre" />  
       				</s:url> 				
					<h1 style="text-align:center;">${perimetreBean.nomPerimetre} <a href="${fileDownload}"><button class="fa fa-download" style="color:darkorange;"></button></a></h1>
					<!-- TWITTER PANEL -->
					<div class="col-md-4 mb">
						<div class="darkblue-panel pn">
							<div class="darkblue-header">
								<h5>RAF Passage recette</h5>
							</div>
							<canvas id="rafPassageRecette" height="120" width="120"></canvas>
							<p>.</p>
							<footer>
							<div class="pull-left">
								<h5>
									<i class="fa fa-map-marker"></i> ${perimetreBean.rafPassage} / ${perimetreBean.chargePassageRecette} j.h
								</h5>
							</div>
							<div class="pull-right">
								<h5>${perimetreBean.avancement}% Terminé</h5>
							</div>
							</footer>
						</div>
						<!-- /darkblue panel -->
					</div>
					<!-- /col-md-4 -->
	
	
					<div class="col-md-4 col-sm-4 mb">
						<!-- REVENUE PANEL -->
						<div class="darkblue-panel pn">
							<div class="darkblue-header">
								<h5>Tendances journalière</h5>
							</div>
							<div id="gore-tendance-journaliere-area" class="graph" style="width:390px; height:200px;"></div>
						</div>
					</div>
					<!-- /col-md-4 -->
					
					<div class="col-md-4 mb">
						<div class="darkblue-panel pn">
							<div class="darkblue-header">
								<h5>Stock actuel</h5>
							</div>
							<canvas id="stockActuel" height="120" width="120"></canvas>
							<p>.</p>
							<footer>
							<div class="pull-left">
								<h5>
									<i class="fa fa-map-marker"></i> ${perimetreBean.nombreAnoCorrigee} / ${perimetreBean.nombreAnoTotal} anomalie(s)
								</h5>
							</div>
							<div class="pull-right">
								<h5>${perimetreBean.nombreAnoTotal - perimetreBean.nombreAnoCorrigee}</h5>
							</div>
							</footer>
						</div>
						<!-- /darkblue panel -->
					</div>
	
					<div class="col-md-4 col-sm-4 mb">
						<!-- REVENUE PANEL -->
						<div class="darkblue-panel pn">
							<div class="darkblue-header">
								<h5>Statistiques</h5>
							</div><br /><br />
							<h5 style="font-weight:700;">Nombre d'anomalies créées (par jour) : ${nombreMoyenTraitement} anomalie(s)</h5>
							<h5 style="font-weight:700;">Nombre d'anomalies corrigées (par jour) : ${nombreMoyenCreation} anomalie(s)</h5>
							<h5 style="font-weight:700;">Ratio DEV/Anomalies : 
							<s:if test="ratioDevAnomalie > perimetreBean.ratioDevAnomalie">
								<span style="color:#FF6C60">${ratioDevAnomalie} %</span>
							<s:else>
								${ratioDevAnomalie} %
							</s:else>
							</s:if>
							
							</h5>
						</div>
					</div>
					<!-- /col-md-4 -->
					
					<div class="col-md-4 col-sm-4 mb">
						<div class="steps pn">
						    <input type='submit' value='Projection' id='submit'/>
						    <label>RAF (immédiat) : ${rafImmediat} j.h</label>
						    <label>RAF (projection) : ${rafProjection} j.h</label>
						    <label>Variation : 
						    <s:if test="variationCharge > 0">
								<span style="color:#FF6C60">${variationCharge} j.h</span>
							</s:if>
							<s:if test="variationCharge < 0">
								<span style="color:#A9D86E">${variationCharge} j.h</span>
							</s:if>
							<s:if test="variationCharge == 0">
								<span>${variationCharge} j.h</span>
							</s:if>
						    </label>
						</div>
					</div>
					<!-- /col-md-4 -->
					
					<div class="col-md-4 col-sm-4 mb">
						<!-- REVENUE PANEL -->
						<div class="darkblue-panel pn">
							<div class="darkblue-header">
								<h5>Evolution de la charge</h5>
							</div>
							<div id="gore-evolution-charge-area" class="graph" style="width:390px; height:200px;"></div>
						</div>
					</div>
					<!-- /col-md-4 -->
	
				</div>
				<!-- /row -->
				
				<div class="row mtbox">
					<s:url id="ajouterEntreePerimetre" action="ajouterEntreePerimetre">  
          				<s:param name="idPerimetre" value="%{perimetreBean.idPerimetre}" />  
       				</s:url> 
                  <gore:activePerimetre perimetre="${perimetreBean}" />              
				 <table class="table table-striped table-advance table-hover">
	                  	  	  <h4 style="text-align:center;"><i class="fa fa-angle-right"></i> ${perimetreBean.nomPerimetre}</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th>Date</th>
                                  <th>Stock initial</th>
                                  <th>Création</th>
                                  <th>Retour KO</th>
                                  <th>Corrigée</th>
                                  <th>Cloturée</th>
                                  <th>Charge traitement</th>
                                  <th>Stock final</th>
                                  <th>Variation</th>
                                  <th>Charge recette</th>
                                  <th>
                                  	<s:if test="(perimetreBean.dateDebut != null) && (perimetreBean.dateFin == null)">
	                                  	<a href="${ajouterEntreePerimetre}"><button class="btn btn-success btn-xs" style="margin-right:5px;"><i class="fa fa-plus-circle " style="font-size:20px;"></i></button></a>
                                  	</s:if>
                                  </th>
                              </tr>
                              </thead>
                              <tbody>
	                              <s:iterator value="perimetreBean.contenu">
	                              <tr>
	                                  <td><s:date name="dateSaisie" format="dd/MM/yyyy"/></td>
	                                  <td><s:property value="stockInitial" /></td>
	                                  <td><s:property value="nombreCreation" /></td>
	                                  <td><s:property value="nombreRetourKO" /></td>
	                                  <td><s:property value="nombreCorrection" /></td>
	                                  <td><s:property value="nombreCloture" /></td>
	                                  <td><s:property value="chargeTraitement" /></td>
	                                  <td><s:property value="stockFinal" /></td>
	                                  <gore:variation variation="${variation}" />
	                                  <td><s:property value="chargeRecette" /></td>
	                                  <td>
	                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
	                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
	                                  </td>
	                              	</tr>
	                              </s:iterator>
                              </tbody>
                          </table>
				</div>
				<!-- /row mt -->
			</s:if>
		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->

		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->
		<gore:notifications />
	 </section> </section> <!--main content end--> <!--footer start--> 
	 <gore:footer />
	 <!--footer end--> </section>

	<gore:importJS />
	<script type="text/javascript">

	 var doughnutDataAvancement = [ {
			value : ${perimetreBean.avancement},
			color : "#68dff0"
		}, {
			value : 100 - ${perimetreBean.avancement},
			color : "#444c57"
		} ];
		var myDoughnut = new Chart(document.getElementById(
				"rafPassageRecette").getContext("2d"))
				.Doughnut(doughnutDataAvancement);
		
	 Morris.Line({
	        element: 'gore-tendance-journaliere-area',
	        data: ${donneesTendanceJournaliere},
	        xkey: ${xKeyTendanceJournaliere},
	        ykeys: ${yKeysTendanceJournaliere},
	        labels: ${labelsTendanceJournaliere},
	        hideHover: 'auto',
	        lineWidth: 3,
	        pointSize: 5,
	        lineColors: ${lineColorsTendanceJournaliere},
	        fillOpacity: 0.8,
	        smooth:true,
	        xLabelFormat:function (x) { 
	              var curr_date = x.getDate();
	              var curr_month = x.getMonth()+1;
	              return curr_date + "/" + curr_month; }
	});
	 
		var doughnutDataStock = [ {
			value : ${perimetreBean.nombreAnoCorrigee},
			color : "#68dff0"
		}, {
			value : ${perimetreBean.nombreAnoTotal} - ${perimetreBean.nombreAnoCorrigee},
			color : "#444c57"
		} ];
		var myDoughnut = new Chart(document.getElementById(
				"stockActuel").getContext("2d"))
				.Doughnut(doughnutDataStock);
		
	 Morris.Line({
	        element: 'gore-evolution-charge-area',
	        data: ${donneesEvolutionCharge},
	        xkey: ${xKeyEvolutionCharge},
	        ykeys: ${yKeysEvolutionCharge},
	        labels: ${labelsEvolutionCharge},
	        hideHover: 'auto',
	        lineWidth: 3,
	        pointSize: 5,
	        lineColors: ${lineColorsEvolutionCharge},
	        fillOpacity: 0.8,
	        smooth:true,
	        xLabelFormat:function (x) { 
	              var curr_date = x.getDate();
	              var curr_month = x.getMonth()+1;
	              return curr_date + "/" + curr_month; }
	});
	</script>
</body>
</html>
