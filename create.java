public class create
{
	public static boolean valid(int grid[][],int key,int i,int j)
	{
		int flag = 0;
		for(int k=0; k<9; k++)
		{
			//row check
			if(key == grid[i][k])     
			{
				//flag = 1;
				//System.out.print("aaa");
				return false;
			}
			//column check
			if(key == grid[k][j])
			{
				//flag = 1;
				//System.out.print("bbb");
				return false;
			}
			//box check
			for(int y = (i/3)*3; y < ((i/3)*3)+3; y++)
			{
				
				for(int x = (j/3)*3; x < ((j/3)*3)+3; x++)
					if(key == grid[y][x])
					{
						//flag = 1;
						//System.out.print("ccc");
						return false;
					}
				//if(flag==1)
				//{//System.out.print("ddd");
					//	return false;
				//}
			}
			/*if(flag==1) 
			{	//System.out.print("eee");
				return false;
			}*/
		}
		
		if(flag == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	
	// THIS FUNCTION HELPS IN SOLVING IF ONLY ONE OPTION IS AVAILABLE
	
	
	public static void solve1(int grid[][],int i,int j)
	{
		int flag=0,val=0;
		for(int x=1;x<10;x++)
		if(valid(grid,x,i,j))
				{
					flag++;
					val=x;
				}
		if(flag==1)
			grid[i][j]=val;
			flag=0;
	}
	
	
	
	public static void generate()
	{
		int grid[][] = new int[9][9];
		int i = 0;   //Variable to be used only for the iteration purposes.
		int j = 0;
		for(i = 0; i<9; i++)
			for(j=0; j<9; j++)
				grid[i][j] = 0;			//all values are -1
		
		
		
		int key =0,flag=0;
				
		flag=0;
		int flag2=0;
		for(i = 0; i<3;i++)
		{
			for(j=0;j<9;)
				{
					int x=(int) (9*Math.random() + 1);	
					if(valid(grid,x,i,j))
					{
						grid[i][j] = x;
						//System.out.print("\t"+grid[i][j]+" ");
						j++;
						
					}
					else 
					flag++;
					
					if(flag>10000000)
					{
						System.out.println("next");
						flag2++;
						flag=0;
						j=0;
					}
				if(flag2>1000)
						break;

				}
				if(flag2>1000)
						break;
				for(j=0;j<9;j++)
				System.out.print(grid[i][j]+" ");
		
			System.out.println("");
			
		}
		flag=0;
		for(j=0;j<3;j++)
		{
			for(i=3;i<9;)
			{	int x=(int) (9*Math.random() + 1);	
					if(valid(grid,x,i,j))
					{
						grid[i][j] = x;
						i++;
					}
					else 
					flag++;
				if(flag>1000000)
					{
						System.out.println("next");
						flag2++;
						flag=0;
						i=3;
					}
			}
		}
		
		flag=0;
		flag2=0;
		for(i = 5; i<6;i=i+3)
		{
			for(j=3;j<9;)
				{
					int x=(int) (9*Math.random() + 1);	
					if(valid(grid,x,i,j))
					{
						grid[i][j] = x;
						//System.out.print("\t"+grid[i][j]+" ");
						j++;
						flag=0;
						
					}
					else 
					flag++;
					
					if(flag>10000000)
					{
						System.out.println("next1");
						flag2++;
						flag=0;
						j=3; 	
					}
				

				}
		}
		flag=0;
		for(j=5;j<9;j=j+3)
		{
			for(i=3;i<9;)
			{	int x=(int) (9*Math.random() + 1);	
					if(valid(grid,x,i,j))
					{
						grid[i][j] = x;
						i++;
					}
					else if(grid[i][j]!=0)
						i++;
					else 
					flag++;
				if(flag>1000000)
					{
						System.out.println("next2");
						flag2++;
						flag=0;
						i=3;	
					}
			}
		}
		
		//Solves the alogrithm one by one
		
		for(int x=0;x<10;x++)
		for(i=0;i<9;i++)
			for(j=0;j<9;j++)
				if(grid[i][j]==0)
					solve1(grid,i,j);
				
		//when THERE ARE TWO NOS FILES ONE OF THEM		
				
		for(i=0;i<9;i++)
			for(j=0;j<9;j++)
		    {  int x=(int) (9*Math.random() + 1);	
					if(valid(grid,x,i,j) && grid[i][j]==0)
					{
						grid[i][j] = x;
						j++;
					}
					else if(grid[i][j]!=0)
						j++;
			}
		
		//SOLVES AGAIN AFTER THE RANDOM SOL HAS BEEN PROVIDED
		
		for(int x=0;x<10;x++)
		
		for(i=0;i<9;i++)
			for(j=0;j<9;j++)
				if(grid[i][j]==0)
					solve1(grid,i,j);
		
			
		
		
		
		System.out.println("");	
		
		
	//DISPLAY THE SOLVED SUDOKU	
		
		for(i=0;i<9;i++)
		{
			for(j=0;j<9;j++)
			{
				System.out.print(grid[i][j]+" ");
				if(j==2||j==5)
					System.out.print("| ");
			}
			
		System.out.println("");
		if(i==2||i==5)
					System.out.println("----------------------");	
		}
		
	}	
	public static void main(String args[])
	{
		generate();
	}
}
