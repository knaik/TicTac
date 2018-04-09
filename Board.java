public class Board{
	private char[][] grid = new char[3][3];
	
		public Board(){
			//System.out.println("board created");
			this.clear();
		}
		
		public void clear(){
			for (int row = 0; row < 3; row++){
				for (int col = 0; col < 3; col++){
					grid[row][col] = '~';
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