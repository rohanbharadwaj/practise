
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LRUCache<K, V> {

	private final int capacity;
	private ConcurrentLinkedQueue<K> queue;
	private ConcurrentHashMap<K, V> map;

	public LRUCache(final int capacity) {
		this.capacity = capacity;
		this.queue	= new ConcurrentLinkedQueue<K>();
		this.map	= new ConcurrentHashMap<K, V>(capacity);
	}

	public V get(final K key) {
		return map.get(key);
	}
	
	public synchronized void put(final K key, final V value) {
		if(key == null || value == null) {
			throw new NullPointerException();
		}
		if (map.containsKey(key)) {
			queue.remove(key);
		}
		while (queue.size() >= capacity) {
			K expiredKey = queue.poll();
			if (expiredKey != null) {
				map.remove(expiredKey);
			}
		}
		queue.add(key);
		map.put(key, value);
	}
	
	
	public static void main(String args[])
	{
		LRUCache<Integer,Integer> obj = new LRUCache<Integer,Integer>(5);
		obj.put(1, 10);
		obj.put(2, 20);
		obj.put(3, 30);
		obj.put(4, 40);
		obj.put(5, 50);
		obj.put(6, 60);
		for(int i=1;i<=5;i++)
		System.out.println(obj.get(i));
	}
}


