<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Contacto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>.error { color: red; font-size: 0.9em; }</style>
</head>
<body>
    <div class="container mt-5 col-md-6">
        <div class="card">
            <div class="card-header bg-success text-white">
                <h4>Nuevo Contacto</h4>
            </div>
            <div class="card-body">
                <form:form action="guardar" method="post" modelAttribute="contacto">
                    
                    <div class="mb-3">
                        <label class="form-label">Nombre:</label>
                        <form:input path="nombre" cssClass="form-control"/>
                        <form:errors path="nombre" cssClass="error"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Correo:</label>
                        <form:input path="correo" cssClass="form-control"/>
                        <form:errors path="correo" cssClass="error"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Teléfono:</label>
                        <form:input path="telefono" cssClass="form-control"/>
                        <form:errors path="telefono" cssClass="error"/>
                    </div>

                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="contactos" class="btn btn-secondary">Cancelar</a>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>