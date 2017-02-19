package leethcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
	private Map<Integer,List<Integer>> getAdjList(int[][] prereq){
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<prereq.length;i++){
			int parent = prereq[i][1];
			int child = prereq[i][0];
			List<Integer> childrens= map.containsKey(parent)? map.get(parent): new ArrayList<Integer>();
			childrens.add(child);
			map.put(parent, childrens);
		}
		return map;
	}
	
	private boolean explore(Integer k,Map<Integer,List<Integer>> adjList, Set<Integer> visited){
		if(!adjList.containsKey(k)){ //sink
			visited.add(k);
			return true;
		}
		if(visited.contains(k)){
			return false;
		}else{
			boolean res = true;
			visited.add(k);
			for(Integer child: adjList.get(k)){
				res = res && explore(child,adjList,visited);
			}
			return res;
		}
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer,List<Integer>> adjList = getAdjList(prerequisites);
		Set<Integer> visited = new HashSet<Integer>();
		for(int key=0;key<numCourses;key++){
			if(visited.contains(key)) continue;
			Set<Integer> newVisited = new HashSet<Integer>();
			boolean noCycle = explore(key,adjList,newVisited);
			if(!noCycle){
				return false;
			}
			visited.addAll(newVisited);
		}
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule cs = new CourseSchedule();
		int[][] prerequisites = {
				{0,1},
				{0,2},
				{1,2}
		};
		System.out.println(cs.canFinish(3, prerequisites));

	}

}
