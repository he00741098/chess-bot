import java.util.*;
class Main {
// public static final String RESET = "\u001B[0m";
// public static final String BLACK = "\u001B[30m";
// public static final String RED = "\u001B[31m";
// public static final String GREEN = "\u001B[32m";
// public static final String YELLOW = "\u001B[33m";
// public static final String BLUE = "\u001B[34m";
// public static final String PURPLE = "\u001B[35m";
// public static final String CYAN = "\u001B[36m";
// public static final String WHITE = "\u001B[37m";



	
  public static void main(String[] args) {
//System.out.println("\033[31;44;1m");
		board board = new board();



		
square[][] pieces = board.getBoard();
	board.update();
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
		
		if(white){
			System.out.print("\033["+codeColor+";47;1m");
		}else{
			System.out.print("\033["+codeColor+";41;1m");
		}
		System.out.print(pieces[pieces.length-1-i][k].getName()+" ");
	
	white=!white;
	}
	white=!white;
	System.out.println();
}


		
		List<int[]> list = bishop.moves(pieces,0);
//System.out.println(list);
for(int[] i : list){
	for(int k : i){
		//System.out.print(k);
	}
	System.out.println();
}
		
	}
}