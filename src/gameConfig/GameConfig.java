package gameConfig;

import pitcher.Pitchable;
import pitcher.Pitcher;
import player.Enterable;
import player.Player;
import referee.Judge;
import referee.Judgeable;

import java.util.List;

public class GameConfig {

    public Enterable enterable() {
        return new Player();
    }

    public Pitchable pitchable() {
        return new Pitcher();
    }

    public Judgeable judgeable() {
        return new Judge();
    }

}
