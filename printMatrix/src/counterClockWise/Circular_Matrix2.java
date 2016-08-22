package counterClockWise;

import java.io.*;
class Circular_Matrix2
    {
        public static void main(String args[])throws IOException
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the number of elements : ");
            int n=Integer.parseInt(br.readLine());
 
            int A[][]=new int[n][n];
            int k=n*n - 1, x2=n-1, y2=n-1, x1 = 0, y1 = 0;
            // if n is even, last element is at bottom right hand corner, 
            // if n is odd, last element is at top left corner

            
            while(k>=0)
                {
	            	for(int j=y1;j<=y2;j++)
	                {
	                    A[j][x1]=k % 10; // down
	                    k--;
	                }
	            	
                    for(int i=x1 + 1;i<=x2;i++)
                    {
                        A[y2][i]=k % 10; //right
                        k--;
                    }
 
                    
                    for(int j=y2 - 1;j>=y1;j--)
                    {
                        A[j][x2]=k % 10; // up
                        k--;
                    }
                    
                    for(int i=x2 - 1;i>=x1 + 1;i--)
                    {
                        A[y1][i]=k % 10; // left
                        k--;
                    }
                    
 
                 x1++;
                 x2--;
                 y1++;
                 y2--;
                }
   
            /* Printing the Circular matrix */
            System.out.println("The Circular Matrix is:");
            for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                        {
                            System.out.print(A[i][j]+ "\t");
                        }
                 System.out.println();
                }
        }
    }
