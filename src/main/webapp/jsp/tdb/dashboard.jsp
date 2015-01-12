<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="gore" tagdir="/WEB-INF/tags/"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Dashbord</title>
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
	
	<gore:menu elementMenu="dashboard" />
	
	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">

	<div class="row">
		<div class="col-lg-9 main-chart">

			<div class="row mt">
				<s:iterator value="tousLesPerimetresEnCours">
						<div class="col-md-4 col-sm-4 mb">
                      		<div class="grey-panel pn donut-chart">
                      			<div class="grey-header">
						  			<h5><s:property value="nomPerimetre"/> </h5>
                      			</div>
                      		
                      		<div class="task-info">
                      			<div class="desc">Avancement : <s:property value="avancement" />%</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-success" role="progressbar"
									aria-valuenow="${avancement}" aria-valuemin="0" aria-valuemax="100"
									style="width: ${avancement}%">
									<span class="sr-only">${avancement}% Complete</span>
								</div>
							</div>
							
							<div class="task-info">
								<div class="percent">Stock Actuel : ${nombreAnoTotal - nombreAnoCorrigee} anomalie(s)</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-success" role="progressbar"
									aria-valuenow="${(nombreAnoCorrigee*100) / nombreAnoTotal}" aria-valuemin="0" aria-valuemax="100"
									style="width: ${(nombreAnoCorrigee*100) / nombreAnoTotal}%">
									<span class="sr-only">${(nombreAnoCorrigee*100) / nombreAnoTotal}% Complete</span>
								</div>
							</div>
							
							<div class="task-info">
								<div class="percent">Conso. traitement : ${nombreTotalConsoTraitement} j.h</div>
							</div>
							<s:if test="nombreTotalConsoTraitement > chargeRetourRecette">
								<div class="progress progress-striped">
										<div class="progress-bar progress-bar-danger" role="progressbar"
											aria-valuenow="${(nombreTotalConsoTraitement*100) / chargeRetourRecette}" aria-valuemin="0" aria-valuemax="100"
											style="width: ${(nombreTotalConsoTraitement*100) / chargeRetourRecette}%">
											<span class="sr-only">${(nombreTotalConsoTraitement*100) / chargeRetourRecette}% Complete</span>
										</div>
									</div>
							</s:if>
							<s:if test="nombreTotalConsoTraitement <= chargeRetourRecette">
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-success" role="progressbar"
										aria-valuenow="${(nombreTotalConsoTraitement*100) / chargeRetourRecette}" aria-valuemin="0" aria-valuemax="100"
										style="width: ${(nombreTotalConsoTraitement*100) / chargeRetourRecette}%">
										<span class="sr-only">${(nombreTotalConsoTraitement*100) / chargeRetourRecette}% Complete</span>
									</div>
								</div>
							</s:if>
	                      	</div><! --/grey-panel -->
                      	</div><!-- /col-md-4-->
				</s:iterator>


			</div>
			<!-- /row -->

		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->


		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->
	<gore:notifications />
	 </section> </section> <!--main content end--> <!--footer start--> 
	 <gore:footer />
	</section>

<gore:importJS />

</body>
</html>
