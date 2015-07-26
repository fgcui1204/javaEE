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
    })
});