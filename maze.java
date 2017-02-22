import java.util.*;

public class maze{
	
	static int path = 0;
	static int m = 4;
	static int n = 4;
	static int [][] maze = new int[m][n];

	public static void main(String[] args) {

		findPath(0,0);
		System.out.println(path);
	}

	public static void findPath(int x, int y){

		if( x<0 || y<0 || x>= m || y >= n )	return;
		if( maze[x][y] == 1  )	return;
		
		if( x == m-1 && n-1 == y ){
			path += 1;
			return;
		}	
		

		maze[x][y] = 1;
		findPath( x, y+1);
		maze[x][y] = 0;

		maze[x][y] = 1;
		findPath( x+1, y);
		maze[x][y] = 0;

		maze[x][y] = 1;
		findPath( x-1 , y);
		maze[x][y] = 0;

		maze[x][y] = 1;
		findPath( x, y-1);
		maze[x][y] = 0;
	}
}