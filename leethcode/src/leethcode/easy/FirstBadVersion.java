package leethcode.easy;

public class FirstBadVersion {
	int [] versions;
	int firstBadVersion;
	
	void cerateVersion(int n, int startBadVersion){
		startBadVersion = startBadVersion - 1 ; //o index;
		versions = new int[n];
		for(int i= 0; i <n ;i++){
			if(i < startBadVersion){
				versions[i] = 1;
			}else{
				versions[i] = -1;
			}
		}
	}
	
	boolean isBadVersion(int version){
		return versions[--version] == -1;
	}
	
	void bst(int start,int end){
		int index = (start+end)/2;
		boolean bindex = isBadVersion(index);
		boolean bnxt = isBadVersion(index+1);
		if(bindex == false && bnxt == true){
			firstBadVersion = index+1;
			return;
		}
		if(bindex == false && bnxt == false){
			bst(index+1,end);
		}else{
			bst(start,index-1);
		}	
	}
	
	
	public int firstBadVersion(int n) {
		bst(1,n);
		return firstBadVersion;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstBadVersion fbs = new FirstBadVersion();
		int n = 8;
		int bv = 3;
		fbs.cerateVersion(n, bv);
		System.out.println(fbs.firstBadVersion(n));
		
		
	}

}
