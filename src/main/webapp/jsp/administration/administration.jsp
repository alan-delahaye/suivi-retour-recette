<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="gore" tagdir="/WEB-INF/tags/"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Administration</title>
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
<s:url id="modifierUtilisateur" action="ajouterUtilisateurs">  
	<s:param name="idUtilisateur" value="utilisateurBean.idUtilisateur" />  
    <s:param name="provenance" value="'monCompte'" />  
</s:url>  
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
				<a href="${modifierUtilisateur}">
				<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
					<div class="box1" style="padding:0px; border-bottom:none;">
						<span class="li_user"></span>
						<h3>Mon compte</h3>
					</div>
					<p>Modifier les informations de mon compte (nom, prénom, ...)</p>
				</div>
				</a>
				<a href="${gestionUtilisateurs}">
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1" style="padding:0px; border-bottom:none;">
						<span class="li_settings"></span>
						<h3>Gestion des utilisateurs</h3>
					</div>
					<p>Ajouter / Supprimer des utilisateurs.</p>
				</div>
				</a>
				<a href="${gestionPerimetres}">
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1" style="padding:0px; border-bottom:none;">
						<span class="li_data"></span>
						<h3>Gestion des périmètres</h3>
					</div>
					<p>Ajouter / modifier un périmètre.</p>
				</div>
				</a>
				<a href="${export}">
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1" style="padding:0px; border-bottom:none;">
						<span class="li_news"></span>
						<h3>Export</h3>
					</div>
					<p>Exporter un périmètre au format excel</p>
				</div>
				</a>
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
