<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="css/style.css">
  <title>Verwijder bevestiging</title>
</head>
<body>

<jsp:include page="header.jsp">
  <jsp:param name="current" value="overzichtFietsen"/>
</jsp:include>

<main>
  <h2>Verwijder fiets uit mijn collectie</h2>
  <p>Wil je de fiets met naam <strong> ${param.naam}</strong> en merk <strong> ${param.merk}</strong> uit de lijst verwijderen?</p>
  <form action="Servlet?command=verwijderFiets&id=${param.id}&naam=${param.naam}" method="POST">
    <input id="submit-button" type="submit" value="Ja"/>
  </form>
  <p><a href="Servlet?command=overzichtFietsen">Annuleer</a></p>

</main>

</body>
</html>
