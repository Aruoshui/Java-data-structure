package LeetCode.简单题.第二天;

public class 回文数 {
    public static boolean isPalindrome(int x) {


        //return new StringBuffer(Integer.toString(x)).reverse().toString().equals(String.valueOf(x));

        if(x<0)
            return false;
        int rem=0,y=0;
        int quo=x;
        while(quo!=0){
            rem=quo%10;
            y=y*10+rem;
            quo=quo/10;
        }
        return y==x;



    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

}
