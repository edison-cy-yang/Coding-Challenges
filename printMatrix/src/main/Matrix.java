package main;

public class Matrix {
	
	public static int[][] printMatrixOdd(int n) {
		int m[][]=new int[n][n];
		
        int counter=n*n - 1; // last number in the matrix
        int x2 = n-1; // largest possible value for x
        int y2 = n-1; // largest possible value for y
        int x1 = 0;   // smallest possible value for x
        int y1 = 0;   // smallest possible value for y
        
        // n is odd, last element is at top left corner
        // starting from the last element, go down->right->up->left

        
        while(counter >= 0) { // while we have not reached 0, the starting point of the matrix
        	
        	for(int j = y1;j <= y2;j++) {         // down
        		m[j][x1] = counter % 10; 		  // go down along the left "wall"
        		counter--;
        	}

        	for(int i = x1 + 1; i <= x2;i++) {     // right
        		m[y2][i] = counter % 10;           // go right along the bottom "wall"
        		counter--;
        	}


        	for(int j = y2 - 1;j >= y1;j--) {     // up
        		m[j][x2] = counter % 10;          // go up along the right "wall"
        		counter--;
        	}

        	for(int i = x2 - 1;i >= x1 + 1;i--) { // left
        		m[y1][i] = counter % 10;          // go left along the top "wall"
        		counter--;					      // Note: i >= x1 + 1 because the leftmost "wall" is already filled
        	}

        	// After we've gone around a circle, update the smallest and largest possible x and y
        	x1++;
        	x2--;
        	y1++;
        	y2--;
        }		
		return m;
	}
	
	public static int[][] printMatrixEven(int n) {
		int[][] m = new int[n][n];
		
		// n is even, last element starts at bottom right corner
		// starting from the last element, go up->left->down->right
		
		int counter = n*n - 1; // last number in the matrix
        int x2 = n-1; // largest possible value for x
        int y2 = n-1; // largest possible value for y
        int x1 = 0;   // smallest possible value for x
        int y1 = 0;   // smallest possible value for y

        
        while(counter >= 0) { // while we have not reached 0, the starting point of the matrix
        	
            for(int j = y2; j >= y1; j--) {        	// up
                m[j][x2] = counter % 10;         	// go up along the right "wall"
                counter--;
            }
            
            for(int i = x2 - 1;i >= x1; i--) {     	// left
                m[y1][i] = counter % 10;         	// go left along the top "wall"
                counter--;
            }
            
            for(int j = y1 + 1; j <= y2; j++) {    	// down
            	m[j][x1] = counter % 10;         	// go down along the left "wall"
            	counter--;
            }

            for(int i = x1 + 1; i <= x2 - 1; i++) {	// right
            	m[y2][i] = counter % 10;            // go right along the bottom "wall"
            	counter--;							// Note: i <= x2 - 1 because the rightmost "wall" is already filled
            }
            
            // After we've gone around a circle, update the smallest and largest possible x and y
            x1++;
            x2--;
            y1++;
            y2--;
       }		
		return m;
	}

	public static void main(String[] args) {
		
		// n in the n by n matrix
		int n = 3;
		
		int[][] m;
		
		if(n % 2 == 1) {         // If n is odd
			m = printMatrixOdd(n);
		}
		else {                   // If n is even
			m = printMatrixEven(n);
		}
		
		 // print the resulting matrix
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
