package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

public class _17电话号码的字母组合_String数组 {
    List<String> result = new ArrayList<String>();
    //在构造一个存储过程情况
    StringBuilder list = new StringBuilder();
    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == null) {
            return result;
        }
        //初始化数组，数字匹配，因此加两个空值
        String numButton [] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTrack(digits,numButton,0);
        return result;
    }

    /**
     *
     * @param digits
     * @param numButton
     * @param startIndex
     */
    private void backTrack(String digits, String[] numButton, int startIndex) {
        if (startIndex == digits.length()){
            result.add(list.toString());
            return;
        }
        //获取对应数字字符对应的字符情况，进行排列组合
        String str = numButton[digits.charAt(startIndex) - '0'];
        for (int i = 0;i<str.length();i++){
            list.append(str.charAt(i));
            backTrack(digits,numButton,startIndex++);
            list.deleteCharAt(list.length() - 1);   //认为每次剔除最后一个
        }
    }
}
