package leethcode.easy;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] res = new int[m+n];
		int i=0;
		int j=0;
		int k = 0;
		while(i<m && j<n){
			if(nums1[i] < nums2[j]){
				res[k] = nums1[i];
				i++;
			}else{
				res[k] = nums2[j];
				j++;
			}
			k++;
		}
		
		while(i<m){
			res[k] = nums1[i];
			k++;i++;
		}
		while(j<n){
			res[k] = nums2[j];
			k++;j++;
		}
		for(i=0;i<res.length;i++){
			nums1[i] = res[i];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2,4,6,0,0,0};
		int[] nums2 = {1,3,7};
		int m= 3;
		int n= 3;
		new MergeSortedArray().merge(nums1, m, nums2, n);
		
		for(int i:nums1){
			System.out.print(i+"\t");
		}
	}

}
