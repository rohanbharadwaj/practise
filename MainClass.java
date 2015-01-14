import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class MainClass {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st=null;
        try
        {    
        st = br.readLine();
        }
        catch(Exception e)
            {
            
        }
        Set<Character> s = new HashSet<Character>();
        for(int i=0;i<st.length();i++)
            {
            if(st.charAt(i)!=' ')
                s.add(st.charAt(i));
        }
        if(s.size()==26)
        {
            System.out.println("pangram");
        	System.out.println(s);
        }
        	else
             System.out.println("not pangram");
        System.out.println(s);
        
    }
}
