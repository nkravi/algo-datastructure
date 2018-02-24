package leethcode.easy;


import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


 class Tuple implements Comparable{
	private int _0;
	private int _1;
	Tuple(int _0, int _1){
		this._0 = Math.min(_0, _1);
		this._1 = Math.max(_0, _1);
	}
	
	public boolean equals(Object obj){
		Tuple that = (Tuple)obj;
		return this._0 == that._0 && this._1 == that._1;
	}
	public String toString(){
		return this._0+""+this._1;
	}
	/* public int hashCode() {
	      return toString().hashCode();
	}*/

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
public class PaintFence {
	 static int numberOfPairs(int[] a, long k) {
	      Map<Long,Integer> map = new HashMap<Long,Integer>();
	      Set<Tuple> set = new TreeSet<>();
	      for(int num: a){
	    	  long remaining = k - num;
	    	  Integer count = map.get(remaining);
	    	  if(count != null && count != 0){
	    		  set.add(new Tuple(num,(int) remaining));
	    		  map.put(remaining, --count);
	    	  }else{
	    		  Integer count1 = (map.get(num)== null)? 0 : map.get(num);
	    		  map.put((long) num, ++count1);
	    	  }  
	      }
	      return set.size();  
	    }

    public static void main(String[] args) {
    	//System.out.println(PaintFence.isOpen(')'));
    	//System.out.println(PaintFence.isClose(')'));
    	//System.out.println(PaintFence.isMatch('(',')'));
    	int [] a = {1,2,3,56,1,2};
    	int k = 57;
    	System.out.println(PaintFence.numberOfPairs(a,k));
    	
	}
}
