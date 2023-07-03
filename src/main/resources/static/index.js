var table = null
var app = {
    host: 'http://localhost:8080/api/v1',
    
    init: function () {
        app.initDatatable('#tasks');

        $("#save").click(function () {
            app.save({
                id: $('#id').val(),
                title: $('#title').val(),
                description: $('#description').val(),
                completed: false,
                due_date: new Date()
            });
        });

    },
    initDatatable: function (id) {
            table = $(id).DataTable({
            ajax: {
                url: app.host + '/task/getAll',
                dataSrc: function (json) {
                    console.log(json);
                    return json;
                }
            },
            dom: 'Bfrtip',
            columns: [
                { data: "id" },
                { data: "title" },
                { data: "description" },
                { data: "completed" },
                { data: "due_date" },
            ],
            buttons: [
                {
                    text: 'Crear',
                    action: function (e, dt, node, config) {
                        app.cleanModal();

                        $('#taskModal').modal();



                    }
                },
                {
                    text: 'Completar',
                    action: function (e, dt, node, config) {
                        //alert('Hola')
                        var data = dt.rows('.table-active').data()[0];
                        console.log(data);
                        console.log(data.id);
                        app.setCompleted(data.id);
                    }
                },
                {
                    text: 'Eliminar',
                    action: function(e,dt,node,config){
                        var data = dt.rows('.table-active').data()[0];
                        if(confirm('¿Está seguro que deseas eliminar la tarea?')){
                            app.delete(data.id);
                        }  
                    }
                }
            ]
        });
        $('#tasks tbody').on('click', 'tr', function () {
            if ($(this).hasClass('table-active')) {
                $(this).removeClass('table-active');
            } else {
                table.$('tr.table-active').removeClass('table-active');
                $(this).addClass('table-active');
            }
        });
    },
    save: function (data) {
        $.ajax({
            url: app.host + '/task/addTask',
            data: JSON.stringify(data),
            method: 'POST',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (json) {
                $("#msg").text('Se guardó la tarea correctamente');
                $("#msg").show();
                $('#taskModal').modal('hide');
                table.ajax.reload();
                
            },
            error: function (error) {

            }
        })
    },
    setCompleted: function (id) {
        $.ajax({
            url: app.host + '/task/completedTask/' + id,
            method: 'PATCH',
            dataType: 'json',
            contentType: "application/json; charset = utf-8",
            success: function (json) {
                $("#msg").text('Se completó tarea');
                $("#msg").show();
                table.ajax.reload();
            },
            error: function (error) {

            }
        })
    },


    delete: function (id) {
        $.ajax({
            url: app.host + '/task/deleteTask/' + id,
            method: 'DELETE',
            dataType: 'json',
            contentType: "application/json; charset = utf-8",
            success: function (json) {
                $("#msg").text('Se eliminó tarea correctamente');
                $("#msg").show();
                table.ajax.reload();
            },
            error: function (error) {

            }
        })
    },
    setDataModal: function (data) {
        $('#id').val(data.id);
        $('#title').val(data.tile);
        $('#description').val(data.description);

    },
    cleanModal: function () {
        $('#id').val('');
        $('#title').val('');
        $('#description').val('');

    }
};

$(document).ready(function () {
    app.init();
});

// $(document).ready(function () {
//     setTimeout(function(){
//         app.init();
//     },2000); 
// });
 
