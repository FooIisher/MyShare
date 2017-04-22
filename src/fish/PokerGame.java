package fish;
/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....
 * LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ���� 
 * ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 * @author fish
 *
 */
public class PokerGame {

	 public static boolean isContinuous(int [] numbers) {
			if(numbers==null&&numbers.length!=5){
	            return false;
	        }
	        
	        int[] tempTimes = new int[14];
	        int max = 0;
	        int min = 14;
	        for(int number:numbers){
	            if(number==0){
	                continue;
	            }
	            tempTimes[number]++;
	            if(number>max){
	                max = number;
	            }
	            if(number<min){
	                min = number;
	            }
	        }
	        
	        for(int i=1;i<tempTimes.length;i++){
	            if(tempTimes[i]>1){
	                return false;
	            }
	        }
	        
	        if(max-min<5){
	            return true;
	        }
	        return false;
	    }
	 
	public static void main(String[] args){
		int[] numbers = {3,0,0,0,0};
		System.out.print(isContinuous(numbers));
	}
}
