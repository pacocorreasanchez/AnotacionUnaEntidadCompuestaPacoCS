<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilo.css" />
    </head>
    <body>

        <div id="principal">
            <h2>Listado de profesores</h2>

            <c:set var = "listado" value = "${listado}"/>
            <c:if test = "${listado.size() < 0}">
                <h1>No hay registros en el sistema</h1>
            </c:if>


            <ul>
                <c:forEach var="item" items="${listado}">
                    <li>Código: ${item.codigo.id}-${item.codigo.tipo}. Nombre: ${item.nombre} ${item.ape1} ${item.ape2}. Escala: ${item.escala}. Fecha: <fmt:formatDate value="${item.fecha.time}" pattern="yyyy-MM-dd HH:mm" /></li>
                </c:forEach>
            </ul>
            <br />
            <p><a href="${contexto}/" class="enlace">Men&uacute; inicial</a></p>
        </div>


    </body>
</html>