package countBall;

import java.util.List;

public class BallCount implements BallCounter{

    private List<Integer> computer;
    private List<Integer> player;

    public BallCount(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
    }

    //볼 카운트
    @Override
    public int countBall(int total, int strike) {
        int ball = total - strike;
        return ball;
    }


    //전체 카운트
    @Override
    public int countTotal() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computer.get(i) == player.get(j)) {
                    total++;
                }
            }
        }
        return total;
    }

    //스트라이크 카운트
    @Override
    public int countStrike() {
        int strike = 0;
        for(int i = 0; i < 3; i++) {
            if(computer.get(i) == player.get(i)) {
                strike++;
            }
        }
        return strike;
    }



}
