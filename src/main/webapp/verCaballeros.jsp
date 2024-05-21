<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Caballeros</title>
</head>
<body>
    <h1>Lista de Caballeros</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Fuerza</th>
            <th>Experiencia</th>
            <th>Foto</th>
        </tr>
        <c:forEach var="caballero" items="${caballeros}">
            <tr>
                <td>${caballero.id}</td>
                <td>${caballero.nombre}</td>
                <td>${caballero.fuerza}</td>
                <td>${caballero.experiencia}</td>
                <td><img src="${caballero.foto}" alt="Foto de ${caballero.nombre}" width="100"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>