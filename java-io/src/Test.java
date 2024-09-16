import java.io.*;
import java.util.Arrays;

/**
 * @author CJW
 * @since 2024/8/21
 */
public class Test {
    private static final int[] arr=new int[10];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            arr[i]=i;
        }
        System.out.println(Arrays.toString(arr));
    }
}
