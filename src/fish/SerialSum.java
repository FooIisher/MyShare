package fish;

import java.util.Scanner;

/**
 * 求一个数N中是那个几个连续数的和
 * 连续数的个数  >L
 * 如 输入9 3
 * 输出 2 3 4 
 * @author fish
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
		for(int i=num;i<100;i++){
			if(i%2==0){
				if(sum%(i/2)==0&&(sum/(i/2))%2==1){
					StringBuffer sb = new StringBuffer();
						int start = (sum/(i/2) -3)/2;
						if(start>0){
							for(int j=0;j<i;j++){
								sb.append( start+j + " ");
							}
							return sb.toString().trim();
					}
				}
			}else{
				if(sum%i==0){
					StringBuffer sb = new StringBuffer();
					int start = sum/i -i/2;
					if(start>0){
						for(int j=0;j<i;j++){
							sb.append( start+j + " ");
						}
					return sb.toString().trim();
					}
				}
			}
		}
		return result;
	}

}
