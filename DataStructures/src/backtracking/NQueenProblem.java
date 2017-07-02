package backtracking;

public class NQueenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Position positions[]=solveNQueen(4);
		for(int i=0;i<positions.length;i++){
			System.out.println("(  "+ positions[i].row+" ,  "+positions[i].col+"  )");
		}
		
	}
	
	public static  Position[] solveNQueen(int n){
		Position[] positions=new Position[n];
		boolean hasSolution=solveNQueenUtil(n, 0, positions);
		if(hasSolution){
			return positions;
		}else{
			return new Position[0];
		}
	}
	
	public static boolean solveNQueenUtil(int n,int row,Position[]positions){
		if(n==row){
			return true;
		}
		int col;
		for(col=0;col<n;col++){
			boolean foundSafe=true;
			for(int queen=0;queen<row;queen++){
				if(positions[queen].col==col||positions[queen].row-positions[queen].col==row-col||positions[queen].row+positions[queen].col==row+col){
					foundSafe=false;
					break;
				}
			}
			if(foundSafe){
				positions[row]=new Position(row, col);
				if(solveNQueenUtil(n, row+1, positions)){
					return true; 
				}
				
			}
		}
		return false;
	}
}

class Position{
	int row;
	int col;
	public Position(int row,int col){
		this.row=row;
		this.col=col;
	}
}