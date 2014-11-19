<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

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
<s:url var="logout" action="logout" />
<s:url var="index" action="dashboard" />
</head>

<body>
	<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start--> <header class="header black-bg"> <!--<div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>--> <!--logo start-->
	<div style="float: left;">
		<a href="${index}" class="logo"><img src="img/Gfi_logo.png" /><b>GORE
				- Gestion Opérationnelle des REtours</b></a>
	</div>
	<!--logo end-->

	<div class="nav notify-row" id="top_menu"
		style="margin-top: 35px; margin-left: 15px;">
		<!--  notification start -->
		<ul class="nav top-menu">
			<!-- settings start -->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="index.html#"> <i
					class="fa fa-tasks"></i> <span class="badge bg-theme">4</span>
			</a>
				<ul class="dropdown-menu extended tasks-bar">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green">4 périmètres non finalisés</p>
					</li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">Lot 3 P1</div>
								<div class="percent">90%</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"
									style="width: 90%">
									<span class="sr-only">90% Complete</span>
								</div>
							</div>
					</a></li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">Lot 3 P2</div>
								<div class="percent">80%</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
									style="width: 80%">
									<span class="sr-only">80% Complete</span>
								</div>
							</div>
					</a></li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">Lot 3 P3</div>
								<div class="percent">60%</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete</span>
								</div>
							</div>
					</a></li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">Lot 3 P4</div>
								<div class="percent">10%</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"
									style="width: 10%">
									<span class="sr-only">10% Complete (Important)</span>
								</div>
							</div>
					</a></li>
					<li class="external"><a href="#">Voir tous les périmètres</a>
					</li>
				</ul></li>
			<!-- settings end -->
		</ul>
		<!--  notification end -->
	</div>

	<div class="top-menu" style="margin-top: 15px;">
		<ul class="nav pull-right top-menu">
			<li><a class="logout" href="${logout}">Déconnexion</a></li>
		</ul>
		<!-- <div style="float:right; margin-top:20px; margin-right:5px;"><b>Alan Delahaye - Responsable</b></div> -->
	</div>

	</header> <!--header end--> <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<!--sidebar start--> <aside>
	<div id="sidebar" class="nav-collapse " style="margin-top: 40px;">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered">
				<a href="profile.html"><img src="img/ui-sam.jpg"
					class="img-circle" width="60"></a>
			</p>
			<h5 class="centered">${utilisateurBean.prenom}
				${utilisateurBean.nom}</h5>

			<li class="mt"><a class="active" href="${index}"> <i
					class="fa fa-dashboard"></i> <span>Tableau de bord</span>
			</a></li>

			<li class="mt"><a> <i class="fa fa-desktop"></i> <span>Saisie
						des informations</span>
			</a></li>

			<li class="mt"><a> <i class="fa fa-cogs"></i> <span>Administration</span>
			</a></li>
		</ul>
		<!-- sidebar menu end-->
	</div>
	</aside> <!--sidebar end--> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">

	<div class="row">
		<div class="col-lg-9 main-chart">

			<div class="row mtbox">
				<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
					<div class="box1">
						<span class="li_heart"></span>
						<h3>933</h3>
					</div>
					<p>933 People liked your page the last 24hs. Whoohoo!</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_cloud"></span>
						<h3>+48</h3>
					</div>
					<p>48 New files were added in your cloud storage.</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_stack"></span>
						<h3>23</h3>
					</div>
					<p>You have 23 unread messages in your inbox.</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_news"></span>
						<h3>+10</h3>
					</div>
					<p>More than 10 news were added in your reader.</p>
				</div>
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_data"></span>
						<h3>OK!</h3>
					</div>
					<p>Your server is working perfectly. Relax & enjoy.</p>
				</div>

			</div>
			<!-- /row mt -->


			<div class="row mt">
				<!-- SERVER STATUS PANELS -->
				<div class="col-md-4 col-sm-4 mb">
					<div class="white-panel pn donut-chart">
						<div class="white-header">
							<h5>SERVER LOAD</h5>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-6 goleft">
								<p>
									<i class="fa fa-database"></i> 90%
								</p>
							</div>
						</div>
						<canvas id="serverstatus01" height="120" width="120"></canvas>
						<script>
							var doughnutData = [ {
								value : 90,
								color : "#68dff0"
							}, {
								value : 10,
								color : "#fdfdfd"
							} ];
							var myDoughnut = new Chart(document.getElementById(
									"serverstatus01").getContext("2d"))
									.Doughnut(doughnutData);
						</script>
					</div>
					<! --/grey-panel -->
				</div>
				<!-- /col-md-4-->


				<div class="col-md-4 col-sm-4 mb">
					<div class="white-panel pn">
						<div class="white-header">
							<h5>TOP PRODUCT</h5>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-6 goleft">
								<p>
									<i class="fa fa-heart"></i> 122
								</p>
							</div>
							<div class="col-sm-6 col-xs-6"></div>
						</div>
						<div class="centered">
							<img src="img/product.png" width="120">
						</div>
					</div>
				</div>
				<!-- /col-md-4 -->

				<div class="col-md-4 mb">
					<!-- WHITE PANEL - TOP USER -->
					<div class="white-panel pn">
						<div class="white-header">
							<h5>TOP USER</h5>
						</div>
						<p>
							<img src="img/ui-zac.jpg" class="img-circle" width="80">
						</p>
						<p>
							<b>Zac Snider</b>
						</p>
						<div class="row">
							<div class="col-md-6">
								<p class="small mt">MEMBER SINCE</p>
								<p>2012</p>
							</div>
							<div class="col-md-6">
								<p class="small mt">TOTAL SPEND</p>
								<p>$ 47,60</p>
							</div>
						</div>
					</div>
				</div>
				<!-- /col-md-4 -->


			</div>
			<!-- /row -->


			<div class="row">
				<!-- TWITTER PANEL -->
				<div class="col-md-4 mb">
					<div class="darkblue-panel pn">
						<div class="darkblue-header">
							<h5>DROPBOX STATICS</h5>
						</div>
						<canvas id="serverstatus02" height="120" width="120"></canvas>
						<script>
							var doughnutData = [ {
								value : 60,
								color : "#68dff0"
							}, {
								value : 40,
								color : "#444c57"
							} ];
							var myDoughnut = new Chart(document.getElementById(
									"serverstatus02").getContext("2d"))
									.Doughnut(doughnutData);
						</script>
						<p>April 17, 2014</p>
						<footer>
						<div class="pull-left">
							<h5>
								<i class="fa fa-hdd-o"></i> 17 GB
							</h5>
						</div>
						<div class="pull-right">
							<h5>60% Used</h5>
						</div>
						</footer>
					</div>
					<! -- /darkblue panel -->
				</div>
				<!-- /col-md-4 -->


				<div class="col-md-4 mb">
					<!-- INSTAGRAM PANEL -->
					<div class="instagram-panel pn">
						<i class="fa fa-instagram fa-4x"></i>
						<p>
							@THISISYOU<br /> 5 min. ago
						</p>
						<p>
							<i class="fa fa-comment"></i> 18 | <i class="fa fa-heart"></i> 49
						</p>
					</div>
				</div>
				<!-- /col-md-4 -->

				<div class="col-md-4 col-sm-4 mb">
					<!-- REVENUE PANEL -->
					<div class="darkblue-panel pn">
						<div class="darkblue-header">
							<h5>REVENUE</h5>
						</div>
						<div class="chart mt">
							<div class="sparkline" data-type="line" data-resize="true"
								data-height="75" data-width="90%" data-line-width="1"
								data-line-color="#fff" data-spot-color="#fff" data-fill-color=""
								data-highlight-line-color="#fff" data-spot-radius="4"
								data-data="[200,135,667,333,526,996,564,123,890,464,655,800,900,1100,2100]"></div>
						</div>
						<p class="mt">
							<b>$ 17,980</b><br />Month Income
						</p>
					</div>
				</div>
				<!-- /col-md-4 -->

			</div>
			<!-- /row -->

			<div class="row mt">
				<!--CUSTOM CHART START -->
				<div class="border-head">
					<h3>VISITS</h3>
				</div>
				<div class="custom-bar-chart">
					<ul class="y-axis">
						<li><span>10.000</span></li>
						<li><span>8.000</span></li>
						<li><span>6.000</span></li>
						<li><span>4.000</span></li>
						<li><span>2.000</span></li>
						<li><span>0</span></li>
					</ul>
					<div class="bar">
						<div class="title">JAN</div>
						<div class="value tooltips" data-original-title="8.500"
							data-toggle="tooltip" data-placement="top">85%</div>
					</div>
					<div class="bar ">
						<div class="title">FEB</div>
						<div class="value tooltips" data-original-title="5.000"
							data-toggle="tooltip" data-placement="top">50%</div>
					</div>
					<div class="bar ">
						<div class="title">MAR</div>
						<div class="value tooltips" data-original-title="6.000"
							data-toggle="tooltip" data-placement="top">60%</div>
					</div>
					<div class="bar ">
						<div class="title">APR</div>
						<div class="value tooltips" data-original-title="4.500"
							data-toggle="tooltip" data-placement="top">45%</div>
					</div>
					<div class="bar">
						<div class="title">MAY</div>
						<div class="value tooltips" data-original-title="3.200"
							data-toggle="tooltip" data-placement="top">32%</div>
					</div>
					<div class="bar ">
						<div class="title">JUN</div>
						<div class="value tooltips" data-original-title="6.200"
							data-toggle="tooltip" data-placement="top">62%</div>
					</div>
					<div class="bar">
						<div class="title">JUL</div>
						<div class="value tooltips" data-original-title="7.500"
							data-toggle="tooltip" data-placement="top">75%</div>
					</div>
				</div>
				<!--custom chart end-->
			</div>
			<!-- /row -->

		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->


		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

		<div class="col-lg-3 ds" style="margin-top: 40px;">
			<!--COMPLETED ACTIONS DONUTS CHART-->
			<h3>NOTIFICATIONS</h3>

			<!-- First Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme" style="background-color: #68DF4A"><i
						class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>15/11/2014</muted>
						<br /> Le périmètre <a href="#">Lot 5</a> a été finalisé.<br />
					</p>
				</div>
			</div>
			<!-- Second Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme" style="background-color: #FF0000"><i
						class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>14/11/2014</muted>
						<br /> ATTENTION : Le périmètre <a href="#">Lot 3 P4</a> est à
						surveillé.<br />
					</p>
				</div>
			</div>

			<!-- USERS ONLINE SECTION -->
			<h3>Membre de l'équipe</h3>
			<!-- First Member -->
			<s:iterator value="tousLesUtilisateurs">
				<div class="desc">
					<div class="thumb">
						<img class="img-circle" src="img/ui-sam.jpg" width="35px"
							height="35px" align="">
					</div>
					<div class="details">
						<p>
							<a><s:property value="nom" /> <s:property value="prenom" /></a><br />
							<muted>
							<s:property value="adresseMail" /></muted>
						</p>
					</div>
				</div>
			</s:iterator>
		</div>
		<!-- /col-lg-3 -->
	</div>
	<! --/row --> </section> </section> <!--main content end--> <!--footer start--> <footer
		class="site-footer">
	<div class="text-center">
		2014 - Alvarez.is - Développements : Alan Delahaye <a
			href="index.html#" class="go-top"> <i class="fa fa-angle-up"></i>
		</a>
	</div>
	</footer> <!--footer end--> </section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="js/jquery.sparkline.js"></script>


	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>

	<script type="text/javascript" src="js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="js/sparkline-chart.js"></script>
	<script src="js/zabuto_calendar.js"></script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var unique_id = $.gritter
									.add({
										// (string | mandatory) the heading of the notification
										title : 'Bienvenue sur AGRAF!',
										// (string | mandatory) the text inside the notification
										text : 'Ici vous pourrez consulter/saisir le RAF des tâches en cours.',
										// (string | optional) the image to display on the left
										image : 'img/ui-sam.jpg',
										// (bool | optional) if you want it to fade out on its own or just sit there
										sticky : false,
										// (int | optional) the time you want it to be alive for before fading out
										time : '1000',
										// (string | optional) the class name you want to apply to that specific message
										class_name : 'my-sticky-class'
									});

							return false;
						});
	</script>

	<script type="application/javascript">
		
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    
	</script>


</body>
</html>
