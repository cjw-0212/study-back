package leetbook_ioa;

import javax.swing.plaf.ScrollBarUI;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CJW
 * @since 2024/9/4
 */
public class LCR164 {
    public String crackPassword(int[] password) {
        //初始化字符串数组进行排序
        String[] str = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            str[i] = String.valueOf(password[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder stringBuilder=new StringBuilder();
        for (String s : str) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
