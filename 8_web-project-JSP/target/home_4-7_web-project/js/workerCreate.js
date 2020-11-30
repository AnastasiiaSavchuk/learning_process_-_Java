$(document).ready(function () {
    $("form input#createWorker").click(function () {

        var fullName = $("form input.fullName").val();
        var title = $("form input.title").val();
        var salary = $("form input.salary").val();

        if (fullName == '' || title == '' || salary == '') {
            alert("Please fill all fields!");
        } else {

            var worker = {
                fullName: fullName,
                title: title,
                salary: salary
            };

            $.post("worker", worker, function (data) {
                if (data == 'To create') {
                    alert("Worker : " + fullName + ", title : " + title + ", salary : " + salary + " was already created!");
                } else if (data == 'Success') {
                    $("form")[0].reset();
                    alert("Worker : " + fullName + ", title : " + title + ", salary : " + salary + " was created!");
                }
            });
        }
    });
});