import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public interface IRoll {

    int nbDice = 5;

    long getScore(Roll roll);
}
