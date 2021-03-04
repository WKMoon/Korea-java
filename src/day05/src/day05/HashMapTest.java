package day05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("사과", 3500);
		fruitMap.put("배", 4000);
		fruitMap.put("자두", 1500);
		fruitMap.put("수박", 8000);
		
		System.out.println(fruitMap);
		System.out.println(fruitMap.get("수박"));
		
		
		//Key분리
		Iterator<String> fruitNames = fruitMap.keySet().iterator();
		
		while(fruitNames.hasNext()) {
			System.out.println(fruitNames.next());
		}
		
		
		//Value분리
		Set<String> keys = fruitMap.keySet();
		int sum = 0;
		for(String key: keys){
		    sum += fruitMap.get(key);
		}
		System.out.println(sum/fruitMap.size());
		
	
		int total = 0;
		for(Integer value : fruitMap.values()) {
			total += value;
		}
		System.out.println(total/fruitMap.size());
		
		
		//메뉴판
		//한 쌍씩 분리(EntrySet())
		Iterator<Entry<String, Integer>> iter = fruitMap.entrySet().iterator();
		
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
		}
	}
}
