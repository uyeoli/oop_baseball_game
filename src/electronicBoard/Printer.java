package electronicBoard;

import referee.Judgement;

public class Board implements StatusPrintable{
    private int total;
    private int strike;
    private int ball;

    //결과 출력
    public void printAnswer(Judgement judgement){
        total = judgement.countTotal();
        strike = judgement.countStrike();
        ball = judgement.countBall(total, strike);
        String result = printStatus(total, strike, ball);
        System.out.println(result);
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
