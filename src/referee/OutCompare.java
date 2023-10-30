package referee;

import java.util.List;
import java.util.Scanner;

public class OutCompare extends PeachingResult {

    //out인지 아닌지 비교
    public boolean compareStrike(List<Integer> computer, List<Integer> player) {
        String result = printAnswer(computer, player);
        Scanner sc = new Scanner(System.in);
        System.out.println(result);
        if(result.equals("3스트라이크")) {
            return false;
        }
        return true;
    }
}
