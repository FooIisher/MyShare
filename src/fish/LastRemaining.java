package fish;

/**
 * 随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 
 * @author fish
 *
 */
public class LastRemaining {

	public static void main(String[] args) {
		System.out.print(solution(5,1));

	}
	
	public static int  solution(int n, int m) {
		int[] numbers =new int[n];
		for(int i=0;i<numbers.length;i++){
			numbers[i] = i;
		}
		
		int start =-1;
		int count =0;
		int step=0;
		while(count>0){
			start++;
			if(start>=n){
				start=0;
			}
			if(numbers[start]==-1){
				continue;
			}
			step++;
			if(step==m){
				numbers[start]=-1;
				step=0;
				count--;
			}
		}
		
		return start;
        
    }

}
