package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeOperations {
	{
		int count=0;
		System.out.println("in the static block"+count);
	}
	static int count=1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(10);
		root.left=new Node(22);
		root.right=new Node(30);
		root.left.left=new Node(11);
		root.left.right=new Node(12);
		root.right.left=new Node(1);
		root.right.right=new Node(42);
		int height=height(root);
		System.out.println("The height of the tree is : "+height);
		System.out.println("the sum of all noes : "+sumOfAllNodes(root));
		System.out.println("Diagonal sum :: ");
		printDiagonalSum(root);
		System.out.println("printing all possible paths");
		Stack<Node>tracker=new Stack<Node>();
		printAllPaths(root, tracker);
		System.out.println("printing paths with sum equal to 43");
		Stack<Node>tracker2=new Stack<Node>();
		printPathWithSum(root, tracker2, 0, 43);
		System.out.println("now printing the LCM");
		leastCommonAncestor(root, 1, 11);
		System.out.println("printing the Bottom view");
		bottomView(root);
		System.out.println("printing the zig zag view of a tree");
		spiralView(root);
		System.out.println("count value before the execution  "+count);
		numberOfLeafNodes(root);
		System.out.println("number of leaves :: "+count);
		Node root2=new Node(56);
		root2.left=new Node(5);
		root2.right=new Node(5);
		int output=isIdenticalTrees(root, root2);
		System.out.println("both the trees are : "+output);
		int output2=subTree(root, root2);
		System.out.println("root2 is a subtree of root1 or not  : "+output2);
		System.out.println("deleting 3 in the tree");
		inOrder(root2);
		deleteNode(root2, 3);
		System.out.println();
		inOrder(root2);
		System.out.println("the diagonal sums: ");
		diagonalSum(root2);
		System.out.println("IS THE TREE SUM TREE OR NOT  : "+isSumTree(root2));
		System.out.println("printing all the paths ::");
		printAllPaths(root2,61);
		System.out.println("PRINTING THE LEAST ANCESTOR OF 5");
		Node found=lowestCommonAncestor(root2, new Node(5),new Node(6));
		if(found==null){
			System.out.println("the ancesytor is not found");
		}else{
			System.out.println("the ancestor is : "+found.data);
		}
		
	}
	public static int sumOfAllNodes(Node root){
		if(root==null){
			return 0;
		}
		int data=root.data+sumOfAllNodes(root.left)+sumOfAllNodes(root.right);
		return data;
	}
	
	public static int height(Node root){
		if(root==null){
			return 0;
		}
		int lh=height(root.left);
		int rh=height(root.right);
		if(lh>rh){
			return 1+lh;
		}else{
			return 1+rh;
		}
	}
	public static void printDiagonalSum(Node root){
		Queue<Node>tracker=new LinkedList<Node>();
		tracker.add(root);
		tracker.add(null);
		while(!tracker.isEmpty()){
			Node p=tracker.poll();
			if(p==null){
				p=tracker.poll();
				if(p==null){
					break;
				}
			}
			int sum=0;
			while(p!=null){
				sum=sum+p.data;
				if(p.left !=null){
					tracker.add(p.left);
				}
				p=p.right;
			}
			System.out.println("sum : "+sum);
		}
		
	}
	public static void printAllPaths(Node root,Stack<Node>tracker){
		
		if(root==null){
			return;
		}
		tracker.push(root);
		printAllPaths(root.left,tracker);
		if(root.left==null && root.right==null){
			for(int i=0;i<tracker.size();i++){
				System.out.print(tracker.elementAt(i).data+"  ");
			}
		}
		printAllPaths(root.right, tracker);
		System.out.println();
		tracker.pop();
	}
	
	public static void printPathWithSum(Node root,Stack<Node>tracker,int sum,int total){
		if(root==null){
			return;
		}
		sum=sum+root.data;
		tracker.push(root);
		if(sum==total){
			for(int i=0;i<tracker.size();i++){
				System.out.print(tracker.elementAt(i).data+ "  ");
			}
		}
		printPathWithSum(root.left, tracker, sum, total);
		printPathWithSum(root.right, tracker, sum, total);
		sum=sum-tracker.pop().data;
		
	}
	
	public static boolean leastCommonAncestor(Node root,int data1,int data2){
		
		if(root==null){
			return false;
		}
		if(root.data==data1|| root.data==data2){
			return true;
		}
		boolean left=leastCommonAncestor(root.left, data1, data2);
		boolean right=leastCommonAncestor(root.right, data1, data2);
		if(left && right){
			System.out.println("this is the LCM  "+root.data);
			return true;
		}else{
			if(left){
				return left;
			}else{
				return right;
			}
		}
	}
	
	public static void bottomView(Node root){
		if(root==null){
			return;
		}
		bottomView(root.left);
		if(root.left==null && root.right==null){
			System.out.print(root.data+" ");
		}
		bottomView(root.right);
		
	}
	
	public static void spiralView(Node root){
		
		Stack<Node>s1=new Stack<Node>();
		Stack<Node>s2=new Stack<Node>();
		s1.push(root);
		while(s1.size()>0||s2.size()>0){
			while(!s1.isEmpty()){
				Node temp=s1.pop();
				System.out.print(temp.data+"  ");
				if(temp!=null){
					if(temp.left!=null)
					s2.push(temp.left);
					if(temp.right!=null)
					s2.push(temp.right);
				}
			}
			while(!s2.empty()){
				Node temp=s2.pop();
				System.out.print(temp.data+"  ");
				if(temp!=null){
					if(temp.right!=null)
					s1.push(temp.right);
					if(temp.left!=null)
					s1.push(temp.left);
				}
			}
		}
			
		
	}
	
	public static void numberOfLeafNodes(Node root){
		if(root !=null){
			if(root.left==null && root.right==null){
				count=count+1;
			}
			numberOfLeafNodes(root.left);
			numberOfLeafNodes(root.right);
			
		}
		
	}
	
	public static int isIdenticalTrees(Node root1,Node root2){
		if(root1==null || root2==null){
			return 1;
		}
		if(root1.data==root2.data && isIdenticalTrees(root1.left, root2.left)==1&&isIdenticalTrees(root1.right, root2.right)==1){
			return 1;
		}
		return 0;
	}
	public static void inOrder(Node root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+"  ");
		inOrder(root.right);
	}
	public static int subTree(Node parent,Node child){
		if(child==null){
			return 1;
		}
		if(parent==null){
			return 0;
		}
		if(isIdenticalTrees(parent, child)==1){
			return 1;
		}
		int check1=subTree(parent.left, child);
		int check2=subTree(parent.right, child);
		if(check1==1 || check2==1){
			return 1;
		}else{return 0;
		}
		//return((subTree(parent.left, child)==1)||(subTree(parent.right, child)==1));
	}
	public static Node deleteNode(Node root,int data){
		
		if(root==null){
			return null;
		}
		System.out.println("im at : "+root.data);
		if(data<root.data){
			root.left=deleteNode(root.left, data);
		}
		else if(data>root.data){
			root.right=deleteNode(root.right, data);
		}
		else{
			if(root.left==null){
				System.out.println("got it---------------------------------");
				return root.right;
			}
			else if(root.right==null){
				System.out.println("found-------------------------");
				return root.left;
			}
			else{
				root.data=minRightNode(root.right).data;
				root.right=deleteNode(root.right, root.data);
				
			}
		}
		return root;
	}
	public static Node minRightNode(Node root){
		Node min=root;
		while(root.left!=null){
			root=root.right;
		}
		return root;
	}
	public static void diagonalSum(Node root){
		
		Stack<Node>stack=new Stack<Node>();
		
		stack.push(root);
		System.out.println(stack.pop().data);
		stack.push(root);
		stack.push(null);
		while(!stack.isEmpty()){
			Node p=stack.pop();
			
				System.out.println(p);
			
			if(p==null){
				System.out.println(p);
				stack.push(null);
				p=stack.pop();
				System.out.println(p);
				if(p==null){
					break;
				}
			}
			int sum=0;
			while(p!=null){
				sum=sum+p.data;
				if(p.left!=null){
					stack.push(p.left);
					
				}
				p=p.right;
			}
			System.out.println("sum : "+sum);
		}
		
	}
	
	public static int sum(Node root){
		
		if(root==null){
			return 0;
		}
		return root.data+sum(root.left)+sum(root.right);
	}
	public static boolean isSumTree(Node root){
		
		if(root==null){
			return true;
		}
		
		if(root.left==null && root.right==null){
			return true;
		}
		int leftSum=sum(root.left);
		int rightSum=sum(root.right);
		if(root.data==(leftSum+rightSum)){
			if(isSumTree(root.left)&&isSumTree(root.right)){
				return true;
			}
		}
		return false;
	}
	public static void printAllPaths(Node root,int sum){
		Stack<Node>stack=new Stack<Node>();
		printAllPathsEncapsule(root,stack);
		printAllPathsWithSum(root, stack, sum);
	}
	
	public static void printAllPathsEncapsule(Node root,Stack<Node>stack){
		if(root==null){
			return;
		}
		stack.push(root);
		printAllPathsEncapsule(root.left, stack);
		if((root.left==null)&&(root.right==null)){
			for(int i=0;i<stack.size();i++){
				System.out.print(stack.elementAt(i).data+"  ");
			}
		}
		System.out.println();
		printAllPathsEncapsule(root.right, stack);
		stack.pop();
	}
	public static void printAllPathsWithSum(Node root,Stack<Node>stack,int sum){
		if(root==null){
			return;
		}
		stack.push(root);
		printAllPathsWithSum(root.left,stack,sum);
		if(root.left==null && root.right==null){
			int total=0;
			for(int i=0;i<stack.size();i++){
				total=total+stack.elementAt(i).data;
			}
			if(total==sum){
				for(int i=0;i<stack.size();i++){
					System.out.print(stack.elementAt(i).data+"  ");
				}
				System.out.println();
			}
		}
		printAllPathsWithSum(root.right, stack, sum);
		stack.pop();
	}
	public static Node lowestCommonAncestor(Node root,Node node1,Node node2){
		if(root==null){
			return null;
		}
		if(root.data==node1.data || root.data==node2.data){
			return root;
		}
		if(lowestCommonAncestor(root.left, node1, node2)!=null && lowestCommonAncestor(root.right, node1, node2)!=null){
			return root;
		}
		return null;
		
	}
	public static boolean isSubtree(Node root,Node sub){
		return true;
	}
}
