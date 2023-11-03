package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerInput implements Enterable{
    Checkable exceptionCheck = new IExceptionCheck();
    Scanner sc = new Scanner(System.in);
    //player 입력
    @Override
    public List<Integer> input(int size) {
        List<Integer> player = new ArrayList<>();
        String number = sc.next();
        for(int i = 0; i < number.length(); i++) {
            player.add(Integer.valueOf(number.charAt(i)-'0'));
        }
        exceptionCheck.exception(player,size);

        return player;
    }




}
