import java.util.ArrayList;

public class Pascal {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<Integer> previousRow = new ArrayList<Integer>();
        ArrayList<Integer> currentRow = new ArrayList<Integer>();
        currentRow.add(1);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(currentRow);
        previousRow = currentRow;
        for (int i=2;i<=numRows;i++)
        {
            //ArrayList<Integer> temp = new ArrayList<Integer>();
            //currentRow = new ArrayList<Integer>(i);
        	int[] temp = new int[i];
            temp[0]=1;
            //currentRow.add(0,1);
            temp[i-1]=1;
            //currentRow.add(i-1,1);
            for(int j=0;j<=i-3;j++)
            {
                //currentRow.add(j+1,previousRow.get(j)+previousRow.get(j+1));
            	temp[j+1] = previousRow.get(j)+previousRow.get(j+1);
            }
            ArrayList<Integer> x = new ArrayList<Integer>();
            //x.addAll(temp);
            for(int k=0;k<temp.length;k++)
            {
            	x.add(temp[k]);
            }
            list.add(x);
            previousRow = x;
            
        }
        
        return list;
    }
    public static void main(String args[])
    {
    	System.out.println(generate(3));
    }
}