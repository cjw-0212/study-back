package base.divideconquer;

/**
 * @author CJW
 * @since 2024/7/25
 */
public class Hanota {
    public static void main(String[] args) {
        solveHanota(3,"A","B","C");
    }

    /**
     * @param num 圆盘数量
     * @param src 起始杆子
     * @param buf 缓冲杆子
     * @param tar 目标杆子
     */
    private static void solveHanota(int num,String src,String buf,String tar){
        if (num == 1) {
            //只要一个盘
            System.out.println("将第"+num+"个圆盘从"+src+"柱放到"+tar+"柱子");
        }else {
            //将问题拆解成三个子问题
            //1、将n-1个盘通过缓冲柱放到换缓冲柱
            solveHanota(num-1,src,tar,buf);
            //2、将最低下那个圆盘放到目标柱
            System.out.println("将第"+num+"个圆盘从"+src+"柱放到"+tar+"柱子");
            //3、将缓冲柱的圆盘通过起始柱放到目标柱
            solveHanota(num-1,buf,src,tar);
        }
    }
}
