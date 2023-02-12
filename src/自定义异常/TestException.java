package 自定义异常;

/**
 * 自定义异常类
 */
class MyException extends Exception {
    //异常信息
    private String message;

    //构造函数
    public MyException(String message){
        super(message);
        this.message = message;
    }

    //获取异常信息,由于构造函数调用了super(message),不用重写此方法
    //public String getMessage(){
    //    return message;
    //}
}

/**
 * 在需要抛出异常的地方使用异常类
 */
 class UseMyException {
    private String name;
    private String password;

    public UseMyException(String name,String password){
        this.name = name;
        this.password = password;
    }

    public void throwException(String password) throws MyException{
        if (!this.password.equals(password)){
            throw new MyException("密码不正确!");
        }
    }
}

/**
 * 测试异常
 */
public class TestException {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
            UseMyException ex = new UseMyException("admin","123");
            try{
                ex.throwException("1234");
            }catch (MyException me){
                System.out.println("MyException:"+me.getMessage());
            }
        }


}
