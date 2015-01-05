<!--sidebar start-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ attribute name="perimetre" required="true"
	type="fr.gfi.alan.delahaye.beans.PerimetreBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${perimetre.dateDebut == null}">
		<div style="margin-right: 100px; float: right;">
			<input type="checkbox" data-toggle="switch" onChange="changeStatePerimetre(${perimetre.idPerimetre});"/>
		</div>
	</c:when>
	<c:when
		test="${(perimetre.dateDebut != null) && (perimetre.dateFin == null)}">
		<div style="margin-right: 100px; float: right;">
			<input type="checkbox" checked="checked" data-toggle="switch" onChange="changeEtatPerimetre(${perimetre.idPerimetre});" />
		</div>
	</c:when>
	<c:otherwise>
		<div style="margin-right: 100px; float: right;">
			<input type="checkbox" disabled data-toggle="switch"/>
		</div>
	</c:otherwise>
</c:choose>

<div id="dialog-confirm"></div>
