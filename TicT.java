import java.util.*;

public class TicT{
	public static void main(String[] args){
		//System.out.println("Welcome to tictactaco");
		Board gameOne = new Board();
		//System.out.println(gameOne);
		Scanner scan = new Scanner(System.in);
		System.out.println("How many players?");
		int players = scan.nextInt();
		gameOne.play();
		
	}
}