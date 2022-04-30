$(document).ready(function () {
    $('#table').bootstrapTable({        	
        	url:'',
            pagination: true,
            search: true,
            pageSize: 5,
            pageList: [5, 10],
            locale: "es-ES",
            columns: [ {
                field: 'materialID',
                title: 'ID',
                width: '180px'
            },{
                field: 'precio',
                title: 'Precio',
                width: '180px'
            }, {
                field: 'nombre',
                title: 'Nombre',
                width: '180px'
            }, {
                field: 'bodega',
                title: 'Bodega',
                width: '180px',
            }, {
                field: 'fechaIngreso',
                title: 'Fecha Ingreso',
                width: '180px'
            },]
        });
              
const hoy = new Date();

function formatoFecha(fecha, formato) {
	const map = {
        dd: fecha.getDate(),
        mm: fecha.getMonth() + 1,
        yy: fecha.getFullYear().toString().slice(-2),
        yyyy: fecha.getFullYear()
    }

    return formato.replace(/dd|mm|yy|yyyy/gi, matched => map[matched])
}
  
$("#idBtnGuardar").click(function() {
		var dataProducto = {
							"precio": $("#idprecio").val(),
							"nombre": $("#idNombre").val(),
							"bodega": $("#idBodega").val(),
							"fechaIngreso": formatoFecha(hoy, 'dd/mm/yy')
						 };
			$.ajax({
				
				data: JSON.stringify(dataProducto),
				type: "POST",
				contentType: "application/json",
				url: '/material/materiales',
				
			})
			.done(function(data, textStatus, jqXHR) {
				
					  $.ajax({
		                    type:"GET",
		                    url:"/material/materiales",
		                    dataType:"json",
		                    success: function(data) {
		                        //si todo sale bien, se agrega la funcionalidad
		                        console.log(data);
		                        $('#table').bootstrapTable('load', data);
		                    },
		                    error: function(dataError) {
		                        console.log(dataError);
		                    },
		                    async: true,
	                	});
	
	                console.log("Termino");
	         });

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});
});