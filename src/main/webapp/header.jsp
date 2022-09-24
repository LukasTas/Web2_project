<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="header">
        <ul>
            <li ${param.current eq 'home'?"id = current":""}>
                <a href="Servlet?command=home">Home</a></li>

            <li ${param.current eq 'overzicht'?"id = current":""}>
                <a href="Servlet?command=overzicht">Overzicht</a></li>

            <li ${param.current eq 'voegtoe'?"id = current":""}>
                <a href="Servlet?command=voegtoeForm">Voeg toe</a></li>

            <li ${param.current eq 'zoek'?"id = current":""}>
                <a href="Servlet?command=zoek">Zoek</a></li>

            <li ${param.current eq 'overzichtFietsen'?"id = current":""}>
                <a href="Servlet?command=overzichtFietsen">Fietsen</a></li>

            <li ${param.current eq 'zoekFiets'?"id = current":""}>
                <a href="Servlet?command=zoekFiets">Zoek fiets</a></li>

            <li ${param.current eq 'overzichtGames'?"id = current":""}>
                <a href="Servlet?command=overzichtGames">Overzicht Games</a></li>
        </ul>
    </div>

</header>
