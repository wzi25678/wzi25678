package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17电话号码的字母组合_回溯模拟 {
    List<String> result = new ArrayList<String>();
    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        // TODO key存储字符数字，value存储对应的英文字母
        Map<Character,String> phoneMap = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        backTrack(result,phoneMap,digits,0,new StringBuffer());
        return result;
    }

    /**
     *
     * @param result
     * @param phoneMap
     * @param digits
     * @param startIndex
     * @param list
     */
    private void backTrack(List<String> result, Map<Character, String> phoneMap, String digits, int startIndex, StringBuffer list) {
        if (startIndex == digits.length()){
            result.add(list.toString());
            return;
        }
        //获取对应数字字符对应的字符情况，进行排列组合
        char curDigit = digits.charAt(startIndex);
        String transLetter = phoneMap.get(curDigit);
        for (int i=0;i<transLetter.length();i++){
            list.append(transLetter.charAt(i));
            backTrack(result, phoneMap, digits,startIndex+1,list);  //每个元素用一次，使用完了之后，就删除当前的值
           // list.deleteCharAt(startIndex);
            list.deleteCharAt(list.length() - 1);   //认为每次剔除最后一个
        }
    }
}
