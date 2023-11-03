package pitcher;

import java.util.List;

public class Pitcher {
    public List<Integer> pitch(Pitchable pitchable) {
        return pitchable.pitch();
    }
}
