<%@page import="java.util.List"%>
<%@page import="Beans.*"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<% List<Pais> paises = (List<Pais>)request.getAttribute("listaPaises"); %>
<% List<Ciudad> ciudades = (List<Ciudad>)request.getAttribute("listaCiudades"); %>
<% List<Programa> profrmas = (List<Programa>)request.getAttribute("listaProgramas"); %>
<% List<Institucion> instituciones = (List<Institucion>)request.getAttribute("listaInstituciones"); %>
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
							<h4>Postulaciones disponibles</h4>
							 <div class="table-wrapper">
								<table class="alt">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Nombre</th>
                                                                            <th>Fecha Inicio</th>
                                                                            <th>Fecha Termino</th>
                                                                            <th>Institucion</th>
                                                                            <th>Pais</th>
                                                                            <th>Ciudad</th>
                                                                            <th>Postular</th>

                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <% for (Programa pro : profrmas) { %>
                                                                            <tr>
                                                                                <td><%= pro.NombrePrograma %></td>
                                                                                <td><%= pro.FechaInicio %></td>
                                                                                <td><%= pro.FechaTermino %></td>
                                                                                    <% for (Institucion insti : instituciones) { %>
                                                                                        <%if (insti.IdInstitucion == pro.IdInstitucion) {%>
                                                                                            <td><%= insti.Nombres %></td>

                                                                                                <% for (Pais pa : paises) { %>
                                                                                                    <%if (pa.IdPais == insti.IdPais) {%>
                                                                                                        <td><%= pa.NombrePais %></td>

                                                                                                            <% for (Ciudad ci : ciudades) { %>
                                                                                                                <%if (insti.IdCiudad == ci.IdCiudad) {%>
                                                                                                                    <td><%= ci.NombreCiudad %></td>
                                                                                                                <%}%>
                                                                                                            <%}%>

                                                                                                    <%}%>
                                                                                                <%}%>

                                                                                        <%}%>
                                                                                    <%}%>
                                                                                    <td><a href="ListarActividadesFamilia?IdPrograma=<%=pro.IdPrograma%>">Mas</a></td>
                                                                            </tr>
                                                                        <%}%>
                                                                    </tbody>
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
										<li><a href="InicioAlumno">Ver estado</a></li>
										<li><a href="ListarProgramas">Realizar Postulacion</a></li>
										<li><a href="ListarNotas">Notas</a></li>
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