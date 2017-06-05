package Graphs;

public class Graph {

	int V;
	AdjList adjNodeList[];
	Graph(int V){
		this.V=V;
		adjNodeList=new AdjList[V];
		for(int i=0;i<adjNodeList.length;i++){
			adjNodeList[i]=new AdjList();
		}
	}
}
