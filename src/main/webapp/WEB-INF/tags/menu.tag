<!--sidebar start--> 
	<aside>
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
	</aside> <!--sidebar end--> 