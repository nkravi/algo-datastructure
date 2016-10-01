package leethcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ShortestWordDistanceII {
	Map<String,Map<String,Integer>> wordMap;
	
	private void processWords(String[] words){
		for(int i=0;i<words.length;i++){
			for(int j=0; j< words.length;j++){
				Map<String,Integer> distMap = (wordMap.containsKey(words[i]))?  wordMap.get(words[i]) : new HashMap<String,Integer>();
				Integer dist = (distMap.containsKey(words[j]) ? distMap.get(words[j]) : Integer.MAX_VALUE );
				dist = Math.min(Math.abs(i-j), dist);
				distMap.put(words[j], dist);
				wordMap.put(words[i], distMap);
			}
		}
	}
	
	ShortestWordDistanceII(String[] words){
		 wordMap =  new HashMap<>();
		 this.processWords(words);
	}
	
	public int shortest(String word1, String word2) {
		if(wordMap == null || wordMap.isEmpty()) return 0;
        return wordMap.get(word1).get(word2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistanceII swd2 = new ShortestWordDistanceII(words);
		System.out.println(swd2.shortest("coding", "practice"));
		System.out.println(swd2.shortest("makes", "coding"));
	}

}
