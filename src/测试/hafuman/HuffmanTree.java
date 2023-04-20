package 测试.hafuman;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 哈夫曼树实现
 * @author piaow
 */
public class HuffmanTree{

    private Map<Character, String> code = new HashMap<Character,String>();

    /**
     * 根据初始的结点列表，建立哈夫曼树，
     * 反复生成哈夫曼树，每次重新构建树，将更新编码
     * 生成好了哈夫曼树，把生成的树根结点进行返回。
     */
    public HTNode buildTree(List<HTNode> nodes){
        while(nodes.size()>1){
            Collections.sort(nodes);
            HTNode left = nodes.get(0);
            HTNode right = nodes.get(1);
            HTNode parent = new HTNode(left.getWeight()+right.getWeight());
            parent.setLchild(left);
            parent.setRchild(right);
            nodes.add(parent);
            nodes.remove(left);
            nodes.remove(right);
        }
        return nodes.get(0);
    }

    /**
     * 根据已建立的哈夫曼树根结点，生成对应的字符编码，
     * 字符编码应为0，1字符串
     */
    public  Map<Character, String> getCode(HTNode tree) {
        //如果当前结点不是字符结点，即没有关键字，只有权值
        if (tree.getData() == '\0') {
            if (tree.getLchild() != null) {
                //左结点就把0拼接其后
                String j = tree.getCode() + HTNode.Code.ZERO.getCode();
                tree.getLchild().setCode(j);
                //递归左孩子
                getCode(tree.getLchild());
            }
            if (tree.getRchild() != null) {
                //右结点就把1拼接其后
                String k = tree.getCode() + HTNode.Code.ONE.getCode();
                tree.getRchild().setCode(k);
                //递归右孩子
                getCode(tree.getRchild());
            }
        }
        //如果当前结点是字符结点，则放入静态全局变量code中，存储关键字和哈夫曼编码值
        else {
            code.put(tree.getData(), tree.getCode());
        }
        return code;
    }

    /**
     * 获取已建立的哈夫曼树生成的字符编码，
     * 字符编码应为0，1字符串
     */
    public Map<Character, String> getCode(){
        return this.code;
    }

    //统计字符串中字符出现的频率
    public  Map<Character,Integer> computeCharCount(String text){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] ch = text.toCharArray();
        for(char b : ch) {
            if(!map.containsKey(b)) {
                map.put(b, 1);
            }
            else {
                map.replace(b,map.get(b)+1);
            }
        }
        return map;
    }

    /**
     * 使用当前类训练好的huffman编码来对文本进行编码
     */
    public String encode(String text) {
        String sum = "";
        char[] b = text.toCharArray();
        for (char tmp : b) {
            sum += code.get(tmp);
        }
        return sum;
    }

    /**
     * 使用当前类中训练好的huffman编码，
     * 对编码后的文本进行解码
     */
    public String decode(String text) {
        String sum ="";
        while (text.length() > 0) {
            for (Map.Entry<Character, String> e : code.entrySet()) {
                String temp = e.getValue();
                if (text.startsWith(temp)) {
                    sum+=e.getKey();
                    text = text.substring(temp.length());
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args){
        HuffmanTree htree = new HuffmanTree();
        //首先对字符串中的字符出现次数进行统计
        String data = "This paper first presents a new array data structure to represent the Huffman tree. "
                +"The memory required in the proposed data structure is less than the previous methods (Huffman, 1952; Roman, 1992), "
                +"which also use array data structure to store the corresponding Huffman tree, and is the lower bound of the one in (Hashemian, 1995)."
                +" We then present an efficient Huffman decoding algorithm based on the proposed data structure; given a Huffman code, "
                +"the search time for finding the source symbol is O(d), where d denotes the depth of the Huffman tree. "
                +"This time bound is equal to the ones in (Hashemian, 1995; Huffman, 1952; Roman, 1992). "
                + "Some experimentations on real images are carried out to demonstrate the performance of space and search time among our method and the previous ones.";
        //chars 保存了每个字符出现的次数
        Map<Character, Integer> chars = htree.computeCharCount(data);
        ArrayList<HTNode> nodes = new ArrayList<>();
        for(Character c : chars.keySet()){
            HTNode node = new HTNode();
            node.setData(c);
            node.setWeight(chars.get(c));
            node.setLchild(null);
            node.setRchild(null);
            nodes.add(node);
        }
        HTNode tree = htree.buildTree(nodes);
        Map<Character, String> code = htree.getCode(tree);

        for(Character c : code.keySet()){
            System.out.println("字符'"+c+"'的哈夫曼编码："+code.get(c));
        }
        String text = "This paper first presents a new array data structure to represent the Huffman tree.";
        String coded = htree.encode(text);
        System.out.println("字符串：This paper first presents a new array data structure to represent the Huffman tree.");
        System.out.println("被编码为："+coded);
        String oriText = htree.decode(coded);
        System.out.println("被解码为："+oriText);
        System.out.println(oriText.equals(text));
        System.out.println("编码后二进制字节长度:" + coded.length());
        System.out.println("原字符串长度" + text.length()*8);
        System.out.println("压缩率"+coded.length()*1.0/text.length()/8);
    }
}

