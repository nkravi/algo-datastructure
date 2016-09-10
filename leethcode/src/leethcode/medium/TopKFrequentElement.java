package leethcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElement {
	class Element{
		private int key;
		private int frequency;
		Element(int key, int frequency){
			this.key = key;
			this.frequency = frequency;
		}
	}
	class ElementComparator implements Comparator<Element>{

		@Override
		public int compare(Element arg0, Element arg1) {
			if(arg0.frequency > arg1.frequency){
				return -1;
			}else{
				return 1;
			}
			
		}
		
	}
	private void buildPriorityQueue(Map<Integer,Integer> frequency,Queue<Element> topElements){
		for(Integer key: frequency.keySet()){
			topElements.add(new Element(key,frequency.get(key)));
		}
	}
	private void CountFrequency(int[] nums,Map<Integer,Integer> frequency){
		for(int key: nums){
			Integer val = frequency.get(key);
			if(val == null)
				val = 0;
			frequency.put(key, ++val);
			
		}
	}
	private List<Integer> getTopKElements(int k,Queue<Element> topElements){
		List<Integer> topK = new ArrayList<Integer>(k);
		for(int i=0;i<k;i++){
			Element e = topElements.remove();
			topK.add(e.key);
		}
		return topK;
	}
	 public List<Integer> topKFrequent(int[] nums, int k) { 
		 Map<Integer,Integer> frequency = new HashMap<Integer,Integer>();
		 ElementComparator comparator = new ElementComparator();
		 CountFrequency(nums,frequency);
		 Queue<Element> topElements = new PriorityQueue<Element>(frequency.size(),comparator);
		 buildPriorityQueue(frequency,topElements); 
		 return getTopKElements(k,topElements);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentElement tk = new TopKFrequentElement();
		int k = 4;
		int[] nums = {1,2,3,4};
		List<Integer> res =tk.topKFrequent(nums,k);
		for(Integer i: res){
			System.out.print(i+"\t");
		}
	}

}
