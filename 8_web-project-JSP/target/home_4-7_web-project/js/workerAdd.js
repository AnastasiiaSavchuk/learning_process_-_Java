$("button#add").click(function () {
    let workerId = jQuery(this).attr("worker_id");

    $.post("teamLeadWorker", {'workerId': workerId}), function (data) {
        if (data == "Worker was added") {
            alert("Worker :" + workerId + ", was already added to TeamLead.");
        } else if (data == "Success") {
            alert("Worker with id : " + workerId + ", was added to TeamLead.");
        }
    };
});