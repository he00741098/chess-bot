import java.util.*;
public class horse extends pawn{
private static String pawn = "h";
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

if(newX==0&&newY==2){
	//System.out.println("Found\n"+(Math.abs(newX-x)==1&&Math.abs(newY-y)==2)+"\n("+x+", "+y+")");
}
	
square piece = board[y][x];
int color = piece.getColor();
boolean fal = false;
if(Math.abs(newX-x)==1&&Math.abs(newY-y)==2){
	fal = true;
}else if(Math.abs(newX-x)==2&&Math.abs(newY-y)==1){
	fal = true;
}

if(fal){
	if(board[newY][newX].isOccupied()){
		if(board[newY][newX].getColor()!=color){
			return true;
		}
		return false;
	}
	return true;
}
	

//##S#S##
//#######
//S#####S
//###H###
//S#####S
//#######
//##S#S##
	return false;
}}