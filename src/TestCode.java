import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestCode {
	public static void main(String[]args) {
		Map<Pair,Integer> map = new HashMap<Pair,Integer>();
		Pair a = new Pair("michael", "anson");
		Pair b = new Pair("michael", "bill");
		Pair c = new Pair("michael", "harry");
		map.put(a,123);
		map.put(b,222);
		map.put(c,13);
		map.put(b,map.get(b)+23);
		
		System.out.println(map.containsKey(b));
		System.out.println(map.get(b));
		String [] input = {"a", "b", "b", "anson", "1", "2"};
		System.out.println(namesLength(input));
		String d = "DataMessage(bill: 0\r\n" + 
				"anson: 0\r\n" + 
				")";
		String [] arr = d.split("\\(");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i);
			System.out.println(arr[i]);
		}
		System.out.println(arr[1].substring(0, arr[1].length()-1));
	}
	private static int namesLength(String[] arguments) {
		int length = 0;
		for(int i = 3; i < arguments.length; i ++) {
			try {
				int a = Integer.valueOf(arguments[i]);
				break;
			} catch (Exception e) {
				length++;
			}
		}
		return length;
	}
}
