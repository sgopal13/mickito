import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) throws IOException {
		
		/*
		 * List<String> l1 = new ArrayList<>(); l1.add("a"); l1.add("b"); l1.add("c");
		 * l1.add("d"); l1.add("e");
		 * 
		 * List<String> l2 = new ArrayList<>(); l2.add("a"); l2.add("s"); l2.add("c");
		 * l2.add("d"); l2.add("q");
		 * 
		 * l1.parallelStream().forEach(l -> { System.out.println("l1 : " + l);
		 * l2.parallelStream().forEach(l22 -> { System.out.println("l2 : " + l22); if
		 * (l.equals(l22)) { System.out.println("true"); } }); });
		 */
		FileOutputStream  fileOutputStream= new FileOutputStream("E:\\test.txt");
		IntStream. range(1,15000).parallel().forEach(i ->{
			System.out.println("l1 :"+i);
			IntStream. range(1,15000).parallel().forEach(i1 ->{
				System.out.println("l2 :"+i1);
				try {
					fileOutputStream.write(String.valueOf(i).getBytes());  
					fileOutputStream.write("\n".getBytes());  
					fileOutputStream.write(String.valueOf(2).getBytes());  
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
		});
		fileOutputStream.close();
	}
}
