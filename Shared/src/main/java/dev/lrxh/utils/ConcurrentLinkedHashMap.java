package dev.lrxh.utils;

import java.util.*;

public class ConcurrentLinkedHashMap<K, V> {
    private Map<K, V> map;

    public ConcurrentLinkedHashMap() {
        this.map = Collections.synchronizedMap(new LinkedHashMap<>());
    }

    public void set(LinkedHashMap linkedHashMap) {
        this.map = Collections.synchronizedMap(linkedHashMap);
    }

    public void put(K key, V value) {
        synchronized (map) {
            map.put(key, value);
        }
    }

    public V get(Object key) {
        synchronized (map) {
            return map.get(key);
        }
    }

    public V remove(Object key) {
        synchronized (map) {
            return map.remove(key);
        }
    }

    public void clear() {
        synchronized (map) {
            map.clear();
        }
    }

    public boolean containsKey(Object key) {
        synchronized (map) {
            return map.containsKey(key);
        }
    }

    public boolean containsValue(Object value) {
        synchronized (map) {
            return map.containsValue(value);
        }
    }

    public int size() {
        synchronized (map) {
            return map.size();
        }
    }

    public boolean isEmpty() {
        synchronized (map) {
            return map.isEmpty();
        }
    }

    public Set<K> keySet() {
        synchronized (map) {
            return new HashSet<>(map.keySet());
        }
    }

    public Collection<V> values() {
        synchronized (map) {
            return new ArrayList<>(map.values());
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        synchronized (map) {
            return new HashSet<>(map.entrySet());
        }
    }

    @Override
    public String toString() {
        synchronized (map) {
            return map.toString();
        }
    }
}
