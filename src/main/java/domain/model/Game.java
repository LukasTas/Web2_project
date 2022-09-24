package domain.model;

import java.util.Objects;


public class Game {
    private int id;
    private String titel;
    private boolean favoriet;
    private int minutenGespeeld;

    public Game(String titel, int speeltijd, boolean favoriet) {
        this.titel = titel;
        this.minutenGespeeld = speeltijd;
        this.favoriet = favoriet;
    }

    public Game(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        if (titel == null || titel.isEmpty())
            throw new DomainException("Ongeldige waarde voor titel.");
        this.titel = titel;
    }

    public int getMinutenGespeeld() {
        return minutenGespeeld;
    }

    public void setMinutenGespeeld(int minutenGespeeld) {
        this.minutenGespeeld = minutenGespeeld;
    }

    public boolean isFavoriet() {
        return favoriet;
    }

    public void setFavoriet(boolean favoriet) {
        this.favoriet = favoriet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && favoriet == game.favoriet && minutenGespeeld == game.minutenGespeeld && titel.equals(game.titel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titel, favoriet, minutenGespeeld);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", titel='" + titel + '\'' +
                ", favorite=" + favoriet +
                ", speeltijd=" + minutenGespeeld +
                '}';
    }
}