<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Links and scripts (tag file) -->
    <t:dependencies></t:dependencies>
</head>
<body>
<!-- Navigation bar (Tag file) -->
<t:navigationbar></t:navigationbar>

<div class="container" style="margin-top: 50px">
    <div class="row">
        PLACEHOLDER SIVU OLUEN LISÄYKSELLE.
        <form:form id="#" modelAttribute="beer" method="POST" action="${context}/registered/addbeer"
                   class="form-horizontal" role="form">

            <!-- Name -->
            <div class="input-group login-input-group">
                <span class="input-group-addon"></span>
                <form:input path="name" class="form-control" placeholder="name"/>
            </div>

            <%--<!-- Mapping not working - WIP -->--%>
            <%--<div class="input-group login-input-group">--%>
                <%--<span class="input-group-addon"></span>--%>
                <%--<form:input path="beerStyle.name" class="form-control" placeholder="beer style"/>--%>
            <%--</div>--%>


            <div class="login-form-group form-group">
                <div class="col-sm-12 controls">
                    <button type="submit" class="btn btn-success">Add beer</button>
                </div>
            </div>
        </form:form>
    </div>
</div>


<!-- Footer (tag files) -->
<t:footer></t:footer>
</body>
</html>
