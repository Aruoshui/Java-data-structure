package LeetCode.简单题.第四天;

public class 最长公共前缀 {
    class Solution {

       /*
       public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int length = strs[0].length();
            int count = strs.length;
            for (int i = 0; i < length; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < count; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
           }
        */

        public String longestCommonPrefix(String[] strs) {
            String s =strs[0];
            for( String string:strs){
                while (!string.startsWith(s)){
                     if(s.length()==0)return "";
                    //公共前缀不匹配就让它变短！
                    s=s.substring(0,s.length()-1);
                }

            }
            return s;
        }

    }

}


