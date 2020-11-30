var oldId = $("button#update").click(function () {
    let oldId = jQuery(this).attr("worker_id");
    return oldId;
});

$(document).ready(function () {
    $("form input#updateWorker").click(function () {

        var fullName = $("form input.fullName").val();
        var title = $("form input.title").val();
        var salary = $("form input.salary").val();

        if (fullName == '' || title == '' || salary == '') {
            alert("Please fill all fields...!!!!!!");
        } else {

            var worker = {
                oldId: oldId,
                fullName: fullName,
                title: title,
                salary: salary
            };

            $.ajax({
                type: 'PUT',
                url: 'worker',
                contentType: 'application/json',
                data: JSON.stringify(worker),
            });

            alert("Worker : " + fullName + ", title : " + title + ", salary : " + salary + " was updated");
        }
    });
});

