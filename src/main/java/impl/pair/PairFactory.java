package impl.pair;

import api.pair.Pair;
import api.pair.PairImpl;

public class PairFactory {
    public static <K, T> Pair<K, T> of(K first, T second) {
        return new PairImpl<>(first, second);
    }
}
