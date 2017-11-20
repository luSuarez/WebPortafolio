<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>Centro de Estudios Montreal</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css"/>
		<link rel="stylesheet" href="assets/css/form.css"/>
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<header id="header">
									<a href="index.jsp" class="logo"><strong>Centro de estudios Montreal </strong> Extranjeria</a>
									<ul class="icons">
										
									</ul>
								</header>

							<!-- Content -->
								<section>
									<header class="main">
										<center><h1>Portal Alumno</h1></center>
									</header>
								<div class="login-page">
								  <div class="form">
                                                                      <form action="svlCrearAlumno" method="POST" class="register-form">
									  <input type="text" id="id_alumno" name="id_alumno" required oninput="checkRut(this)"  placeholder="Rut"/>
									  <input type="text" id="id_nombre" name="id_nombre" required placeholder="Nombre"/>
									  <input type="text" id="id_apellidop" name="id_apellidop" required placeholder="Apellido Paterno"/>
									  <input type="text" id="id_apellidom" name="id_apellidom" required placeholder="Apellido Materno"/>
									  <input type="text" id="correo" name="id_correo" required placeholder="Correo"/>
									  <input type="text" id="id_telefono" name="id_telefono" required placeholder="Telefono"/>
									  <input type="password" id="id_pass" name="id_pass" placeholder="password"/>
									  <input type="submit" value="Registrar" />
									  
									  <p class="message">Estas registrado? <a href="#">Inicia Sesion</a></p>
									</form>
									<form action="LogInAlumno" method="POST" class="login-form">
                                                                            <input name="user" type="text" placeholder="Nombre de usuario" value="jos.perez"/>
                                                                            <input name="pass" type="password" placeholder="Contraseña" value="12345"/>
                                                                          <input type="submit" value="Iniciar Sesion" />
									  <p class="message">No estas regristrado? <a href="#">Crea una cuenta</a></p>
									</form>
								  </div>
								</div>
																										
								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										<li><a href="index.jsp">Inicio</a></li>
										<li><a href="Cursos.jsp">Cursos Disponibles</a></li>
										<li>
											<span class="opener">Portal</span>
											<ul>
												<li><a href="logAlumno.jsp">Alumno</a></li>
												<li><a href="logFam.jsp">Familia Anfitriona</a></li>
											</ul>
										</li>
										<li><a href="informacion.jsp">Informacion</a></li>
									</ul>
								</nav>



							

						<!-- Section -->
								<section>
									<header class="major">
										<h2>Preguntas</h2>
									</header>
									<p>Si tienes alguna duda especifica comunicate con el area de extranjeria</p>
									<ul class="contact">
										<li class="fa-envelope-o"><a href="mailto:extranjeria@cem.cl?subject=Consultas">extranjeria@cem.cl</a></li>
										
										<li class="fa-phone"><a href="tel:+5627892614">(2)7892614</a></li>
										
										<li class="fa-home">Antonio Varas 666, providencia, chile </li>
									</ul>
								</section>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Centro de estudios Montreal</p>
								</footer>


						</div>
					</div>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/Login.js"></script>
			
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>