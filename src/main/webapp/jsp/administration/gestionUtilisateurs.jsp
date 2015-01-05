<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="gore" tagdir="/WEB-INF/tags/"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Administration - Gestion des utilisateurs</title>
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
	
	<gore:menu elementMenu="administration"/>

	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">

	<div class="row">
		<div class="col-lg-9 main-chart" style="margin-top:5%;">

			<div class="row mtbox">
				 <table class="table table-striped table-advance table-hover">
	                  	  	  <h4 style="text-align:center;"><i class="fa fa-angle-right"></i> Liste des utilisateurs</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th>Nom</th>
                                  <th>Prénom</th>
                                  <th>Adresse mail</th>
                                  <th>Fonction</th>
                                  <th>Téléphone</th>
                                  <th><a href="${ajouterUtilisateurs}"><button class="btn btn-success btn-xs" style="margin-right:5px;"><i class="fa fa-plus-circle " style="font-size:20px;"></i></button></a></th>
                              </tr>
                              </thead>
                              <tbody>
                              <s:iterator value="lesUtilisateurs">
                              		<s:url id="modifierUtilisateur" action="ajouterUtilisateurs">  
          								<s:param name="idUtilisateur" value="%{idUtilisateur}" />  
          								<s:param name="provenance" value="gestionUtilisateur" />  
       								</s:url>  
	                              <tr>
	                                  <td><s:property value="nom" /></td>
	                                  <td><s:property value="prenom" /></td>
	                                  <td><s:property value="adresseMail" /></td>
	                                  <td><s:property value="fonction" /></td>
	                                  <td><s:property value="numeroTelephone" /></td>
	                                  <td>
	                                  	<s:url id="supprimerUtilisateur" action="supprimerUtilisateur">
											<s:param name="idUtilisateur" value="%{idUtilisateur}" />
										</s:url> 
										<a href="${modifierUtilisateur}"><button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button></a>
	                                     <a href="${supprimerUtilisateur}"><button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button></a>
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
