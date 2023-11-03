package player;

import GameStatus.GameStatus;

import java.util.List;

public class IExceptionCheck implements Checkable {
    //player exception 체크
    @Override
    public void exception(List<Integer> player) {
        if(player.size() > GameStatus.SIZE.getStatus()) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < player.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(player.get(i) == player.get(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
