function eliminaru(id_usuario) {
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
				 url:"/eliminaru/"+id_usuario,
				 success: function(res) {
					console.log(res);
				}
			  });
		    swal("Poof! Registro eliminado!", {
		      icon: "success",
		    }).then((ok)=>{
		    	if(ok){
		    		location.href="/empleados";
		    		}
			});
			} else {
				swal("Your imaginary file is safe!");
			}
		});

}