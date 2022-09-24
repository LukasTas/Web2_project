<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <title>Succesvol aangepast!</title>
</head>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="zoekFiets"/>
</jsp:include>
<body>
<main>
    <h1>Succesvol aangepast!</h1>
    <p>U hebt zonet succesvol een fiets aangepast!</p>
    <p>U kunt nu terugkeren naar het <a href="Servlet?command=overzichtFietsen">overzicht van de fietsen</a>.</p>
</main>
<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>
