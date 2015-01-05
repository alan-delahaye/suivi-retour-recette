<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="gore" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Périmètre - Saisie des périmètres</title>
<s:head />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="lineicons/style.css">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css" href="css/theme.css">

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
	
	<gore:menu elementMenu="perimetre"/>

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
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Ajouter une nouvelle entrée au perimètre ${perimetreBean.nomPerimetre}</h4>
                       
                       <s:form cssClass="form-horizontal style-form" action="validateEntreePerimetre" theme="simple" >
                       	  <s:actionerror />
                       	  <s:hidden name="entreePerimetreBean.idPerimetreForm" value="%{entreePerimetreBean.idPerimetreForm}" />
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Date de la saisie<span style="color:red;">*</span></label>
                           	  <div class="col-sm-10">
		 						  <s:textfield id="datepicker" name="entreePerimetreBean.dateSaisieForm" value="%{entreePerimetreBean.dateSaisieForm}" />
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nombre création anomalie(s)</label>
                           	  <div class="col-sm-10">
								  <s:textfield cssClass="form-control round-form" name="entreePerimetreBean.nombreCreationForm" placeholder="10 anomalies" value="%{entreePerimetreBean.nombreCreationForm}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nombre retour KO</label>
                           	  <div class="col-sm-10">
								  <s:textfield cssClass="form-control round-form" name="entreePerimetreBean.nombreRetourKOForm" placeholder="10 anomalies" value="%{entreePerimetreBean.nombreRetourKOForm}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nombre correction</label>
                           	  <div class="col-sm-10">
								  <s:textfield cssClass="form-control round-form" name="entreePerimetreBean.nombreCorrectionForm" placeholder="10 anomalies" value="%{entreePerimetreBean.nombreCorrectionForm}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Nombre clôture</label>
                           	  <div class="col-sm-10">
								  <s:textfield cssClass="form-control round-form" name="entreePerimetreBean.nombreClotureForm" placeholder="10 anomalies" value="%{entreePerimetreBean.nombreClotureForm}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Charge traitement</label>
                           	  <div class="col-sm-10">
								  <s:textfield cssClass="form-control round-form" name="entreePerimetreBean.chargeTraitementForm" placeholder="3.5 j.h" value="%{entreePerimetreBean.chargeTraitementForm}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Charge recette (passage initial + correctif)</label>
                           	  <div class="col-sm-10">
								  <s:textfield cssClass="form-control round-form" name="entreePerimetreBean.chargeRecetteForm" placeholder="3.5 j.h" value="%{entreePerimetreBean.chargeRecetteForm}"/>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">Raf recette (passage initial)</label>
                           	  <div class="col-sm-10">
								  <s:textfield cssClass="form-control round-form" name="entreePerimetreBean.rafRecetteForm" placeholder="3.5 j.h" value="%{entreePerimetreBean.rafRecetteForm}"/>
                              </div>
                          </div>
  						  <button class="btn btn-theme" type="submit"><i class="fa fa-check"></i> Valider</button>
  						  	<s:url id="perimetreRetour" action="perimetre">  
          						<s:param name="idPerimetre" value="%{perimetreBean.idPerimetre}" />  
       						</s:url> 
						    <a href="${perimetreRetour}">
						  	<button class="btn btn-theme04" type="button"><i class="fa fa-cross"></i> Annuler</button>
						  </a>
                      </s:form>
                      <p><i>Attention : seul les champs suivis de <span style="color:red;">*</span> sont obligatoire. Si un champ n'est pas renseigné, alors celui-ci sera renseigné automatiquement avec la valeur 0.</i></p>
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
	<script>
	var array = ${badDates};
	var firstDay = ${firstDate};
$( "#datepicker" ).datepicker({
	dateFormat: "dd/mm/yy", 
    minDate:firstDay,
	beforeShowDay: function(date){
        var string = jQuery.datepicker.formatDate('dd/mm/yy', date);
        return [ array.indexOf(string) == -1 ]
    },
	defaultDate:0});

</script>
	
</body>
</html>
