<%@page import="java.util.List"%>
<%@page import="Beans.*"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<% List<Actividad> actividades = (List<Actividad>)request.getAttribute("actividades"); %>
<% List<FamiliaAnfitriona> familias = (List<FamiliaAnfitriona>)request.getAttribute("familias"); %>
<% String id = (String)request.getSession().getAttribute("idPrograma"); 
   int idPrograma = Integer.parseInt(id); %>
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
									<a href="Alumno.jsp" class="logo"><strong>Centro de estudios Montreal </strong> Portal Alumno</a>
									<ul class="icons">
										
									</ul>
								</header>

							<!-- Banner -->
								<section id="banner">
									<div class="content">
										<header>
											<h1>Realizar postulaciones</h1>
										</header>
									</div>
								</section>
					<!-- Section -->
							<h4>Actividades del curso</h4>
							 <div class="table-wrapper">
								<table class="alt">
								<thead>
									<tr>
										<th>Nombre</th>
										<th>Descripcion</th>
									</tr>
								</thead>
								<tbody>
                                                                    <%for (Actividad actividad : actividades) {%>
                                                                        <tr>
                                                                            <td><%=actividad.NombreActividad %></td>
                                                                            <td><%=actividad.Descripcion %></td>
                                                                        </tr>    
                                                                     <%}%>
										
									
								</tbody>
							</table>
						</div>
							
							<!-- Section -->
							<h4>Familias disponibles</h4>
							 <div class="table-wrapper">
								<table class="alt">
									<thead>
										<tr>
											<th>Nombre</th>
											<th>Correo</th>
											<th>Telefono</th>
											<th>Direccion</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
                                                                            <%for (FamiliaAnfitriona familia : familias) {%>
                                                                                <tr>
                                                                                    <td><%=familia.NombreCompleto() %></td>
                                                                                    <td><%=familia.Correo %></td>
                                                                                    <td><%=familia.Telefono %></td>
                                                                                    <td><%=familia.Direccion %></td>
                                                                                    <td><a href="RealizarPostulacion?idFamilia=<%=familia.IdFamilia %>">Selecciona</a></td>
                                                                                </tr>    
                                                                            <%}%>
									</tbody>
								</table>
							</div>	
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
										<li><a href="svtInicioAlumno">Ver estado</a></li>
										<li><a href="postulacion.jsp">Realizar Postulacion</a></li>
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