package leethcode.hard;

public class RegularExpressionMatching {
	
	private  boolean isMatch(char[] s, char[] p, int sPtr, int pPtr, Boolean mem[][]){
		
		if(sPtr < 0 && pPtr <0){
			return true;
		}else if(pPtr < 0 || sPtr <0){
			return false;
		}else{
			if(mem[sPtr][pPtr] != null){
				return mem[sPtr][pPtr];
			}
			boolean match = false;
			boolean zeroMatch = false;
			boolean oneOrMoreMatch = false;
			if(s[sPtr] == p[pPtr] || p[pPtr] == '.'){
				match = isMatch(s,p,sPtr-1,pPtr-1);
			}else if(p[pPtr] == '*'){
				//0-Match
				zeroMatch = isMatch(s,p,sPtr,pPtr-2);
				//1 or more match match
				if(s[sPtr] == p[pPtr-1] || p[pPtr-1] == '.'){
					oneOrMoreMatch = isMatch(s,p,sPtr-1,pPtr) || isMatch(s,p,sPtr-1,pPtr-2);
				}
			}
			mem[sPtr][pPtr] =  false || match || zeroMatch || oneOrMoreMatch;
			return mem[sPtr][pPtr];
		}
		
		
	}
	
	private boolean isMatch(char[] s, char[] p, int sPtr, int pPtr){
		if(sPtr < 0 && pPtr <0){
			return true;
		}else if(pPtr < 0 || sPtr <0){
			return false;
		}else{
			//System.out.println(sPtr +" "+pPtr);
			boolean match = false;
			boolean zeroMatch = false;
			boolean oneOrMoreMatch = false;
			if(s[sPtr] == p[pPtr] || p[pPtr] == '.'){
				match = isMatch(s,p,sPtr-1,pPtr-1);
			}else if(p[pPtr] == '*'){
				//0-Match
				zeroMatch = isMatch(s,p,sPtr,pPtr-2);
				//1 or more match match
				if(s[sPtr] == p[pPtr-1] || p[pPtr-1] == '.'){
					oneOrMoreMatch = isMatch(s,p,sPtr-1,pPtr) || isMatch(s,p,sPtr-1,pPtr-2);
				}
			}
			return false || match || zeroMatch || oneOrMoreMatch;
			
		}
	}
	
	
	public boolean isMatch(String s, String p) {
		Boolean[][] mem = new Boolean[s.length()][p.length()];
		//append x to handle empty case
		s= "x"+s;
		p= "x"+p;
		return isMatch(s.toCharArray(), p.toCharArray(), s.length()-1,p.length()-1,mem);
		//return true;
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
		
		//System.out.println(rgx.isMatch("aaa", "aaaa"));
	}

}
