<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Evento</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>.text-danger { font-size: 0.85em; }</style>
</head>
<body>
    <div class="container mt-5 col-md-6">
        <div class="card shadow">
            <div class="card-header bg-success text-white">
                <h4>Nuevo Evento</h4>
            </div>
            <div class="card-body">
                <form:form action="guardar" method="post" modelAttribute="evento">
                    
                    <div class="mb-3">
                        <label class="form-label">Título del Evento</label>
                        <form:input path="titulo" cssClass="form-control" placeholder="Ej: Cumpleaños Mensual"/>
                        <form:errors path="titulo" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Fecha</label>
                        <form:input type="date" path="fecha" cssClass="form-control"/>
                        <form:errors path="fecha" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Responsable</label>
                        <form:input path="responsable" cssClass="form-control" placeholder="Ej: Recursos Humanos"/>
                        <form:errors path="responsable" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Descripción</label>
                        <form:textarea path="descripcion" cssClass="form-control" rows="3"/>
                        <form:errors path="descripcion" cssClass="text-danger"/>
                    </div>

                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-success">Guardar Evento</button>
                        <a href="./" class="btn btn-secondary">Cancelar</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>