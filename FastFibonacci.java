package FasterMethods;

public class FastFibonacci {
	public static void main (String [] args)
	{
		System.out.print(fibDoubling(0)+", ");
		System.out.print(fibDoubling(1)+", ");
		System.out.print(fibDoubling(2)+", ");
		System.out.print(fibDoubling(3)+", ");
		System.out.print(fibDoubling(4)+", ");
		System.out.print(fibDoubling(5)+", ");
		System.out.print(fibDoubling(6)+", ");
		System.out.print(fibDoubling(7)+", ");
		System.out.print(fibDoubling(8)+", ");
		System.out.print(fibDoubling(9)+", ");
		System.out.print(fibDoubling(10)+", ..., ");
		System.out.print(fibDoubling(43));
		System.out.println();

		System.out.print(fibRounding(0)+", ");
		System.out.print(fibRounding(1)+", ");
		System.out.print(fibRounding(2)+", ");
		System.out.print(fibRounding(3)+", ");
		System.out.print(fibRounding(4)+", ");
		System.out.print(fibRounding(5)+", ");
		System.out.print(fibRounding(6)+", ");
		System.out.print(fibRounding(7)+", ");
		System.out.print(fibRounding(8)+", ");
		System.out.print(fibRounding(9)+", ");
		System.out.print(fibRounding(10)+", ..., ");
		System.out.print(fibRounding(43));
		System.out.println();
		
		System.out.print(fibMatrix(0)+", ");
		System.out.print(fibMatrix(1)+", ");
		System.out.print(fibMatrix(2)+", ");
		System.out.print(fibMatrix(3)+", ");
		System.out.print(fibMatrix(4)+", ");
		System.out.print(fibMatrix(5)+", ");
		System.out.print(fibMatrix(6)+", ");
		System.out.print(fibMatrix(7)+", ");
		System.out.print(fibMatrix(8)+", ");
		System.out.print(fibMatrix(9)+", ");
		System.out.print(fibMatrix(10)+", ..., ");
		System.out.print(fibMatrix(43));
	}
	
	public static int fibDoubling(int place)
	{
		//this method removes redundant calculations from 
			//the matrix method for fibonacci
		//F(2K)=(F(K) * (2 * F(K+1)-F(K)))
		//F(2K+1)=(F(K+1)^2 + F(K)^2)
		int output=0;
		int k=place/2;
		if(place <= 0)
			return 0;
		else if(place <= 2)
			return 1;
		
		if(place%2==0)
		{
			output = (fibDoubling(k) * (2 * fibDoubling(k+1)-fibDoubling(k)));
		}
		else
		{
			output = (int)(Math.pow(fibDoubling(k+1),2) + Math.pow(fibDoubling(k), 2));
		}
		
		return output;
	}
	
	public static int fibRounding(int place)
	{
		//runs in O(1)
		double sqrt5 = Math.sqrt(5);
		double phi = (sqrt5+1)/2;
		return (int)Math.round(Math.pow(phi, place)/sqrt5);
	}

	public static int fibMatrix(int place) {
		
		//[11]^n=[f(n+1)  f(n)]
		//[10]   [f(n)  f(n-1)]
		int[] matrix = {1, 1, 1, 0};
		if(place<=0)
			return 0;
		else if(place<=2)
			return 1;
		return matrixPow(matrix, place)[1];
	}
	
	public static int[] matrixPow(int[] matrix, int place) 
	{
		if (place < 0)
			throw new IllegalArgumentException();
		int[] result = {1, 0, 0, 1};
		while (place != 0) {  // Exponentiation by squaring
			if (place % 2 != 0)
				result = matrixMultiply(result, matrix);
			place /= 2;
			matrix = matrixMultiply(matrix, matrix);
		}
		return result;
	}
	
	public static int[] matrixMultiply(int[] a, int[] b) 
	{
		return new int[] {
			(a[0]* b[0])+(a[1]* b[2]),
			(a[0]* b[1])+(a[1]* b[3]),
			(a[2]* b[0])+(a[3]* b[2]),
			(a[2]* b[1])+(a[3]* b[3])};
	}
}
