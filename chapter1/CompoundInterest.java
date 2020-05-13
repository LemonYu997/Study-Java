//1.9 多维数组
package chapter1;

//计算复利，列表
public class CompoundInterest {
    public static void main(String[] args) {
        //final 定义常数
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        //设置6种利率 10% 11% 12% 13% 14% 15%
        double[] interestRate = new double[NRATES];
        for (int j = 0; j < interestRate.length; j++) {
            interestRate[j] = (STARTRATE + j) / 100.0;
        }

        //创建余额的多维数组
        double[][] balances = new double[NYEARS][NRATES];

        //初始化余额为10000
        for (int j = 0; j < balances[0].length; j++) {
            balances[0][j] = 10000;
        }

        //计算之后几年的利率
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                //先得到去年的余额
                double oldBalance = balances[i - 1][j];

                //计算利率
                double interest = oldBalance * interestRate[j];

                //计算今年的余额
                balances[i][j] = oldBalance + interest;
            }
        }

        //打印利率行
        for (int j = 0; j < interestRate.length; j++) {
            System.out.printf("%9.0f%%", 100 * interestRate[j]);
        }
        //打印一个空行
        System.out.println();

        //打印余额表
        //for each 嵌套处理多维数组所有元素
        for (double[] row : balances) {
            for (double b: row) {
                System.out.printf("%10.2f", b);
            }

            System.out.println();
        }
    }
}


