<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>BeerDB</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.js"></script>
    <script src="<c:url value="/resources/js/callajax.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/formvalidation.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/beerdb.js"/>" type="text/javascript"></script>
    <c:set var="context" value="${pageContext.request.contextPath}" />

    <!-- MUSTACHE.JS TEMPLATING -->
    <!-- Templating for first column's data -->
    <script type="text/template" id="template-column-one">
        {{#.}}
            <li value="{{id}}"><a href="#" data-toggle="tab">{{name}}</a></li>
        {{/.}}
    </script>

    <!-- Templating for second column's data -->
    <script type="text/template" id="template-column-two">
        {{#.}}
            <li value="{{id}}"><a href="{{id}}" data-toggle="tab">{{name}}</a></li>
        {{/.}}
    </script>

    <!-- Templating for third column's data -->
    <script type="text/template" id="template-column-three">
        <h1 align="center">{{name}}</h1>
        {{#beerPackage}}
        <div>{{price}} euros, {{size}}l</div>
        {{/beerPackage}}
        <br>
        <p>Description: {{description}}</p>
        <p>Alcohol: {{alcohol}}%</p>
        {{#brewery}}
        <p>Brewery: {{name}}, {{country}}</p>
        {{/brewery}}
        Ingredients:
        {{#beerRawMaterialList}}
        <ol>
            {{#.}}
             <li>{{rawMaterial}}</li>
            {{/.}}
        </ol>
        {{/beerRawMaterialList}}

        {{#user}}
        <p>Uploaded by {{username}} on {{created}}</p>
        {{/user}}
        <br>
    </script>
</head>

<body>

<!-- Page header comes from JSP Tags. It changes depending on the user role. This is for unregistered user -->
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <!-- Mobile header -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">BeerDB</a>
        </div>

        <!-- Navigation bar -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">

                <!-- Sign Up / Sign In links are shown for the unregistered user -->
                <sec:authorize access="isAnonymous()">
                <li>
                    <a href="#" class="open-sign-up-modal">Sign Up</a>
                </li>
                <li>
                    <a href="#" id="open-sign-in-modal">Sign In</a>
                </li>
                </sec:authorize>

                <!-- Dropdown menu are shown for the registered user -->
                <sec:authorize access="isAuthenticated()">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Settings <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Placeholder</a></li>
                        <li><a href="#">Placeholder</a></li>
                        <li><a href="#">Placeholder</a></li>
                        <li class="divider"></li>
                        <li><a href="${context}/logout">Log off</a></li>
                    </ul>
                </li>
                </sec:authorize>
            </ul>
        </div>

    </div>
</nav>

<!-- SIGN UP pop-up -->
<div class="modal" id="sign-up-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" id="reset-form" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">SIGN UP</h4>
            </div>
            <div class="modal-body">
                <div class="col-lg-6">
                    <form:form id="validate-form" modelAttribute="user" method="POST" action="${context}/signup">
                        Username:
                        <form:input path="username" class="form-control"/>
                        <form:errors path="username"/>
                        Firstname:
                        <form:input path="firstname" class="form-control"/>
                        <form:errors path="firstname"/>
                        Lastname:
                        <form:input path="lastname" class="form-control"/>
                        <form:errors path="lastname"/>
                        Email:
                        <form:input path="email" class="form-control"/>
                        <form:errors path="email"/>
                        Password:
                        <form:input path="password" type="password" class="form-control" id="password"/>
                        <form:errors path="password"/>
                        Password:
                        <input name="password2" type="password" class="form-control"/>
                        <button type="submit" class="btn btn-primary">Seivaa!</button>
                    </form:form>
                </div>
                <div class="col-lg-6">
                    <!-- prerendered text, username validation? -->
                </div>
                <div class="modal-footer">
                    <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                    <%--<button type="submit" class="btn btn-primary">Save changes</button>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- SIGN IN pop-up -->
<div class="modal" id="sign-in-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div id="loginbox" class="mainbox col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <div class="panel-heading">
                    <div class="panel-title">Sign In</div>
                    <button type="button" class="close login-close-button" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                </div>

                <div id="login-panel-body" class="panel-body" >

                    <form action="j_spring_security_check" method="POST" id="loginform" class="form-horizontal" role="form" >
                        <div class="input-group login-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input id="login-username" type="text" class="form-control" name="j_username" placeholder="username">
                        </div>

                        <div class="input-group login-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input id="login-password" type="password" class="form-control" name="j_password" placeholder="password">
                        </div>

                        <div class="error"><c:out value="${loginError}"/></div>

                        <div id="login-form-group" class="form-group">
                            <div class="col-sm-12 controls">
                                <button type="submit" class="btn btn-success">Login</button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>



<div class="container">
    <div class="row">
        <!-- Introduction text -->
        <div class="col-lg-12 text-center">
            <h1>Database for Beers and Brewerys</h1>

            <!-- Content for unregistered user -->
            <sec:authorize access="isAnonymous()">
            <p class="lead">BeerDB is your database for delicious beers and wonderful brewerys.
                <a href="#" class="open-sign-up-modal">Sign Up</a> and you can post your own beers to database and even
                rate them (well, not yet, but it's coming soon..)! So much wow. Freetime project.
            </p>
            </sec:authorize>

            <!-- Content for registered user -->
            <sec:authorize access="isAuthenticated()">
            <p class="lead">You are registered as "<sec:authentication property="principal.username"/>"
                and this text is mainly placeholder</p>
            </sec:authorize>
        </div>
    </div>

    <div class="row">
        <div class="menu">
            <!-- COLUMN ONE. Menu where beerstyles are listed -->
            <div class="col-lg-3">
                <ul id="column-one-content" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                <!-- Data for li-elements are dynamically generated by appendResponseToColumnOne -function in callajax.js -->
                </ul>
             </div>

            <!-- COLUMN TWO. Menu where beers are listed by chosen beerstyle -->
            <div class="col-lg-3">
                <div id="my-tab-content" class="tab-content">
                    <div class="tab-pane active">
                         <ul id="column-two-content" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                         <!-- Data for li-elements are dynamically generated by appendResponseToColumnTwo -function in callajax.js -->
                         </ul>
                    </div>
                </div>
            </div>

            <!-- COLUMN THREE. All the information about chosen beer -->
            <div class="col-lg-6">
                    <div id="column-three-content" class="tab-content">
                    <!-- Data for this div is dynamically generated in appendResponseToColumnThree -function in callajax.js  -->
                    </div>
            </div>
        </div> <!-- menu -->
    </div> <!-- row -->

</div> <!-- container -->

<script>
$(document).ready(function() {
    <c:if test="${openSignInModalIfLoginFail == true}">
    $('#sign-in-modal').modal('show');
    </c:if>

    <%--<c:if test="${openSignUpModalIfFormErrors == true}">--%>
    <%--$('#sign-up-modal').modal('show');--%>
    <%--</c:if>--%>
});
</script>


<!-- Footer -->
<div class="footer navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <a target="_blank" href="https://github.com/juhaniniinimaa/beerdb">
                    <img src="<c:url value="/resources/logos/GitHub-Mark-32px.png"/>" alt="GitHub"/></a>
            </div>
        </div>
    </div>
</div>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>