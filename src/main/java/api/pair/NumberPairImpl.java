package api.pair;

public class NumberPairImpl<T extends Number, K extends Number> implements NumberPair<T, K>{
    private T firstItem;
    private K secondItem;

    public NumberPairImpl(T firstItem, K secondItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }


    @Override
    public T getFirst() {
        return firstItem;
    }

    @Override
    public K getSecond() {
        return secondItem;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;

        if(obj instanceof Pair<?, ?>) {
            if (!((NumberPair<?, ?>) obj).getFirst().equals(this.getFirst()))
                return false;

            if (!((NumberPair<?, ?>) obj).getSecond().equals(this.getSecond()))
                return false;

            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "First value is: " + this.getFirst().toString() + " Second value is: " + this.getSecond().toString();

    }



}
