<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<title>BeerDB</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
<link href="<c:url value="/resources/css/rateyo.css"/>" rel="stylesheet"/>
<link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css" rel="stylesheet"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.js"></script>
<script src="<c:url value="/resources/js/callajax.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/formvalidation.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/beerdb.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/rateyo.js"/>" type="text/javascript"></script>
<c:set var="context" value="${pageContext.request.contextPath}" />