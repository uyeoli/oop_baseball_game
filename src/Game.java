import electronicBoard.Printer;
import pitcher.Pitching;
import referee.Judgement;
import player.PlayerInput;

import java.util.List;
import java.util.Scanner;

public class Game {
    Pitching numberCreate = new Pitching();
    PlayerInput numberInput = new PlayerInput();
    Printer printer = new Printer();
    private final int size = 3;
    public void startGame() {
        System.out.println("게임을 시작합니다.");

        List<Integer> computer = numberCreate.createNumber(size);
        boolean flag = false;

        while(!flag) {
            List<Integer> player = numberInput.input(size);
            Judgement judgement = new Judgement(computer, player, size);
            printer.printAnswer(judgement);
            flag = judgement.isOut(size);
            if(flag == true) {
                askRestart();
            }
        }
    }

    private void endGame() {
        System.out.println("게임을 종료합니다.");
    }

    private void askRestart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정답입니다.");
        System.out.println("1. 다시시작     2. 종료");
        int num = sc.nextInt();
        if(num == 1) {
            startGame();
        } else if(num == 2) {
            endGame();
        }
    }
}
