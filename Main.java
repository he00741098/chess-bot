import java.util.*;
class Main {
public static final String RESET = "\u001B[0m";
// public static final String BLACK = "\u001B[30m";
// public static final String RED = "\u001B[31m";
// public static final String GREEN = "\u001B[32m";
// public static final String YELLOW = "\u001B[33m";
// public static final String BLUE = "\u001B[34m";
// public static final String PURPLE = "\u001B[35m";
// public static final String CYAN = "\u001B[36m";
// public static final String WHITE = "\u001B[37m";



	
  public static void main(String[] args) {
		Scanner bob = new Scanner(System.in);
		
//System.out.println("\033[31;44;1m");
		board board = new board();



		
square[][] pieces = board.getBoard();
	board.update();

while(true){
	//clear board
System.out.println("\033[H\033[2J");
printer(pieces);
	//	System.out.println(pieces[0][0].getColor());
// List<square> squares = new ArrayList<square>();

// 		for(square[] p : pieces){
// 			for(square s : p){
// 				squares.add(s);
// 			}
// 		}


//sorting lists of stuff

	



		
		
		
		//pieces[1][4].empty();
		//pieces[1][2].empty();
		//System.out.println(queen.move(3,0,3,2,pieces));
//System.out.println(pieces);
		boolean white = true;
		int codeColor;
for(int i = 0; i<pieces.length; i++){
	for(int k = 0; k<pieces[i].length; k++){

if(pieces[pieces.length-1-i][k].isOccupied()&&pieces[pieces.length-1-i][k].getColor()==0){
	codeColor=33;
}else if(pieces[pieces.length-1-i][k].getColor()==1){
	codeColor=30;
}else{
	codeColor = 34;
}
		System.out.print(RESET);
		if(white){
			System.out.print("\033["+codeColor+";47;1m");
		}else{
			System.out.print("\033["+codeColor+";41;1m");
		}
		System.out.print(pieces[pieces.length-1-i][k].getName()+" ");
	
	white=!white;
	}
	white=!white;
	System.out.println(RESET);
}


		
// 		List<int[]> list = bishop.moves(pieces,0);
// //System.out.println(list);
// for(int[] i : list){
// 	for(int k : i){
// 		//System.out.print(k);
// 	}
// 	System.out.println();
// }


System.out.println("move");
if(board.getWhiteCheck()){
	System.out.println("White under check");
}
if(board.getBlackCheck()){
	System.out.println("Black Under Check");
}
	
String move = bob.nextLine();

if(move.substring(0,1).equals("R")){
int substring = move.indexOf(";");
int x = Integer.parseInt(move.substring(1, substring));
move = move.substring(substring+1);
substring = move.indexOf(";");
int y;
	if(substring==-1){
	y = Integer.parseInt(move.substring(0));
}else{
		y = Integer.parseInt(move.substring(0, substring));
}

pieces[y][x].empty();
board.update();
	
}else if(move.substring(0,1).equals("S")){
String item = move.substring(1,2);
int substring = move.indexOf(";");
int x = Integer.parseInt(move.substring(2, substring));
move = move.substring(substring+1);
substring = move.indexOf(";");
int y;
	if(substring==-1){
	y = Integer.parseInt(move.substring(0));
}else{
		y = Integer.parseInt(move.substring(0, substring));
}

pieces[y][x].setName(item);
board.update();
}else{
	//board.update();
int substring = move.indexOf(";");
int x = Integer.parseInt(move.substring(0, substring));
move = move.substring(substring+1);
substring = move.indexOf(";");
int y = Integer.parseInt(move.substring(0, substring));
move = move.substring(substring+1);
substring = move.indexOf(";");
	int newX = Integer.parseInt(move.substring(0, substring));
	move = move.substring(substring+1);
	substring = move.indexOf(";");
int newY;
	if(substring==-1){
	newY = Integer.parseInt(move.substring(0));
}else{
		newY = Integer.parseInt(move.substring(0, substring));
}

board.realMove(x, y, newX, newY);

}



	
}
		
	}




	public static void printer(square[][] pieces){
		//boolean white = true;
		int codeColor;
for(int i = 0; i<pieces.length; i++){
	for(int k = 0; k<pieces[i].length; k++){

if(pieces[pieces.length-1-i][k].isOccupied()&&pieces[pieces.length-1-i][k].getColor()==0){
	codeColor=33;
}else if(pieces[pieces.length-1-i][k].getColor()==1){
	codeColor=30;
}else{
	codeColor = 34;
}
		
		if(pieces[pieces.length-1-i][k].getWhite()>0||pieces[pieces.length-1-i][k].getBlack()>0){
			System.out.print("\033["+codeColor+";41;1m");
		}else{
			System.out.print("\033["+codeColor+";47;1m");
		}
		System.out.print(pieces[pieces.length-1-i][k].getName()+" ");
	
	//white=!white;
	}
	//white=!white;
	System.out.println(RESET);

}
	
	System.out.println(RESET);
	}
}