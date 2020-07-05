//1.10 不规则数组
package chapter1;

//创建一个三角矩阵 （不规则数组）
public class Test10LotteryArray {
    public static void main(String[] args) {
        final int NMAX = 10;

        //行数
        int[][] odds = new int[NMAX + 1][];
        for (int n = 0; n <= NMAX; n++) {
            //设置每行元素个数，每行比上一行多一个元素
            odds[n] = new int[n + 1];
        }

        //填充三角矩阵
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {

                //计算 n * (n -1) * (n-2) * ... * (n-k+1) / (1*2*3*...*k)
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++) {
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                }
                odds[n][k] = lotteryOdds;
            }
        }

        //输出三角矩阵
        for (int[] row : odds) {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }
}
