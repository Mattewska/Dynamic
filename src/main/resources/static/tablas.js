
//Botones para descargar datos de las tablas

$('#btndescargas').on('click', requestdescargar);

function requestdescargar(){
    
    tableToExcel('Historial', 'Historial de Entregas DS');
       
}