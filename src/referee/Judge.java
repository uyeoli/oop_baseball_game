package referee;

import GameStatus.GameStatus;

import java.util.List;
import java.util.function.Consumer;

public class Judge implements Judgeable {

    private int strike;
    private int ball;
    private List<Integer> pitchingBall;
    private List<Integer> inputBall;
    private int size = GameStatus.SIZE.getStatus();
    public Judge(List<Integer> pitchingBall, List<Integer> inputBall) {
        this.pitchingBall = pitchingBall;
        this.inputBall = inputBall;
        this.strike = countStrike();
        this.ball = countBall();
    }

    //out인지 아닌지 비교
    @Override
    public boolean isOut() {
        if(strike == size) {
            return true;
        }
        return false;
    }

    //볼 카운트
    @Override
    public int getBallCount() {
        return ball;
    }

    //스트라이크 카운트
    @Override
    public int getStrikeCount() {
        return strike;
    }


    public int countBall() {
        int ball = 0;
        for (int i=0; i < inputBall.size(); i++) {
            if (pitchingBall.contains(inputBall.get(i))) {
                ball++;
            }
        }
        ball = ball - strike;

        return ball;
    }

    public int countStrike() {
        int strike = 0;
        for (int i=0; i < inputBall.size(); i++) {
            if (inputBall.get(i) == pitchingBall.get(i)) {
                strike++;
            }
        }

        return strike;
    }

}
