package day05;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
	public static void main(String[] args) {
		//알고리즘: 문제를 해결하기 위한 절차
		//자료구조: 여러 알고리즘이 모여 구조화가 되어있는것
		//		의미없는 데이터가 자료구조를 통과하면 하나의 정보가 된다.
		//10: 의미없는 값
		//int age = 10; :자료구조
		ArrayList<Integer> datas = new ArrayList();
		
		datas.add(10);
		datas.add(20);
		datas.add(30);
		datas.add(40);
		datas.add(50);
		datas.add(60);
		datas.add(70);
		datas.add(80);
		datas.add(90);
		
		System.out.println(datas.size());
		System.out.println(datas.get(1));
		
		
		//CRUD
		//create
		//read
		//update
		//delete
		
//		추가(40추가)
//		삽입(10뒤에 15 삽입)
//		수정(20을 200으로 수정)
//		삭제(50 삭제)
		
		for(int i = 0; i < datas.size(); i++) {
			if(datas.get(i) == 10) {
				datas.add(i+1, 15);
			}
			if(datas.get(i) == 20) {
				datas.set(i, 200);
			}
			if(datas.get(i) == 50) {
				datas.remove(i);
			}
		}
		
		System.out.println(datas);
		
		
		ArrayList<Integer> datas2 = new ArrayList<>();
		datas2.add(10);
		datas2.add(10);
		datas2.add(20);
		datas2.add(10);
		
		
		//마지막 10을 삭제한다
		datas2.lastIndexOf(10);

		
		ArrayList<Integer> idxs = new ArrayList();
		
		for(int i = 0; i < datas2.size(); i++) {
			if(datas2.get(i) == 10) {
				idxs.add(i);
			}
		}
		try {
			//remove(int idx) 를 사용하기 위해서는 Integer를 int로 언박싱 해야한다.
			//따라서 idxs.get(1).intValue()를 통해 int타입으로 언박싱을 해주면,
			//remove(int idx)로 인식되어 해당 인덱스에 있는 값이 삭제된다.
			datas2.remove(idxs.get(1).intValue());
		} catch (Exception e) {
			System.out.println("존재하지 않는 인덱스입니다.");
		}
		
		
		Collections.sort(datas);
		
		

	}
}
