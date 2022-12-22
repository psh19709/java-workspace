package day24.map;

//import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapApp6 {

	public static void main(String[] args) {
		String text = "In touch with former comrades now fighting in Ukraine, Gabidullin said that Russia’s use of mercenaries has ramped up as the Kremlin’s execution of its war has fallen into disarray. Ukraine’s Defense Minister Oleksiy Reznikov told CNN that Wagner troops were being deployed in the “most difficult and important missions” in Ukraine, playing a key role in Russian victories in Mariupol and Kherson.";
		text = text.toLowerCase();
		
		Map<Character, Integer> map = new TreeMap<>();
		
		int len = text.length();
		for(int index = 0; index < len; index++) {
			char ch = text.charAt(index);
			int code = (int) ch;
			if (code >= 97 && code <= 122) {
				if(map.containsKey(ch)) {
					int count = map.get(ch);
					map.put(ch, count + 1);
				} else {
					map.put(ch, 1);
				}
			}
		}
		System.out.println(map);
		
	}
}
