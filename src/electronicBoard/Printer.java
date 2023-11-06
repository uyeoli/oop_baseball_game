package electronicBoard;

import referee.Judgeable;

public class Printer implements StatusPrintable{
    private Judgeable judgement;

    public Printer(Judgeable judgement) {
        this.judgement = judgement;
    }
    //결과 출력
    @Override
    public void printAnswer(){
        int strike = judgement.countStrike();
        int ball = judgement.countBall();
        String result = printStatus(strike, ball);
        System.out.println(result);
    }

    public String printStatus(int strike, int ball) {
        String result = "";
        if(ball == 0 && strike == 0) {
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
