package api.pair;

public class PairImpl<T, K> implements Pair<T, K>{

    private T firstItem;
    private K secondItem;

    public PairImpl(T firstItem, K secondItem) {
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
            if (!((Pair<?, ?>) obj).getFirst().equals(this.getFirst()))
                return false;

            if (!((Pair<?, ?>) obj).getSecond().equals(this.getSecond()))
                return false;

            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.getFirst().getClass().getName() + this.getSecond().getClass().getName();

    }

}
