$(document).ready(function(){


    $('#open-sign-up-modal').click(function(){
        $('#sign-up-modal').modal('show');
    });

    $('#open-sign-in-modal').click(function(){
        $('#sign-in-modal').modal('show');
    });

    $('#reset-form').click(function(){
        var form = $('#validate-form').validate();
        form.resetForm();

    });

    <!-- Validation for user registration -->

    $('#validate-form').validate({
        rules: {
            username: {
              required: true,
              minlength: 3
            },
            password: {
                required: true
            },
            password2: {
                required: true,
                equalTo: "#password"
            }
        }
    });
});
