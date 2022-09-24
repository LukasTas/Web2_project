package ui.controller;

import domain.db.BierDB;
import domain.db.FietsenDB;
import domain.db.GameDB;
import domain.model.Bier;
import domain.model.DomainException;
import domain.model.Fiets;
import domain.model.Game;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private BierDB bierDB = new BierDB();
    private FietsenDB fietsenDB = new FietsenDB();
    private GameDB gameDB = new GameDB();
    int teller = 0;


    public Servlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        String destination;
        switch (command){
            case "voegtoe":
                destination = voegtoe(request,response);
                break;
            case "voegtoeForm":
                destination = voegtoeForm(request,response);
                break;
            case "verwijder":
                destination = verwijder(request,response);
                break;
            case "verwijderBevestig":
                destination = verwijderBevestig(request,response);
                break;
            case "zoek":
                destination = zoek(request,response);
                break;
            case "zoekNaam":
                destination = zoekNaam(request,response);
                break;
            case "overzicht":
                destination = overzicht(request,response);
                break;
            case "update":
                destination = update(request);
                break;
            case "updateWaarden":
                destination = updateWaarden(request,response);
                break;
            case "resetCookie":
                destination = resetCookie(request, response);
                break;
            case "overzichtFietsen":
                destination = overzichtFietsen(request,response);
                break;
            case "verwijderFiets":
                destination = verwijderFiets(request,response);
                break;
            case "zoekFiets":
                destination = zoekFiets(request,response);
                break;
            case "zoekMerk":
                destination = zoekMerk(request,response);
                break;
            case "verwijderFietsBevestig":
                destination = verwijderFietsBevestig(request,response);
                break;
            case "updateFiets":
                destination = updateFiets(request);
                break;
            case "updateWaardenFiets":
                destination = updateWaardenFiets(request,response);
                break;
            case"undoDelete":
                destination = undoDelete(request,response);
                break;
            case"clearZoekopdrachten":
                destination = clearZoekopdrachten(request,response);
                break;
            case "updateFietsBevestig":
                destination = updateFietsBevestig(request,response);
                break;
            case "overzichtGames":
                destination = overzichtGames(request,response);
                break;
            case "verwijderGame":
                destination = verwijderGame(request,response);
                break;
            case "deleteGame":
                destination = deleteGame(request,response);
                break;
            default:
                destination = home(request,response);
        }
        request.getRequestDispatcher(destination).forward(request,response);
    }

    private String deleteGame(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("id");
        int id = Integer.parseInt(ids);
        gameDB.deleteGame(id);
        return overzichtGames(request,response);
    }

    private String verwijderGame(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Game game = gameDB.getGameById(Integer.parseInt(id));
        request.setAttribute("game", game);
        return "verwijderBevestigingGame.jsp";
    }


    private String overzichtGames(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("games",gameDB.getAlleGames());
        return "overzichtGames.jsp";
    }


    //-----------------------------------------------------------


    private String overzichtFietsen(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                int id = Integer.parseInt(cookie.getValue());
                Fiets fiets = fietsenDB.getFietsById(id);
                request.setAttribute("fiets", fiets);
            }
        }

        request.setAttribute("fietsen", fietsenDB.getAlleFietsen());
        return "overzichtFietsen.jsp";
    }

    private String updateFietsBevestig(HttpServletRequest request, HttpServletResponse response) {
        return "updateBevestigFiets.jsp";
    }


    private String verwijderFiets(HttpServletRequest request, HttpServletResponse response){
        String ids = request.getParameter("id");
        int id = Integer.parseInt(ids);
        fietsenDB.verwijderFiets(id);
        return overzichtFietsen(request,response);

    }

    private String verwijderFietsBevestig(HttpServletRequest request, HttpServletResponse response){
        return "verwijderFietsBevestiging.jsp";
    }

    private String zoekFiets(HttpServletRequest request, HttpServletResponse response) {
        return "formVindFiets.jsp";
    }

    private String zoekMerk(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String merk = request.getParameter("merk");
        List<Fiets> fietsen = fietsenDB.getFietsenVanMerk(merk);
        HttpSession session = request.getSession();
        ArrayList<String> zoekopdrachten = new ArrayList<>();

        if (session.getAttribute("zoekopdrachten") != null) {
            zoekopdrachten = (ArrayList<String>) session.getAttribute("zoekopdrachten");
        }
        zoekopdrachten.add(merk);
        session.setAttribute("zoekopdrachten", zoekopdrachten);


        if (fietsen == null){
            return zoekFiets(request,response);
        } else {
            request.setAttribute("fietsen", fietsen);
            return zoekFiets(request,response);
        }
    }

