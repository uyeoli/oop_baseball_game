package referee;

import java.util.List;

public interface Judgeable {

    boolean isOut();

    void doJudge(List<Integer> pitchingBall, List<Integer> inputBall);


}
