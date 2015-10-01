class PeekingIterator implements Iterator<Integer> {
    private Iterator<i]Integer> iter;
    private Integer peek = null;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            peek = iter.next();
        }
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = peek;
        peek = (iter.hasNext()) ? iter.next() : null;
        return res;
    }
    
    @Override
    public boolean hasNext() {
        return peek != null;
    }
}
