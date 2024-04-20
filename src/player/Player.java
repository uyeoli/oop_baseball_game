package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Enterable{
    Checkable check = new Validator();
    Scanner sc = new Scanner(System.in);
    //player 입력
    @Override
    public List<Integer> input() {
        List<Integer> inputBall = new ArrayList<>();
        String number = sc.next();
        for(int i = 0; i < number.length(); i++) {
            inputBall.add(Integer.valueOf(number.charAt(i)-'0'));
        }
        check.checkValidation(inputBall);

        return inputBall;
    }




}
