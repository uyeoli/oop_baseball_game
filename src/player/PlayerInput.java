package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerInput {

    //player 입력
    public List<Integer> input(int size) {
        IExceptionCheck exceptionCheck = new IExceptionCheck();
        Scanner sc = new Scanner(System.in);
        List<Integer> player = new ArrayList<>();
        String number = sc.next();
        for(int i = 0; i < number.length(); i++) {
            player.add(Integer.valueOf(number.charAt(i)-'0'));
        }
        exceptionCheck.exception(player,size);

        return player;
    }




}
