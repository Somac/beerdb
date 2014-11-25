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

//    $('#reset-sign-up-form').click(function(){
//        var form = $('#validate-sign-up-form').validate();
//        form.resetForm();
//
//    });

    /*
     * Front-end validation for "add beer" function *
     */

    $('#validate-add-beer-form').validate({
        rules: {
            name: {
                required: true,
                minlength: 2
            }
        }
    });

});
