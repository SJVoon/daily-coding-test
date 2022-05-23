package solutions.page1;

public class Problem2 {
    /**
     * Problem 2 : Even Fibonacci numbers
     * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
     * By starting with 1 and 2, the first 10 terms will be:
     * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
     * find the sum of the even-valued terms.
     */
    public static void solve(int n){
        int prevFib = 1;
        int currentFib = 2;
        if(n<2){
            System.out.println(0);
            return;
        }
        else if(n==2){
            System.out.println(2);
            return;
        }

        int sum = 0;
        while(currentFib<n){
            if(currentFib%2==0)
                sum += currentFib;
            //store current + previous as answer
            currentFib += prevFib;
            //store current - previous as previous answer
            prevFib = currentFib - prevFib;
        }
        System.out.println(sum);
    }
}
