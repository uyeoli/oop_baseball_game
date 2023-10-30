package computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberCreate {

    //컴퓨터 숫자 생성
    public List<Integer> createNumber() {
        Random random = new Random();
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int num = random.nextInt(9) + 1;
            if (!computer.contains(num)) {
                computer.add(num);
            }
        }
        return computer;
    }

}
