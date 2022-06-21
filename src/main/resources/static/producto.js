function eliminarp(id_producto) {
	swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Una vez eliminado no se prodra restablecer!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				 url:"/eliminarp/"+id_producto,
				 success: function(res) {
					console.log(res);
				}
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/inventario";
		    		}
			});
			} else {
				swal("Your imaginary file is safe!");
			}
		});

}