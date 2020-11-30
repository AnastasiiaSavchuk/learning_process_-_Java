let projects = null;

$.get("getProject", function (data) {
    if (data != '') {
        projects = data;
    }
}).done(function () {
    let cardsContent = '';

    jQuery.each(projects, function (i, project) {
        cardsContent += "<div class='card border-success mb-3' style='width: 350px; border-color: #004c40; margin-right: 3px; display: inline-block !important;'>" +
            "<div class='card-header'>" +
            "<h3>Project name : " + project.name + "</h3>" +
            "</div>" +
            "<div class='card-body text-success'>" +
            "<h4 style='color: #404E67;'>Project role : " + project.role + "</h4>" +
            "</div>" +
            "<div class='card-body text-success'>" +
            "<h4 style='color: #404E67;'>Project budget : " + project.budget + "</h4>" +
            "</div>" +
            "<div class='card-body text-success'>" +
            "<h4 style='color: #404E67;'>Project email : " + project.email + "</h4>" +
            "</div>" +
            "<div class='card-body text-success'>" +
            "<h4 style='color: #00796b;'>Project is bla bla bla</h4>" +
            "</div>" +
            "</div>"
    })

    $("div#projectCards").html(cardsContent);
});