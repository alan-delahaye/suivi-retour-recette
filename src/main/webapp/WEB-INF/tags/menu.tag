<!--sidebar start--> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ attribute name="elementMenu" required="true" type="java.lang.String" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<aside>
	<div id="sidebar" class="nav-collapse " style="margin-top: 40px;">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">

			<p class="centered" id="avatarAAfficher">
				
			</p>
			<h5 class="centered">${utilisateurBean.prenom}
				${utilisateurBean.nom}</h5>

			<li class="mt">
				<c:choose>
					<c:when test="${elementMenu == 'dashboard'}"> 
						<a href="${index}" class="active"> 
							<i class="fa fa-dashboard"></i> <span>Tableau de bord</span>
						</a>
					 </c:when>
					<c:otherwise>
						<a href="${index}"> 
							<i class="fa fa-dashboard"></i> <span>Tableau de bord</span>
						</a>
					</c:otherwise>
				</c:choose>
			</li>

			<li class="mt">
				<c:choose>
					<c:when test="${elementMenu == 'perimetre'}">
						<a href="${perimetre}" class="active">
							<i class="fa fa-desktop"></i> <span>Saisie
							des informations</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="${perimetre}">
							<i class="fa fa-desktop"></i> <span>Saisie
							des informations</span>
						</a>
					</c:otherwise>
				</c:choose>
			</li>

			<li class="mt">
				<c:choose>
					<c:when test="${elementMenu == 'administration'}">
						<a href="${admin}" class="active">
							<i class="fa fa-cogs"></i> <span>Administration</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="${admin}">
							<i class="fa fa-cogs"></i> <span>Administration</span>
						</a>
					</c:otherwise>
				</c:choose>
			</li>
		</ul>
		<!-- sidebar menu end-->
	</div>
	</aside> <!--sidebar end-->