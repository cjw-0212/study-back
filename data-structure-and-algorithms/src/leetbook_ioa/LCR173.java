package leetbook_ioa;

/**
 * @author CJW
 * @since 2024/9/11
 */
public class LCR173 {
    public int takeAttendance(int[] records) {
        int i = 0;
        int j = records.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (records[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
