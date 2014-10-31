$(document).ready(function(){

    <!-- Validation for user registration -->

    $('#form-validate').validate({
        rules: {
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
