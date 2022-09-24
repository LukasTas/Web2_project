<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Verwijder bevestiging</title>
</head>
<body>

<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="current" value="home"/>
    </jsp:include>

    <main>
        <h2>Verwijder game</h2>


        <p>Bent u zeker dat u game ${param.titel} wilt verwijderen?</p>
        <a href="Servlet?command=overzichtGames">Neen</a>

        <a href="Servlet?command=deleteGame&titel=${param.titel}&id=${param.id}">Ja</a>
    </main>
</div>
</body>
</html>