public class Main 
{

	public static void main(String args[])
	{
		int grid[][] = new int[9][9];
		int i = 0;   //Variable to be used only for the iteration purposes.
		int j = 0;
		for(i = 0; i<9; i++)
		{
			j=0;
			while(j != 9)
			{
				int flag = 0;
				int key = (int) (9*Math.random() + 1);
				for(int k=0; k<9; k++)
				{
					//row check
					if(key == grid[i][k])     
					{
						flag = 1;
						break;
					}
					//column check
					if(key == grid[k][j])
					{
						flag = 1;
						break;
					}
					//box check
					for(int x = (j/3)*3; x < ((j/3)*3)+3; x++)
						for(int y = (i/3)*3; y < ((i/3)*3)+3; y++)
							if(key == grid[x][y])
							{
								flag = 1;
								break;
							}
				}
				if(flag == 0)
				{
					grid[i][j] = key;
					System.out.print(grid[i][j]+" ");
					j++;
				}
			}
			System.out.println("");
		}
	}
}