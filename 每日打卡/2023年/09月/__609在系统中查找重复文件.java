package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class __609在系统中查找重复文件 {
	public List<List<String>> findDuplicate(String[] paths) {
		/**
		 解释题目：
		    题目就是说，给了很多个文件路径（包括文件名），以及文件内容
		    要求你把文件内容相同的文件路径（包括文件名），放在同一个List里。

		 解题思路：
		 List<List<String>>结果
		 要用到HashMap，key去存文件内容，value去存文件路径（包括文件名）

		 然后就是输入的是String[] paths
		 即["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
		 就单个来说，即是root/a 1.txt(abcd) 2.txt(efgh)
		 即空格space表示到头了，1.txt表示文件名       需要split掉()来获取value
		 同时记录到的文件名，都得转换成root/a 1.txt，root/a 2.txt这样的形式
		 */
		HashMap<String,List<String>> map = new HashMap<>();
		for (String path:paths){
			//用空格space进行分隔
			String keyValues[] = path.split(" ");
			int keyValues_Length = keyValues.length;
			//从上图的分析，我们可以知道，keyValues[0]即是对应的value，当然了还不全是，还得加上具体的文件名才行
			//接下来应该分离出具体的单个文件名，以及他们对应的key值，文件名则去组成我们需要的value值。
			for (int i = 1;i<keyValues_Length;i++){
				//                                  split左括号，需要转义
				String [] name_cont = keyValues[i].split("\\(");
				//      root/a 1.txt    abcd 2.txt     efgh
				name_cont[1] = name_cont[1].replace(")","");
				List <String> list = map.getOrDefault(name_cont[1],new ArrayList<String>());
				list.add(keyValues[0]+"/"+name_cont[0]);
				map.put(name_cont[1],list);
			}
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (String key : map.keySet()){
			if (map.get(key).size() > 1){
				res.add(map.get(key));
			}
		}
		return res;
	}
}
