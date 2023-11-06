package pitcher;

import GameStatus.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pitching implements Pitchable{

    //컴퓨터 숫자 생성
    @Override
    public List<Integer> pitch() {
        Random random = new Random();
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GameStatus.SIZE.getStatus()) {
            int num = random.nextInt(9) + 1;
            if (!computer.contains(num)) {
                computer.add(num);
            }
        }
        return computer;
    }

}
