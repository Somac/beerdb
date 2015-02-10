<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
<c:set var="principalUsername">
    <sec:authentication property="principal.username" />
</c:set>
</sec:authorize>
<!DOCTYPE html>
<html>
<head>
    <!-- Links and scripts (tag file) -->
    <t:dependencies></t:dependencies>

    <!-- Templating for first column's data -->
    <script type="text/x-handlebars-template" id="template-column-one">
        {{#.}}
        <li value="{{id}}"><a href="#" data-toggle="tab">{{name}}</a></li>
        {{/.}}
    </script>

    <!-- Templating for second column's data -->
    <script type="text/x-handlebars-template" id="template-column-two">
        {{#.}}
            <li value="{{id}}"><a href="{{id}}" data-toggle="tab">{{name}}</a></li>
        {{/.}}
    </script>

    <!-- Templating for third column's data -->
    <script type="text/x-handlebars-template" id="template-column-three">
        <h1>{{name}}</h1>
        {{#beerPackage}}
        <p class="price">{{price}} € <span class="size">{{aPackage.size}}l</span><br></p>
        <p class="per-liter">{{pricePerLiter}} €/l</p>
        {{/beerPackage}}

        <div class="title">
            <h2>Rating</h2>
        </div>
            {{#rating}}
                {{#if averageRate}}
                    <p>{{averageRate}} stars out of 5</p>
                    <p>{{amountOfRaters}} voters</p>
                    {{else}}
                    <p>No votes given.</p>
                {{/if}}
            {{/rating}}
        <hr>

        <div class="title">
            <h2>Description</h2>
        </div>
        <p>Contains {{alcohol}}% percent of alcohol. {{description}}</p>
        <hr>

        <div class="title">
            <h2>Brewery</h2>
        </div>
        {{#brewery}}
        <p>{{name}}, {{country.name}}</p>
        {{/brewery}}
        <hr>

        <div class="title">
            <h2>Uploader</h2>
        </div>
        {{#user}}
        <p>{{username}} on {{../created}}</p>
        {{/user}}
        <hr>

    </script>
</head>
<body>
<!-- Navigation bar -->
<t:navigationbar></t:navigationbar>

<!-- Introduction -->
<div class="container-fluid introduction">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 text-center">
            <span class="vertical-align">
                <h1>Database for Beers and Brewerys</h1>

                    <!-- Introduction text for unregistered user -->
                    <sec:authorize access="isAnonymous()">
                    <p class="lead">BeerDB is your database for delicious beers and wonderful brewerys.
                        <a href="${context}/signup" type="submit">Sign Up</a> and you can post your own beer to database and
                        rate others. So much wow. Free-time project.
                    </p>
                    </sec:authorize>

                    <!-- Introduction text for registered user -->
                    <sec:authorize access="isAuthenticated()">
                    <p class="lead">You are logged in as "${principalUsername}"
                        and this text is mainly placeholder. </p>
                    </sec:authorize>
            </span>
        </div>
    </div>
</div>

<!-- Menu -->
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


<!-- Success modal when user registration or adding beer to db is completed -->
<div class="modal" id="success-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Great success!</h4>
            </div>
            <div class="modal-body">
                <!-- "You just made a new account.." OR "You successfully added beer.." -->
                ${message}
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">OK</button>
            </div>
        </div>
    </div>
</div>


<!-- Opens success modal -->
<script>
    $(document).ready(function() {
        <c:if test="${openSuccessModal == true}">
        $('#success-modal').modal('show');
        </c:if>
    });
</script>

<!-- Footer -->
<t:footer></t:footer>
</body>
</html>