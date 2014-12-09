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
    <script>
        $(function() {
            $( "#alcohol" ).spinner({
                step: 0.01,
                numberFormat: "n"
            });
            $( "#price" ).spinner({
                min: 0.1,
                max: 80000,
                step: 0.01,
                numberFormat: 'C',
                culture: 'de-DE'
            });
        });
    </script>
</head>
<body>
<!-- Navigation bar (Tag file) -->
<t:navigationbar></t:navigationbar>

<div class="container gap">
    <div class="row">

        <p class="lead">Add beer to database</p>

        <div class="error login-input-group"><c:out value="${beerExists}"/></div>

        <form:form id="validate-add-beer-form" modelAttribute="beer" method="POST" action="${context}/registered/addbeer"
                   class="form-horizontal" role="form">

            <!-- Name -->
            Name
            <div class="input-group login-input-group">
                <span class="input-group-addon"></span>
                <form:input path="name" class="form-control" placeholder="name of the beer"/>
            </div>

            <!-- Description -->
            Description
            <div class="input-group login-input-group">
                <span class="input-group-addon"></span>
                <form:input path="description" class="form-control" placeholder="informal description about the beer. Use english, please"/>
            </div>

            <!-- Alcohol -->
            <p>
                Alcohol %
                <form:input path="alcohol" id="alcohol" value="5.00"/>
            </p>

            <!-- Price -->
            <p>
                Price (euros)
                <form:input path="beerPackage.price" id="price" name="price" value="1.00"/>
            </p>

            <!-- Beer style -->
            <h2>Choose style of the beer</h2>
            <div class="input-group login-input-group">
                <form:select path="beerStyle.id">
                    <c:forEach items="${beerStyleDropDown}" var="style">
                        <form:option value="${style.id}">${style.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <!-- Brewery -->
            <h2>Choose brewery</h2>
            <div class="input-group login-input-group">
                <form:select path="brewery.id">
                    <c:forEach items="${breweryDropDown}" var="brewery">
                        <form:option value="${brewery.id}">${brewery.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>

            <!-- Package -->
            <h2>Choose standard package size</h2>
            <form:select path="beerPackage.aPackage.packageID">
                <c:forEach items="${packageDropDown}" var="apackage">
                    <form:option value="${apackage.packageID}">${apackage.size}</form:option>
                </c:forEach>
            </form:select>


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
