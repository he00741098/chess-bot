import java.util.*;
public class king extends pawn{

private static String pawn = "k";
public static List<int[]> moves(square[][] board, int color){
List<int[]> moves = new ArrayList<int[]>();

for(int i = 0; i<board.length;i++){
	//System.out.print(1);
for(int k = 0; k<board[i].length;k++){
if(board[i][k].isOccupied()&&board[i][k].getName()==pawn&&board[i][k].getColor()==color){
for(int o = 0; o<board.length; o++){
for(int p = 0; p<board.length; p++){
	//System.out.println(i+", "+k+"\n"+o+", "+p);
if(move(k,i,p,o,board)){
	//System.out.println("Approved");
	int[] temp = {k,i,p,o};
	moves.add(temp);
}
	
}
	
}
	
}
	
}
	
}
	return moves;
}


public static boolean move(int x, int y, int newX, int newY, square[][] board){
square piece = board[y][x];
int color = piece.getColor();
	
if(Math.abs(newY-y)>1||Math.abs(newX-x)>1){return false;}
if(board[newY][newX].isOccupied()&&board[newY][newX].getColor()!=color){
	if(color==0){	
	if(board[newY][newX].getBlack()==0){
		return true;}else{return false;}
	}else if(color==1){
if(board[newY][newX].getWhite()==0){
		return true;}else{return false;}

		
	}
}
if(!board[newY][newX].isOccupied()){
		if(color==0){	
	if(board[newY][newX].getBlack()==0){
		return true;}else{return false;}
	}else if(color==1){
if(board[newY][newX].getWhite()==0){
		return true;}else{return false;}

		
	}
}






	//castling
// 	if(color == 0){
// if(!board.getWhiteCheck()){

// if(newX==2&&newY==0){
// 	if(!board.getwRook1()){
// if()
		
// 	}
// }

	
// }

		
// 	}else if(color == 1){

		
// 	}





	
return false;	
}





	
}