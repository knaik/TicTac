import java.util.*;

public class Board{
		// internal inconsistency between offset for row/column. sometimes row starts at 0, sometimes at 1
		
		private char[][] grid = new char[3][3];
		private int totalMoves = 0;
		private char empty = '~';
		private char curPlayer =  'X';
		
		
		Scanner scan = new Scanner(System.in);
		
		public Board(){
			this.clear();
		}
	
		public void play(){
			while(totalMoves < 10){
				System.out.println("Current player is "+ curPlayer);

				System.out.print("row:");
				int tempR = scan.nextInt();
				System.out.print("\b col:");
				int tempC = scan.nextInt();
				
				//grid[tempR][tempC] = curPlayer;
				boolean setting = setMove(curPlayer, tempR, tempC);
				while (setting == false) { //using a while loop properly, makes more sense than if/for :)
					System.out.println("error with input, try again");
				
					// no way to do goto in java so... will try again later.
					// the issue is trying to use a getmove method won't
					// pass the temp in a useful way.
					//maybe setmove and getmove can be combined later?
					
					System.out.print("row:");
					tempR = scan.nextInt();
					System.out.print("\b col:");
					tempC = scan.nextInt();
					setting = setMove(curPlayer, tempR, tempC);
					
				}
				
				if (setting) { // checks if true, maybe a better way to do this?
					totalMoves++;
				}
				if (curPlayer == 'X') {
					curPlayer = 'O';
				} else {
					curPlayer = 'X';
				}
				
				System.out.println(this.toString());
				checkWin();
			}
		}
	
	
	public void checkWin(){
		for (int r = 0; r < 3; r++){ // ----> check
			int tempSumX = 0;
			int tempSumO = 0;

			for (int c = 0; c < 3; c++){
				if (getP(r,c) == 'X') {
					tempSumX++;
				}
				if (getP(r,c) == 'O') {
					tempSumO++;
				}
			}
			
			if (tempSumX  == 3) {
				System.out.println("X won");
				System.exit(0);

			}
			if (tempSumO  == 3) {
				System.out.println("O won");
				System.exit(0);

			}
			
		}
		for (int c = 0; c < 3; c++){ // horiz check
			int tempSumX = 0;
			int tempSumO = 0;

			for (int r = 0; r < 3; r++){
				if (getP(r,c) == 'X') {
					tempSumX++;
				}
				if (getP(r,c) == 'O') {
					tempSumO++;
				}
			}
			
			if (tempSumX  == 3) {
				System.out.println("X won");
				System.exit(0);

			}
			if (tempSumO  == 3) {
				System.out.println("O won");
				System.exit(0);

			}
			
		}
		
		//choosing 4 if statments instead of compound 2 if statments for readability
		if (getP(0,0) == 'X' && getP(1,1) == 'X' && getP(2,2) == 'X') {
			System.out.println("X won");
			System.exit(0);
		}
		if (getP(0,2) == 'X' && getP(1,1) == 'X' && getP(2,0) == 'X') {
			System.out.println("X won");
			System.exit(0);
		}
		
		if (getP(0,0) == 'O' && getP(1,1) == 'O' && getP(2,2) == 'O') {
			System.out.println("O won");
			System.exit(0);
		}
		if (getP(0,2) == 'O' && getP(1,1) == 'O' && getP(2,0) == 'O') {
			System.out.println("O won");
			System.exit(0);
		}
	}
		
	private boolean setMove(char in, int r, int c){
		if(r > 3 || r < 1 || c > 3 || c < 1 ) {
			return false;
		}
		if (grid[r-1][c-1] != empty){ 
			return false;
		}
		grid[r-1][c-1] = in;
		return true;
	}
	
	private void getMove(){
		// refractor later
	}
		
	private char getP(int row, int col){
		return grid[row][col];
	}
	
	public void clear(){
		for (int row = 0; row < 3; row++){
			for (int col = 0; col < 3; col++){
				grid[row][col] = empty;
			}
		}
	}
	
	public String toString(){
		String s = "";
		s = s + grid[0][0] + "|" + grid[0][1] + "|" + grid[0][2] + "\n";
		s += "-----\n";
		s = s + grid[1][0] + "|" + grid[1][1] + "|" + grid[1][2] + "\n";
		s += "-----\n";
		s = s + grid[2][0] + "|" + grid[2][1] + "|" + grid[2][2] + "\n";
		return s;
	}

}