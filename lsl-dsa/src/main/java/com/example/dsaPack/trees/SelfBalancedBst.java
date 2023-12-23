package com.example.dsaPack.trees;

import java.util.Comparator;

public class SelfBalancedBst<K> {
	
	class Node{
		
		int height;
		
		K key;
		Node left, right;
		public Node(K key, Node left, Node right) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
	}
	
	Node root;

	Comparator<K> comparator;
	
	public SelfBalancedBst(Comparator<K> comparator, K key) {
		root = new Node(key, null, null,null);
		this.comparator = comparator;
	}
	
	
	public void delete(K key) {
		root = delete(root,key);
		//
	}
	
	private Node delete(Node root, K key) {
		
		if(root==null) return null;
		int diff = comparator.compare(root.key,key);
		
		if(diff == 0) {
			Node croot = root;
			Node leftMostNode = croot.right;
			
			if(leftMostNode == null) {
				return root.left;
			}
			else if(leftMostNode.left == null) {
				return leftMostNode.right;
			}
			
			
			while(leftMostNode.left!=null) {
				leftMostNode.height = 1 + Math.max(getHeight(leftMostNode.left)-1, getHeight(leftMostNode.right));
				leftMostNode = leftMostNode.left;
			}
			
			
			leftMostNode.left = croot.left;
			leftMostNode.right = croot.right;
			leftMostNode.height = 1 + Math.max(getHeight(leftMostNode.left), getHeight(leftMostNode.right));
			
			//rotation
			leftMostNode = rotate(leftMostNode);
			
			return leftMostNode;
		}
		else if (diff < 0) {
			root.left = delete(root.left,key);
		}
		else {
			root.right = delete(root.right,key);
		}
		
		root.height = 1 + getMaxHeight(root.left, root.right);
		
		return root;
	}
	
	
	
	
	
	Node rotate(Node root){
		
		int k1 = getHeight(root.left), k2=getHeight(root.right);
		int k = k2-k1;
		if(k<2) return root;
		
		if(k1>k2) {
			
		}
		else {
			
		}
		return root;
	}
	
	public boolean insert(K key) {
		
		
		
		return false;
	}
	
	
	
	Node createNode(K key, Node left, Node right){
		return new Node(key, left, right);
	}
	
	int getMaxHeight(Node a, Node b) {
		int k1,k2;
		k1 = a == null ? -1 : a.height;
			
		k2 = b == null ? -1 : b.height;
		
		return Math.max(k1, k2);
	}
	
	int getHeight(Node a) {
		int k1;
		k1 = a == null ? -1 : a.height;
		return k1;
	}
}
