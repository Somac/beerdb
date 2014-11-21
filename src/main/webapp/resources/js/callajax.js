$(document).ready(function(){

   /*
    * Generates first column to the menu when page is loaded and presents it via it's own template
    */

    $.getJSON("fetchColumnOneData", function(response){
        console.log(response);

        var template = $('#template-column-one').html();
        var text = Mustache.render(template, response);

        $('#column-one-content').html(text);

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

            var template = $('#template-column-two').html();
            var text = Mustache.render(template, response);

            $('#column-two-content').html(text);
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

            var template = $('#template-column-three').html();
            var text = Mustache.render(template, response);
            $('#column-three-content').html(text);
        }

    });
});