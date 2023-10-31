package referee;

import java.util.List;
import java.util.Scanner;

public class OutCompare{

    //out인지 아닌지 비교
    public boolean compareStrike(List<Integer> computer, List<Integer> player) {
        PeachingResult peachingResult = new PeachingResult();
        String result = peachingResult.printAnswer(computer, player);
        System.out.println(result);
        if(result.contains("3스트라이크")) {
            return false;
        }
        return true;
    }
}
