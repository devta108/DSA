import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator){
        this.iterator = iterator;

    }
    public Integer peek(){

    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
