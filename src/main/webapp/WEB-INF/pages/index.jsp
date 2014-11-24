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


    <!-- MUSTACHE.JS TEMPLATES for parsing JSON to HTML -->
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
        <h1>{{name}}</h1>
        {{#beerPackage}}
        <p style="font-size: 150%">{{price}} € <span style="font-style: italic; font-size: 80%">{{size}}l</span><br></p>
        <p style="font-style: italic">{{perLiter}} €/l</p>
        {{/beerPackage}}

        <div class="title">
            <h2>Description</h2>
        </div>
        <p>Contains {{alcohol}}% percent of alcohol. {{description}}</p>
        <hr>

        <div class="title">
            <h2>Brewery</h2>
        </div>
        {{#brewery}}
        <p>{{name}}, {{country}}</p>
        {{/brewery}}
        <hr>

        <div class="title">
            <h2>Uploader</h2>
        </div>
        {{#user}}
        <p>{{username}} on {{created}}</p>
        {{/user}}
        <hr>

        <div class="title">
            <h2>Rating</h2>
        </div>
        <div class="ui star rating"></div> 3.6 avg.
        Votes given:
        <br>

    </script>
</head>
<body>
<!-- Navigation bar (Tag file) -->
<t:navigationbar></t:navigationbar>

<!-- Actual body of the site -->
<div class="container-fluid introduction">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 text-center">
            <span class="vertical-align">
                <h1>Database for Beers and Brewerys</h1>

                    <!-- Introduction text for unregistered user -->
                    <sec:authorize access="isAnonymous()">
                    <p class="lead">BeerDB is your database for delicious beers and wonderful brewerys.
                        <a href="#" class="open-sign-up-modal">Sign Up</a> and you can post your own beers to database and even
                        rate them (well, not yet, but it's coming..)! So much wow. Freetime project.
                    </p>
                    </sec:authorize>

                    <!-- Introduction text for registered user -->
                    <sec:authorize access="isAuthenticated()">
                    <p class="lead">You are logged in as "<sec:authentication property="principal.username"/>"
                        and this text is mainly placeholder. </p>
                    </sec:authorize>
            </span>
        </div>
    </div>
</div>

<div class="container">
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
                     <ul id="column-two-content" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                     <!-- Data for li-elements are dynamically generated by appendResponseToColumnTwo -function in callajax.js -->
                     </ul>
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

    <c:if test="${openSignUpModalIfSignUpFail == true}">
    $('#sign-up-modal').modal('show');
    </c:if>
});
</script>

<!-- Footer (tag files) -->
<t:footer></t:footer>
</body>
</html>