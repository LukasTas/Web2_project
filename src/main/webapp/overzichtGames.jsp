<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Games</title>
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="current" value="home"/>
    </jsp:include>

    <h2>Games</h2>

    <p><c:if test="${param.naam != null}"> <p><p>U heeft zopas de game met naam <strong>${param.naam}</strong> verwijderd.</c:if></p>

    <table>
    <c:choose>
        <c:when test="${games != null}">
            <tr>
                <th>Id</th>
                <th>Titel</th>
                <th>Minuten gespeeld</th>
                <th>Verwijder</th>
            </tr>
            <c:forEach var="games" items="${games}">
                <tr>
                    <td>
                            ${games.id}
                    </td>
                    <td>
                            ${games.titel}
                    </td>
                    <td>
                            ${games.minutenGespeeld}
                    </td>
                    <td>
                        <a href="Servlet?command=verwijderGame&id=${games.id}&titel=${games.titel}">Verwijder</a>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <p>Er zijn geen games.</p>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
