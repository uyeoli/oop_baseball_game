import computer.NumberCreate;
import player.NumberInput;
import referee.OutCompare;

import java.util.List;
import java.util.Scanner;

public class Game {
    NumberCreate numberCreate = new NumberCreate();
    NumberInput numberInput = new NumberInput();

    public void startGame() {
        System.out.println("게임을 시작합니다.");
        OutCompare result = new OutCompare();
        List<Integer> computer = numberCreate.createNumber();
        boolean flag = true;

        while(flag) {
            List<Integer> player = numberInput.inputNumber();
            flag = result.compareStrike(computer,player);
            if(flag == false) {
                askRestart();
            }
        }
    }

    private void endGame() {
        System.out.println("게임을 종료합니다.");
    }

    private void askRestart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 다시시작     2. 종료");
        int num = sc.nextInt();
        if(num == 1) {
            startGame();
        } else if(num == 2) {
            endGame();
        }
    }
}
