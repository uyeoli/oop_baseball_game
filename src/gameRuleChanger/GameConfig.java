package gameRuleChanger;

import electronicBoard.Printer;
import electronicBoard.StatusPrintable;
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

    public StatusPrintable statusPrintable(Judgeable judgeable) {
        return new Printer(judgeable);
    }

    public Judgeable judgeable(List<Integer> pitchingBall, List<Integer> inputBall) {
        return new Judge(pitchingBall, inputBall);
    }

}
