import java.util.*;
public class square{
//white = 0, black = 1	
private boolean occupied;
	private int color;
private String name = " ";
	private int white;
	private int black;

public int getWhite(){
	return white;
}
public int getBlack(){
	return black;
}
	
public square(){
	occupied = false;
}

public void whiteClear(){
	white = 0;
}
public void blackClear(){
	black = 0;
}
public void wAttack(){
	white++;
}
public void bAttack(){
	black++;
}
	
public square clone(){
	square n = new square();
	n.setName(name);
	n.setColor(color);
	n.occupied = occupied;
	n.white = white;
	n.black = black;
	return n;
}	
	
public void empty(){occupied = false;color = -999;name =" ";}
public square(String name){
	this.name = name;
}
public void setName(String name){
	this.name = name;
	occupied = true;
}
public void setColor(int num){
  this.color = num;
}

public String getName(){
	return name;
}
public int getColor(){
	return color;
}
public boolean isOccupied(){
return occupied;
	
}
}