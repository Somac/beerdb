$(document).ready(function(){

$('.open-sign-up-modal').click(function(){
    $('#sign-up-modal').modal('show');
});

$('#open-sign-in-modal').click(function(){
    $('#sign-in-modal').modal('show');
});

$('#reset-form').click(function(){
    var form = $('#validate-form').validate();
    form.resetForm();

});

});

