package leethcode.easy;

public class ShortestWordDistance {

	public int shortestDistance(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int d1 = -1;
		int d2 = -1;
		for(int i=0;i<words.length;i++){
			if(words[i].equals(word1)){
				d1 = i;
			}
			if(words[i].equals(word2)){
				d2 = i;
			}
			if(d1 != -1 && d2 != -1){
				min = Math.min(min,Math.abs(d1-d2));
			}
		}
		
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestWordDistance swd = new ShortestWordDistance();
		String[] words = {"coding","practice"};
		String word1 = "coding";
		String word2 = "practice";
		System.out.println(swd.shortestDistance(words, word1, word2));
	}

}
