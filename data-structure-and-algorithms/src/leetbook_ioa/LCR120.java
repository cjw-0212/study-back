package leetbook_ioa;

import java.util.HashSet;
import java.util.Set;

/**
 * @author CJW
 * @since 2024/7/18
 */
public class LCR120 {
    public int findRepeatDocument1(int[] documents) {
        /*使用hashset取到重复就返回*/
        Set<Integer> set = new HashSet<>();
        for (int document : documents) {
            if (set.contains(document)) {
                return document;
            }
            set.add(document);
        }
        return -1;
    }

    public int findRepeatDocument2(int[] documents) {
        /*利用索引与值的一对多关系进行筛选*/
        int i=0;
        while (i<documents.length){
            if (i==documents[i]){
                //索引与值一致跳过
                i++;
            } else if (documents[i]==documents[documents[i]]) {
                //存在相等值直接返回
                return documents[i];
            }else {
                //将值交换到对应索引下
                int temp=documents[i];
                documents[i]=documents[temp];
                documents[temp]=temp;
            }
        }
        return -1;
    }
}





























