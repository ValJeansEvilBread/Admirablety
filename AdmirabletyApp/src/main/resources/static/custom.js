$(document).ready(function() {
  $('.purge_btn').hover(function(){
    $(this).removeClass('btn-primary');
    $(this).addClass('btn-danger');
    $(this).html("Purge");
  }, function(){
    $(this).html("Track");
    $(this).removeClass('btn-danger');
    $(this).addClass('btn-primary');
  });
})