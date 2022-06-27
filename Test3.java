import java.util.*;
import java.math.*;
import java.util.ArrayList;

public class Test3 {
    static ArrayList<Character> numbs = new ArrayList<>();   //ArrayList Char
    public static void main(String[] args){
        int sum = 0;
        BigInteger fact = fact(100);
        String numS = fact.toString();        //Char to String
        for (int i = 0; i < numS.length(); i++) {
           char numsC =  numS.charAt(i);
           numbs.add(numsC);        //each element to ArrayList
        }
       for(int x = 0;x < numbs.size();x++){
           int r = Character.getNumericValue(numbs.get(x));
           sum+=r;                  //Sum of the ArrayList numbs
       }
       System.out.println(sum);
    }

    private static BigInteger fact(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));  // calculating the factorial
        return result;
    }


}
