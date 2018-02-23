package fish;

import java.util.Scanner;

/**
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18 
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 * 连续数的个数  >L
 * 如 输入9 3
 * 输出 2 3 4 
 * 
 * @author fish
 *	
 *	这道题目主要是用了连续求和对称的性质去处理
 *	比如  1 2 3 4 5  的和  我将其看做 5个 3 相加
 *  比如  2 3 4 5 6 7 8 的和 可以看做   3个 4+5的和  
 *  根据这个思路来N进行划分
 *  
 */
public class SerialSum {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		while(sc.hasNext()){
			int N = sc.nextInt();
			int L = sc.nextInt();
			System.out.print(handler(N,L));
		}
		sc.close();

	}

	private static String handler(int sum, int num) {
		String result = "No";
		for(int i=num;i<=100;i++){
			if(i%2==0){
				if(sum%(i/2)==0&&(sum/(i/2))%2==1){
					StringBuffer sb = new StringBuffer();
						int start = (sum/(i/2) -1)/2 -(i/2-1);
					
						for(int j=0;j<i;j++){
							sb.append( start+j + " ");
						}
						return sb.toString().trim();
				
				}
			}else{
				if(sum%i==0){
					StringBuffer sb = new StringBuffer();
					int start = sum/i -i/2;
					
					for(int j=0;j<i;j++){
						sb.append( start+j + " ");
					}
					return sb.toString().trim();
				
				}
			}
		}
		return result;
	}

}
