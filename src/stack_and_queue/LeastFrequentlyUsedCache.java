package stack_and_queue;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeastFrequentlyUsedCache {
    public static void main(String[] args) {

        LFU<Integer, Integer> cache = new LFU<>(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.put(4, 40);
        cache.put(4, 45);
        cache.put(3, 45);
        cache.put(2, 45);
        System.out.println("------------");
        cache.get(3);
        cache.get(2);
        cache.get(4);
        cache.put(5, 50);
        cache.get(4);
    }

    private static class LFU<K, V> {

        private Map<Integer, LinkedList<Map.Entry<K, V>>> freqList;
        private Map<K, Map.Entry<K, V>> map;
        private int size;
        private int currentSize;
        private int currentFreq;

        public LFU() {
            this.freqList = new HashMap<Integer, LinkedList<Map.Entry<K, V>>>();
            this.map = new HashMap<>();
            this.size = 5;
            this.currentSize = 0;
            this.currentFreq = 1;
        }

        public LFU(int size) {
            this.freqList = new HashMap<Integer, LinkedList<Map.Entry<K, V>>>();
            this.map = new HashMap<>();
            this.size = size;
            this.currentSize = 0;
            this.currentFreq = 1;
        }

        public void put(K key, V value) {
            if (map.containsKey(key)) {
                Map.Entry<K, V> e = map.remove(key);
                currentSize--;

                LinkedList<Map.Entry<K, V>> list = freqList.get(currentFreq);
                list.remove(e);

                e = new AbstractMap.SimpleImmutableEntry<K, V>(key, value);

                list = freqList.get(currentFreq + 1);
                if (list == null) {
                    list = new LinkedList<Map.Entry<K, V>>();
                    freqList.put(currentFreq + 1, list);
                }

                list.addFirst(e);
                map.put(key, e);
                currentSize++;

                System.out.println("Frequency Map: " + freqList.toString() + " " + " Map: " + map.toString());

                if (freqList.get(currentFreq).isEmpty()) {
                    currentFreq++;
                }

                return;
            }

            if (currentSize == size) {
                LinkedList<Map.Entry<K, V>> list = freqList.get(currentFreq);
                Map.Entry<K, V> e = list.removeLast();
                map.remove(e.getKey());
                currentSize--;

                if (freqList.get(currentFreq).isEmpty()) {
                    currentFreq++;
                }

            }

            Map.Entry<K, V> e = new AbstractMap.SimpleImmutableEntry<K, V>(key, value);
            LinkedList<Map.Entry<K, V>> list = freqList.get(1);
            if (list == null) {
                list = new LinkedList<Map.Entry<K, V>>();
                freqList.put(1, list);
                currentFreq = 1;
            }
            list.addFirst(e);

            map.put(key, e);
            currentSize++;

            System.out.println("Frequency Map: " + freqList.toString() + " " + " Map: " + map.toString());
        }

        public V get(K key) {
            if (map.isEmpty() || !map.containsKey(key)) {
                throw new IllegalStateException("no value found with key: " + key);
            }

            Map.Entry<K, V> e = map.remove(key);
            currentSize--;

            LinkedList<Map.Entry<K, V>> list = freqList.get(currentFreq);

            list.remove(e);

            list = freqList.get(currentFreq + 1);
            if (list == null) {
                list = new LinkedList<Map.Entry<K, V>>();
                freqList.put(currentFreq + 1, list);
            }

            list.addFirst(e);
            map.put(key, e);
            currentSize++;

            if (freqList.get(currentFreq).isEmpty()) {
                currentFreq++;
            }

            System.out.println("Frequency Map: " + freqList.toString() + " " + " Map: " + map.toString());

            return e.getValue();
        }
    }

}
