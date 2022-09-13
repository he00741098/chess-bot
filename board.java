import java.util.*;
public class board{

private square[][] board;
public square[][] getBoard(){
	return board;
}
public board(){
board = new square[8][8];
//fill board with squares
for(int i = 0; i<board.length;i++){
	for(int k = 0; k<board[i].length;k++){
board[i][k] = new square();
		
	}
}
for(int i = 0; i<2; i++){
int b = 0;
if(i==1){
	b = 7;
}
board[b][0].setName("r");
board[b][1].setName("h");
board[b][2].setName("b");
board[b][3].setName("q");
board[b][4].setName("k");
board[b][5].setName("b");
board[b][6].setName("h");
board[b][7].setName("r");
for(int p = 0; p<8; p++){
board[b][p].setColor(b/7);
}

for(int p = 0; p<8; p++){
	//System.out.println(b+1+((b/7)*6));
if(b+1+((b/7)*6)==1){	
board[b+1+((b/7)*6)][p].setName("p");
board[b+1+((b/7)*6)][p].setColor(b/7);
}else{
board[b-1][p].setName("p");
board[b-1][p].setColor(b/7);
	
}
}

	
}


	
}




public void northEastFinder(int x, int y){
	if(x>7||y>7){return;}
int color = board[y][x].getColor();
if((x+1==7&&y+1==7)||(y+1<=7&&x+1<=7&&board[y+1][x+1].isOccupied())){
	if(color == 0){
		if(y+1<=7&&x+1<=7){
		board[y+1][x+1].wAttack();}
	}else if(color==1){
		if(y+1<=7&&x+1<=7){
		board[y+1][x+1].bAttack();}
	}
return;
}else{
	if(color == 0){
		if(y+1<=7&&x+1<=7){
		board[y+1][x+1].wAttack();}
	}else if(color==1){
		if(y+1<=7&&x+1<=7){
		board[y+1][x+1].bAttack();}
	}
	northEastFinder(x+1, y+1);
}

	
}
public void southEastFinder(int x, int y){
	if(x>7||y<0){
		return;
	}
int color = board[y][x].getColor();
if((x+1==7&&y-1==0)||(x+1<=7&&y-1>=0&&board[y-1][x+1].isOccupied())){
	if(color == 0){
		if(y-1>=0&&x+1<=7){
		board[y-1][x+1].wAttack();}
	}else if(color==1){
		if(y-1>=0&&x+1<=7){
		board[y-1][x+1].bAttack();}
	}
return;
}else{
	if(color == 0){
		if(y-1>=0&&x+1<=7){
		board[y-1][x+1].wAttack();}
	}else if(color==1){
		if(y-1>=0&&x+1<=7){
		board[y-1][x+1].bAttack();}
	}
	southEastFinder(x+1, y-1);
}

	
}

public void northWestFinder(int x, int y){
	if(x<0||y>7){
		return;
	}
int color = board[y][x].getColor();
if((x-1==0&&y+1==7)||(y+1<=7&&x-1>=0&&board[y+1][x-1].isOccupied())){
	if(color == 0){
		if(y+1<=7&&x-1>=0){
		board[y+1][x-1].wAttack();}
	}else if(color==1){
		if(y+1<=7&&x-1>=0){
		board[y+1][x-1].bAttack();}
	}
return;
}else{
	if(color == 0){
		if(y+1<=7&&x-1>=0){
		board[y+1][x-1].wAttack();}
	}else if(color==1){
		if(y+1<=7&&x-1>=0){
		board[y+1][x-1].bAttack();}
	}
	northWestFinder(x-1, y+1);
}

	
}
	public void southWestFinder(int x, int y){
		if(y<0||x<0){
			return;
		}
int color = board[y][x].getColor();
if((x-1==0&&y-1==0)||(x-1>=0&&y-1>=0&&board[y-1][x-1].isOccupied())){
	if(color == 0){
		if(y-1>=0&&x-1>=0){
		board[y-1][x-1].wAttack();}
	}else if(color==1){
		if(y-1>=0&&x-1>=0){
		board[y-1][x-1].bAttack();}
	}
return;
}else{
	if(color == 0){
		if(y-1>=0&&x-1>=0){
		board[y-1][x-1].wAttack();}
	}else if(color==1){
		if(y-1>=0&&x-1>=0){
		board[y-1][x-1].bAttack();}
	}
	southWestFinder(x-1, y-1);
}

	
}

public void westFinder(int x, int y){
	if(x<0){return;}
int color = board[y][x].getColor();
if(x-1==0||(x-1>=0&&board[y][x-1].isOccupied())){
	if(color == 0){
		if(x-1>=0){
		board[y][x-1].wAttack();}
	}else if(color==1){
		if(x-1>=0){
		board[y][x-1].bAttack();}
	}
return;
}else{
	if(color == 0){
		if(x-1>=0){
		board[y][x-1].wAttack();}
	}else if(color==1){
		if(x-1>=0){
		board[y][x-1].bAttack();}
	}
	westFinder(x-1, y);
}

	
}

public void southFinder(int x, int y){
	if(y<0||x>7||y>7){
		return;
	}
int color = board[y][x].getColor();
if(y-1==0||(y-1>=0&&board[y-1][x].isOccupied())){
	if(color == 0){
		board[y-1][x].wAttack();
	}else if(color==1){
		board[y-1][x].bAttack();
	}
return;
}else{
	if(color == 0){
		if(y-1>=0){
		board[y-1][x].wAttack();}
	}else if(color==1){
		if(y-1>=0){
		board[y-1][x].bAttack();}
	}
	southFinder(x, y-1);
}

	
}

public void northFinder(int x, int y){
	if(y>7){
		return;
	}
int color = board[y][x].getColor();
if(y+1==0||(y+1<=7&&board[y+1][x].isOccupied())){
	if(color == 0){
		if(y+1<=7){
		board[y+1][x].wAttack();}
	}else if(color==1){
		if(y+1<=7){
		board[y+1][x].bAttack();}
	}
return;
}else{
	if(color == 0){
		if(y+1<=7){
		board[y+1][x].wAttack();}
	}else if(color==1){
		if(y+1<=7){
		board[y+1][x].bAttack();}
	}
	southFinder(x, y+1);
}

	
}


	
public void eastFinder(int x, int y){
	if(x>7){return;}
int color = board[y][x].getColor();
if((x+1<=7&&board[y][x+1].isOccupied())||x+1==7){
	if(color == 0){
		if(x+1<=7){
		board[y][x+1].wAttack();}
	}else if(color==1){
		if(x+1<=7){
		board[y][x+1].bAttack();}
	}
return;
}else{
	if(color == 0){
		if(x+1<=7){
		board[y][x+1].wAttack();}
	}else if(color==1){
		if(x+1<=7){
		board[y][x+1].bAttack();}
	}
	eastFinder(x+1, y);
}

	
}

	
public void update(){

for(int i = 0; i<board.length; i++){
for(int k = 0; k<board[i].length; k++){


if(board[k][i].isOccupied()){

if(board[k][i].getName()=="r"){
northFinder(i,k);
eastFinder(i,k);
southFinder(i,k);
westFinder(i,k);
	
}else if(board[k][i].getName()=="p"){


if(i!=0){
	if(board[k][i].getColor() == 0){
	board[k+1][i-1].wAttack();}
	else if(board[k][i].getColor() == 1){
		board[k-1][i-1].bAttack();
	}
}
if(i!=7){

	if(board[k][i].getColor() == 0){
	board[k+1][i+1].wAttack();}
	else if(board[k][i].getColor() == 1){
		board[k-1][i+1].bAttack();
	}
	
}
	
	
}else if(board[k][i].getName()=="b"){

northEastFinder(i,k);
southEastFinder(i,k);
southWestFinder(i,k);
northWestFinder(i,k);

	
	
}else if(board[k][i].getName()=="h"){
int color = board[k][i].getColor();
if(k+2<=7){
	if(i+1<=7){
		if(color == 0){
		board[k+2][i+1].wAttack();
			}
		else if(color == 1){
		board[k+2][i+1].bAttack();
			}
	}
	if(i-1>=0){
if(color == 0){
	board[k+2][i-1].wAttack();
}
		else if(color == 1){
			board[k+2][i-1].bAttack();
		}
		
	}
}else if(k-2>=0){
	if(i+1<=7){
		if(color == 0){
		board[k-22][i+1].wAttack();
			}
		else if(color == 1){
		board[k-2][i+1].bAttack();
			}
	}
	if(i-1>=0){
if(color == 0){
	board[k-2][i-1].wAttack();
}
		else if(color == 1){
			board[k-2][i-1].bAttack();
		}
		
	}
}else if(i+2<=7){
	if(k+1<=7){
		if(color == 0){
		board[k+1][i+2].wAttack();
			}
		else if(color == 1){
		board[k+1][i+2].bAttack();
			}
	}
	if(k-1>=0){
if(color == 0){
	board[k-1][i+2].wAttack();
}
		else if(color == 1){
			board[k-1][i+2].bAttack();
		}
		
	}
}else if(i-2<=7){
	if(k+1<=7){
		if(color == 0){
		board[k+1][i-2].wAttack();
			}
		else if(color == 1){
		board[k+1][i-2].bAttack();
			}
	}
	if(k-1>=0){
if(color == 0){
	board[k-1][i-2].wAttack();
}
		else if(color == 1){
			board[k-1][i-2].bAttack();
		}
		
	}
}




	
}else if(board[k][i].getName()=="k"){
int color= board[k][i].getColor();
if(color == 0){
if(k+1<=7&&board[k+1][i].getBlack()==0){
	board[k+1][i].wAttack();
}
if(k+1<=7&&i+1<=7&&board[k+1][i+1].getBlack()==0){
	board[k+1][i+1].wAttack();
}

if(i+1<=7&&board[k][i+1].getBlack()==0){
	board[k][i+1].wAttack();
}
if(k-1>=0&&i+1<=7&&board[k-1][i+1].getBlack()==0){
	board[k-1][i+1].wAttack();
}
if(k-1>=0&&board[k-1][i].getBlack()==0){
	board[k-1][i].wAttack();
}
	if(k-1>=0&&i-1>=0&&board[k-1][i-1].getBlack()==0){
	board[k-1][i-1].wAttack();
}
if(i-1>=0&&board[k][i-1].getBlack()==0){
	board[k][i-1].wAttack();
}
	if(k+1<=7&&i-1>=0&&board[k+1][i-1].getBlack()==0){
	board[k+1][i-1].wAttack();
}
	
}else if(color == 1){
if(k+1<=7&&board[k+1][i].getWhite()==0){
	board[k+1][i].bAttack();
}
if(k+1<=7&&i+1<=7&&board[k+1][i+1].getWhite()==0){
	board[k+1][i+1].bAttack();
}

if(i+1<=7&&board[k][i+1].getWhite()==0){
	board[k][i+1].bAttack();
}
if(k-1>=0&&i+1<=7&&board[k-1][i+1].getWhite()==0){
	board[k-1][i+1].bAttack();
}
if(k-1>=0&&board[k-1][i].getWhite()==0){
	board[k-1][i].bAttack();
}
	if(k-1>=0&&i-1>=0&&board[k-1][i-1].getWhite()==0){
	board[k-1][i-1].bAttack();
}
if(i-1>=0&&board[k][i-1].getWhite()==0){
	board[k][i-1].bAttack();
}
	if(k+1<=7&&i-1>=0&&board[k+1][i-1].getWhite()==0){
	board[k+1][i-1].bAttack();
}
	
}

	


	
}else if(board[k][i].getName()=="q"){
northEastFinder(i,k);
southEastFinder(i,k);
southWestFinder(i,k);
northWestFinder(i,k);
northFinder(i,k);
eastFinder(i,k);
southFinder(i,k);
westFinder(i,k);
}


	
}
	




	
}
	
}

	

	
}

//16 pieces
//16 pawn moves
//4 horse moves
	
}