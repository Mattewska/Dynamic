function eliminar(idReporte){
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
		url:"/eliminar/"+idReporte,
		success : function(res){
			console.log(res);
		}
		
		});
    swal("! Tu archivo ha sido eliminado!", {
      icon: "success",
      }).then((ok)=> {
	if(ok){
		location.href="/listar";
	}
    });
  } else {
    swal("Your imaginary file is safe!");
  }
});
	
}