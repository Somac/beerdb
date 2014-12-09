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
     * Front-end validation for "add beer" function *
     */

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
            price: {
                required: true,
                min: 0.1,
                max: 100000,
                number: true
            }
        }
    });

});
