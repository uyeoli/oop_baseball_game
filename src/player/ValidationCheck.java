package player;

import GameStatus.GameStatus;

import java.util.List;

public class ValidationCheck implements Checkable {
    //player 유효성 체크
    @Override
    public void checkValidation(List<Integer> inputBall) {
        if(inputBall.size() > GameStatus.SIZE.getStatus()) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < inputBall.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(inputBall.get(i) == inputBall.get(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
