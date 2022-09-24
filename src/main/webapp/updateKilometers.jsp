<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Nieuw aantal kilometers</title>
</head>
<body>

<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="current" value="overzichtFietsen"/>
    </jsp:include>

    <main>
        <h2>Pas de afgelegde kilometers aan</h2>
        <section>
            <c:if test="${not empty errors}">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </section>

        <form method="post" action="Servlet?command=updateWaardenFiets&naam=${fiets.naam}" novalidate>
        <p class="form group ${statusKilometers}">
            <label for="kilometers">Kilometers: <input id="kilometers" name="kilometers" type="number" value="${fiets.kilometers}"></label>
        </p>
        <p>
            <input id="submit-button" name="submit" type="submit" value="update!"/>
        </p>
        </form>

    </main>

</div>

</body>
</html>

