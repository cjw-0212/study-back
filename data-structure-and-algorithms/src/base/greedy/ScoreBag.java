package base.greedy;

import java.util.Arrays;

/**
 * @author CJW
 * @since 2024/7/30
 */
public class ScoreBag {
    public static void main(String[] args) {
        //每个物品只能选择一次，但可以选择物品的一部分，价值根据选择的重量比例计算，问在限定背包容量下背包中物品的最大价值
        int[] wgt = {10, 20, 30, 40, 50};
        int[] val = {50, 120, 150, 210, 240};
        int cap = 50;
        System.out.println(getResult(wgt, val, cap));
    }

    private static double getResult(int[] wgt, int[] val, int cap) {
        Item[] items = new Item[wgt.length];
        for (int i = 0; i < wgt.length; i++) {
            items[i] = new Item(wgt[i], val[i]);
        }
        //根据单位价值进行排序
        Arrays.sort(items, (o1, o2) -> Double.compare((double) o2.value / o2.weight, (double) o1.value / o1.weight));
        double res = 0;
        //从大到小进行遍历
        for (Item item : items) {
            if (item.weight <= cap) {
                //剩余容量充足整个放入
                res += item.value;
                cap -= item.weight;
            } else {
                //容易不足以放入整个，放入一部分填满然后退出
                res += (double) item.value / item.weight * cap;
                break;
            }
        }
        return res;
    }

    private static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
