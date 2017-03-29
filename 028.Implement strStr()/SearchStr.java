package ralph;

public class SearchStr {
	
    public static int strStr(String haystack, String needle) {

	/** In order to find the needle in haystack, we need to make sure every char 
    	 *  in needle matches a char in haystack, in certain sequence. Algorithm:
	 *  1. Iterate through chars in haystack;
	 *  2. Set two pointers, one at the beginning of needle, another at a certain
	 *     position in haystack, compare the two chars at two pointers. 
	 *  3. If chars are the same, move both pointers to next postions.
	 *  4. If first pointer reaches the end of needle, return the start position
	 *     of second pointer; if second pointer reaches the end of haystack,
	 *     return -1;
	 *  5. After iteration through haystack, return -1;
	 *  6. Special case: if needle is a empty string, always return 0.
	 *  The algorithm roughly compares word in every position in haystack. Assume
	 *  haystack.length()=n, needle.length()=m, the algorithm runs O(n*m).
    	 */ 
    	
    	if (needle.equals("")) return 0;
        
        int i,j,k; 
        for (i=0;i<haystack.length();i++) {
            j=0;
            k=i;

            while (haystack.charAt(k)==needle.charAt(j)) {
                j++;
                k++;
                if (j==needle.length()) return i;
                if (k==haystack.length()) return -1;
            }
            
        }
        return -1;
    }
	
    
    
    public static void main(String[] args) {
	String n1="def";
	String h1="abcdef";
		
	System.out.printf("The starting position of %s in %s is %d\n",n1,h1,strStr(h1,n1));
	System.out.printf("The starting position of %s in %s is %d\n",h1,n1,strStr(n1,h1));
    }

}
