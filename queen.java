import java.util.*;
public class queen extends pawn{

private static String pawn = "q";
public static List<int[]> moves(square[][] board, int color){
List<int[]> moves = new ArrayList<int[]>();

for(int i = 0; i<board.length;i++){
	//System.out.print(1);
for(int k = 0; k<board[i].length;k++){
if(board[i][k].isOccupied()&&board[i][k].getName()==pawn&&board[i][k].getColor()==color){
for(int o = 0; o<board.length; o++){
for(int p = 0; p<board.length; p++){
	//System.out.println(i+", "+k+"\n"+o+", "+p);
	//System.out.println(move(k,i,p,o,board));
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
boolean falsify = true;
//0 = north;1=NE;2=E;3=SE;4=S;5=SW;6=W;7=NW;
int direction=-1;
//movement pattern
if(Math.abs(newY-y)!=Math.abs(newX-x)){falsify=false;}else{falsify=true;
if(newX-x>0&&newY-y>0){direction = 3;}
else if(newX-x<0&&newY-y>0){direction=5;}
else if(newX-x<0&&newY-y<0){direction=7;}
else if(newX-x>0&&newY-y<0){direction=1;}																													
																													}

if(Math.abs(newY-y)>0&&newX==x){
	falsify = true;
	if(newY-y>0){
		direction=4;
	}else if(newY-y<0){
		direction=0;
	}
}

if(Math.abs(newX-x)>0&&newY==y){
	falsify = true;
	if(newX-x>0){
		direction = 2;
	}else if(newX-x<0){
		direction = 6;
	}
}
if(!falsify){return false;}

if(direction!=-1){

if(direction%2!=0){
int yCoeff = 1;
int xCoeff = 1;
//0 = north;1=NE;2=E;3=SE;4=S;5=SW;6=W;7=NW;
if(direction==1){
	yCoeff = -1;
	xCoeff = 1;
}else if(direction == 3){
	yCoeff = 1;
	xCoeff = 1;
}else if(direction == 5){
	yCoeff = 1;
	xCoeff = -1;
}else if(direction == 7){
	yCoeff = -1;
	xCoeff = -1;
}

if(board[newY][newX].isOccupied()){
	if(board[newY][newX].getColor()==color){
		return false;
	}
}
	
for(int i = 1; i<Math.abs(newX-x); i++){
if(board[y+(yCoeff*i)][x+(xCoeff*i)].isOccupied()){
	return false;
}
	
}

	return true;
}else if(direction%2==0){
int yCoeff = 1;
int xCoeff = 1;
// int yCorr = 1;
// int xCorr = 1;
//0 = north;1=NE;2=E;3=SE;4=S;5=SW;6=W;7=NW;
if(direction == 0){
	yCoeff = -1;
	xCoeff = 0;
	// xCorr=0
}else if(direction == 2){
	yCoeff = 0;
	xCoeff = 1;
}else if(direction == 4){
	yCoeff = 1;
	xCoeff = 0;
}else if(direction == 6){
	yCoeff = 0;
	xCoeff = -1;
}


if(board[newY][newX].isOccupied()){
	if(board[newY][newX].getColor()==color){
		return false;
	}
}


if(direction == 2 || direction == 6){	
for(int i = 0; i<Math.abs(newX-x)-1; i++){
	//System.out.println(y+(yCoeff*i)+", "+(x+(xCoeff*i)));
if(board[y+(yCoeff*i)][x+(xCoeff*i)].isOccupied()){
	return false;
}
}
}else if(direction == 0 || direction == 4){	
for(int i = 1; i<Math.abs(newY-y); i++){
	//System.out.println(y+(yCoeff*i)+", "+(x+(xCoeff*i)));
if(board[y+(yCoeff*i)][x+(xCoeff*i)].isOccupied()){
	return false;
}
	
}



	
}
	return true;
}


	
}

	
// if(board[newY][newX].isOccupied()&&board[newY][newX].getColor()!=color){
// 	return true;
// }
// if(!board[newY][newX].isOccupied()){
// 	return true;
// }
return false;	
}





	
}