<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Agenda Corporativa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <nav class="navbar navbar-dark bg-primary mb-4">
        <div class="container">
            <span class="navbar-brand">📅 Agenda Corporativa</span>
            <a href="nuevo" class="btn btn-light">➕ Nuevo Evento</a>
        </div>
    </nav>

    <div class="container">
        <h3 class="mb-3 text-center">Próximos Eventos</h3>
        
        <div class="row">
            <c:forEach var="ev" items="${eventos}">
                <div class="col-md-6 mb-3">
                    <div class="card shadow-sm">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <strong>${ev.fecha}</strong>
                            <span class="badge bg-info text-dark">${ev.responsable}</span>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${ev.titulo}</h5>
                            <p class="card-text">${ev.descripcion}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <c:if test="${empty eventos}">
            <div class="alert alert-warning text-center">No hay eventos programados.</div>
        </c:if>
    </div>
</body>
</html>