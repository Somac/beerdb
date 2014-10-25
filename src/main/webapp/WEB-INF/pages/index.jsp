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
    <script src="resources/js/mustache.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <script>

        $(document).ready(function(){

            <!-- Generates first column to the menu when page is loaded and presents it via it's own template -->
            $.getJSON("fetchColumnOneData", function(response){
                console.log(response);

                var template = $('#template-column-one').html();
                var text = Mustache.render(template, response);

                $('#column-one-content').html(text);

            });

             <!-- When link (some beerstyle) have been clicked in column 1. it triggers AJAX call below -->
             <!-- and generates content to the second menu and presents it via it's own template. -->
            $('#column-one-content').on('click','li', function(){
                var styleID = $(this).attr('value');

                $.ajax({
                    type: "GET",
                    url: "fetchColumnTwoData",
                    data: "styleID=" + styleID,
                    success: function(response){
                        appendResponseToColumnTwo(response);
                    },
                    error: function(){
                        alert('Ajax call for second menu caused an error');
                    }
                })
                function appendResponseToColumnTwo(response){
                    console.log(response);

                    var columnThree = $('#column-three-content');
                    columnThree.empty();

                    var template = $('#template-column-two').html();
                    var text = Mustache.render(template, response);

                    $('#column-two-content').html(text);
                }
            });

            <!-- When link (some beer) have been clicked in column 2. it triggers AJAX call below and generates content -->
            <!-- to the third menu and presents it via it's own template. -->
            $('#column-two-content').on('click', 'li', function(){
                var beerID = $(this).attr('value')

                $.ajax({
                    type: "GET",
                    url: "fetchColumnThreeData",
                    data: "beerID=" + beerID,
                    success: function(response){
                        appendResponseToColumnThree(response);
                    },
                    error: function(){
                        alert('Ajax call for third menu caused an error');
                    }
                })
                function appendResponseToColumnThree(response){
                    console.log(response);

                    var template = $('#template-column-three').html();
                    var text = Mustache.render(template, response);
                    $('#column-three-content').html(text);
                }

            });
        });
    </script>

    <!-- MUSTACHE.JS TEMPLATING -->
    <!-- Templating for first column's data -->
    <script type="text/template" id="template-column-one">
        {{#.}}
        <li value="{{id}}"><a href="#" data-toggle="tab">{{beerStyle}}</a></li>
        {{/.}}
    </script>

    <!-- Templating for second column's data -->
    <script type="text/template" id="template-column-two">
        {{#.}}
        <li value="{{id}}"><a href="{{name}}" data-toggle="tab">{{name}}</a></li>
        {{/.}}
    </script>

    <!-- Templating for third column's data -->
    <script type="text/template" id="template-column-three">
        <h1>{{name}}</h1>
        <p>Process: {{process}}</p>
        <p>Not much to see here yet</p>
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
        <ul id="column-one-content" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
        <!-- Data for li-elements are dynamically generated by appendResponseToColumnOne (JS method) -->
        </ul>
     </div>

    <!-- COLUMN TWO. Menu where beers are listed by chosen beerstyle -->
    <div class="col-md-4">
        <div id="my-tab-content" class="tab-content">
            <div class="tab-pane active">
                 <ul id="column-two-content" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                 <!-- Data for li-elements are dynamically generated by appendResponseToColumnTwo (JS method) -->
                 </ul>
            </div>
        </div>
    </div>

    <!-- COLUMN THREE. All the information about chosen beer -->
    <div class="col-md-4">
        <span class="pull-left">
            <div id="column-three-content" class="tab-content">
            <!-- Data for this div is dynamically generated in appendResponseToColumnThree (JS method) -->
            </div>
        </span>
    </div>


</div> <!-- row -->
</div> <!-- container -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>