$(document).ready(function(){

    /* Voting system for beers */

    $("#rating").rateYo().on("rateyo.set", function (e, data) {
        alert("The rating is set to " + data.rating + "!");
    });

});

