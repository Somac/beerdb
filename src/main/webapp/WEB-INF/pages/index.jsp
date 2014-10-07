<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>BeerDB</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%--<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>--%>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <script>
        //ei toimi vielä!!
        $(function(){
            var hash = window.location.hash;
            hash && $('ul.nav a[href="' + hash + '"]').tab('show');

            $('.nav-tabs a').click(function (e) {
                $(this).tab('show');
                var scrollmem = $('body').scrollTop();
                window.location.hash = this.hash;
                $('html,body').scrollTop(scrollmem);
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


<div class="row">
    <!-- COLUMN ONE. Menu where beerstyles are listed -->
    <div class="col-md-4 devSet"/>
        <span class="pull-right">
            <ul class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs" style="float:left; width:200px; clear:none;">
                <li class="active"><a href="#ykkostabi" data-toggle="tab">Home</a></li>
                <li><a href="#kakkostabi" data-toggle="tab">Profile</a></li>
                <li><a href="#kolmostabi" data-toggle="tab">Search</a></li>
            </ul>
        </span>
     </div>

    <!-- COLUMN TWO. Menu where beers are listed by chosen beerstyle -->
    <div class="col-md-2 devSet">
            <div id="my-tab-content" class="tab-content" style="float:left; width:200px;">
                <div class="tab-pane active" id="ykkostabi">
                     <ul class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                         <li><a href="#facebooktab" data-toggle="tab">Facebook</a></li>
                         <li><a href="#instagramtab" data-toggle="tab">Instagram</a></li>
                         <li><a href="#twittertab" data-toggle="tab">Twitter</a></li>
                      </ul>
                </div>
                <div class="tab-pane" id="kakkostabi">
                    <h1>Profile</h1>
                    <p>profile profile profile profile</p>
                </div>
                <div class="tab-pane" id="kolmostabi">
                    <h1>Search</h1>
                    <p>search search search search</p>
                </div>
            </div>
    </div>

    <!-- COLUMN THREE. All the information about chosen beer -->
    <div class="col-md-4 devSet">
        <span class="pull-left">
            <div class="tab-content">
                <div class="tab-pane" id="facebooktab">
                    <h1>Facebook</h1>
                    <p>facebook facebook facebook facebook</p>
                </div>
                <div class="tab-pane" id="instagramtab">
                    <h1>Instagram</h1>
                    <p>instagram instagram instagram instagram</p>
                </div>
                <div class="tab-pane" id="twittertab">
                    <h1>Twitter</h1>
                    <p>twitter twitter twitter twitter</p>
                </div>
            </div>
        </span>
    </div>
</div>

<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>--%>
<%--<script src="resources/js/bootstrap.min.js"></script>--%>
</body>
</html>