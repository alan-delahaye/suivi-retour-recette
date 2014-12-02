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
		<gore:notifications />
	 </section> </section> <!--main content end--> <!--footer start--> 
	 <gore:footer />
	 <!--footer end--> </section>

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
