<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pokemones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Pokedex</h1>
		<div class="row">
			<c:forEach items="${respuesta.results}" var="pokemon">
				<div class="card col-3">
					<h2>${pokemon.name}</h2>
					<a href="/pokemon/${pokemon.name}" class="btn btn-success">Ver Detalle</a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>