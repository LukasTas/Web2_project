<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Voeg toe | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="voegtoe"/>
</jsp:include>
<main>
    <h2>Voeg toe!</h2>
        <section>
            <p>voeg een biertje toe aan het overzicht door het onderstaande formulier in te vullen! (* = verplicht)</p>
            <c:if test="${not empty errors}">
            <div class="alert">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
                </c:if>
        </section>

    <form method="post" action="Servlet?command=voegtoe" novalidate>
        <p class="form group ${statusNaam}">
            <label for="naam">Naam*: <input id="naam" name="naam" type="text" required value="${naamVorigeWaarde}"></label>
        </p>
        <p class="form group ${statusAlcoholpercentage}">
            <label for="alcoholpercentage">Alcoholpercentage:* <input id="alcoholpercentage" name="alcoholpercentage" type="number" min="0" max="26" step="0.1"required value="${alcoholpercentageVorigewaarde}"></label>
        </p>
        <p class="form group ${statusScore}">
            <label for="score">Score (op 10)*: <input id="score" name="score" type=number min="0" max="10" step="1" required value="${scoreVorigewaarde}"></label>
        </p>
        <p class="form group ${statusBiersoort}">
            <label for="biersoort">Soort bier:* <input id="biersoort" name="biersoort" type="text" requiredvalue="${biersoortVorigeWaarde}"></label>
        </p>
        <p>
            <input id="submit-button" name="submit" type="submit" value="verzend"/>
        </p>
    </form>
</main>
<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>
