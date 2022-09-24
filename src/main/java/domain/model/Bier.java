package domain.model;

public class Bier {
    private String naam;
    private double alcoholPercentage;
    private int score;
    private String biersoort;


    public Bier(String naam, double alcoholPercentage, int score,String biersoort){
        setNaam(naam);
        setAlcoholPercentage(alcoholPercentage);
        setScore(score);
        setBiersoort(biersoort);
    }

    public Bier(){
    }

    public Bier(String naam){
        this.setNaam(naam);
    }

    public Bier(double alcoholPercentage, int score, String biersoort){
        this.setAlcoholPercentage(alcoholPercentage);
        this.setScore(score);
        this.setBiersoort(biersoort);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.trim().isEmpty()) {
            throw new IllegalArgumentException("vul een geldige naam in");
        }
        this.naam = naam;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        if (alcoholPercentage < 0 || alcoholPercentage > 26 ){
            throw new IllegalArgumentException("vul een geldig alcoholpercentage in (0-26)");
        }
        this.alcoholPercentage = alcoholPercentage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0 || score > 10){
            throw new IllegalArgumentException("vul een geldige score in (0-10)");
        }
        this.score = score;
    }

    public String getBiersoort() {
        return biersoort;
    }

    public void setBiersoort(String biersoort) {
        if(biersoort == null || biersoort.trim().isEmpty()){
            throw new IllegalArgumentException("vul een geldige biersoort in");
        }
        this.biersoort = biersoort;
    }
}
