package leethcode.hard;

public class MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int high1 = nums1.length -1;
		int low1 = 0;
		
		int high2 = nums2.length -1;
		int low2 = 0;
		boolean noMove = false;
		int mid1 = -1;
		int mid2 = -1;
		while(low1 <= high1 && low2 <= high2){
			mid1 = low1 + (high1-low1) /2;
			mid2 = low2 + (high2-low2) /2;
			System.out.println(mid1 +"\t"+mid2);
			if(nums1[mid1] == nums2[mid2]){
				break;
			}else if(nums1[mid1] > nums2[mid2]){ //mid1 should move left and mid2 should move right
				if(mid1 >0 && nums1[mid1-1] < nums2[mid2]){
					noMove = true;
				}else{
					noMove = false; //move mid1 left
					high1 = mid1 - 1;
				}
				if(mid2 < nums2.length-1 && nums2[mid2+1] > nums1[mid1]){
					noMove = true;
				}else{
					noMove = false; //move mid2 right
					low2 = mid2 + 1;
				}
			}else{ // mid1 right and mid2 left
				if(mid1 < nums1.length-1 && nums1[mid1+1] > nums2[mid2]){
					noMove = true;
				}else{
					noMove = false; //move mid1 right
					low1 = mid1 + 1;
				}
				if(mid2 >0 && nums2[mid2-1] < nums1[mid1]){
					noMove = true;
				}else{
					noMove = false; //move mid2 left
					high2 = mid2 - 1;
				}
			}
			if(noMove) break;
		}
		
		System.out.println(mid1+" "+mid2);
		
		
		return 0.0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums1 = {1,2,3,45};
		int []nums2 = {30,50,60};
		System.out.println(
				new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2));

	}

}
