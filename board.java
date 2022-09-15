import java.util.*;
public class board{
private boolean whiteCheck = false;
private boolean blackCheck = false;
int tempColor = -1;
private boolean kingMoved = false;
private boolean wRook1Move = false;
private boolean wRook2Move = false;
private boolean bRook1Move = false;
private boolean bRook2Move = false;


public boolean getwRook1(){return wRook1Move;}
public boolean getwRook2(){return wRook2Move;}
public boolean getbRook1(){return bRook1Move;}
public boolean getbRook2(){return bRook2Move;}
	
public boolean getWhiteCheck(){return whiteCheck;}
public boolean getBlackCheck(){return blackCheck;}
public boolean getKingMoved(){return kingMoved;}
public void setBoard(square[][] bo){
	board = bo;
}	
	
public board clone(){

board k = new board();

k.wRook1Move = wRook1Move;
k.wRook2Move = wRook2Move;
k.bRook1Move = bRook1Move;
k.bRook2Move = bRook2Move;
k.whiteCheck = whiteCheck;
k.blackCheck = blackCheck;
k.kingMoved = kingMoved;
square[][] board = new square[8][8];
for(int i = 0; i<board.length;i++){
	for(int p = 0; p<board[i].length;p++){
board[i][p] = this.board[i][p].clone();
		
	}}


	
k.board = board;

	
	return k;
}
	
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
	if(x>7||y>7){
		tempColor=-1;
		return;}
if(tempColor==-1){
	tempColor = board[y][x].getColor();
}
	int color = tempColor;
if((x+1==7&&y+1==7)||(y+1<=7&&x+1<=7&&board[y+1][x+1].isOccupied())){
	if(color == 0){
		if(y+1<=7&&x+1<=7){
		board[y+1][x+1].wAttack();}
	}else if(color==1){
		if(y+1<=7&&x+1<=7){
		board[y+1][x+1].bAttack();}
	}
	tempColor = -1;
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
		tempColor=-1;
		return;
	}
if(tempColor==-1){
	tempColor = board[y][x].getColor();
}
	int color = tempColor;
if((x+1==7&&y-1==0)||(x+1<=7&&y-1>=0&&board[y-1][x+1].isOccupied())){
	if(color == 0){
		if(y-1>=0&&x+1<=7){
		board[y-1][x+1].wAttack();}
	}else if(color==1){
		if(y-1>=0&&x+1<=7){
		board[y-1][x+1].bAttack();}
	}
	tempColor = -1;
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
		tempColor=-1;
		return;
	}
if(tempColor==-1){
	tempColor = board[y][x].getColor();
}
	int color = tempColor;
if((x-1==0&&y+1==7)||(y+1<=7&&x-1>=0&&board[y+1][x-1].isOccupied())){
	if(color == 0){
		if(y+1<=7&&x-1>=0){
		board[y+1][x-1].wAttack();}
	}else if(color==1){
		if(y+1<=7&&x-1>=0){
		board[y+1][x-1].bAttack();}
	}
	tempColor = -1;
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
			tempColor=-1;
			return;
		}
if(tempColor==-1){
	tempColor = board[y][x].getColor();
}
	int color = tempColor;
if((x-1==0&&y-1==0)||(x-1>=0&&y-1>=0&&board[y-1][x-1].isOccupied())){
	if(color == 0){
		if(y-1>=0&&x-1>=0){
		board[y-1][x-1].wAttack();}
	}else if(color==1){
		if(y-1>=0&&x-1>=0){
		board[y-1][x-1].bAttack();}
	}
	tempColor = -1;
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
	if(x<0){
		tempColor=-1;
		return;}
if(tempColor==-1){
	tempColor = board[y][x].getColor();
}
	int color = tempColor;
if(x-1==0||(x-1>=0&&board[y][x-1].isOccupied())){
	if(color == 0){
		if(x-1>=0){
		board[y][x-1].wAttack();}
	}else if(color==1){
		if(x-1>=0){
		board[y][x-1].bAttack();}
	}
	tempColor = -1;
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
	if(y<0){
		tempColor=-1;
		return;
	}
if(tempColor==-1){
	tempColor = board[y][x].getColor();
}
	int color = tempColor;
if(y-1==0||(y-1>=0&&board[y-1][x].isOccupied())){
	if(color == 0){
		board[y-1][x].wAttack();
	}else if(color==1){
		board[y-1][x].bAttack();
	}
	tempColor = -1;
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
		//System.out.println(x+", "+y);
		tempColor=-1;
		return;
	}
	if(x==7&&y==0){
	//System.out.println(board[y][x].getColor());
}
if(tempColor==-1){
	
	tempColor = board[y][x].getColor();

	//System.out.println("Color set: "+x+", "+y+", "+tempColor);
}

if(x==7&&y==0){
	System.out.println(tempColor);
}

	
	int color = tempColor;
if(y+1==7||(y+1<=7&&board[y+1][x].isOccupied())){
	if(color == 0){
		if(y+1<=7){
		board[y+1][x].wAttack();}
	}else if(color==1){
		if(y+1<=7){
		board[y+1][x].bAttack();}
	}
	tempColor = -1;
return;
}else{
	if(color == 0){
		if(y+1<=7){
		board[y+1][x].wAttack();}
	}else if(color==1){
		if(y+1<=7){
		board[y+1][x].bAttack();}
	}
	northFinder(x, y+1);
}

	tempColor=-1;
}

	
public void eastFinder(int x, int y){
	if(x>7){
		tempColor=-1;
		return;}
if(tempColor==-1){
	
	tempColor = board[y][x].getColor();
}
	int color = tempColor;
if((x+1<=7&&board[y][x+1].isOccupied())||x+1==7){
	if(color == 0){
		if(x+1<=7){
		board[y][x+1].wAttack();}
	}else if(color==1){
		if(x+1<=7){
		board[y][x+1].bAttack();}
	}
	tempColor = -1;
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

	
// for(square[] b : board){
// 	for(square i : b){

// if(i.getName().equals("k")){
// int kolor = i.getColor();

// if(kolor==0){

// 	if(i.getBlack()>0){
// 		whiteCheck = true;
		
// 	}else{
// 		whiteCheck = false;
// 	}
	
// }else if(kolor==1){

// 		if(i.getWhite()>0){
// 		blackCheck = true;
// 	}else{
// 			blackCheck = false;
// 	}
// }

	
// }

		
// 	}
// }
	
	
	
	
	
	for(square[] b : board){
	for(square i : b){
		i.blackClear();
		i.whiteClear();
	}
}




	
//queen detection
for(int j = 0; j<7; j++){

if(board[7][j].getName().equals("p")){
	board[7][j].setName("q");
}
if(board[0][j].getName().equals("p")){
	board[0][j].setName("q");
}
	
}

	
for(int i = 0; i<board.length; i++){
for(int k = 0; k<board[i].length; k++){


if(board[k][i].isOccupied()){

if(board[k][i].getName()=="r"){
northFinder(i,k);
eastFinder(i,k);
southFinder(i,k);
westFinder(i,k);
	
}else if(board[k][i].getName()=="p"){


if(i-1>=0){
	if(board[k][i].getColor() == 0){
	if(k+1<=7){	
	board[k+1][i-1].wAttack();
	}}
	else if(board[k][i].getColor() == 1){
		if(k-1>=0){
		board[k-1][i-1].bAttack();}
	}
}
if(i+1<=7){

	if(board[k][i].getColor() == 0){
	if(k+1<=7){	
	board[k+1][i+1].wAttack();}
	}
	else if(board[k][i].getColor() == 1){
	if(k-1>=0){	
		board[k-1][i+1].bAttack();
	}
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
}
	if(k-2>=0){
	if(i+1<=7){
		if(color == 0){
		board[k-2][i+1].wAttack();
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
}
	if(i+2<=7){
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
}
	if(i-2>=0){
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

	
//check detector
for(square[] b : board){
	for(square i : b){

if(i.getName().equals("k")){
int kolor = i.getColor();

if(kolor==0){

	if(i.getBlack()>0){
		//System.out.println("White Under Check");
		
		whiteCheck = true;
		
	}else{
		whiteCheck = false;
	}
	
}else if(kolor==1){

		if(i.getWhite()>0){
		blackCheck = true;
			//System.out.println("White Under Check");
	}else{
			blackCheck = false;
	}
}

	
}

		
	}
}

	
}


public boolean checkMateCheck(int color){








	
}

//16 pieces
//16 pawn moves
//4 horse moves



public void realMove(int x, int y, int newX, int newY){

int color = board[y][x].getColor();
String piece = board[y][x].getName();

if(piece.equals("h")){
if(horse.move(x, y, newX, newY, board)){
board[y][x].empty();
board[newY][newX].setName("h");
	board[newY][newX].setColor(color);
}

	
}else if(piece.equals("b")){

if(bishop.move(x, y, newX, newY, board)){
board[y][x].empty();
board[newY][newX].setName("b");
	board[newY][newX].setColor(color);
}

	
}else if(piece.equals("p")){
	if(pawn.move(x, y, newX, newY, board)){
board[y][x].empty();
board[newY][newX].setName("p");
		board[newY][newX].setColor(color);
}
}else if(piece.equals("q")){
	if(queen.move(x, y, newX, newY, board)){
board[y][x].empty();
board[newY][newX].setName("q");
		board[newY][newX].setColor(color);
}
}else if(piece.equals("r")){
	if(rook.move(x, y, newX, newY, board)){
board[y][x].empty();
board[newY][newX].setName("r");
		board[newY][newX].setColor(color);

if(!wRook1Move&&color==0&&x==0&&y==0){
	wRook1Move = true;
}else if(!wRook2Move&&color==0&&x==7&&y==0){
	wRook2Move = true;
}else if(!bRook1Move&&color==0&&x==0&&y==7){
	bRook1Move = true;
}else if(!bRook2Move&&color==0&&x==7&&y==7){
	bRook2Move = true;
}




		
}
}else if(piece.equals("k")){
	if(king.move(x, y, newX, newY, board)){
board[y][x].empty();
board[newY][newX].setName("k");
		board[newY][newX].setColor(color);
		kingMoved = true;
}else{

if(color==0){

if(!kingMoved){
if(newX==2&&newY==0){
if(!wRook1Move){

if(!board[0][1].isOccupied()){
	if(!board[0][2].isOccupied()){
		if(!board[0][3].isOccupied()){
			board[0][2].setColor(color);
			board[0][4].empty();
			board[0][2].setName("k");
			board[0][0].empty();
			board[0][3].setName("r");
			board[0][3].setColor(color);
		}
	}
}
	
	
}
	
}else if(newX==6&&newY==0){
if(!wRook2Move){

if(!board[0][6].isOccupied()){
	if(!board[0][5].isOccupied()){
		
			board[0][6].setColor(color);
			board[0][4].empty();
			board[0][6].setName("k");
			board[0][7].empty();
			board[0][5].setName("r");
			board[0][5].setColor(color);
		
	}
}
	
	
}


	
}

	
}
	
	
}else if(color==1){

if(!kingMoved){
if(newX==2&&newY==7){
if(!wRook1Move){

if(!board[7][1].isOccupied()){
	if(!board[7][2].isOccupied()){
		if(!board[7][3].isOccupied()){
			board[7][2].setColor(color);
			board[7][4].empty();
			board[7][2].setName("k");
			board[7][0].empty();
			board[7][3].setName("r");
			board[7][3].setColor(color);
		}
	}
}
	
	
}
	
}else if(newX==6&&newY==7){
if(!wRook2Move){

if(!board[7][6].isOccupied()){
	if(!board[7][5].isOccupied()){
		
			board[7][6].setColor(color);
			board[7][4].empty();
			board[7][6].setName("k");
			board[7][7].empty();
			board[7][5].setName("r");
			board[7][5].setColor(color);
		
	}
}
	
	
}


	
}

	
}
	
}




		
}




	
}




update();
if(color == 0){
	//System.out.println("EEEEE");
	if(whiteCheck){
		board[newY][newX].empty();
		board[y][x].setName(piece);
		board[y][x].setColor(color);
		update();
		
	}
}else if(color == 1){
	//System.out.println("DDDDDD");
	if(blackCheck){
		board[newY][newX].empty();
		board[y][x].setName(piece);
		board[y][x].setColor(color);
		update();
		
	}
}
	
}



	
}