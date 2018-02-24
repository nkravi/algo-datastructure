package leethcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleII {
	
	private boolean containsCycle;

	private void createNeighbourMatrix(Map<Integer,List<Integer>> neighbour,int[][] prerequisites){
		for(int i=0;i<prerequisites.length;i++){
			int key = prerequisites[i][1];
			int val = prerequisites[i][0];
			List<Integer> values = neighbour.get(key);
			if(values == null)
				values = new ArrayList<Integer>();
			values.add(val);
			neighbour.put(key, values);
		}
	}
	
	
	private void topUtil(int start,int v,Map<Integer,List<Integer>> neighbour,Set<Integer> visited,Stack<Integer> st){
		visited.add(v);
		List<Integer> neighbours = neighbour.get(v);
		if(neighbours == null) neighbours = new ArrayList<Integer>();
		for(int u : neighbours ){
			if(start == u)
				containsCycle = true;
			if(visited.contains(u))
				continue;
			topUtil(start,u,neighbour,visited,st);
		}
		st.push(v);
	}
	
	
	
	private int[] topSort(Map<Integer,List<Integer>> neighbour,int numCourses){
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		int [] res = new int[0];
		
		for(int v=0;v<numCourses;v++){
			if(containsCycle == true)
				return res;
			if(!visited.contains(v))
				topUtil(v,v,neighbour,visited, st);
		}
		
		
		if(st.size() != numCourses)
			return res;
		
		res = new int[numCourses];
		
		for(int i=0; !st.isEmpty();i++){
			res[i] = st.pop();
		}
		
		return res;
	}
	
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer,List<Integer>> neighbour = new HashMap<Integer,List<Integer>>();
		createNeighbourMatrix(neighbour,prerequisites);
		if(neighbour.isEmpty()){
			// you can take in any order
			int [] res = new int[numCourses];
			for(int i=0;i<res.length;i++)
				res[i] = i;
			return res;
		}
		
		return topSort(neighbour,numCourses);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseScheduleII cs = new CourseScheduleII();
		int numCourses = 4;
		int [][] prerequisites= 
			{{1,0},{2,0},{3,1},{3,2}};
			//{{1,0}};
		    //{{0,1},{1,0}};
		int res [] = cs.findOrder(numCourses, prerequisites);
		
		if(res.length == 0)
			System.out.println("Empty array");
		for(int i:res){
			System.out.print(i+"  ");
		}

	}

}
