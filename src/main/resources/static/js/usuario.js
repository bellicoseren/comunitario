GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#getAll").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "/asistencia",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,
									function(i, user) {
										var user = "User Name  "
												+ user.nombre
												+ ", Author  = " + user.apellidoPaterno
												+ "<br>";
										$('#getResultDiv.list-group').append(
												user)
												console.log("----", user);
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})