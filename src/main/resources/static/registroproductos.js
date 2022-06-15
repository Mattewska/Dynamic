$(document).ready(function(){

    jQuery.validator.addMethod("mayus", function(value, element) {
        // allow any non-whitespace characters as the host part
        return this.optional( element ) || /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/.test( value );
      }, 'La contraseña debe tener entre 8 y 16 caracteres, al menos un número, y al menos una minúscula y una mayúscula. NO puede tener otros símbolos.');

$("#rproductos").validate({


rules:{

nombre:{
required: true 
},
precio: { 
required: true
},
stock: { 
required: true
},
categoria: { 
required: true
},   

},

messages:{

nombre: {required: "Ingrese el nombre del producto"},

precio: {required: "Ingrese el precio del producto"},

stock: {required: "Ingrese la cantidad disponible del producto"},

categoria: {required: "Seleccione una categoria"}

}



});


})