<%@page import="Beans.*"%>

<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<% Usuario user = (Usuario)request.getSession().getAttribute("usuario"); %>
<% FamiliaAnfitriona familia = (FamiliaAnfitriona)request.getAttribute("familia"); %>
<% Pais pais = (Pais)request.getAttribute("pais"); %>
<% Ciudad ciudad = (Ciudad)request.getAttribute("ciudad"); %>
<html>
	<head>
		<title>Centro de Estudios Montreal</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
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
									<a href="Familia.jsp" class="logo"><strong>Centro de estudios Montreal </strong> Portal Familia Anfitriona</a>
									<ul class="icons">
										
									</ul>
								</header>

							<!-- Banner -->
								<section id="banner">
									<div class="content">
										<header>
											<h1>Informacion de la Familia</h1>
										</header>
									</div>
								</section>

							<!-- Section -->
							
							 <div class="table-wrapper">
								<table class="alt">
									<thead>
										<tr>
											<th></th>
											<th></th>
										
										</tr>
									</thead>
									<tbody>
									<tr>
											<td>Nombre del Responsable</td>
											<td><%=familia.NombreCompleto() %></td>
											
										</tr>
										<tr>
											<td>Correo</td>
											<td><%=familia.Correo %></td>
											
										</tr>
										<tr>
											<td>Telefono</td>
											<td><%=familia.Telefono %></td>
											
										</tr>
										<tr>
											<td>Direccion</td>
											<td><%=familia.Direccion %></td>
											
										</tr>
										<tr>
											<td>Ciudad</td>
											<td><%=ciudad.NombreCiudad %></td>
											
										</tr>
										<tr>
											<td>Pais</td>
											<td><%=pais.NombrePais %></td>
											
										</tr>
										<tr>
											<td>Estado</td>
											<td><%=familia.Estado %></td>
											
										</tr>
									</tbody>
									<tfoot>
										<tr>
										
										</tr>
									</tfoot>
								</table>
							</div>

							<!-- Section -->
								

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
										<li><a href="familia.jsp">Ver estado</a></li>
										<li><a href="documento.jsp">Subir Documentacion</a></li>
										<li><a href="SignOut">Salir</a></li>
									</ul>
								</nav>
						<!---Tablas--->
							<section>
							
							
							
							
							</section>
								

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
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>