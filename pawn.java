import java.util.*;
public class pawn{

private static String pawn = "p";
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

if(piece.getColor() == 0){
//if white
if(newY-y <=2){
if(newY-y==1&&newX-x==0&&!board[newY][newX].isOccupied()){
	return true;
}else if(newY-y == 2&&newX-x==0&&y==1&&!board[newY][newX].isOccupied()){
return true;
	
}else if(newX-x==1&&newY-y==1&&board[newY][newX].getColor()==1){
	return true;
}else if(x-newX==1&&newY-y==1&&board[newY][newX].getColor()==1){
	return true;
}

	
}else{
	//System.out.println("Falsed52");
	return false;}

	
}else if(piece.getColor() == 1){
//if black
	//System.out.println("black");
if(y-newY <=2){
if(y-newY==1&&newX-x==0&&!board[newY][newX].isOccupied()){
	return true;
}else if(y-newY == 2&&newX-x==0&&y==6&&!board[newY][newX].isOccupied()){
return true;
	
}else if(newX-x==1&&y-newY==1&&board[newY][newX].getColor()==0){
	return true;
}else if(x-newX==1&&y-newY==1&&board[newY][newX].getColor()==0){
	return true;
}

	
}

}
return false;	
}





	
}