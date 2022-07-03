package utils;
public interface Map<K, V>{
    void    clear();
    boolean containsKey(K key);
    boolean isEmpty();
    V       put(K key, V value);
    V       remove(K key);
    int     size();

}
