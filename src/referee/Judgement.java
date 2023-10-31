package referee;

import java.util.List;

public class Judgement implements Judgeable {

    private List<Integer> computer;
    private List<Integer> player;
    private int size;

    public Judgement(List<Integer> computer, List<Integer> player, int size) {
        this.computer = computer;
        this.player = player;
        this.size = size;
    }

    //out인지 아닌지 비교
    @Override
    public boolean isOut(int size) {
        if(countStrike() == size) {
            return true;
        }
        return false;
    }

    //볼 카운트
    public int countBall(int total, int strike) {
        int ball = total - strike;
        return ball;
    }


    //전체 카운트
    public int countTotal() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (computer.get(i) == player.get(j)) {
                    total++;
                }
            }
        }
        return total;
    }

    //스트라이크 카운트
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
