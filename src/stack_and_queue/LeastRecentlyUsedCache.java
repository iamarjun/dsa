package stack_and_queue;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeastRecentlyUsedCache {
    public static void main(String[] args) {

        LRU<Integer, Integer> cache = new LRU<>();

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.get(1);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.put(7, 7);
        cache.get(1);
        cache.put(8, 8);
    }

    private static class LRU<K, V> {

        private LinkedList<Map.Entry<K, V>> list;
        private Map<K, Map.Entry<K, V>> map;
        private int size;

        public LRU() {
            this.list = new LinkedList<>();
            this.map = new HashMap<>();
            this.size = 5;
        }
        public LRU(int size) {
            this.list = new LinkedList<>();
            this.map = new HashMap<>();
            this.size = size;
        }

        public void put(K key, V value) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
            if (map.size() == size) {
                Map.Entry<K, V> e = list.removeLast();
                map.remove(e.getKey());
            }

            Map.Entry<K, V> e = new AbstractMap.SimpleImmutableEntry<K,V>(key, value);
            list.addFirst(e);

            map.put(key, e);

            System.out.println("List: " + list.toString() + " " + " Map: " + map.toString());
        }

        public V get(K key) {
            if (map.isEmpty()) {
                throw new IllegalStateException("map is empty");
            }

            Map.Entry<K, V> e = map.get(key);
            list.remove(e);
            list.addFirst(e);
            return e.getValue();
        }
    }
}
