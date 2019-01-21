<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilo.css" />
    </head>
    <body>

        <div id="principal">
            <h2>Insercci&oacute;n de datos</h2>
            <form method="post" action="control?op=add">
                <table>
                    <tr>
                        <td>Código (id y tipo)</td>
                        <td>id: </td>
                        <td><input type="text" name="id"  placleholder="id"/></td>
                        <td>tipo: </td>
                        <td><input type="text" name="tipo"  placeholder="tipo"/></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" /></td>
                    </tr>
                    <tr>
                        <td>Apellido 1</td>
                        <td><input type="text" name="ape1"  /></td>
                    </tr>
                    <tr>
                        <td>Apellido 2</td>
                        <td><input type="text" name="ape2" /></td>
                    </tr>
                    <tr>
                        <td>Escala</td>
                        <td>
                            <select name="escala">
                                <option value="esca" disabled selected>Escala</option>
                                <option value="t">T</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Fecha</td>
                        <td><input type="datetime-local" name="fecha" /></td>
                    </tr>
                    <tr>

                        <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                    </tr>
                </table>
            </form>
        </div>


    </body>
</html>