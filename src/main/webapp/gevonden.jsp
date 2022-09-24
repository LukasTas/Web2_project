<jsp:useBean id="bier" scope="request" type="domain.model.Bier"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Gevonden | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="zoek"/>
</jsp:include>
<main>
    <h2>Gevonden</h2>
    <p>Het volgende resultaat is gevonden:</p>
    <p>Naam: ${bier.naam}</p>
    <p>Alcoholpercentage: ${bier.alcoholPercentage} % </p>
    <p>Soort bier: ${bier.biersoort}</p>
    <p>Score: ${bier.score}</p>
</main>

<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>
