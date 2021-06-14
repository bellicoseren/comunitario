$(document).ready(function() {  
$("#formRegistrar").submit(function(e) {
       e.preventDefault();
    }).validate({
		
      	rules: {
                   nombre: {
                           required: true,
                           minlength: 3
                   },
				   apellidoPaterno: {
                           required: true,
                           minlength: 3
                   },
				   apellidoMaterno: {
                           required: true,
                           minlength: 3
                   },
				   edad: {
                           required: true,
                           digits: true,
						   range: [4, 100]
                   },
				   telefono: {
						   digits: true,
					       required: true,
						   minlength: 10,
						   maxlength: 10
				},
				direccion: {
                           required: true,
                           minlength: 3
                   }
           },
           messages: {
                   nombre: {
						
                           required: "Introduce tu nombre",
                           minlength: "Se necesitan minimo 3 caracteres"
                   },
				   apellidoPaterno: {
						
                           required: "Introduce tu apellido paterno",
                           minlength: "Se necesitan minimo 3 caracteres"
                   },
				   apellidoMaterno: {
						
                           required: "Introduce tu apellido materno",
                           minlength: "Se necesitan minimo 3 caracteres"
                   },
					edad: {
						   required: "Ingresa edad",
						   digits: "Es requerido un numero}"
					},
					telefono: {
						   digits: "Sólo se pueden escribir numeros",
                           required: "Introduce telefono",
                           minlength: "Se necesitan 10 digitos",
                           maxlength: "No pueden ser más de 10 digitos"
                   },
					direccion: {
						   minlength: "Minimo dos Letras",
                           required: "Escribe tu dirección"
                           
                   },
           },

        //errorPlacement: function(error, element) {
         //     error.appendTo(element.parent());
         //},
         submitHandler: function(form) {
            $.post("/registro/registrar", $("#formRegistrar").serialize(), function(fragment) {
			console.log(fragment);
			$("#rest").replaceWith(fragment);
            });
            return false;
         }
	
    });
});