package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.zip.Adler32;

public class GraphOpertions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V=6;
		Graph graph=createGrph(V);
		addEdge(graph, 0, 4,12);
		addEdge(graph, 4, 0,12);
		addEdge(graph, 4, 5,1);
		addEdge(graph, 1, 2,2);
		addEdge(graph, 1, 3,4);
		//addEdge(graph,1, 4);
		addEdge(graph, 2, 3,5);
		addEdge(graph,5,3,12);
		//addEdge(graph,3, 4);
		printGraph(graph);
		System.out.println("printing the binary search of the graph");
		breadFirstSearch(graph, 0);
		System.out.println();
		System.out.println("printing the depth first search of the graph");
		depthFirstSearch(graph);
		System.out.println();
		System.out.println("printing the topological sort of the graph");
		topologicalSort(graph);
		System.out.println();
		System.out.println("printing the mother vertex of the graph");
		motherVertexGraph(graph);
		System.out.println();
		System.out.println("printing the transitive closure of the graph");
		transitiveClosure(graph);
		System.out.println();
		System.out.println("printing the graphs with K CORES");
		printKCores(graph, 2);
		System.out.println();
		System.out.println("detecting if a loop is present inthe graph");
		System.out.println("LOOP PRESENT  : "+detectCycle(graph));
	}
	
	public static Graph createGrph(int V){
		Graph graph=new Graph(V);
		return graph;
	}
	
	public static void addEdge(Graph graph,int src,int dest,int weight){
		
		AdjListNode newNode =new AdjListNode(dest,weight);
		
		//adding adj vertices(list) of source to the new node
		System.out.println(graph.adjNodeList[dest].head);
		newNode.next=graph.adjNodeList[src].head;
		//setting the newNod as the adjecent node
		graph.adjNodeList[src].head=newNode;
		
		/// this is incase of non directed graphs
	/*	
		AdjListNode newNode2=new AdjListNode(src,weight);
		
		//adding adj list of the other one to src
		
		newNode2.next=graph.adjNodeList[dest].head;
		
		//settin this new node as the adjecent node
		
		graph.adjNodeList[dest].head=newNode2;
		*/
		
	}
	public static void printGraph(Graph graph){
		int v;
		for(int i=0;i<graph.V;i++){
			AdjListNode head=graph.adjNodeList[i].head;
			System.out.print(i +" --> ");
			while(head !=null){
				System.out.print(head.dest+"  ");
				head=head.next;
			}
			System.out.println();
		}
	}
	
	public static void breadFirstSearch(Graph graph,int s){
		
		Queue<Integer> nodeQueue =new LinkedList<Integer>();
		boolean visited[]=new boolean[graph.V];
		nodeQueue.add(s);
		visited[s]=true;
		while(!nodeQueue.isEmpty()){
			int node=nodeQueue.poll();
			System.out.print(node+"  ");
			AdjListNode head=graph.adjNodeList[node].head;
			while(head !=null){
				if(visited[head.dest]!=true){
					nodeQueue.add(head.dest);
					visited[head.dest]=true;
				}
				head=head.next;
			}
		}
	}
	
	public static void depthFirstSearch(Graph graph){
		boolean visited[]=new boolean[graph.V];
		for(int i=0;i<graph.V;i++){
			if(visited[i]!=true){
				depthFirstSearchUtil(graph, i, visited);
			}
		}
		
	}
	
	public static void depthFirstSearchUtil(Graph graph,int s,boolean[] visited){
		
			System.out.print(s+"  ");
			visited[s]=true;
		
		
		AdjListNode head=graph.adjNodeList[s].head;
		while(head!=null){
			if(visited[head.dest]!=true)
				depthFirstSearchUtil(graph, head.dest, visited);
			head=head.next;
		}
		
	}
	public static void topologicalSortUtil(Graph graph,int v,boolean visited[],Stack<Integer>nodes){
		visited[v]=true;
		AdjListNode head=graph.adjNodeList[v].head;
		while(head!=null){
			if(visited[head.dest]!=true){
				topologicalSortUtil(graph, head.dest, visited, nodes);
			}
			head=head.next;
		}
		nodes.push(v);
	}
	public static void topologicalSort(Graph graph){
		Stack<Integer>nodes=new Stack<Integer>();
		boolean visited[]=new boolean[graph.V];
		for(int i=0;i<graph.V;i++){
			if(visited[i]!=true){
				topologicalSortUtil(graph, i, visited, nodes);
			}
		}
		
		while(!nodes.isEmpty()){
			System.out.print(nodes.pop()+"  ");
		}
	}
	public static void longestPath(Graph graph,int source){
		boolean visited[]=new boolean[graph.V];
		//get the topological sort of the graph
		Stack<Integer>nodes =new Stack<Integer>();
		//for(int i=0;i<graph.V;i++){
		//	if(visited[i]!=true){
				topologicalSortUtil(graph, source, visited, nodes);
			//}
		//}
		
		/// create a distances array and intialise them to infinity(min)
		Integer distances[]=new Integer[graph.V];
		for(int i=0;i<distances.length;i++){
			distances[i]=-1;
		}
		distances[source]=0;
		while(!nodes.isEmpty()){
			int current=nodes.pop();
			AdjListNode head=graph.adjNodeList[current].head;
			while(head!=null){
				int weight=distances[head.dest]+head.weight;
				
			}
		}
	}
	public static void motherVertexGraph(Graph graph){
		boolean visited[]=new boolean[graph.V];
		int v=-1;
		for(int i=0;i<graph.V;i++){
			if(visited[i]!=true){
				depthFirstSearchUtil(graph, i, visited);
				v=i;
			}
			
		}
		boolean motherVertTest[]=new boolean[graph.V];
		System.out.println("");
		depthFirstSearchUtil(graph, v,motherVertTest);
		int found=0;
		for(int i=0;i<motherVertTest.length;i++){
			if(motherVertTest[i]==false){
				found=1;
				
				break;
			}
		}
		if(found==1){
			System.out.println("there is no mother vertex in this graph");
		}else{
		System.out.println("the mother verted is : "+v);
		}
	}
	public static void DFSUtilTransitiveClosure(Graph graph,int s,boolean[]visited,int[][]TC){
		AdjListNode head=graph.adjNodeList[s].head;
		while(head!=null){
			if(TC[s][head.dest]==0){
				TC[s][head.dest]=1;
				visited[head.dest]=true;
				DFSUtilTransitiveClosure(graph, head.dest, visited, TC);
			}
			head=head.next;
		}
	}
	public static void transitiveClosure(Graph graph){
		int TC[][]=new int[graph.V][graph.V];
		boolean visited[]=new boolean[graph.V];
		for(int i=0;i<graph.V;i++){
			if(visited[i]!=true){
				DFSUtilTransitiveClosure(graph, i, visited, TC);
			}
		}
		for(int i=0;i<graph.V;i++){
			for(int j=0;j<graph.V;j++){
				System.out.print(TC[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static boolean DFSUtilPrintCores(Graph graph,int s,boolean visited[],int degree[],int k){
		visited[s]=true;
		AdjListNode head=graph.adjNodeList[s].head;
		while(head !=null){
			if(degree[head.dest]<k){
				degree[s]=degree[s]-1;
		
			}
			if(visited[head.dest]!=true){
				if(DFSUtilPrintCores(graph, head.dest, visited, degree, k)){
					degree[s]=degree[s]-1;
				}
			}
			head=head.next;
		}
		return degree[s]<k;
	}
	public static void getDegree(Graph g,int[]degree){
		for(int i=0;i<g.V;i++){
			AdjListNode head=g.adjNodeList[i].head;
			int deg=0;
			while(head!=null){
				deg=deg+1;
				head=head.next;
			}
			degree[i]=deg;
		}
	}
	public static void printKCores(Graph graph,int cores){
		int[]degree=new int[graph.V];
		getDegree(graph, degree); 
		boolean visited[]=new boolean[graph.V];
		for(int i=0;i<visited.length;i++){
			if(visited[i]!=true){
				DFSUtilPrintCores(graph, i, visited, degree,cores );
			}
		}
		for(int i=0;i<degree.length;i++){
			if(degree[i]>=cores){
				AdjListNode head=graph.adjNodeList[i].head;
				System.out.print("[ "+i+" ] : ");
				while(head!=null){
					if(degree[head.dest]>=cores){
						System.out.print(" -> "+head.dest);
					}
					head=head.next;
				}
			}
			System.out.println();
			///System.out.println(i+"  --> "+degree[i]);
		}
		
	}
	public static boolean DFSUtilDetectCycle(Graph graph,int src,boolean[]visited,boolean[]recStack){
		visited[src]=true;
		recStack[src]=true;
		AdjListNode head=graph.adjNodeList[src].head;
		while(head!=null){
			if(!visited[head.dest]&&DFSUtilDetectCycle(graph, head.dest, visited, recStack)){
				System.out.println("it failed here");
				return true;
			}
			else if(recStack[head.dest]==true){
				System.out.println("it is intiated here at src : "+src+"  at dest : "+head.dest);
				return true;
			}
			head=head.next;
		}
		recStack[src]=false;
		return false;
	}
	public static boolean detectCycle(Graph graph){
		boolean[]visited=new boolean[graph.V];
		boolean[]recStack=new boolean[graph.V];
		for(int i=0;i<graph.V;i++){
			if(!visited[i]){
				if(DFSUtilDetectCycle(graph, i, visited, recStack)){
					return true;
				}
			}
		}
		return false;
	}
}
