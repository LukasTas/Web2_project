<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Home | Bieren</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="current" value="home"/>
</jsp:include>
<main>
    <article>
        <h2><strong>Welkom bij de bier-tierlist!</strong></h2>
        <p>Op deze website houd ik een overzicht bij van alle bieren die ik al heb gedronken samen met een score op 10, en het alcholpercentage. </p>
        <p>Ken jij nog biertjes die niet in de lijst staan en die <strong>absoluut</strong> de moeite zijn? Voeg ze gerust toe!</p>
        <c:if test="${besteBier.naam != null}"> <p>Het beste biertje in de lijst is: ${besteBier.naam}</p></c:if>


</main>
<footer>
    <p>Lukas Tas - Webontwikkeling 2</p>
</footer>
</body>
</html>