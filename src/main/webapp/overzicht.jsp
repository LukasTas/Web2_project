<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="domain.model.Bier" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="icon" href="afbeeldingen/klinkendePils.jpg">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap" rel="stylesheet">
    <title>Overzicht | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="overzicht"/>
</jsp:include>
<main>
    <h2>Overzicht</h2>
    <article>Hieronder vind je een overzicht van alle bieren!</article>

    <table>
        <c:choose>
            <c:when test="${bieren != null}">
        <tr>
            <th>Naam</th>
            <th>Alcoholpercentage</th>
            <th>Score</th>
            <th>Soort bier</th>
            <th>Pas aan</th>
            <th>Verwijder</th>
        </tr>
        <c:forEach var="bieren" items="${bieren}">
            <tr>
                <td>
                    ${bieren.naam}
                </td>
                <td>
                    ${bieren.alcoholPercentage}
                </td>
                <td>
                    ${bieren.score}
                </td>
                <td>
                    ${bieren.biersoort}
                </td>
                <td>
                <a href="Servlet?command=update&naam=${bieren.naam}">Pas aan</a>
                </td>
                <td>
                <a href="Servlet?command=verwijderBevestig&naam=${bieren.naam}">Verwijder</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <section>
        </c:when>
            <c:otherwise>
                <p>U hebt nog geen bieren toegevoegd.</p>
                <p><a href="voeg-toe.jsp"> Voeg nu een bier toe!</a></p>
            </c:otherwise>
        </c:choose>
    </section>

    <section>
        <c:if test="${besteBier.naam != null}"> <h2>Algemeen</h2> </c:if>
        <c:if test="${besteBier.naam != null}"> <ul><p>Bier met de hoogste score: ${besteBier.naam}</p></c:if></ul>
        <c:if test="${besteBier.naam != null}"> <ul><p>Bier met de laagste score: ${slechtsteBier.naam}</c:if></ul>
    </section>

    <br>
    <br>

    <c:if test="${not empty bierSessie}">
        <form action="Servlet?command=undoDelete" method="POST">
            <input type="submit" value="Laatst verwijderde fiets terugzetten!">
        </form>
    </c:if>
</main>
<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>
