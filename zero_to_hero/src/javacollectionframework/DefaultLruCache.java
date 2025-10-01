package javacollectionframework;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultLruCache extends LinkedHashMap<Integer, Integer> implements LruCache {
    private int capacity;

    public DefaultLruCache(){
        super(16, 0.75f, true);
    }

    public DefaultLruCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    @Override
    public int get(int key) {
        Integer value = super.get(key);
        return value == null ? -1 : value;
    }

    @Override
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;while (size() > this.capacity) {
            remove(keySet().iterator().next());
        }
    }
}
