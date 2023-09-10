import java.util.HashMap;
import java.util.Map;

public class Main{

		public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("Ram", 36);
		map.put("Shyam", 60);
		
		map.forEach((k,v) -> System.out.println(k+" , "+v));
		
	}

}