//    private String zoekMerk(HttpServletRequest request, HttpServletResponse response){
//        String merk = request.getParameter("merk");
//        ArrayList<String> errors = new ArrayList<>();
//        List<Fiets> fietsen = new ArrayList<>();
//        HttpSession session = request.getSession();
//        ArrayList<String> zoekopdrachten = new ArrayList<>();
//
//        try{
//            if (session.getAttribute("zoekopdrachten") != null) {
//                zoekopdrachten = (ArrayList<String>) session.getAttribute("zoekopdrachten");
//            }
//            zoekopdrachten.add(merk);
//            session.setAttribute("zoekopdrachten", zoekopdrachten);
//            fietsen = fietsenDB.getFietsenVanMerk(merk);
//        } catch (DomainException e){
//            errors.add(e.getMessage());
//        } if(errors.size() == 0){
//            request.setAttribute("fietsen", fietsen);
//        } else {
//            request.setAttribute("errors", errors);
//        }
//        return zoekMerk(request,response);
//    }


    private String clearZoekopdrachten(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("zoekopdrachten");
        return zoekFiets(request,response);
    }

    private String updateWaardenFiets(HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> errors = new ArrayList<>();
        Fiets fiets = fietsenDB.vindFiets(request.getParameter("naam"));
        String id = String.valueOf(fiets.getId());
        Cookie cookie = new Cookie("id", id);
        response.addCookie(cookie);
        setKilometers(fiets, request, errors);

        if(errors.size() == 0){
            try{
                fietsenDB.pasKilometersAan(fiets.getId(), fiets.getKilometers());
                cookie.setValue(id);
                response.addCookie(cookie);
                return updateFietsBevestig(request,response);
            } catch (DomainException e){
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "updateKilometers.jsp";
    }


    private String updateFiets(HttpServletRequest request){
        Fiets fiets = fietsenDB.vindFiets(request.getParameter("naam"));

        String kilometers = request.getParameter("kilometers");

        request.setAttribute("fiets",fiets);
        request.setAttribute("kilometers",kilometers);

        return "updateKilometers.jsp";
    }


    private void setKilometers(Fiets fiets, HttpServletRequest request, ArrayList<String> errors) {
        int kilometers;
        if(request.getParameter("kilometers").trim().isEmpty() || request.getParameter("kilometers") == null){
            kilometers = -2;
        } else {
            kilometers = Integer.parseInt(request.getParameter("kilometers"));
        }
        try {
            fiets.setKilometers(kilometers);
            request.setAttribute("kilometersVorigewaarde",kilometers);
        } catch (DomainException e){
            errors.add(e.getMessage());
        }
        request.setAttribute("errors", errors);
    }


    //-----------------------------------------------------------


    private String home(HttpServletRequest request, HttpServletResponse response){
        Bier besteBier = bierDB.getBesteBier();
        request.setAttribute("besteBier", besteBier);
        return"index.jsp";
    }

    private String voegtoeForm(HttpServletRequest request, HttpServletResponse response){
        return "voeg-toe.jsp";
    }

    private String voegtoe(HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> errors = new ArrayList<>();

        Bier bier = new Bier();
        setNaam(bier, request, errors);
        setAlcoholPercentage(bier, request, errors);
        setScore(bier, request, errors);
        setBiersoort(bier, request, errors);

        if (errors.size() == 0) {
            try {
                bierDB.voegBierToe(bier);
                return overzicht(request, response);
            }
            catch (IllegalArgumentException e) {
                request.setAttribute("error", e.getMessage());
                return "voeg-toe.jsp";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "voeg-toe.jsp";
        }
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response){
//        HttpSession session = request.getSession();
//        request.setAttribute("oudeBiertjes", session.getAttribute("bierSessie"));

        Bier besteBier = bierDB.getBesteBier();
        Bier slechtsteBier = bierDB.getSlechtsteBier();
        request.setAttribute("besteBier",besteBier);
        request.setAttribute("slechtsteBier",slechtsteBier);
        request.setAttribute("bieren",bierDB.getBieren());
        return "overzicht.jsp";
    }

    private String undoDelete(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Bier bier = (Bier) session.getAttribute("bierSessie");
        bierDB.voegBierToe(bier);
        session.removeAttribute("bierSessie");
        return overzicht(request, response);
    }

    private String zoek(HttpServletRequest request, HttpServletResponse response){
        return "zoek.jsp";
    }


    private String zoekNaam(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String destination;

        String naam = request.getParameter("naam");
        Cookie cookie = new Cookie("zoekTeller", URLEncoder.encode(String.valueOf(teller),"UTF-8"));
        response.addCookie(cookie);

        if(naam == null){
            cookie.setValue(String.valueOf(teller));
            destination = "niet-gevonden.jsp";
        } else {
            Bier bier = bierDB.vind(naam);
            if(bier == null){
                cookie.setValue(String.valueOf(teller));
                destination = "niet-gevonden.jsp";
            } else {
                teller++;
                cookie.setValue(String.valueOf(teller));
                response.addCookie(cookie);

                destination = "gevonden.jsp";
                request.setAttribute("bier",bier);
            }
        }
        request.getRequestDispatcher(destination);
        return destination;
    }


    private String update(HttpServletRequest request){
        Bier bier = bierDB.vind(request.getParameter("naam"));
        String naam = request.getParameter("naam");
        String alcoholpercentage = request.getParameter("alcoholpercentage");
        String score = request.getParameter("score");
        String biersoort = request.getParameter("biersoort");


        request.setAttribute("bier",bier);
        request.setAttribute("naam",naam);
        request.setAttribute("alcoholpercentage",alcoholpercentage);
        request.setAttribute("score",score);
        request.setAttribute("biersoort",biersoort);
        return "update.jsp";
    }

    private String updateWaarden(HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> errors = new ArrayList<>();
        Bier bier = bierDB.vind(request.getParameter("naam"));

        setNaam(bier, request, errors);
        setAlcoholPercentage(bier, request, errors);
        setScore(bier, request, errors);
        setBiersoort(bier, request, errors);

        if(errors.size() == 0){
            try {
                bierDB.updateBier(bier.getNaam(),bier.getAlcoholPercentage(), bier.getScore(), bier.getBiersoort());
                return overzicht(request,response);
            } catch (IllegalArgumentException e){
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors",errors);
        return "update.jsp";
    }


    private String verwijder(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String naam = request.getParameter("naam");
        session.setAttribute("bierSessie", bierDB.vind(naam));

        bierDB.verwijderBier(naam);
        return overzicht(request,response);
    }

    private String verwijderBevestig(HttpServletRequest request, HttpServletResponse response){
        return "verwijderBevestig.jsp";
    }

    private String resetCookie(HttpServletRequest request, HttpServletResponse response) {
        String destination = "zoek.jsp";
        teller = 0;
        Cookie cookie = new Cookie("zoekTeller", "0");
        response.addCookie(cookie);
        request.getRequestDispatcher(destination);
        return destination;
    }


    private void setNaam(Bier bier, HttpServletRequest request, ArrayList<String> errors) {
        String naam = request.getParameter("naam");
        try {
            bier.setNaam(naam);
            request.setAttribute("naamVorigeWaarde",naam);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setScore(Bier bier, HttpServletRequest request, ArrayList<String> errors) {
        int score;
        if(request.getParameter("score").trim().isEmpty() || request.getParameter("score") == null){
            score = 11;
        } else {
            score = Integer.parseInt(request.getParameter("score"));
        }
        try {
            bier.setScore(score);
            request.setAttribute("scoreVorigewaarde",score);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setBiersoort(Bier bier, HttpServletRequest request, ArrayList<String> errors) {
        String biersoort = request.getParameter("biersoort");
        try {
            bier.setBiersoort(biersoort);
            request.setAttribute("biersoortVorigeWaarde",biersoort);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    private void setAlcoholPercentage(Bier bier, HttpServletRequest request, ArrayList<String> errors) {
        double alcoholpercentage;
        if(request.getParameter("alcoholpercentage").trim().isEmpty() || request.getParameter("alcoholpercentage") == null){
            alcoholpercentage = 27;
        } else {
            alcoholpercentage = Double.parseDouble(request.getParameter("alcoholpercentage"));
        }
        try {
            bier.setAlcoholPercentage(alcoholpercentage);
            request.setAttribute("alcoholpercentageVorigewaarde",alcoholpercentage);
        } catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }





}
