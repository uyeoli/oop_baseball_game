import pitcher.Pitchable;
import player.Enterable;
import referee.Judgeable;
import gameStatus.GameStatus;
import gameConfig.GameConfig;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Pitchable pitcher;
    private Enterable player;
//    private StatusPrintable printer;
    private Judgeable judge;

    Scanner sc = new Scanner(System.in);

    public void startGame() {
        GameConfig gameConfig = new GameConfig();
        pitcher = gameConfig.pitchable();
        player = gameConfig.enterable();
        judge = gameConfig.judgeable();
        List<Integer> pitchingBall = pitcher.pitch();

        while(true) {
            judge.doJudge(pitchingBall, player.input());
            if(judge.isOut()) {
                break;
            }
        }

        if(isRestart()){
            startGame();
        }
    }

    private boolean isRestart() {
        System.out.println("정답입니다.");
        System.out.println("1. 다시시작     2. 종료");

        return GameStatus.CONTINUE.isContinue(sc.nextInt());
    }
}
