<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

    <!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
  <link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>

<script src="<%=request.getContextPath()%>/assets/js/materiales.js"></script>	

<title>Almacenamiento Bodega</title>
</head>
<body>	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-center" style="background-color: #e3f2fd;">
	<div class="nav justify-content-center">
	  <a class="navbar-brand" href="#" style=" font-weight: bold;">Usuario Conectado : ${usuarioConectado}</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <form class="form-inline my-2 my-lg-0" action="/logout" method="get">
			<button class="btn btn-primary" type="submit">logout</button>
	    </form>
	  </div>
	</div>
</nav>
<div class="container">
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="idprecio">Precio</label>
	      <input type="text" class="form-control" id="idprecio">
	    </div>
	    <div class="form-group col-md-6">
	      <label for="idNombre">Nombre</label>
	      <input type="text" class="form-control" id="idNombre">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="idBodega">Bodega</label>
	    <input type="text" class="form-control" id="idBodega" >
	  </div>
	  <button type="submit" class="btn btn-primary" id="idBtnGuardar">Agregar</button>
		
</div>

<div class="container">
	<table id="table">
	  
	</table>
</div>
</body>
</html>