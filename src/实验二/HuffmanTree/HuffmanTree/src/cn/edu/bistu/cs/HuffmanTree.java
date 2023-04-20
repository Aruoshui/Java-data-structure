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

			nodes.add(parent);
			//处理之前的节点
			nodes.remove(leftNode);
			nodes.remove(rightNode);

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
//	public static Map<Character, String> getCode(HTNode tree){
//		//
//		String s = "";
//		code = new HashMap<>();
//
////		for (int i = 0; i <10 ; i++) {
//
//			if(tree.getData() =='\0'){
//				if (tree.getLchild() != null){
//					HTNode.Code c = HTNode.Code.ZERO;
//					s = s.concat("0");
//					tree = tree.getLchild();
//					//s.concat(String.valueOf(tree.getCode()));
//
//					//getCode(tree.getLchild());
//
//
////					System.out.println(tree.isLeaf());
////					System.out.println(s);
////					System.out.println(tree.getData());
////					continue;
//				} else if (tree.getRchild() != null) {
//					//s.concat("1");
//					HTNode.Code c = HTNode.Code.ONE;
//					//tree.setCode(HTNode.Code.ONE);
//					s = s.concat("1");
//					tree = tree.getRchild();
//
//					//getCode(tree.getRchild());
////					System.out.println(s);
////					System.out.println(tree.getData());
////					continue;
//
//				}
//
//			}else {
//				code.put(tree.getData(),s);
//
//			}
//
//
////		}
//		return code;
//	}

//	public static Map<Character, String> getCode(HTNode tree) {
//		String s = "";
//		HashMap<Character, String> code = new HashMap<>(); // 修改HashMap的声明，将键的类型由 HTNode 修改为 Character
//		if (tree.getData() == '\0') {
//			Stack<HTNode> stack = new Stack<>();
//			stack.push(tree);
//			while (!stack.isEmpty()) {
//				HTNode node = stack.pop();
//				if (node.getLchild() != null) {
//					HTNode.Code c = HTNode.Code.ZERO;
//					s = s.concat("0");
//					//System.out.println(s);
//					stack.push(node.getLchild());
//				}
//				if (node.getRchild() != null) {
//					HTNode.Code c = HTNode.Code.ONE;
//					s = s.concat("1");
//					stack.push(node.getRchild());
//				}
//				if (node.getLchild() == null && node.getRchild() == null) { // 添加判断，只有在叶子节点时才将编码加入到HashMap中
//					code.put(node.getData(), s);
//				}
//			}
//		}
//		return code;
//
//	}

//
//	public Map<Character, String> getCode(HTNode tree) {
//		Map<Character, String> code = new HashMap<>(); // 创建一个新的哈希映射，用于存储字符和对应的哈夫曼编码值
//
//		// 如果当前节点不是字符节点，即没有关键字，只有权值
//		if (tree.getData() == '\0') {
//			if (tree.getLchild() != null) {
//				HTNode.Code leftCode = tree.getCode().concat(HTNode.Code.ZERO); // 拼接左子节点的编码
//				tree.getLchild().setCode(leftCode); // 更新左子节点的编码
//				// 递归处理左子节点
//				code.putAll(getCode(tree.getLchild())); // 将左子节点返回的编码映射合并到当前编码映射中
//			}
//			if (tree.getRchild() != null) {
//				Code rightCode = tree.getCode().concat(Code.ONE); // 拼接右子节点的编码
//				tree.getRchild().setCode(rightCode); // 更新右子节点的编码
//				// 递归处理右子节点
//				code.putAll(getCode(tree.getRchild())); // 将右子节点返回的编码映射合并到当前编码映射中
//			}
//		} else {
//			// 如果当前节点是字符节点，则将关键字和哈夫曼编码值放入code中
//			code.put(tree.getData(), tree.getCode().toString()); // 将 Code 类型的编码值转换为字符串并放入哈希映射中
//		}
//
//		return code;
//	}


