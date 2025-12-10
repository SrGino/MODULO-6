<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Contactos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Agenda de Contactos</h2>
        
        <a href="nuevo" class="btn btn-primary mb-3">Nuevo Contacto</a>

        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${lista}">
                    <tr>
                        <td><c:out value="${c.nombre}"/></td>
                        <td><c:out value="${c.correo}"/></td>
                        <td><c:out value="${c.telefono}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <c:if test="${empty lista}">
            <div class="alert alert-warning">No hay contactos registrados aún.</div>
        </c:if>
    </div>
</body>
</html>