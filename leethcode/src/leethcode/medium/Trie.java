package leethcode.medium;

import java.util.HashMap;
 import java.util.Map;

public class Trie {

	class Node{
		char val;
		Map<Character,Node> childrens;
		Node(char val){
			this.val = val;
			childrens = new HashMap<>();
		}
	}
	
	private Node root;
	
	public Trie(){
		root = new Node('#');
	}
	
	private void insert(Node node,char[] word,int i){
		if(i>=word.length){
			node.childrens.put('$', null);
			return;
		}
		if(!node.childrens.containsKey(word[i])){
			Node newNode = new Node(word[i]);
			node.childrens.put(word[i], newNode);	
		}
		insert(node.childrens.get(word[i]),word,i+1);
	}
	public void insert(String word) {
		char[] cWord = word.toCharArray();
		insert(root,cWord,0);
	}
	
	private Node search(Node node,char[] word,int i){
		if(node == null || i >= word.length){
			return node;
		}else{
			if(node.childrens.containsKey(word[i])){
				return search(node.childrens.get(word[i]),word,i+1);
			}else{
				return search(null,word,i+1);
			}
		}
	}
	
	public boolean search(String word) {
		Node node = search(root,word.toCharArray(),0);
		if(node != null && node.childrens.containsKey('$')){
			return true;
		}else{
			return false;
		}
	}
	public boolean startsWith(String prefix) {
		Node node = search(root,prefix.toCharArray(),0);
		if(node != null){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie= new Trie();
		trie.insert("cat");
		trie.insert("dog");
		trie.insert("caba");
		System.out.println(trie.search("cat"));
		System.out.println(trie.search("god"));
		System.out.println(trie.search("ca"));
		System.out.println(trie.startsWith("ca"));

	}

}
