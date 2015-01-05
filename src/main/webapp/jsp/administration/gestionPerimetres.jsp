<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="gore" tagdir="/WEB-INF/tags/"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Administration - Gestion des périmètres</title>
<s:head />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="lineicons/style.css">

<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">

<script src="js/chart-master/Chart.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Création des liens de la page -->
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
	
	<gore:menu elementMenu="administration" />
	
	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">

	<div class="row">
		<div class="col-lg-9 main-chart" style="margin-top:5%;">

						<div class="row mtbox">
				 <table class="table table-striped table-advance table-hover">
	                  	  	  <h4 style="text-align:center;"><i class="fa fa-angle-right"></i> Liste des périmètres</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th>Nom du périmètre</th>
                                  <th>Charge init. développements</th>
                                  <th>Ratio DEV/retours RE7</th>
                                  <th>Charge retours RE7</th>
                                  <th>Ratio DEV/Anomalie</th>
                                  <th>Charge init. passage recette</th>
                                  <th><a href="${ajouterPerimetre}"><button class="btn btn-success btn-xs" style="margin-right:5px;"><i class="fa fa-plus-circle " style="font-size:20px;"></i></button></a></th>
                              </tr>
                              </thead>
                              <tbody>
                              <s:iterator value="listePerimetres">
                              		<s:url id="modifierPerimetre" action="ajouterPerimetre">  
          								<s:param name="idPerimetre" value="%{idPerimetre}" />  
       								</s:url>
       								<s:url id="supprimerPerimetre" action="supprimerPerimetre">
										<s:param name="idPerimetre" value="%{idPerimetre}" />  
									</s:url>  
	                              <tr>
	                                  <td><s:property value="nomPerimetre"/></td>
	                                  <td><s:property value="chargeInitDeveloppement"/> j.h</td>
	                                  <td><s:property value="ratioDevRetourRecette"/> %</td>
	                                  <td><s:property value="chargeRetourRecette"/> j.h</td>
	                                  <td><s:property value="ratioDevAnomalie"/> %</td>
	                                  <td><s:property value="chargePassageRecette"/> j.h</td>
	                                  <td>
	                                      <a href="${modifierPerimetre}"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button></a>
	                                      <a href="${supprimerPerimetre}"><button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
	                                  </td>
	                              </tr>
                              </s:iterator>
                              
                              </tbody>
                          </table>
			</div>
			<!-- /row mt -->
		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->


	<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

	<gore:notifications />

	</section> </section>
	
	<gore:footer />
	
	</section>

  	<gore:importJS />

</body>
</html>
