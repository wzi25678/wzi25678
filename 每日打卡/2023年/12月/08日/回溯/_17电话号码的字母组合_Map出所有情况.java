package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17电话号码的字母组合_Map出所有情况 {
    List<String> result = new ArrayList<String>();
    //构造一个String类去存储每一个子集,考虑到String使用有限，我们采用sb
    StringBuilder subSets = new StringBuilder();
    //对于本题，还要绘制一个phoneButtonMap
    Map<Character,String> phoneButtonMap = new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
    }};
    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        //判断非空，然后进入递归
        if (digits == null||digits.length() == 0   ){
            return result;
        }
        bactTrack(digits,0,subSets);
        return result;
    }

    /**
     *
     * @param digits
     * @param startIndex
     * @param subSets
     */
    private void bactTrack(String digits, int startIndex, StringBuilder subSets) {
        //先给出终止条件，在写进去回溯情况
        if (startIndex == digits.length()){
            result.add(subSets.toString());
            return;
        }
        //获取字符，然后对字符里面的每一个数都去尝试一下
        char dight = digits.charAt(startIndex);
        StringBuilder stringBuilder = new StringBuilder(phoneButtonMap.get(dight));
        for (int i=0;i<stringBuilder.length();i++){
            //获取Map对应的每一个字符组成一种情况,先加入到subSets列表
            subSets.append(stringBuilder.charAt(i));
            bactTrack(digits,startIndex+1,subSets);
            subSets.deleteCharAt(subSets.length()-1);
            //最后通过递归，再删除尾部节点
        }
    }
}
