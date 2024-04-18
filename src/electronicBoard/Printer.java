package electronicBoard;

import referee.Judgeable;

public class Printer implements StatusPrintable{

    private final Judgeable judgeable;

    public Printer(Judgeable judgeable) {
        this.judgeable = judgeable;
    }

    @Override
    public void printResult(){
        String result = printStatus(judgeable.getCountingStrike(), judgeable.getCountingBall());
        System.out.println(result);
    }

    private String printStatus(int strike, int ball) {
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
