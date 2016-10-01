package leethcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	
	private boolean check(String []aPattern,String []aStr){
		boolean ret = true;
		Map<String,String> map = new HashMap<>();
		for(int i=0;i< aPattern.length;i++){
			String val = map.get(aPattern[i]);
			if(val == null){
				map.put(aPattern[i], aStr[i]);
			}else if(!val.equals(aStr[i])){
				ret = false;
				break;
			}
			
		}
		return ret;
	}
	public boolean wordPattern(String pattern, String str) {
		
		if(pattern.length() ==0 || str.length() ==0) return false;
		
		String []a = pattern.split("");
		String []b = str.split(" ");
		
		if(a.length != b.length){
			return false;
		}
		
		
		return check(a,b)&&check(b,a);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "";
		String str = "beef";
		
		System.out.println(new WordPattern().wordPattern(pattern, str));
	}

}
