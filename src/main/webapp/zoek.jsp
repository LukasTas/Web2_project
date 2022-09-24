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
    <title>Zoek | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="zoek"/>
</jsp:include>
<main>
    <h2>Ga op zoek naar een biertje!</h2>


    <p> U deed al <strong>${cookie.zoekTeller.value}</strong> succesvolle zoekopdracht(en)!</p>
    <form method="POST" action="Servlet?command=resetCookie">
        <input type="submit" value="Reset Cookie">
    </form>
    <form method="POST" action="Servlet?command=zoekNaam" novalidate>
        <label for="naam">Naam:
            <input id="naam" type="text" name="naam" required>
        </label>
        <label>
            <input id="submit-button" type="submit" value="ga op zoek!">
        </label>
    </form>
</main>
<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>
