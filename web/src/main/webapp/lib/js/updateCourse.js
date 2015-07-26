$(function(){

    var form = $('#update_course');
    form.submit(function(event){
        $.ajax({
            type: 'PUT',
            url: '/web/courses/update',
            data: form.serialize(),
            success: function(){
                window.location = '/web/courses'
            }
        });
        event.preventDefault();
    });
    //$('.update_course').on('click', function(){
    //    var id = $('input#courseId').val();
    //    var name = $('input#name').val();
    //    var description = $('input#description').val();
    //
    //    var json = { "id" : id, "name" : name, "description": description};
    //    //console.log(json);
    //    $.ajax({
    //        url: '/web/courses/update',
    //        type: 'POST',
    //        data: { "id" : id, "name" : name, "description": description},
    //        contentType: 'application/json; charset=utf-8',
    //        dataType: 'json',
    //    success: function(){
    //            $(location).attr('href', '/web/courses');
    //            //window.location.reload();
    //        }
    //    })
    //})
});