package FasterMethods;

public class FastMultiplication {
	public static void main (String [] args)
	{
		System.out.println(12345*12345);
		System.out.println(karatsuba(12345,12345));
		System.out.println(exponentiationBySquaring(12345,2));
	}
	
	public static int karatsuba (int first,int second)
	{
		int output=0;
		int sign=1;
		
		if(first<0)
			sign *= -1;
		if(second<1)
			sign *=-1;
		
		while(first !=0)
		{
			//add second number to output if 1 in lowest bit (rightmost)
			if(Integer.lowestOneBit(first)==1?true:false)
			{
				output+=second;
			}
			//right shift logical the first number 
				//(brings it to 0 in at most 64 moves)
			first>>>=1;
			//left shift second number
				//double the value to be added
			second<<=1;
		}
		output *= sign;
		return output;
	}
	
	public static int exponentiationBySquaring(int number,int power)
	{
		//if power is odd,
			//x^n=x(x^2)^((n-1)/2)
		//if power is even,
			//x^n=x(x^2)^(n/2)
		//if power is 0, return 1
		//if power is 1, return number
		if(power<0)
			return exponentiationBySquaring(1/number,-1*power);
		else if(power==0)
			return 1;
		else if(power==1)
			return number;
		
		if(power%2 == 0)
			return exponentiationBySquaring(number*number, power/2);
		else
			return number*exponentiationBySquaring(number*number, (power-1)/2);
	}
}
