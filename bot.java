import java.util.*;
public class bot{

private int color;
private int maxRec = 6;

public bot(int color){
	this.color = color;}
public bot(int color, int maxRec){
	this.color = color;
	this.maxRec = maxRec;
}

public int play(board b, int place){
if(place>maxRec){
	return -999;
}

	
square[][] board = b.getBoard();

List<int[]> allMoves = new ArrayList<int[]>();
if(true){
List<int[]> horseMoves = horse.moves(board, color);
List<int[]> queenMoves = queen.moves(board, color);
List<int[]> rookMoves = rook.moves(board, color);
List<int[]> bishopMoves = bishop.moves(board, color);
List<int[]> kingMoves = king.moves(board, color);
List<int[]> pawnMoves = pawn.moves(board, color);


allMoves.addAll(horseMoves);allMoves.addAll(pawnMoves);
allMoves.addAll(queenMoves);allMoves.addAll(rookMoves);
allMoves.addAll(bishopMoves);allMoves.addAll(kingMoves);
}
//validation for a move
//squares attacking - variable weights
//pieces attacking
//squares defending
//pieces defending
//higher value pieces attacking
//lower value pieces
//check
//fork
//checkmate
//influence

	return -1;
}




	
}