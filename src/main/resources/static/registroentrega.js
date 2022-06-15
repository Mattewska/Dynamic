$(document).ready(function(){

    jQuery.validator.addMethod("mayus", function(value, element) {
        // allow any non-whitespace characters as the host part
        return this.optional( element ) || /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/.test( value );
      }, 'La contraseña debe tener entre 8 y 16 caracteres, al menos un número, y al menos una minúscula y una mayúscula. NO puede tener otros símbolos.');

$("#rentrega").validate({


rules:{

fecha:{
required: true
},
factura:{ 
required: true
},
estado:{ 
required: true
}  

},

messages:{

fecha: {required: "Ingrese la fecha actual."},

factura: {required: "Ingrese la factura de venta."},

estado: {required: "Seleccione un estado."}

}



});


})