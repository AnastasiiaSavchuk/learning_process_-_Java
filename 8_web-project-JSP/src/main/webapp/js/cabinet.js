function search() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("teamLeadTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

let workers = null;

$.get("teamLead", function (data) {
    if (data != '') {
        workers = data;
    }
}).done(function () {
    let tableContent = "<tr>" +
        "<th>Full Name</th>" +
        "<th>Title</th>" +
        "<th>Salary</th>" +
        "<th>Count</th>" +
        "<th>Actions</th>" +
        "</tr>";

    jQuery.each(workers, function (i, worker) {
        tableContent += "<tr class='header'>" +
            "<td>" + worker.fullName + "</th>" +
            "<td>" + worker.title + "</th>" +
            "<td>" + worker.salary + "</th>" +
            "<td>" + worker.count + "</td>" +
            "<td><button onclick='deleteWorkerFromTeamLead(" + worker.id + ")'><i class='fa fa-trash' aria-hidden='true'></i></button></td>" +
            "</tr>";
    });

    $("table#teamLeadTable").html(tableContent);
});

function deleteWorkerFromTeamLead(workerId) {
    let finalUrl = '';
    let url = window.location.href.split('/');
    for (let i = 0; i < url.length - 1; i++) {
        finalUrl += url[i] + '/';
    }
    finalUrl += "teamLead?workerId=" + workerId;

    $.ajax({
        url: finalUrl,
        type: 'DELETE',
        success: function (data) {
            if (data == 'Success') {
                location.reload();
                alert("Worker was deleted.")
            }
        }
    });
}