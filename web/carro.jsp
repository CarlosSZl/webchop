
<%-- 
    Document   : principal
    Created on : 18-09-2023, 03:11:39
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="beans.beanProducto"%>
<%@ page import="java.util.Iterator"%>
<%
    String usuario=(String) request.getSession().getAttribute("sUsuario");
    if(usuario==null){
        response.sendRedirect("index.html");
    }
    
 List<beanProducto> productosList = (List<beanProducto>) request.getSession().getAttribute("productosCarro");
 Iterator itProd = productosList.iterator();
 //String total =(String) request.getSession().getAttribute("productosCarroTotal");
%>

<html lang="es">

<head>
    <meta charset="UTF-8">
    <title> StoreShop</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>


    <style>
        body {
            background-color: #fffFff;
        }

        .card.a {
            cursor: pointer;
            color: gray;
            text-decoration: none;
        }

        .card.img {
            height: 200px;
        }

        p.content {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .card.h2 {
            margin: 0 0;
        }

        .card {
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
            border: 1px solid#1b0088;
            padding: 15px;
            margin: 10px 0;
            background-color: #fff;
            /* max-width: 400px; */
            white-space: nowrap;
            overflow: hidden;
            transition: all 0.2 ease-in-out;

            &:hover {
                box-shadow: 0 5px 5px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.24);
                cursor: pointer;
            }
        }

        .card2 {
            box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
            border: 1px solid rgba(0, 0, 0, 0.2);
            border-radius: 5px;
            padding: 15px;
            margin: 10px 0;
            background-color: #fff;
            /* max-width: 400px; */
            white-space: nowrap;
            overflow: hidden;
            transition: all 0.2 ease-in-out;

            &:hover {
                box-shadow: 0 5px 5px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.24);
                cursor: pointer;
            }
        }
    </style>
</head>

<body>
    <!--Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <img src="img/logo.jpeg" width="220" class="d-inline-block align-top" alt="">

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" style="font-weight: bold; cursor: pointer;" href="principal.jsp">Home</a>
                </li>
                <!--
                <li class="nav-item ">
                    <a class="nav-link" style="font-weight: bold" href="about.html">Quienes somos</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link" style="font-weight: bold" href="contacto.html">Contacto</a>
                </li>
                 -->
            </ul>
        </div>

        <div style="padding-right: 15px;">
            <a href="carro.jsp">Carro de compras</a>&nbsp;&nbsp;&nbsp;
            <a href="historial.jsp">Historial de compras</a>&nbsp;&nbsp;&nbsp;
            <a href="sLogin?conf=0">salir de la sesion</a>
        </div>
    </nav>

    <div
        style="text-align: center; margin: auto; width: 100%; display: block; height: 300px; background-image: url('img/store.jpg'); background-size: cover; background-repeat: no-repeat;">
    </div>


    <div style="width: 100%; display: 
    block; overflow: hidden; margin: 20px 0 30px 0;">
        <h3 style="display: block; width: 500px; margin: auto; text-align: center; border-bottom: 1px solid #1b0088; font-weight: bold;">
            Carro De Compras</h3>
    </div>

    <div style="width: 90%; display: block; overflow: hidden; margin: auto; max-width: 1100px;">
        <div style="width: 100%; display: inline-block; margin: 1px solid gray; padding: 20px;">
          <div class="card" style="width: 100%; display: block;">       
 <%while(itProd.hasNext()){
    beanProducto producto=(beanProducto) itProd.next();
     
 %>
   
 
 <div class="card" style="width: 100%; display: block;">
                <div style="display: inline-block; width: 30%; height: 200px;">
                    <img class="card-img-top" src="img/<%= producto.getImg()%>" alt="Card image cap" style="width: 100%; height: 100%;">
                </div>
                <div style="display: inline-block; ">
                    <div class="card-body">
                        <h5 class="card-title"><%= producto.getNombre()%></h5>
                        <p class="card-text">CLP <%= producto.getPrecio()%></p>
                    </div>
                </div>
                <div class="card2" style="display: inline-block; float: right; width: 30%;">
                    <div class="card-body">
                        <h5 class="card-title"><%= producto.getNombre()%></h5>
                        <p class="card-text">CLP  <%= producto.getPrecio()%></p>
                    </div>
                </div>
            </div>

<% }%>

            
               
                <div style="display: inline-block; ">
                    <div class="card-body">
                        <h5 class="card-title">El pago se realiza por transferencia </h5>
                        <p class="card-text">cuenta banco estado 10229....</p>
                    </div>
                </div>
                <div class="card2" style="display: inline-block; float: right; width: 30%;">
                    <!--<div class="card-body">
                        <h5 class="card-title">Total a pagar</h5>
                        <p class="card-text">CLP  </p>
                        <a href="#" class="btn btn-primary">Confirmar</a>
                    </div>-->
                    <a href="sVentas?in=0" class="btn btn-primary">Confirmar</a>
                </div>
            </div>

        </div>
    </div>




    <!-- Footer -->
    <footer class="page-footer font-small blue pt-4">

        <div class="footer-copyright text-center py-3">
            <!--<img class="logoPrincipal" style="width: 100px;" src="assets/img/logo1.jpeg">&nbsp;&nbsp;
        <img class="logoPrincipal" style="width: 150px;" src="assets/img/logo2.jpeg">&nbsp;&nbsp;-->
        </div>
        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">
            © 2023 Copyright: StoreShop
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->

</body>

</html>

<!--
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contenido solo para usuario registrado</h1>
        <p>Bienvenido: <%=usuario%></p>
        <a href="sLogin?conf=0">salir de la sesion
        
    </body>
</html>
 -->