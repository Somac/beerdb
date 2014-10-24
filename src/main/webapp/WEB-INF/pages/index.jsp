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
            $('#column-one-list li').click(function(){
                var styleID = $(this).attr('value');

                $.ajax({
                    type: "GET",
                    url: "fetchColumnTwo",
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

                    var columnTwo = $('#column-two-list');
                    columnTwo.empty();

                    for (var i = 0; i < response.length; i++){
                        columnTwo.append("<li value=\"" + response[i].id + "\"><a href=\"#content\" data-toggle=\"tab\">"
                                + response[i].name + "</a></li>");
                    }
                }
            });
            $('#column-two-list').on('click', 'li', function(){
                var beerID = $(this).attr('value')

                $.ajax({
                    type: "GET",
                    url: "fetchColumnThree",
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

                    var columnThree = $('#column-three-content');
                    columnThree.empty();

                    columnThree.append('<h1>' + response.name + '</h1>' +
                            '<br><b>Process</b><br><p>' + response.process + '</p>' +
                            '<br><b>BreweryID</b><br><p>' + response.breweryID + '</p>');
                }

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
            <ul id="column-one-list" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                <c:forEach items="${beerStyleList}" var="b">
                    <li value="${b.id}"><a href="#" data-toggle="tab">${b.beerStyle} ${b.id}</a></li>
                </c:forEach>
            </ul>
     </div>

    <!-- COLUMN TWO. Menu where beers are listed by chosen beerstyle -->
    <div class="col-md-4">
            <div id="my-tab-content" class="tab-content">
                <div class="tab-pane active">
                     <ul id="column-two-list" class="nav nav-pills nav-stacked" role="tablist" data-tabs="tabs">
                     <!-- Data for li-elements are dynamically listed by appendResponseToColumnTwo (JS method) -->
                     </ul>
                </div>
            </div>
    </div>

    <!-- COLUMN THREE. All the information about chosen beer -->
    <div class="col-md-4">
        <span class="pull-left">
            <div class="tab-content" id="column-three-content">
            <!-- Data for this div is dynamically made in appendResponseToColumnThree (JS method) -->
            </div>
        </span>
    </div>

</div> <!-- row -->
</div> <!-- container -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>