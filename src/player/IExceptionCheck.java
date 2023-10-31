package player;

import java.util.List;

public class ExceptionCheck implements Checkable {
    //player exception 체크
    @Override
    public void exception(List<Integer> player) {
        if(player.size() > 3) {
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
