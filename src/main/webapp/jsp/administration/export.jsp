<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="gore" tagdir="/WEB-INF/tags/"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Administration - Export</title>
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
				<p> Ecran Export, en cours de création</p>
				
				<s:url id="fileDownload" namespace="/" action="download" ></s:url>
 
					<h4>Download file - <s:a href="%{fileDownload}">fileABC.txt</s:a></h4>
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
