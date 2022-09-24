<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <title>Mijn fietsen</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="zoekFiets"/>
</jsp:include>

<main>

    <c:if test="${not empty errors}">
        <ul>
            <c:forEach items="${errors}" var="error">
                <li>${error}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form method="POST" action="Servlet?command=zoekMerk" novalidate>
        <label for="merk">Merk:
            <input id="merk" type="text" name="merk" required>
        </label>
        <label>
            <input id="submit-button" type="submit" value="ga op zoek!">
        </label>
    </form>

    <section>
            <c:if test="${not empty fietsen}">
                <h2> Bekijk alle fietsen</h2>
                <table>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Naam fiets</th>
                        <th>Merk</th>
                        <th>Bouwjaar</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="fietsen" items="${fietsen}">
                        <tr>
                            <td>${fietsen.id}</td>
                            <td>${fietsen.naam}</td>
                            <td>${fietsen.merk}</td>
                            <td>${fietsen.bouwjaar}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty fietsen}">
                <p>We konden helaas geen zoekresultaten vinden.</p>
            </c:if>
    </section>
    <br>
    <br>
    <br>
    <c:if test="${not empty zoekopdrachten}">
        <p>U heeft volgende merken al succesvol opgezocht:</p>
    </c:if>

    <ul>
        <c:forEach var="merk" items="${zoekopdrachten}">
            <li>${merk}</li>
        </c:forEach>
    </ul>

    <c:if test="${not empty zoekopdrachten}">
    <form method="POST" action="Servlet?command=clearZoekopdrachten">
        <input type="submit" value="wis de lijst!">
    </form>
    </c:if>
    <c:if test="${empty zoekopdrachten}">
        <p>U zocht nog niets op.</p>
    </c:if>
</main>
</body>
</html>

<body>



