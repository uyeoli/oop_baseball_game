import electronicBoard.Printer;
import electronicBoard.StatusPrintable;
import pitcher.Pitchable;
import pitcher.Pitcher;
import player.Enterable;
import player.Player;
import referee.Judgeable;
import referee.Judge;
import GameStatus.GameStatus;

import java.util.List;
import java.util.Scanner;

public class Game {
    Pitchable pitcher = new Pitcher(); // 인터페이스 타입으로 인스턴스화
    Enterable player = new Player();
    StatusPrintable printer = new Printer();
    Scanner sc = new Scanner(System.in);

    private Judgeable judgement;
    public void startGame() {
        System.out.println("게임을 시작합니다.");
        List<Integer> computerList = pitcher.pitch(); //투수의 피칭은 pitchable에 의존성을 둠 -> DIP 원칙 O
        while(true) {
            List<Integer> playerList = player.input(); //플레이어의 입력은 eneterable에 의존성을 둠 - > DIP 원칙 O
            judgement = new Judge(computerList, playerList);
            printer.printAnswer(judgement);
            if(judgement.isOut()) {
                askRestart();
                break;
            }
        }
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
