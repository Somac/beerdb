$(document).ready(function(){

   /*
    * Generates first column to the menu when page is loaded and presents it via it's own template
    */

    $.getJSON("fetchColumnOneData", function(response){
        console.log(response);

        var output = $('#template-column-one').html();
        var template = Handlebars.compile(output);

        $('#column-one-content').html(template(response));

    });


   /*
    * When link (some beerstyle) have been clicked in column 1. it triggers AJAX call below
    * and generates content to the second menu and presents it via it's own template.
    */

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

            var output = $('#template-column-two').html();
            var template = Handlebars.compile(output);

            $('#column-two-content').html(template(response));
        }
    });


    /*
     * When link (some beer) have been clicked in column 2. it triggers AJAX call below and generates content
     * to the third menu and presents it via it's own template.
     */

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

            var output = $('#template-column-three').html();
            var template = Handlebars.compile(output);

            $('#column-three-content').html(template(response));

        }

    });
});