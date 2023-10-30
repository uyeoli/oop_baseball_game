package referee;

import countBall.BallCount;

import java.util.List;

public class PeachingResult {
    
    //피칭 결과 출력
    public String printAnswer(List<Integer> computer, List<Integer> player){
        BallCount count = new BallCount(computer, player);
        String result = "";

        int total = count.totalCount();
        int strike = count.strikeCount();
        int ball = count.ballCount();

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
