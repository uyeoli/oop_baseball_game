package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberInput {

    //player 숫자 입력
    public List<Integer> inputNumber() {
        Scanner sc = new Scanner(System.in);
        List<Integer> player = new ArrayList<>();
        String number = sc.next();
        for(int i = 0; i < number.length(); i++) {
            player.add(Integer.valueOf(number.charAt(i)-'0'));
        }
        exception(player);

        return player;
    }


    //player exception 체크
    private void exception(List<Integer> player) {
        if(player.size() > 3) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < player.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(player.get(i) == player.get(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

}
