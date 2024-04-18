import electronicBoard.StatusPrintable;
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
    private StatusPrintable printer;
    private Judgeable judge;

    Scanner sc = new Scanner(System.in);

    public void startGame() {
        GameConfig gameConfig = new GameConfig();
        pitcher = gameConfig.pitchable();
        player = gameConfig.enterable();

        List<Integer> pitchingBall = pitcher.pitch();

        while(true) {
            judge = gameConfig.judgeable(pitchingBall, player.input());

            printer = gameConfig.statusPrintable(judge);
            printer.printResult();

            if(judge.isOut()) {
                break;
            }
        }
        askRestart();
    }

    private void endGame() {
        System.out.println("게임을 종료합니다.");
    }

    private void askRestart() {
        System.out.println("정답입니다.");
        System.out.println("1. 다시시작     2. 종료");
        if(GameStatus.CONTINUE.isContinue(sc.nextInt())) {
            startGame();
        } else {
            endGame();
        }
    }
}
