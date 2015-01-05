<!--sidebar start-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ attribute name="variation" required="true" type="java.lang.Integer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${variation > 0}">
		<td style="color: #FF0000"><i class="fa fa-thumbs-o-down" /> ${variation}</td>
	</c:when>
	<c:when test="${variation < 0}">
		<td style="color: limegreen"><i class="fa fa-thumbs-o-up" /> ${variation}</td>
	</c:when>
	<c:otherwise>
		<td style="color: #000000"><i class="fa fa-hand-o-right" /> ${variation}</td>
	</c:otherwise>
</c:choose>


