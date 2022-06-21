$(document).ready(function(){

    jQuery.validator.addMethod("mayus", function(value, element) {
        // allow any non-whitespace characters as the host part
        return this.optional( element ) || /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/.test( value );
      }, 'La contraseña debe tener entre 8 y 16 caracteres, al menos un número, y al menos una minúscula y una mayúscula. NO puede tener otros símbolos.');

$("#login").validate({


rules:{

correo:{
required: true,
email:true 
},
clave: { 
required: true, 
minlength: 8,
mayus: true
} 

},

messages:{

correo: {required: "Ingrese su correo registrado", email: "El correo ingresado no es valido, ingrese uno valido"},

clave: {required: "Ingrese su Contraseña", minlength: "La contraseña es de minimo 8 caracteres"}

}



});


})