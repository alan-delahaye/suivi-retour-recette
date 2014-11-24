<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>

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

<!-- Création des liens de la page -->
<s:url var="logout" action="logout" />
<s:url var="index" action="dashboard" />
<s:url var="admin" action="administration" />
<s:url var="perimetre" action="perimetre" />
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
				- Gestion Opérationnelle des REtours sur recettes</b></a>
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

			<li class="mt"><a href="${index}"> <i
					class="fa fa-dashboard"></i> <span>Tableau de bord</span>
			</a></li>

			<li class="mt"><a href="${perimetre}" class="active"> <i class="fa fa-desktop"></i> <span>Saisie
						des informations</span>
			</a></li>

			<li class="mt"><a href="${admin}"> <i class="fa fa-cogs"></i> <span>Administration</span>
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

<%-- 				<s:iterator value="lesPerimetresParents" var="indexLesPerimetresParents"> --%>
<%-- 					<s:iterator value="lesPerimetres"> --%>
<%-- 						<li><a href="#"><s:property value="nomPerimetre" /></a></li> --%>
<%-- 					</s:iterator> --%>
<!-- 					<li class="divider"></li> -->
<%-- 				</s:iterator> --%>
					<s:iterator value="tousLesPerimetres">
					<s:iterator value="value">
						<li><a href="#"><s:property value="nomPerimetre" /></a></li>
					</s:iterator>
					
					<li class="divider"></li>
				</s:iterator>
					

						</ul>
					</div>
				</div>
			</div>
			<!-- /row mt -->
			<div class="row mtbox">
				 <table class="table table-striped table-advance table-hover">
	                  	  	  <h4 style="text-align:center;"><i class="fa fa-angle-right"></i> Lot 3 P3</h4>
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
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                  <td>19/11/2014</a></td>
                                  <td>0</td>
                                  <td>4</td>
                                  <td>0</td>
                                  <td>1</td>
                                  <td>0</td>
                                  <td>1</td>
                                  <td>3</td>
                                  <td style="color:#FF0000"><i class="fa fa-thumbs-o-down" /> 3</td>
                                  <td>1</td>
                                  <td>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>20/11/2014</a></td>
                                  <td>3</td>
                                  <td>4</td>
                                  <td>0</td>
                                  <td>4</td>
                                  <td>0</td>
                                  <td>1</td>
                                  <td>3</td>
                                  <td style="color:#000000"><i class="fa fa-hand-o-right" /> 0</td>
                                  <td>1</td>
                                  <td>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              <tr>
                                  <td>21/11/2014</a></td>
                                  <td>3</td>
                                  <td>1</td>
                                  <td>0</td>
                                  <td>3</td>
                                  <td>0</td>
                                  <td>1</td>
                                  <td>1</td>
                                  <td style="color:#00FF00"><i class="fa fa-thumbs-o-up" /> -3</td>
                                  <td>1</td>
                                  <td>
                                      <button class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></button>
                                      <button class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></button>
                                  </td>
                              </tr>
                              </tbody>
                          </table>
			</div>
			<!-- /row mt -->
		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->

		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

		<div class="col-lg-3 ds" style="margin-top: 40px;">
			<!--COMPLETED ACTIONS DONUTS CHART-->
			<h3>Notifications</h3>

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
			<h3>Membres de l'équipe</h3>
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
