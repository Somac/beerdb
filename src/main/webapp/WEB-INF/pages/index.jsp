<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>BeerDB</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <script>
        $(document).ready(function(){
            $('#columnonelist li').click(function(){
                var variable = $(this).attr('value');

                $.ajax({
                    type: "GET",
                    url: "fetchColumnTwo",
                    data: "variable=" + variable
                })

            });
        });
    </script>

</head>

<body>

<!-- Page header comes from JSP Tags. It changes depending on the user role. This is for unregistered user -->
<t:unregistereduser>
    <jsp:attribute name="header">
    </jsp:attribute>
</t:unregistereduser>

<!-- Introduction text -->
<div class="container">
        <div class="jumbotron" style="background: transparent !important;">
            <h1>BeerDB</h1>
            <p>Free time project for the lulz.</p>
            <p>BeerDB is your database for delicious beers and wonderful brewerys. Search
                beers below.</p>
        </div>
</div>

<div class="container">
<div class="row">

    <!-- COLUMN ONE. Menu where beerstyles are listed -->
    <div class="col-md-4">
            <ul id="columnonelist" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                <c:forEach items="${bs}" var="b">
                    <li value="${b.id}"><a href="#" data-toggle="tab">${b.beerStyle} ${b.id}</a></li>
                </c:forEach>
            </ul>
     </div>

    <%--<!-- COLUMN TWO. Menu where beers are listed by chosen beerstyle -->--%>
    <%--<div class="col-md-4">--%>
            <%--<div id="my-tab-content" class="tab-content">--%>
                <%--<div class="tab-pane active" id="ykkostabi">--%>
                     <%--<ul class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">--%>
                             <%--<%--<li><a href="#facebooktab" data-toggle="tab" id="idVar">Facebook</a></li>--%>
                                 <%--<input type="text" id="idVar"/>--%>
                                 <%--<input type="button" value="Save" onclick="doAjax();"></button>--%>
                                 <%--<%--<button type="submit" onclick="doAjax();">Save</button>--%>

                         <%--<li><a href="#instagramtab" data-toggle="tab">Instagram</a></li>--%>
                         <%--<li><a href="#twittertab" data-toggle="tab">Twitter</a></li>--%>
                      <%--</ul>--%>
                <%--</div>--%>
                <%--<div class="tab-pane" id="kakkostabi">--%>
                    <%--<h1>Profile</h1>--%>
                    <%--<p>profile profile profile profile</p>--%>
                <%--</div>--%>
                <%--<div class="tab-pane" id="kolmostabi">--%>
                    <%--<h1>Search</h1>--%>
                    <%--<p>search search search search</p>--%>
                <%--</div>--%>
            <%--</div>--%>
    <%--</div>--%>

    <%--<!-- COLUMN THREE. All the information about chosen beer -->--%>
    <%--<div class="col-md-4">--%>
        <%--<span class="pull-left">--%>
            <%--<div class="tab-content">--%>
                <%--<div class="tab-pane" id="facebooktab">--%>
                    <%--<h1>Facebook</h1>--%>
                    <%--<p>facebook facebook facebook facebook</p>--%>
                <%--</div>--%>
                <%--<div class="tab-pane" id="instagramtab">--%>
                    <%--<h1>Instagram</h1>--%>
                    <%--<p>instagram instagram instagram instagram</p>--%>
                <%--</div>--%>
                <%--<div class="tab-pane" id="twittertab">--%>
                    <%--<h1>Twitter</h1>--%>
                    <%--<p>twitter twitter twitter twitter</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</span>--%>
    <%--</div>--%>

</div> <!-- row -->
</div> <!-- container -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>