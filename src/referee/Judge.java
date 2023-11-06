package referee;

import GameStatus.GameStatus;

import java.util.List;

public class Judgement implements Judgeable {

    private List<Integer> computer;
    private List<Integer> player;
    private int size = GameStatus.SIZE.getStatus();
    public Judgement(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
    }

    //out인지 아닌지 비교
    @Override
    public boolean isOut() {
        if(countStrike() == size) {
            return true;
        }
        return false;
    }


    //전체 카운트
    @Override
    public int countBall() {
        int ball = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (computer.get(i) == player.get(j)) {
                    ball++;
                }
            }
        }
        ball = ball - countStrike();

        return ball;
    }

    //스트라이크 카운트
    @Override
    public int countStrike() {
        int strike = 0;
        for(int i = 0; i < size; i++) {
            if(computer.get(i) == player.get(i)) {
                strike++;
            }
        }
        return strike;
    }



}
