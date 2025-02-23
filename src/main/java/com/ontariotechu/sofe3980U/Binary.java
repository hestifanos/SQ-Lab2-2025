package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}
	
		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		// uncomment the following code
		/*
		if (this.number.isEmpty()) { // replace empty strings with a single zero
			this.number = "0";
		}
  		*/
	}
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	public static Binary subtract(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int borrow=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || borrow!=0) // loop until all digits are processed
		{
			int diff=borrow; // previous borrow
			if(ind1>=0){ // if num1 has a digit to subtract
				diff += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to diff
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to subtract
				diff -= (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and subtract it from diff
				ind2--; //update ind2
			}
			if(diff<0) // if the result is negative
			{
				diff+=2; // add 2 to the result
				borrow=-1; // set the borrow to -1
			}
			else
			{
				borrow=0; // set the borrow to 0
			}
			num3 =( (diff==0)? "0":"1")+num3; //convert diff to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}

	public Binary divide(Binary second){

		int num1 = Integer.parseInt(this.getValue(), 2);
		int num2 = Integer.parseInt(second.getValue(), 2);

		int quotient = num1 / num2;

		return new Binary (Integer.toString(quotient));

	}

	public Binary or(Binary second){

		StringBuilder result = new StringBuilder();
		int len1 = this.getValue().length();
		int len2 = second.getValue().length();
		int maxLength = Math.max(len1, len2);

		// padding the short binary string with leading 0
		String a = "0".repeat(maxLength - len1) + this.getValue();
		String b = "0".repeat(maxLength - len2) + second.getValue();


		// performing or operation.
		for(int i=0; i<maxLength; i++){

			char bitA = a.charAt(i);
			char bitB = b.charAt(i);
			char orResult = (bitA == '1' || bitB == '1') ? '1': '0';
			result.append(orResult);

		}



	    return new Binary(result.toString());
	}


	public Binary and(Binary second){

		StringBuilder result = new StringBuilder();
		int len1 = this.getValue().length();
		int len2 = second.getValue().length();
		int maxLength = Math.max(len1, len2);

		// padding the short binary string with leading 0
		String a = "0".repeat(maxLength - len1) + this.getValue();
		String b = "0".repeat(maxLength - len2) + second.getValue();


		// performing or operation.
		for(int i=0; i<maxLength; i++){

			char bitA = a.charAt(i);
			char bitB = b.charAt(i);
			char orResult = (bitA == '1' && bitB == '1') ? '1': '0';
			result.append(orResult);

		}



	    return new Binary(result.toString());
	}

	public Binary mult(Binary second) {
		int num1 = Integer.parseInt(this.getValue(), 2);
		int num2 = Integer.parseInt(second.getValue(), 2);
	
		int product = num1 * num2;
	
		return new Binary(Integer.toBinaryString(product)); // Ensure it returns a binary string
	}
	

@Override
public boolean equals(Object obj) {
    if (this == obj) return true; // Case 1: If the same object, return true
    if (obj == null || getClass() != obj.getClass()) return false; // Case 2: Null check and class type check
    Binary binary = (Binary) obj; // Case 3: Cast to Binary if obj is not null and of the correct type
    return getValue().equals(binary.getValue()); // Case 4: Compare the internal value field
}



}	
