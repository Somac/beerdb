$(document).ready(function(){

   /*
    * Front-end validation for user registration *
    */

    $('#validate-sign-up-form').validate({
        rules: {
            username: {
              required: true,
              minlength: 3
            },
            email: {
                required: true,
                email: true
            },
            password: {
               required: true,
               minlength: 5
            },
            password2: {
               required: true,
               equalTo: "#password"
            }
        }
    });


    /*
     * Front-end validation for "add beer" function and jquery spinner for numbers *
     */

    $( "#alcohol" ).spinner({
        step: 0.01,
        numberFormat: "n"
    });

    $( "#price" ).spinner({
        min: 0.1,
        max: 80000,
        step: 0.01,
        numberFormat: 'C',
        culture: 'de-DE'
    });

    $('#validate-add-beer-form').validate({
        rules: {
            name: {
                required: true,
                minlength: 2,
                maxlength: 30
            },
            description:{
                required: true,
                minlength: 5,
                maxlength: 100
            },
            alcohol: {
                required: true,
                min: 0.1,
                max: 100,
                number: true
            },
            "beerPackage.price": {
                required: true,
                min: 0.1,
                max: 100000,
                number: true
            }
        }
    });

});