//	public static Map<Character, String> getCode(HTNode tree){
//		Map<Character, String> codeMap = new HashMap<>();
//		Stack<HTNode> stack = new Stack<>();
//		stack.push(tree); // 将根结点入栈
//
//		while(!stack.isEmpty()){
//			HTNode node = stack.pop(); // 弹出栈顶结点
//			String code = codeMap.getOrDefault(node.getData(), ""); // 获取当前结点对应的编码字符串
//
//			if(node.isLeaf()){ // 遍历到叶子结点时，将字符和对应的编码存入Map中
//				codeMap.put(node.getData(), code);
//			}
//			if(node.getRchild() != null){ // 先将右子树入栈
//				stack.push(node.getRchild());
//				codeMap.put(node.getRchild().getData(), code + "1"); // 将编码字符串加入1并存入Map
//			}
//			if(node.getLchild() != null){ // 再将左子树入栈
//				stack.push(node.getLchild());
//				codeMap.put(node.getLchild().getData(), code + "0"); // 将编码字符串加入0并存入Map
//			}
//		}
//
//		return codeMap;
//	}


	public static Map<Character, String> getCode(HTNode tree) {
		Map<Character, String> codeMap = new HashMap<>();
		Stack<HTNode> nodeStack = new Stack<>();
		Stack<String> codeStack = new Stack<>();
		nodeStack.push(tree);
		codeStack.push("");
		while (!nodeStack.isEmpty()) {
			HTNode node = nodeStack.pop();
			String code = codeStack.pop();
			if (node.isLeaf()) {
				codeMap.put(node.getData(), code);
			} else {
				if (node.getRchild() != null) {
					nodeStack.push(node.getRchild());
					codeStack.push(code + "1");
				}
				if (node.getLchild() != null) {
					nodeStack.push(node.getLchild());
					codeStack.push(code + "0");
				}
			}
		}
		return codeMap;
	}


	/*

1. 我们创建一个空的 `codeMap` 来存储字符编码，以及两个栈：`nodeStack` 来存储哈夫曼树的结点，`codeStack` 来存储相应的编码。
2. 我们将哈夫曼树的根结点压入 `nodeStack`，并将一个空字符串压入 `codeStack`。
3. 当 `nodeStack` 不为空时，我们从 `nodeStack` 中弹出一个结点，以及从 `codeStack` 中弹出其对应的编码。
4. 如果该结点是叶子结点，我们将其字符和编码添加到 `codeMap` 中。
5. 如果该结点不是叶子结点，我们将其右子结点（如果有）压入 `nodeStack`，并将其编码加上 "1" 压入 `codeStack`。然后我们将其左子结点（如果有）压入 `nodeStack`，并将其编码加上 "0" 压入 `codeStack`。
6. 我们重复步骤 3-5，直到 `nodeStack` 为空。
7. 最后，我们返回 `codeMap`。


	 */


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

		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey()+": " + entry.getValue());
			System.out.println("___________________");
		}
		return map;
	}
	
	/**
	 * 使用当前类训练好的huffman编码来对文本进行编码
	 * @return
	 */
	public String encode(String text){
		String then = "";
		for (int i = 0; i < text.length(); i++) {
			then = then.concat(code.get(text.charAt(i)));
		}
		return then;
	}
	
	/**
	 * 使用指定的huffman编码来对文本进行编码
	 * @return
	 */
	public static String encode(String text, Map<Character, String> code){
		String then = "";
		for (int i = 0; i < text.length(); i++) {
			then = then.concat(code.get(text.charAt(i)));
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
		String last = "";
		int i = 0;
		//startsWith() 方法用于检测字符串是否以指定的前缀开始。
		while (text.length() <= 0){
			for (Character character : code.keySet()) {
				if(text.startsWith(code.get(character),i+=code.get(i).length())){
					last = last.concat(String.valueOf(character));
				}

			}
		}
		return last;
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
