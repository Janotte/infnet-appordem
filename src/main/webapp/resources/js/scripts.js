$("#confirm-delete-modal").on("show.bs.modal", function (e) {
    $(this)
        .find(".confirm-delete-btn")
        .attr("href", $(e.relatedTarget).data("href"));
});

$("confirm-delete-modal").on("click", ".confirm-delete-btn", function (e) {
    var $modalDiv = $(e.delegateTarget);
    var id = $(this).data("recordId");

    $modalDiv.addClass("loading");
    $.post("/usuario/" + id + "/excluir").then(function () {
        $modalDiv.modal("hide").removeClass("loading");
    });
});

$(function () {
    $("#datepicker").datepicker();
});

$("#alert").show().delay(4000).fadeOut();

$("#insert-modal").on("show.bs.modal", function (e) {
    $(this)
        .find(".confirm-insert-btn")
        .attr("href", $(e.relatedTarget).data("href"));
});

$("insert-modal").on("click", ".confirm-insert-btn", function (e) {
    var $modalDiv = $(e.delegateTarget);
    var id = $(this).data("recordId");

    $modalDiv.addClass("loading");
    $.post("/ordem/" + id + "/itens/adicionar").then(function () {
        $modalDiv.modal("hide").removeClass("loading");
    });
});
