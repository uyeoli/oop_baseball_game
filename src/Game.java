import electronicBoard.Printer;
import pitcher.Pitchable;
import pitcher.Pitcher;
import pitcher.Pitching;
import player.Enterable;
import player.Player;
import referee.Judgement;
import player.PlayerInput;
import GameStatus.GameStatus;

import java.util.List;
import java.util.Scanner;

public class Game {
    Pitchable pitchable = new Pitching();
    Enterable enterable = new PlayerInput();
    Pitcher pitcher = new Pitcher();
    Player player = new Player();

    Scanner sc = new Scanner(System.in);

    private Judgement judgement;

    Printer printer;
    public void startGame() {
        System.out.println("게임을 시작합니다.");
        List<Integer> computerList = pitcher.pitch(pitchable); //투수의 피칭은 pitchable에 따라 달라짐 -> 의존성을 추상클래스에 둠
        System.out.println(computerList);
        while(true) {
            List<Integer> playerList = player.input(enterable); //플레이어의 input은 enterable이라는 인터페이스에 의존성을 둠
            judgement = new Judgement(computerList, playerList);
            printer = new Printer(judgement);
            printer.printAnswer();
            if(judgement.isOut()) {
                askRestart();
                break;
            }
        }
    }

    private void endGame() {
        System.out.println("게임을 종료합니다.");
    }

    private boolean askRestart() {
        System.out.println("정답입니다.");
        System.out.println("1. 다시시작     2. 종료");
        if(GameStatus.CONTINUE.isContinue(sc.nextInt())) {
            startGame();
            return true;
        } else {
            endGame();
            return false;
        }
    }
}
