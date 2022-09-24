<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/style.css">
  <title>Bekijk alle fietsen</title>
</head>
<body>
<div id="container">
<jsp:include page="header.jsp">
  <jsp:param name="current" value="overzichtFietsen"/>
</jsp:include>


  <main>
    <h2>Overzicht</h2>
    <article>Hieronder vind je een overzicht van alle fietsen</article>
    <c:if test="${fiets != null}">
        <p>De laatst gewijzigde fiets is: <strong>${fiets.naam}</strong> van het merk <strong>${fiets.merk}</strong>, gebouwd in <strong>${fiets.bouwjaar}</strong> met <strong>${fiets.kilometers}</strong> kilometers!</p>
    </c:if>



    <p><c:if test="${param.naam != null}"> <p><p>U heeft zopas de fiets met naam <strong>${param.naam}</strong> verwijderd.</c:if></p>

    <table>
      <c:choose>
      <c:when test="${fietsen != null}">
      <tr>
        <th>Id</th>
        <th>Naam</th>
        <th>Merk</th>
        <th>Bouwjaar</th>
        <th>Kilometers</th>
        <th>Update kilometers</th>
        <th>Verwijder</th>
      </tr>
      <c:forEach var="fietsen" items="${fietsen}">
        <tr>
          <td>
              ${fietsen.id}
          </td>
          <td>
              ${fietsen.naam}
          </td>
          <td>
              ${fietsen.merk}
          </td>
          <td>
              ${fietsen.bouwjaar}
          </td>
          <td>
              ${fietsen.kilometers}
          </td>
          <td>
            <a href="Servlet?command=updateFiets&naam=${fietsen.naam}&kilometers=${fietsen.kilometers}">Update kilometers</a>
          </td>
          <td>
            <a href="Servlet?command=verwijderFietsBevestig&id=${fietsen.id}&naam=${fietsen.naam}&merk=${fietsen.merk}">Verwijder</a>
          </td>
        </tr>
      </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
      <p>Er zijn nog geen geregistreerde fietsen.</p>
    </c:otherwise>
    </c:choose>


  </main>
</div>
</body>
</html>