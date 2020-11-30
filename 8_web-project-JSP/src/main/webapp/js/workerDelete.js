function deleteWorkerFromDB(workerId) {
    let finalUrl = '';

    let url = window.location.href.split('/');
    for (let i = 0; i < url.length - 1; i++) {
        finalUrl += url[i] + '/';
    }

    finalUrl += "worker?workerId=" + workerId;

    $.ajax({
        url: finalUrl,
        type: 'DELETE',
        success: function (data) {
            if (data == 'Success') {
                window.location.href = "worker.jsp";
                alert("Worker was deleted from DataBase.")
            }
        }
    });
}
