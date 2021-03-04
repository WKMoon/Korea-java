import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] arr;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
				
		arr = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		
		for(int i = 0; i < m; i++) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			
			arr[f].add(s);
			arr[s].add(f);
		}
		
		
		for(int i = 1; i < n+1; i++) {
			Collections.sort(arr[i]);
		}
		
		check = new boolean[n+1];
		dfs(v);
		check = new boolean[n+1];
		System.out.println();
		bfs(v);
		
	}

	
	public static void dfs(int v) {
		if(check[v]) {
			return;
		}
		System.out.print(v+" ");

		for(int i : arr[v]) {
			check[v] = true;
			dfs(i);
		}
		
	}
	
	public static void bfs(int v) {
		System.out.print(v + " ");
		check[v] = true;
		for(int i : arr[v]) {
			if(check[i]) {
				return;
			}
			System.out.print(i + " ");
			check[i] = true;
		}
	}
	
}
