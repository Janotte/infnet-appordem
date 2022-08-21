$('#confirm-delete-modal').on('show.bs.modal', function(e) {
    $(this).find('.confirm-delete-btn').attr('href', $(e.relatedTarget).data('href'));
});

$('confirm-delete-modal').on('click', '.confirm-delete-btn', function(e) {

  var $modalDiv = $(e.delegateTarget);
  var id = $(this).data('recordId');

  $modalDiv.addClass('loading');
  $.post('/componente/' + id + '/excluir').then(function() {
     $modalDiv.modal('hide').removeClass('loading');
  });
});

$(function(){
  $('#datepicker').datepicker();
});