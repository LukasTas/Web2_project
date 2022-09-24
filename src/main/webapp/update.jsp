<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap" rel="stylesheet">
    <link rel="icon" href="afbeeldingen/klinkendePils.jpg">
    <title>Update | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value=""/>
</jsp:include>
<main>
    <h2>Voeg toe!</h2>
    <section>
        <c:if test="${not empty errors}">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
        </c:if>
    </section>
        <form method="post" action="Servlet?command=updateWaarden" novalidate>
            <p class="form group ${statusNaam}">
                <label for="naam">Naam*: <input readonly name="naam" id="naam" type="text" required value="${bier.naam}"></label>
            </p>
            <p class="form group ${statusAlcoholpercentage}">
                <label for="alcoholpercentage">Alcoholpercentage:* <input id="alcoholpercentage" name="alcoholpercentage" type=number min="0" max="26" step="0.1" value="${bier.alcoholPercentage}"></label>
            </p>
            <p class="form group ${statusScore}">
                <label for="score">Score (op 10)*: <input id="score" name="score" type=number min="0" max="10" step="0.5" required value="${bier.score}"></label>
            </p>
            <p class="form group ${statusBiersoort}">
                <label for="biersoort">Soort bier:* <input id="biersoort" name="biersoort" type="text" value="${bier.biersoort}"></label>
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
