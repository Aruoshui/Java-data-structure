package 稀疏数组.三元组;

public class Triple implements Comparable<Triple>{
    int row,colume,value;

    public Triple(int row,int colume,int value){
        if(row>=0&&colume>=0){
            this.colume = colume;
            this.row = row;
            this.value = value;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColume() {
        return colume;
    }

    public void setColume(int colume) {
        this.colume = colume;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Triple(String triple){
        int i = triple.indexOf(','),j = triple.indexOf(',',i+1);   //(1,1,5)
        this.row = Integer.parseInt(triple.substring(1,i));
        this.colume = Integer.parseInt(triple.substring(i+1,j));
        this.value = Integer.parseInt(triple.substring(j+1,triple.length()-1));
    }

    public String toString(){
        return "("+row+","+colume+","+value+")";
    }

    public Triple toSymmetry(){
        return new Triple(this.colume,this.row,this.value);    //返回一个对称位置元素的三元组
    }


    @Override
    public int compareTo(Triple triple) {
        if(this.row==triple.row && this.colume == triple.colume){
            return 0;
        }else {
            return (this.row<triple.row||this.row==triple.row&&this.colume<triple.colume)?-1:1;
        }

    }
}
