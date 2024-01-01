package com.example.dsaPack.datastructures.trie;

import java.util.List;

public class TrieExample {
	
	//Trie defination
	class Trie {
		
		class TrieNode {
			int nodeVistCount = 0;
	        TrieNode[] child;
	        TrieNode(){
	            child = new TrieNode[1];
	        }
		}
		
		TrieNode root ;
		
		Trie() {
			root = new TrieNode();	
		}
		
		boolean search() {
			return true;
		}
		
		void add() {
			
		}
	}
	
	
	
}


