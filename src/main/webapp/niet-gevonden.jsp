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
    <title>Niet gevonden | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
<jsp:param name="current" value="zoek"/>
</jsp:include>
<main>
    <h2>Sorry, niet gevonden!</h2>
    <p>Het biertje waarnaar u op zoek bent werd niet gevonden.</p>
</main>
<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>
