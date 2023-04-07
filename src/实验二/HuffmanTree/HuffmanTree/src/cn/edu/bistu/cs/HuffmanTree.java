package 实验二.HuffmanTree.HuffmanTree.src.cn.edu.bistu.cs;



import java.util.*;

/**
 * 哈夫曼树实现
 * @author chenruoyu
 *
 */
public class HuffmanTree {


	/**
	 * 哈夫曼编码
	 */
	private static Map<Character, String> code = null;
	
	/**
	 * 生成的huffman树根结点
	 */
	private HTNode tree = null;
		
	/**
	 * 根据初始的结点列表，建立哈夫曼树，
	 * 并生成哈夫曼编码，保存在当前类的code对象中，
	 * 生成的树根结点，被保存在当前类的tree对象中。
	 * 可以反复生成哈夫曼树，每次重新构建树，将更新编码
	 * @param nodes
	 * @return
	 */
	public HTNode buildTree(List<HTNode> nodes){
		while (nodes.size()>1){
			//排序
			Collections.sort(nodes);
			//去除权值最小的两个节点
			HTNode leftNode = nodes.get(0);
			HTNode rightNode = nodes.get(1);
			//构建父母节点，并赋权值
			HTNode parent = new HTNode();
			parent.setWeight(leftNode.getWeight()+rightNode.getWeight());
			parent.setLchild(leftNode);
			parent.setRchild(rightNode);
			//处理之前的节点
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		//返回根节点
		return nodes.get(0);
	}
	
	/**
	 * 根据已建立的哈夫曼树根结点，生成对应的字符编码，
	 * 字符编码应为0，1字符串
	 * @param tree
	 * @return
	 */
	public static Map<Character, String> getCode(HTNode tree){
		//
		String s = "";

		//for (int i = 0; i <20 ; i++) {

			while (tree.getData() =='\0'){
				if (tree.getLchild() != null){
					HTNode.Code c = HTNode.Code.ZERO;
					s = s.concat("0");
					tree = tree.getLchild();
					//s.concat(String.valueOf(tree.getCode()));

					System.out.println(s);
					System.out.println(tree.getData());
					continue;
				} else if (tree.getRchild() != null) {
					//s.concat("1");
					
					tree.setCode(HTNode.Code.ONE);
					tree = tree.getRchild();
					s.concat(String.valueOf(tree.getCode()));
					System.out.println(s);
					System.out.println(tree.getData());
					continue;
				}
			}
				code.put(tree.getData(),s);

		//}
		return code;
	}
	
	/**
	 * 获取已建立的哈夫曼树生成的字符编码，
	 * 字符编码应为0，1字符串
	 * @return
	 */
	public Map<Character, String> getCode(){
		return this.code;
	}
	
	
	/**
	 * 统计字符串中字符出现的频率
	 * @param text
	 * @return
	 */
	public static Map<Character,Integer> computeCharCount(String text){
		//利用hashmap建立字符和出现次数的一一对立
		/**
		 * 字符出现频率存储的hashmap
		 */
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			char a = text.charAt(i);
			//比较关键字
			if(map.containsKey(a)){
				//后面加一
				map.put(a, map.get(a) + 1);
			} else {
				//新建map
				map.put(a, 1);

			}
		}
		return map;
	}
	
	/**
	 * 使用当前类训练好的huffman编码来对文本进行编码
	 * @return
	 */
	public String encode(String text){
		String then = null;
		for (int i = 0; i < text.length(); i++) {
			then.concat(code.get(text.charAt(i)));
		}
		return then;
	}
	
	/**
	 * 使用指定的huffman编码来对文本进行编码
	 * @return
	 */
	public static String encode(String text, Map<Character, String> code){
		String then = null;
		for (int i = 0; i < text.length(); i++) {
			then.concat(code.get(text.charAt(i)));
		}
		return then;
	}

	/**
	 * 使用当前类中训练好的huffman编码，
	 * 对编码后的文本进行解码
	 * @param text
	 * @return
	 */
	public String decode(String text){
		String last = null;
		int i = 0;
		//startsWith() 方法用于检测字符串是否以指定的前缀开始。
		while (text.length() <= 0){
			for (Character character : code.keySet()) {
				if(text.startsWith(code.get(character),i+=code.get(i).length())){
					last.concat(String.valueOf(character));
				}

			}
		}
		return null;
	}
	
	public HTNode getTree() {
		return tree;
	}

	/**
	 * 使用预先建立好的huffman树，
	 * 对编码后的文本进行解码
	 * @param text
	 * @return
	 */
	public String decode(String text, HTNode tree){
		getCode(tree);

		return decode(text);
	}
	public static void main(String[] args){
		HuffmanTree htree = new HuffmanTree();
		//首先对字符串中的字符出现次数进行统计
		String data = "In computer science and information theory, "
				+ "a Huffman code is a particular type of optimal prefix code that is commonly used for lossless data compression. "
				+ "The process of finding and/or using such a code proceeds by means of Huffman coding, "
				+ "an algorithm developed by David A. Huffman while he was a Ph.D. student at MIT, and published in the 1952 paper "
				+ "\"A Method for the Construction of Minimum-Redundancy Codes\".[1] "
				+ "The output from Huffman's algorithm can be viewed as a variable-length code table for encoding a source symbol "
				+ "(such as a character in a file). The algorithm derives this table from the estimated probability or frequency of occurrence"
				+ " (weight) for each possible value of the source symbol. As in other entropy encoding methods, more common symbols are generally "
				+ "represented using fewer bits than less common symbols. Huffman's method can be efficiently implemented, "
				+ "finding a code in linear time to the number of input weights if these weights are sorted.[2] However, "
				+ "although optimal among methods encoding symbols separately, Huffman coding is not always optimal among all compression methods.";
		Map<Character, Integer> chars = HuffmanTree.computeCharCount(data);
		ArrayList<HTNode> nodes = new ArrayList<>();
		for(Character c : chars.keySet()){
			HTNode node = new HTNode();
			node.setData(c);
			node.setWeight(chars.get(c));
			node.setLchild(null);
			node.setRchild(null);
			node.setLeaf(true);
			nodes.add(node);
		}
		HTNode tree = htree.buildTree(nodes);
		Map<Character, String> code = HuffmanTree.getCode(tree);
		for(Character c : code.keySet()){
			System.out.println("字符'"+c+"'的哈夫曼编码："+code.get(c));
		}
		String text = "In computer science and information theory";
		String coded = htree.encode(text);
		System.out.println("字符串：In computer science and information theory");
		System.out.println("被编码为："+coded);
		String oriText = htree.decode(coded);
		System.out.println("编码："+coded);
		System.out.println("被解码为："+oriText);
		System.out.println(oriText.equals(text));
	}
	
	
	
}
