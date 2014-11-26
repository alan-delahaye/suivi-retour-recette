<%@taglib prefix="s" uri="/struts-tags"%>
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

	</header> <!--header end--> 