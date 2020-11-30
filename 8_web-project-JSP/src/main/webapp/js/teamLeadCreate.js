$(document).ready(function () {
    $("form input#createTeamLead").click(function () {
        var fullName = $("form input.fullName").val();
        var dateOfBirth = $("form input.dateOfBirth").val();
        var salary = $("form input.salary").val();

        if (fullName == '' || dateOfBirth == '' || salary == '') {
            alert("Please fill all fields!");
        } else {
            var teamLead = {
                fullName: fullName,
                dateOfBirth: dateOfBirth,
                salary: salary
            };

            $.post("teamLead", teamLead, function (data) {
                if (data == 'To create') {
                    alert("TeamLead was already created!");
                } else if (data == 'Success') {
                    alert("TeamLead : " + fullName + ", title : " + dateOfBirth + ", salary : " + salary + " was added!");
                    $("form")[0].reset();
                }
            });
        }
    });
});