package 类与对象.递归.递归的基础概念;


//递归就是方法自己调用自己，每次调用时传入不同的变量。    recursion(递归)
public class 递归的基础调用 {
    public static void main(String[] args) {
        /*
        打印问题
         */
        Recursion recursion=new Recursion();
        recursion.test(10);

        System.out.println(recursion.factorial(10));


        /*
        阶乘问题
         */


    }
}
class Recursion{
    public  void test(int n){  //void 每次递归调用后都要返回前一个，再执行前一个的方法内容

        /*  if(n>=2){
               test(n-1);
            }else{
               System.out.println("n="+n);
            }

       */

        if(n>=2){
            test(n-1);   //递归调用,反复开栈
        }
        System.out.println("n="+n);   //如同羽毛球筒，放的时候一个一个放，想拿出最前面的一个时，要把其他的也一并拿了
    }

    public int  factorial(int n){
        if(n==1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }

}
