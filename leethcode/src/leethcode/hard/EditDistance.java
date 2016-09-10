package leethcode.hard;

public class EditDistance {

	
	private int min3(int a,int b, int c){
		int t = (a<b) ? a: b;
		return (t<c) ? t: c;
	}
	
	public int minDistance(String word1, String word2) {
		//add an extra column & row
		word1 = "X" + word1;
		word2 = "X" + word2;
		
		//convert to char
		char[] cWord1 = word1.toCharArray();
		char[] cWord2 = word2.toCharArray();
		
		int [][] dist = new int[cWord1.length][cWord2.length];
		
		//fill first col & row
		
		for(int i= 0; i < cWord1.length;i++)
			dist[i][0] = i;
		
		for(int i= 0; i < cWord2.length;i++)
			dist[0][i] = i;
		
		
		for(int i= 1;i< cWord1.length ; i++){
			for(int j=1; j<cWord2.length;j++){
				int x = dist[i-1][j];
				int y = dist[i][j-1];
				int d = dist[i-1][j-1];
				if(cWord1[i] == cWord2[j]){
					dist[i][j] = d;
				}else{
					dist[i][j] = min3(x,y,d)+1;
				}
			}
		}
		return dist[cWord1.length-1][cWord2.length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance("abcd", "xyz"));

	}

}
