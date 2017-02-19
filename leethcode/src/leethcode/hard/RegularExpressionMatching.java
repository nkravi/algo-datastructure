package leethcode.hard;

public class RegularExpressionMatching {
	
	
	private void print(Integer[][] mem){
		System.out.println();
		for(int i=0;i< mem.length;i++){
			System.out.println();
			for(int j =0;j<mem[i].length;j++){
				System.out.print(mem[i][j]+"\t");
				
			}
		}
		
		
	}
	
	private boolean isMatch(char[] s, char[] p, int i, int j, Character c,Integer[][] mem){
		print(mem);
		if(i <0 && j < 0){
			return true;
		}else if( i < 0 || j < 0){
			//System.out.println(i+" "+j);
			return false;
		}else{
			if(mem[i][j] != null){
				return mem[i][j] == 0;
			}else{
				boolean res = false;
				if(s[i] == p[j] || p[j] == '.'){
					res=isMatch(s,p,i-1,j-1,c,mem);
				}else if(p[j] == '*'){
					c = (c==null)? p[j-1]: c;
					if(c== s[i] || c=='.'){//there is a match
						res = isMatch(s,p,i-1,j,c,mem) || isMatch(s,p,i-1,j-2,null,mem)|| isMatch(s,p,i,j-2,null,mem);
						//System.out.println(res);
					}else{
						res = isMatch(s,p,i,j-2,null,mem);
					}
				}else{
					res = false;
				}
				mem[i][j] = (res)?0:1;
				return mem[i][j] == 0;
			}	
		}
	}
	
	public boolean isMatch(String s, String p) {
		Integer[][] mem = new Integer[s.length()][p.length()];
		return isMatch(s.toCharArray(),p.toCharArray(),s.length()-1,p.length()-1,null,mem);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RegularExpressionMatching rgx = new RegularExpressionMatching();
		/*System.out.println(rgx.isMatch("aa", "a"));
		System.out.println(rgx.isMatch("aa", "aa"));
		System.out.println(rgx.isMatch("aaa", "aa"));
		System.out.println(rgx.isMatch("aa", "a*"));
		System.out.println(rgx.isMatch("aa", ".*"));
		System.out.println(rgx.isMatch("ab", ".*"));*/
		System.out.println(rgx.isMatch("aab", "c*a*b"));
		/*System.out.println(rgx.isMatch("ab", ".*c"));
		System.out.println(rgx.isMatch("aaa", ".a*a"));
		System.out.println(rgx.isMatch("a", "ab*"));*/

	}

}
