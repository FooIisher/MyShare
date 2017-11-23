package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *  所有的员工均在1楼进电梯的时候，选择所要到达的楼层。
 *  然后计算出停靠的楼层i，当到达楼层i的时候，电梯停止。
 *  所有人走出电梯，步行到所在的楼层中。求所有人爬的楼层数目和的最小值。
 *
 *
 *  设置在第i层的人为N2，i层以上的人为N3，i层以下的人为N1，假设在第i层所有人的路径和为T
 *
 *  假设电梯停在i+1层，
 *  原来在第i层以上有N3个人，他们都会少爬一层，那么总路径就减少N3
 *  原来在第i层有N2个人，他们需要多爬一层，那么总路径就加上N2
 *  原来在第i层以下有N1个人，他们需要多往下走一层，那么总路径就增加N1
 *  可以得出换到i+1层后，总路径变为了T+N2+N1-N3
 *
 *  由此我们可以得出当 N3>N1+N2时，总路径会减少
 */
public class Elevator {

    static final int N = 10 ;
    static int person[] = {0, 2, 5 , 7 , 3 , 5 , 2 , 6, 2 , 6 , 3};

    public  static void main(String[] args){
        System.out.print(handler(N,person));
    }

    private static List<Integer> handler(int n, int[] person) {
        List<Integer> result = new ArrayList<>();
        int N1 = 0;
        int N2 = person[1];
        int N3 = 0;
        int T = 0;
        int floor =1;
        //统计N3和T的值
        for(int i=2;i<=n;i++){
            T +=  person[i] * (i-1);
            N3 += person[i];
        }

        for(int i = 2 ;i <= n; i++){
            //向上爬路径会减少
            if(N3 > N1+N2){
                T = T + N2 + N1 - N3;
                N1 += person[i];
                N2 = person[i];
                N3 -= person[i];
                floor = i;
            }else{
                break;
            }
        }
        result.add(floor);
        result.add(T);
        return  result;
    }

}
