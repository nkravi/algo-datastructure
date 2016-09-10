package leethcode.easy;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Show Tags

 */
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int minGas = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i =0; i < cost.length ;i++){
			int fGas = gas[i] - cost[i];
			if(fGas < minGas ){
				minGas = fGas;
				minIndex = i;
			}
		}
		int start = minIndex;
		int currentGas = 0;
		
		for(int i =0;i<= cost.length;i++){
			if(minIndex > cost.length-1){
				minIndex = minIndex - cost.length;
			}
			if(gas[minIndex] - cost[minIndex] >= 0){
				currentGas =  currentGas + (gas[minIndex] - cost[minIndex]);
				minIndex++;
			}else{
				break;
			}
		}
		
		System.out.println(minIndex +" "+ start);
		if(start == minIndex)
			return minIndex;
		
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {1,1,1,1};
		int[] cost = {1,1,1,1}; 
		
		System.out.println(new GasStation().canCompleteCircuit(gas, cost) );

	}

}
