package p2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {

//		Path path = Paths.get("src/p2/Main.java");
//		//파일 경로로 스트림 만들기
//		Stream<String> stream = Files.lines(path);
//	
//		stream.forEach(System.out::println);
//		stream.close();
//		
//		
//		//BufferedReader.lines()를 이용해서 파일 스트림으로 얻기
//		File file = path.toFile();
//		FileReader fileReader = new FileReader(file);
//		BufferedReader br = new BufferedReader(fileReader);
//		
//		Stream<String> stream2 = br.lines();
//		stream2.forEach(System.out::println);
//		
		
//		Path path2 = Paths.get("/usr/share/java /usr/local/jdk1.8.0_271/bin/java");
//		Stream<Path> stream3 = Files.list(path2);
//		
//		stream3.forEach(p->System.out.println(p.getFileName()));

		
		//Random Stream
		
		IntStream is =new Random().ints();
		is.forEach(a->System.out.println(a));
		
		
		
	}

}
