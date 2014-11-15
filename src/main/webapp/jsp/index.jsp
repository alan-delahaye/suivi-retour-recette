<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Connexion</title>
	<s:head />
<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
  <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

<!-- 	  <div id="login-page"> -->
<!-- 	  	<div class="container"> -->
<%-- 	  		  <s:form action="helloWorld" class="form-login"> --%>
<!-- 		        <h2 class="form-login-heading">Connexion à l'application</h2> -->
<!-- 		        <div class="login-wrap"> -->
<%-- 		        	<s:textfield label="Identifiant : " name="name" placeholder="Mon identifiant"/> --%>
<%-- 					<s:textfield label="Mot de passe" name="dateNow" placeholder="Mon mot de passe"/> --%>
<%-- 					<s:submit class="btn btn-theme btn-block"><i class="fa fa-lock"></i>Connexion</s:submit>    --%>
<!-- 		            <hr>		 -->
<!-- 		        </div> -->
<%-- 	  		  </s:form> --%>
<!-- 	  	</div> -->
<!-- 	  </div> -->

<div id="login-page">
	  	<div class="container">
	  	
		      <s:form cssClass="form-login" action="helloWorld" theme="simple">
		        <h2 class="form-login-heading">Connexion à l'application</h2>
		        <div class="login-wrap">
		        	<s:actionerror/>
		        	<s:textfield label="Identifiant" cssClass="form-control" name="identifiant" placeholder="Mon identifiant"/>
		        	<br>
					<s:textfield label="Mot de passe" cssClass="form-control" name="motDePasse" placeholder="Mon mot de passe"/>
					<br>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> Connexion</button>
		        </div>
		      </s:form>	  	
	  	
	  	</div>
	  </div>


    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("img/login-bg.jpg", {speed: 500});
    </script>

</body>
</html>
	