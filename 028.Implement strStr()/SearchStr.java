package ralph;

public class SearchStr {
	
    public int strStr(String haystack, String needle) {
        
    	
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
		// TODO Auto-generated method stub

	}

}
