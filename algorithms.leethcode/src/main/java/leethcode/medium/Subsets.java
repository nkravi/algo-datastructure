package leethcode.medium;
import java.util.ArrayList;
import java.util.List;

public class Subsets {

	private void DFS(int[] nums, int i, List<Integer> tmp, List<List<Integer>> res){
		if(isSolution(nums,tmp,res)){
			return;
		}else{
			List<List<Integer>> candidates = generateCandidates(nums,i,tmp);
			int k = 1;
			for(List<Integer> candidate: candidates){
				DFS(nums,i+k,candidate,res);
				k++;
			}
		}
	}
	
	private List<List<Integer>> generateCandidates(int[] nums, int i, List<Integer> tmp) {
		List<List<Integer>> candidates = new ArrayList<>();
		for(int k=i+1;k<nums.length;k++){
			List<Integer> nxt = new ArrayList<>(tmp);
			nxt.add(nums[k]);
			candidates.add(nxt);
		}
		
		
		return candidates;
	}

	private boolean isSolution(int[] nums,List<Integer> tmp, List<List<Integer>> res) {
		if(tmp.size() <= nums.length){
			res.add(tmp);
		}
		if(tmp.size() == nums.length) return true;
		return false;
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		DFS(nums,-1,new ArrayList<Integer>(),res);
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		List<List<Integer>> res = new Subsets().subsets(nums);
		System.out.println(res.size());
		for(List<Integer> lst: res){
			System.out.println();
			for(int i: lst){
				System.out.print(i+"\t");
			}
		}

	}

}
