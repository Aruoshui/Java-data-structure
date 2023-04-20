package 测试.hafuman;

public class HTNode implements Comparable<HTNode>{

    //这里做了修改，因为在全局变量code里，编码是采用String类型的，所以这里做修改
    public enum Code{
        ZERO("0"), ONE("1");
        private String code;
        private Code(String c){
            this.code = c;
        }
        public String getCode(){
            return code;
        }
    }

    /**
     *  哈夫曼树的叶子结点数据
     */
    private char data ;

    /**
     * 结点的编码，只有0和1两种可能
     */
    private String code="";

    private double weight;
    private HTNode lchild;
    private HTNode rchild;

    public HTNode(double weight) {
        this.weight=weight;
    }
    public HTNode() {
    }
    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public HTNode getLchild() {
        return lchild;
    }
    public void setLchild(HTNode lchild) {
        this.lchild = lchild;
    }
    public HTNode getRchild() {
        return rchild;
    }
    public void setRchild(HTNode rchild) {
        this.rchild = rchild;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public int compareTo(HTNode o) {
        if(this.weight<o.weight){
            return -1;
        }else{
            return 1;
        }
    }
}
