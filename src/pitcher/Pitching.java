package pitcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pitching {

    //컴퓨터 숫자 생성
    public List<Integer> pitch(int size) {
        Random random = new Random();
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int num = random.nextInt(9) + 1;
            if (!computer.contains(num)) {
                computer.add(num);
            }
        }
        return computer;
    }

}
