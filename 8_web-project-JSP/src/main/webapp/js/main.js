$('.message a').click(function () {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
})

$(document).ready(function () {
    $("button#register").click(function () {
        var name = $("form.register-form input.name").val();
        var budget = $("form.register-form input.budget").val();
        var email = $("form.register-form input.email").val();
        var password = $("form.register-form input.password").val();
        var confirmPassword = $("form.register-form input.confirmPassword").val();
        if ((password.length) < 8) {
            alert("Password should at least have 8 character!!!");
        } else if (!(password).match(confirmPassword)) {
            alert("Your passwords don't match. Try again?");
        } else {
            var projectRegistration = {
                name: name,
                budget: budget,
                email: email,
                password: password
            };
            $.post("registration", projectRegistration, function (data) {
                    if (data == 'To login') {
                        alert("Project is already registered. Click to 'Sing in'.");
                    } else if (data == 'Success') {
                        $("form")[0].reset();
                        alert("Project : " + name + " was registered. Click 'Sing In.'");
                    }
                }
            );
        }
    })
    ;
})
;

$(document).ready(function () {
    $("button#login").click(function () {
        var email = $("form.login-form input.email").val();
        var password = $("form.login-form input.password").val();

        if (email == '' || password == '') {
            alert("Please fill all fields...!!!!!!");
        } else {
            var project = {
                email: email,
                password: password
            };
            $.post("login", project, function (data) {
                if (data == 'Wrong password') {
                    alert("Wrong password! Try again")
                } else if (data == 'Project is NOT registered') {
                    alert("You are NOT registered! Please click 'Create new project'.")
                } else if (data != '') {
                    let finalUrl = '';
                    let url = window.location.href.split('/');
                    for (let i = 0; i < url.length - 1; i++) {
                        finalUrl += url[i] + '/';
                    }
                    finalUrl += data.destinationUrl;
                    window.location.href = finalUrl;
                }
                $("form")[1].reset();
            });
        }
    });
});