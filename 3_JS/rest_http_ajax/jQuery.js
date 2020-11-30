$(document).ready(function () {
    $('#ajaxGet').bind('click', function () {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: 'http://localhost:3000/personGet?surname=' + $('#getSurname').val() +
                '&name=' + $('#getName').val() + '&age=' + $('#getAge').val() +
                '&address=' + $('#getAddress').val(),
            success: function (data) {
                console.log('This is success!');
                console.log(JSON.stringify(data));
            }
        });
    });

    $('#getAge').blur(function () {
        if (($(this).val() < 0) || ($(this).val() > 100) || (isNaN($(this).val()))) {
            $('#getAge').val('Введіть вік від 0 до 100');
            $('#getAge').focus();
        }
    });
});

$(document).ready(function () {
    $('#ajaxPost').bind('click', function () {
        $.ajax({
            type: 'POST',
            data: JSON.stringify({
                surname: $('#postSurname').val(),
                name: $('#postName').val(),
                age: $('#postAge').val(),
                address: $('#postAddress').val()
            }),
            contentType: 'application/json',
            url: 'http://localhost:3000/personPost',
            success: function (data) {
                console.log('This is success!');
                console.log(JSON.stringify(data));
            }
        });
    });

    $('#postAge').blur(function () {
        if (($(this).val() < 0) || ($(this).val() > 100) || (isNaN($(this).val()))) {
            $('#postAge').val('Введіть вік від 0 до 100');
            $('#postAge').focus();
        }
    });
});