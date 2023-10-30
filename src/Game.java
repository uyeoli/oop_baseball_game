import computer.NumberCreate;
import player.NumberInput;
import referee.OutCompare;

import java.util.List;
import java.util.Scanner;

public class Game {
    NumberCreate numberCreate = new NumberCreate();
    NumberInput numberInput = new NumberInput();

    public void start() {
        System.out.println("게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);
        OutCompare result = new OutCompare();

        List<Integer> computer = numberCreate.createNumber();

        boolean flag = true;

        while(flag) {
            List<Integer> player = numberInput.inputNumber();
            flag = result.compareStrike(computer,player); // true / false
            if(flag == false) {
                System.out.println("1. 다시시작     2. 종료");
                int num = sc.nextInt();
                if(num == 1) {
                    start();
                } else if(num == 2) {
                    endGame();
                }
            }
        }

    }

    private void endGame() {
        System.out.println("게임을 종료합니다.");
    }
}
