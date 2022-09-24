package domain.db;
import domain.model.Bier;
import java.util.ArrayList;
import java.util.Objects;

public class BierDB {
    ArrayList<Bier> bieren;



    public BierDB(){
        bieren = new ArrayList<>();
        this.voegBierToe(new Bier("Cara Pils",4.4,10,"pils"));
        this.voegBierToe(new Bier("Stella",5.2,9,"pils"));
        this.voegBierToe(new Bier("Duvel",8.5,10,"blond speciaalbier"));
        this.voegBierToe(new Bier("Leffe",6.6,8,"blond speciaalbier"));
    }

    public ArrayList<Bier> getBieren(){
        if (bieren.size() == 0){
            return null;
        }
        return this.bieren;
    }

    public void voegBierToe(Bier bier){
        if(bier == null) {
            throw new IllegalArgumentException("Geen geldig bier!");
        }
        for (Bier b: bieren){
            if(b.getNaam().equalsIgnoreCase(bier.getNaam()))
                throw new IllegalArgumentException("dit bier is al toegevoegd.");
        }
        bieren.add(bier);
    }

    public void verwijderBier(String naam){
        if(naam == null || naam.trim().isEmpty()){
            throw new IllegalArgumentException("geen geldige naam.");
        }
        bieren.remove(this.vind(naam));
    }

    public Bier vind(String naam){
        for (Bier bier: bieren){
            if (bier.getNaam().equals(naam)){
                return bier;
            }
        }
        return null;
    }

    public Bier getBesteBier(){
        if (bieren.size() == 0){
            return null;
        }
        Bier beste= bieren.get(0);
        for(Bier bier: bieren){
            if(bier.getScore() > beste.getScore()){
                beste = bier;
            }
        }
        return beste;
    }

    public Bier getSlechtsteBier(){
        if(bieren.size() == 0){
            return null;
        }
        Bier slechtste = bieren.get(0);
        for(Bier bier: bieren){
            if(bier.getScore() < slechtste.getScore()){
                slechtste = bier;
            }
        }
        return slechtste;
    }

    public void updateBier(String naam, double alcoholpercentage, int score, String biersoort){
        Bier bier = this.vind(naam);
        bier.setAlcoholPercentage(alcoholpercentage);
        bier.setScore(score);
        bier.setBiersoort(biersoort);
    }

    public void veranderBier(String naam, Bier biertje){
        System.out.println( "naam: " + naam + "biertje: " + biertje);
        bieren.removeIf(i -> Objects.equals(i.getNaam(), naam));
        voegBierToe(biertje);
        biertje.setNaam(naam);
//        nieuwBiertje--;
    }

    public Bier zoekBierBijNaam(String naam){
        Bier biertje = null;
        for(Bier bier: bieren){
            if(bier.getNaam().equals(naam)){
                biertje = bier;
            }
        }
        return biertje;
    }
}
