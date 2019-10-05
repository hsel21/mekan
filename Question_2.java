import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Question_2 {

	static int largestBonus(int[]trader,int[]risk,int[]bonus) {
		int total_bonus = 0;
		
		TreeMap<Integer, Integer> m = new TreeMap<Integer,Integer>(Collections.reverseOrder()); //Reverse order puts greatest bonus at the beginning
		ArrayList<Integer> tl = new ArrayList<Integer>(); //Keeps track of what trader we matched with a trade
		
		for(int i = 0; i < bonus.length; i++) {
			if(m.containsKey(bonus[i]) && m.get(bonus[i]) > risk[i]) {
				m.put(bonus[i], risk[i]);
			}else if(!m.containsKey(bonus[i])) {
				m.put(bonus[i], risk[i]);
			}
		}
		
		for (Entry<Integer, Integer> entry : m.entrySet())  {
			int r = entry.getValue();
			int i = 0; //Labels for the trader array
			for(int t: trader) {
				if(t >= r && !tl.contains(i)) {
					tl.add(i);
					total_bonus += entry.getKey();
					if(tl.size() == trader.length) {
						return total_bonus;
					}
				}
				i++;
			}			
		}
		
		return total_bonus;
	}
	
	public static void main(String[]argv) {

		int[]trader = {6, 7, 2, 8, 1};
		int[]risk = {5, 4, 1, 3, 8};
		int[]bonus = {9, 6, 4, 9, 4};
				
		System.out.println(largestBonus(trader,risk,bonus));
	}
}
