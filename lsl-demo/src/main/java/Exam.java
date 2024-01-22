
/*
 * 
 *  

                 30  

              /      \  

            10        50  

           /  \        /  \  

         3   16   	  40  60  

  

Output: 43 56 120 140 
 */

public class Exam {
	
	static class Node{
		int value;
		Node left, right;
		Node(int value,Node left,Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node l1 = new Node(3,null,null);
		Node l2 = new Node(16,null,null);
		Node l3 = new Node(40,null,null);
		Node l4 = new Node(60,null,null);
		

		Node m1 = new Node(10,l1,l2);
		Node m2 = new Node(50,l3,l4);
		

		Node root = new Node(30,m1,m2);
		
		solve(root,0);
		
		
	}
	
	static void solve(Node r,int sum) {
		if(r==null)
			return ;
		
		sum += r.value ;
		
		if(r.left == null && r.right==null) {
			System.out.print(sum+" ");
			return ;
		}

		if(r.left!=null) {
			solve(r.left,sum);
		}
		if(r.right!=null) {
			solve(r.right,sum);
		}
	}

}
