import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Question_3 {

	static int modalRank(Integer[]scores, Integer[]yours) {
		int mrank = 1;
		Map<Integer, Integer> yf= new HashMap<Integer, Integer>();
		 
		//Find mode of yours. If multiple modes, then get max 
          
        for(int i = 0; i < yours.length; i++) { 
            int key = yours[i]; 
            if(yf.containsKey(key)){ 
                int freq = yf.get(key); 
                freq++; 
                yf.put(key, freq); 
            } 
            else{ 
                yf.put(key, 1); 
            } 
        } 
        int max_count = 0, mode_yours = -1; 
          
        for(Entry<Integer, Integer> val : yf.entrySet()){ 
            if (max_count <= val.getValue()){
            	if(max_count < val.getValue()) {
            		mode_yours = val.getKey(); 
                    max_count = val.getValue();
            	}else if(max_count == val.getValue() && mode_yours < val.getKey()) {
            		mode_yours = val.getKey(); 
                    max_count = val.getValue();
            	}            
            } 
        } 
          
		//mode_yours is mode of yours
        
       // Set<Integer> ss = new TreeSet<Integer>(Arrays.asList(scores));
       
        /*
         * Can this part be optimized? Removing duplicates from scores and comparing mode_yours with each element 
         */
        
        Set<Integer> ss = new TreeSet<Integer>(Collections.reverseOrder());
        Collections.addAll(ss, scores);
        for(int i: ss) {
        	if(i > mode_yours) {
        		mrank++;
        	}else{
        		return mrank;
        	}
        }
		
        return mrank;
	}
	
	public static void main(String[]argv) {
		Integer[]scores = {100, 90, 90, 80, 75, 60};
		Integer[]yours = {50, 77, 77, 90, 95, 90};
		System.out.println(modalRank(scores,yours));
	}
}
