package fish;

/**
 * ���ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 * ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,
 * Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,
 * ��������һ��С���ѿ�ʼ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,
 * ���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
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
