package countBall;

import java.util.List;

public class BallCount {

    private List<Integer> computer;
    private List<Integer> player;

    public BallCount(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
    }

    //전체 카운트
    public int totalCount() {
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
    public int strikeCount() {
        int strike = 0;
        for(int i = 0; i < 3; i++) {
            if(computer.get(i) == player.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    //볼 카운트
    public int ballCount() {
        int ball = totalCount() - strikeCount();
        return ball;
    }
}
