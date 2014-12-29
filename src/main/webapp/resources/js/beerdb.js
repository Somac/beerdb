$(document).ready(function(){

    $('.open-sign-up-modal').click(function(){
        $('#sign-up-modal').modal('show');
    });

    $('#open-sign-in-modal').click(function(){
        $('#sign-in-modal').modal('show');
    });

    /* Voting system for beers */

    $("#rating").rateYo().on("rateyo.set", function (e, data) {
        alert("The rating is set to " + data.rating + "!");
    });

});

