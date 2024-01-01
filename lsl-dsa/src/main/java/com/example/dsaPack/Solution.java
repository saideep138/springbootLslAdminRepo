package com.example.dsaPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public class TreeNode {
		    int val;
		      TreeNode left;
		      TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
		     this.val = val;
		     this.left = left;
		     this.right = right;
		 }
	}
		 
    static Map<Integer, List<TreeNode>> map = new HashMap();
    int k=0;
    
    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }
    
    static List<TreeNode> solve2(int n) {
    	//solve(n);
//    	k=2;
    	if(map.containsKey(n)) {
        return map.get(n);
    	}

    	return null;
    }
    
    public List<TreeNode> solve(int n) {
    	solve2(n);k=2;
        if(map.containsKey(n)) {
            return map.get(n);
        }

        List<TreeNode> ans = new ArrayList<TreeNode>(),left,right;

        if(n%2==0){
            //System.out.println("HI");
            map.put(n, ans);
            return ans;
        }
        if(n==0){
            map.put(n, ans);
            return ans;
        }
        if(n==1){
            ans.add(new TreeNode(0,null,null));
            map.put(n, ans);
            return ans;
        }

         for(int j=1 ; j<n ; j+=2){
            left  = solve(j);
            right = solve(n-j-1);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    ans.add(new TreeNode(0,l,r));
                }
            }
         }

         map.put(n, ans);

        return ans;

    }
}