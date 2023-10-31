package referee;

import countBall.BallCount;

import java.util.List;

public class PeachingResult implements StatusPrinter {
    private int total;
    private int strike;
    private int ball;
    //피칭 결과 출력
    public String printAnswer(List<Integer> computer, List<Integer> player){
        BallCount count = new BallCount(computer, player);
        total = count.countTotal();
        strike = count.countStrike();
        ball = count.countBall(total, strike);
        String result = printStatus(total, strike, ball);

        return result;
    }

    @Override
    public String printStatus(int total, int strike, int ball) {
        String result = "";
        if(total == 0) {
            result = "낫싱";
        } else if(strike == 0) {
            result = ball + "볼";
        } else if (ball == 0) {
            result = strike + "스트라이크";
        } else {
            result = ball + "볼 " + strike + "스트라이크";
        }
        return result;
    }

}
