function eliminar(id_domicilio){
	
swal({
  title: "¿Seguro desea eliminar este registro?",
  text: "Si lo elimina no podra recuperarlo de nuevo",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminar/"+id_domicilio,
		success: function(res){
			console.log(res);
		}	
	});
    swal("Su registro fue eliminado correctamente", {
      icon: "success",
    }).then((OK)=>{
	if(OK){
	location.href="/Historial_Entregas";		
	}	
});
  } else {
    swal("Registro no eliminado!");
  }
});	
}

function eliminarF(id_factura) {
	swal({
		title: "Esta seguro de eliminar?",
		text: "una vez eliminado, no podra recuperar este archivo!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/eliminarFactura/" + id_factura,
					success: function(res) {
						console.log(res);
					}

				});
				swal("! Tu archivo ha sido eliminado!", {
					icon: "success",
				}).then((ok) => {
					if (ok) {
						location.href = "/listarFactura";
					}
				});
			} else {
				swal("tu registro se encuentra bien!");
			}
		});

}

function eliminarDetalle(id_detalle) {
	swal({
		title: "Esta seguro de eliminar?",
		text: "una vez eliminado, no podra recuperar este archivo!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url: "/eliminarDetalleF/"+id_detalle,
					success: function(res) {
						console.log(res);
					}

				});
				swal("! Tu archivo ha sido eliminado!", {
					icon: "success",
				}).then((ok) => {
					if (ok) {
						location.href = "/listarFactura";
					}
				});
			} else {
				swal("tu registro se encuentra bien!");
			}
		});

}