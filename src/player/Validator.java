package player;

import gameStatus.GameStatus;

import java.util.List;

public class Validator implements Checkable {
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
