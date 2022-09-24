package domain.db;

import domain.model.DomainException;
import domain.model.Game;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class GameDB {
    private final List<Game> games = new ArrayList<>();
    private int sequence = 0;

    public GameDB() {
        this.add(new Game("Counter-Strike: Global Offensive", 575, true));
        this.add(new Game("Dota 2", 455, false));
        this.add(new Game("Lost Ark", 611, false));
        this.add(new Game("Apex Legends", 215, false));
        this.add(new Game("PUBG Battlegrounds", 105, false));
    }

    public void add(Game game) {
        if (game == null) {
            throw new DomainException("Ongeldige game.");
        }
        this.sequence++;
        game.setId(sequence);
        games.add(game);
    }

    public Game getGameById(int id) {
        return games.stream().filter(game -> game.getId() == id).findFirst().orElseThrow(() -> new DomainException("Game niet gevonden"));
    }

    public List<Game> getAlleGames() {
        return games;
    }


    public List<Game> getGamesLangerGespeeldDan(int tijd) {
        return getAlleGames().stream().filter((game -> game.getMinutenGespeeld() > tijd)).collect(collectingAndThen(toList(), result -> {
            if (result.isEmpty())
                throw new DomainException("Geen games gevonden.");
            return result;
        }));
    }

    public void deleteGame(int id) {
        games.removeIf(game -> game.getId() == id);
    }

    @Override
    public String toString() {
        String out = "";
        for (Game game : getAlleGames()) {
            out += game.toString() + "\n";
        }
        return out;
    }
}