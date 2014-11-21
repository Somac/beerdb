$(document).ready(function(){

    <!-- Front-end validation for user registration -->

    $('#validate-form').validate({
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
});
