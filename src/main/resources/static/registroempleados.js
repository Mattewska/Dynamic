$(document).ready(function () {
  jQuery.validator.addMethod(
    "mayus",
    function (value, element) {
      // allow any non-whitespace characters as the host part
      return (
        this.optional(element) ||
        /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/.test(value)
      );
    },
    "La contraseña debe tener entre 8 y 16 caracteres, al menos un número, y al menos una minúscula y una mayúscula. NO puede tener otros símbolos."
  );

  $("#rempleados").validate({
    rules: {
      nombre: {
        required: true
      },

      apellido: {
        required: true
      },

      clave: {
        required: true,
        minlength: 8,
        mayus: true
      },

      telefono: {
        required: true,
        minlength: 10
      },

      fecha_nacimiento: {
        required: true
      },

      direccion: {
        required: true
      },

      rol: {
        required: true
      },

      correo: {
        required: true,
        email: true
      },
    },

    messages: {
      nombre: {
        required: "Ingrese su nombre completo."
      },

      apellido: {
        required: "Ingrese sus apellidos."
      },

      clave: {
        required: "Ingrese su Contraseña", 
        minlength: "La contraseña es de minimo 8 caracteres", 
        maxlength: "La contraseña es de maximo 16 caracteres"
      },

      telefono: {
        required: "Ingrese el telefono movil del usuario.", minlength: "El telefono movil es de minimo 10 caracteres" 
      },

      fecha_nacimiento: {
        required: "Ingrese la fecha de nacimiento del usuario."
      },

      direccion: {
        required: "Ingrese la dirección de residencia del usuario." 
      },

      rol: {
        required: "Seleccione el rol que desempeñará el usuario." 
      },

      correo: {
        required: "Ingrese el correo electronico del usuario.",
        email:"El correo ingresado no es valido, ingrese uno valido"  
      },
    },
  });
});
