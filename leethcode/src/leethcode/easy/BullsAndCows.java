package leethcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class BullsAndCows {

	
	public String getHint(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		Map<Character,Integer> bcMaps = new HashMap<Character,Integer>();
		char []secretArray = secret.toCharArray();
		char []guessArray = guess.toCharArray();
		List<Character> unmatched = new ArrayList<Character>();
		
		for(int i=0;i<secretArray.length;i++){
			if(secretArray[i] == guessArray[i])
				bulls++;
			else{
				Integer count = bcMaps.get(secretArray[i]);
				if(count == null){
					count = 0;
				}
				bcMaps.put(secretArray[i], ++count);
				unmatched.add(guessArray[i]);
			}
		}
		
		
		for(int i=0;i<unmatched.size();i++){
			Integer count  = bcMaps.get(unmatched.get(i));
			//not found
			if(count == null || count == 0)
				continue;
			//found
			cows++;
			bcMaps.put(unmatched.get(i), --count);
		
		}
		
        return bulls+"A"+cows+"B";
    }
	
	
	
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(BullsAndCowsTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
