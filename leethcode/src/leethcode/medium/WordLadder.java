package leethcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	private class Tuple{
		private int depth;
		private String word;
		Tuple(String word,int depth){
			this.depth = depth;
			this.word = word;
		}
	}
	
	private int depth = Integer.MAX_VALUE;
	
	boolean isDone(String word,int depth,String destination){
		System.out.println(word +" "+ depth);
		if(word.equals(destination)){
			this.depth = Math.min(depth,this.depth);
			return true;
		}
		
		return false;
	}
	
	List<String> getNeighbours(String word,Set<String> wordList,Set<String> visited){
		
		char[] wordArray = word.toCharArray();
		List<String> res = new ArrayList<>();
		for(int i=0;i< wordArray.length;i++){
			for(char j='a'; j<='z';j++){
				char tmp = wordArray[i];
				wordArray[i] = j;
				String s= new String(wordArray);
				if(!visited.contains(s) && wordList.contains(s)){
					res.add(s);
				}
				wordArray[i] = tmp;
			}
		}
		
		return res;
	}
	
	void BFS(String src,String destination,Set<String> wordList,Set<String> visited){
		Queue<Tuple>  q = new LinkedList<>();
		q.add(new Tuple(src,1));
		while(!q.isEmpty()){
			Tuple t = q.remove();
			visited.add(t.word);
			List<String> neighbours = getNeighbours(t.word,wordList,visited);
			for(String neighbour: neighbours){
				q.add(new Tuple(neighbour,t.depth+1));
				if(destination.equals(neighbour)){
					this.depth = t.depth+1;
					return;
				}
			}
			
		}
	}
	
	
	void DFS(String word,int depth,String src,String destination,Set<String> wordList,Set<String> visited){
		if(isDone(word,depth,destination)){
			return;
		}
		visited.add(word);
		List<String> candidates = getNeighbours(word,wordList,visited);
		for(String candidate: candidates){
			visited.add(candidate);
			DFS(candidate,depth+1,src,destination,wordList,visited);
			visited.remove(candidate);
		}
		visited.remove(word);
	}
	
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		
		Set<String> visited = new HashSet<>();
		wordList.add(endWord);
		//DFS(beginWord,1,beginWord,endWord,wordList,visited);
		BFS(beginWord,endWord,wordList,visited);
		return (depth == Integer.MAX_VALUE)? 0: depth;
    }
	public static void main(String[] args) {
		String beginWord ="hit";
		String endWord = "cog";
		String[] words = {"hot","dot","dog","lot","log"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(words));
		System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
	}

}
