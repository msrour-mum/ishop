$(document).ready(function () {
    $('#password, #repassword').on('keyup', function () {

if ($('#password').val() == $('#repassword').val()) {
$('#message').html('Matching').css('color', 'green');
} else
$('#message').html('Not Matching').css('color', 'red');

});

});

