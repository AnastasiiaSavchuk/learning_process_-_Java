let workers = null;

$.get("getWorker", function (data) {
    if (data != '') {
        workers = data;
    }
}).done(function () {
    let cardsContent = '';

    jQuery.each(workers, function (i, worker) {
        cardsContent += "<div class='card border-success mb-3' style='width: 270px;border-color: #004c40;margin-right: 3px;display: inline-block;'>" +
            "<div class='card-header'>" +
            "<h3 class='card-title'>Worker name : " + worker.fullName + "</h3>" +
            "</div>" +
            "<div class='card-body text-success'>" +
            "<h4 style='color: #00796b;font-size: 14px;font-weight:bold;'>Work in the project company. Lalalalalalalalalalalalalala. </h4>" +
            "<a href='worker?id=" + worker.id + "'style='color: #004c40;font-size: 14px;font-weight:bold;margin-top: 10px'>About worker</a> " +
            "</div>" +
            "</div>"
    })

    $("div#workerCards").html(cardsContent);
});