$(document).ready(function(){

   /*
    * Front-end validation for user registration *
    */

    $('#validate-sign-up-form').validate({
        errorElement: "div",
        errorPlacement: function(error, element){
            error.appendTo("div#errors");
        },
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
        },
        messages: {
            username: {
                required: "Username is required",
                minlength: "Username must be at least 3 characters long"
            },
            email: {
                required: "Email is required",
                email: "Please enter a valid email address."
            },
            password: {
                required: "Password is required",
                minlength: "Password must be at least 5 characters long"
            },
            password2: {
                required: "Password is required",
                equalTo: "Passwords don't match"
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
        errorElement: "div",
        errorPlacement: function(error){
            error.appendTo("div#beererrors");
        },
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
        },
        messages: {
            name: {
                required: "Name of the beer is required",
                minlength: "Name must be at least 3 characters long",
                maxlength: "Name can't be more than 30 characters"

            },
            description:{
                required: "Description is required",
                minlength: "Description must be at least 3 characters long",
                maxlength: "Name can't be more than 100 characters"
            },
            alcohol:{
                required: "Alcohol percent is required",
                min: "Alcohol percent must be greater than or equal to 0.1",
                max: "Alcohol percent must be less or equal to 100",
                number: "Please enter only numbers"
            },
            "beerPackage.price":{
                required: "Price is required",
                min: "Price must be greater than or equal to 0.1",
                max: "Price must be less or equal to 100.000",
                number: "Please enter only numbers"
            }
        }
    });

});
