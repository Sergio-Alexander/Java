package utils;

public interface Set <E>{
    void add(E item);
    boolean contains(E item);
    void clear();
    boolean isEmpty();
    void remove(E item);
    int size();
}
