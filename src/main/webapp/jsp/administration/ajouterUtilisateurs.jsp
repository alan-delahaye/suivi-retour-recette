<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="gore" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Administration - Gestion des utilisateurs</title>
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
			<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Ajouter un nouvel utilisateur</h4>
                       <s:form cssClass="form-horizontal style-form" action="validateUtilisateur" theme="simple" >
                       	  <s:actionerror/>
                       	  <s:hidden name="utilisateur.idUtilisateur" value="%{utilisateur.idUtilisateur}" />
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nom</label>
                              <div class="col-sm-10">
                              	  <s:textfield cssClass="form-control round-form" name="utilisateur.nom" placeholder="Dupont" value="%{utilisateur.nom}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Prénom</label>
                              <div class="col-sm-10">
                              	  <s:textfield cssClass="form-control round-form" name="utilisateur.prenom" placeholder="Jean-Pierre" value="%{utilisateur.prenom}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Fonction</label>
                              <div class="col-sm-10">
                              	  <s:textfield cssClass="form-control round-form" name="utilisateur.fonction" placeholder="Chef de Projet" value="%{utilisateur.fonction}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Adresse mail</label>
                              <div class="col-sm-10">
                              	  <s:textfield cssClass="form-control round-form" name="utilisateur.adresseMail" placeholder="jean-pierre.dupont@gfi.fr" value="%{utilisateur.adresseMail}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Numéro de téléphone</label>
                              <div class="col-sm-10">
                              	  <s:textfield cssClass="form-control round-form" name="utilisateur.numeroTelephone" placeholder="01234567890" value="%{utilisateur.numeroTelephone}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Mot de passe</label>
                              <div class="col-sm-10">
                              		<s:password cssClass="form-control round-form" name="utilisateur.mdp1" value="%{utilisateur.mdp1}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Confirmer le mot de passe</label>
                              <div class="col-sm-10">
                              		<s:password cssClass="form-control round-form" name="utilisateur.mdp2" value="%{utilisateur.mdp2}"/>
                              </div>
                          </div>
  						  <button class="btn btn-theme" type="submit"><i class="fa fa-check"></i> Valider</button>
			              <c:choose>
								<c:when test="${provenance == 'monCompte'}">
									<s:hidden name="provenance" value="monCompte" />
									<a href="${admin}">
										<button class="btn btn-theme04" type="button"><i class="fa fa-cross"></i> Annuler</button>
									</a>
								</c:when>
								<c:otherwise>
									<s:hidden name="provenance" value="gestionUtilisateur" />
									<a href="${gestionUtilisateurs}">
										<button class="btn btn-theme04" type="button"><i class="fa fa-cross"></i> Annuler</button>
									</a>
								</c:otherwise>
							</c:choose>
                      </s:form>
                  </div>
          		</div><!-- col-lg-12-->      		 
				 
				 
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
