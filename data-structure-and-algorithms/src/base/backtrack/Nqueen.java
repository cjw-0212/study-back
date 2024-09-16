package base.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/26
 */
public class Nqueen {
    public static void main(String[] args) {
        List<List<List<String>>> res = nqueen(10);
        for (List<List<String>> list : res) {
            for (List<String> subList : list) {
                System.out.println(subList.toString());
            }
            System.out.println();
        }
        System.out.println(res.size());
    }

    private static List<List<List<String>>> nqueen(int n) {
        List<List<List<String>>> res = new ArrayList<>();
        List<List<String>> state = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("#");
            }
            state.add(row);
        }
        //主对角线上row+col的值相等，次对角线上row-col的值相等
        //对于n的二维表（以0为起始坐标），row+col的范围为【0，2n-2】，row-col的范围为【-（n-1），n-1】
        //也即是两者的长度相等都为2n-1
        boolean[] line1 = new boolean[2 * n - 1];
        boolean[] line2 = new boolean[2 * n - 1];
        boolean[] colFlag = new boolean[n];
        solveNqueen(0, n, colFlag, line1, line2, state, res);
        return res;
    }

    /**
     * n皇后递归回溯算法
     *
     * @param row   记录已经放了几行的皇后了（根据规则可知每行只能放一个皇后）
     * @param n     需要放置的数量
     * @param colFlag   记录每一列是否已经放置了
     * @param line1 记录主对角线是否已经放置了
     * @param line2 记录次对角线是否已经放置了
     * @param state 棋盘
     * @param res   结果集
     */
    private static void solveNqueen(int row, int n, boolean[] colFlag, boolean[] line1, boolean[] line2,
                                    List<List<String>> state, List<List<List<String>>> res) {
        //放置的行数与总数相同，找到一种方法
        if (row == n) {
            List<List<String>> tempState = new ArrayList<>();
            for (List<String> list : state) {
                tempState.add(new ArrayList<>(list));
            }
            res.add(tempState);
        }
        //遍历列进行放置
        for (int col = 0; col < n; col++) {
            //+n-1将范围放入数组范围内
            int line1Index = row - col + n - 1;
            int line2Index = row + col;
            //如果该列，以及两个对角线都没有放置，则放入皇后
            if (!colFlag[col] && !line1[line1Index] && !line2[line2Index]) {
                state.get(row).set(col, "Q");
                //标记当前位置
                colFlag[col] = line1[line1Index] = line2[line2Index] = true;
                //放置下一行
                solveNqueen(row + 1, n, colFlag, line1, line2, state, res);
                //回溯
                state.get(row).set(col, "#");
                colFlag[col] = line1[line1Index] = line2[line2Index] = false;
            }
        }
    }
}
