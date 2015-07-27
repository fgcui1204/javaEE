$(function(){

    $('.delete_course').on('click', function(){
        var id = $(this).data('id');

        $.ajax({
            url: '/web/courses/delete/'+id,
            type: 'DELETE',
            dataType:'text',
            success: function(){
                window.location.reload();
            }
        })
    });

    //$('add_course').on('click', function(){
    //    $.get({
    //        url: 'web/courses/create',
    //        success: function(){
    //            window.location('/web/course/create');
    //        }
    //    })
    //});
});