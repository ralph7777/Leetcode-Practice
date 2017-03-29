package ralph;

import java.util.Stack;

public class ValidParens {
	
    public static boolean isValid(String s) {
    	/** The String is legal iff every right parenthesis matches its closest left one, regardless 
    	 *  of those already been testified as a pair. Algorithm (Using stack):
	 *  1. Create an empty stack;
	 *  2. Iterate through all char in string, there are two cases:
	 *    1). get a left parenthesis, then push it into stack;
	 *    2). get a right one, then pop out one char of stack to see if they match, return False
	 *	  if they don't match or the stack is empty;  
	 *  3. Check the stack, return False if not empty;
	 *  4. Return True.
	 *  Obviously, the algorithm runs O(n) time, n as length of string.
    	 */ 
    	
        Stack<Character> stk=new Stack<Character>();
        boolean flag=true;
        int len=s.length();
        for (int i=0; i<len; i++) {
        	char c=s.charAt(i);
           	//System.out.println("processing "+i+" "+c);
            if (c=='{' || c=='(' || c=='[') {
                stk.push(c);
                //System.out.println("Push:"+c);
            }
            else {
            	if (stk.empty()) return false;
                switch (c) {
                    case ')' : flag=flag && (stk.pop()=='(');
                    break;
                    case ']' : flag=flag && (stk.pop()=='[');
                    break;
                    case '}' : flag=flag && (stk.pop()=='{');
                    break;
                }
            }
        }
        flag=flag && (stk.empty());
        return flag;
    }

    public static void main(String[] args) {
	String s1="{";
	System.out.println("String "+s1+ " is " +isValid(s1));
    }

}
