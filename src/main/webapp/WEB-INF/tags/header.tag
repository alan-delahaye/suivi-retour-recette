<%@taglib prefix="s" uri="/struts-tags"%>
<!--header start--> <header class="header black-bg"> 
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
					class="fa fa-tasks"></i> <span class="badge bg-theme">${nbPerimetreEnCours}</span>
			</a>
				<ul class="dropdown-menu extended tasks-bar">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green">${nbPerimetreEnCours} périmètre(s) non finalisés</p>
					</li>
					<s:iterator value="tousLesPerimetresEnCours">
						<s:url id="perimetreAAfficher" action="perimetre">  
          					<s:param name="idPerimetre" value="%{idPerimetre}" />  
       					</s:url> 
						<li><a href="${perimetreAAfficher}">
							<div class="task-info">
								<div class="desc"><s:property value="nomPerimetre" /></div>
								<div class="percent"><s:property value="avancement" />%</div>
							</div>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-success" role="progressbar"
									aria-valuenow="${avancement}" aria-valuemin="0" aria-valuemax="100"
									style="width: ${avancement}%">
									<span class="sr-only">${avancement}% Complete</span>
								</div>
							</div>
						</a></li>
					
					</s:iterator>
					<li class="external"><a href="${perimetre}">Voir tous les périmètres</a>
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
	</div>

	</header> <!--header end--> 