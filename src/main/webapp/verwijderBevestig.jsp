<%@ page import="domain.model.Bier" %>
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
    <title>Verwijderen | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="overzicht"/>
</jsp:include>
<main>
    <section>
        <h2>Bevestiging</h2>
        <p>Bent u zeker dat u <strong> ${param.naam} </strong> wilt verwijderen ? </p>
        <form action="Servlet?command=verwijder&naam=${param.naam}" method="POST">
            <input id="submit-button" type="submit" value="ik ben zeker!"/>
        </form>
        <p><a href="Servlet?command=overzicht">Annuleer</a></p>
    </section>
</main>
<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>
