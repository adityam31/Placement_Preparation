/*
An string of words is given, the task is to reverse the string using stack.

Input Format:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains a string s of words without spaces.

Output Format:
For each test case ,print the reverse of the string in new line. 
*/

import java.io.*;
import java.util.*;

public class ReverseAStringUsingStack 
{
	public static String reverseString(String str)
	{
		String result = "";
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++)
			stack.push(str.charAt(i));
		
		for(int i = 0; i < str.length(); i++)
			result = result+stack.pop();
		
		return result;
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		while(testCases > 0)
		{
			String input = br.readLine();
			
			System.out.println(reverseString(input));
			
			testCases--;
		}
	}

}
