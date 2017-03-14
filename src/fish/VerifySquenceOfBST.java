package fish;

import java.util.Arrays;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * @author fish
 *
 */
public class VerifySquenceOfBST {

	public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length>2){
        	int root = sequence[sequence.length-1];
            int mid = sequence.length-1;
    		for(int i=0;i<sequence.length;i++){
            	if(sequence[i]>root){
            		mid=i;
            		break;
            	}
            }
    		
    		for(int i=mid;i<sequence.length-1;i++){
    			if(sequence[i]<root){
    				return false;
    			}
    		}
      
    		
    		if(mid==0){
    			int[] right =Arrays.copyOfRange(sequence, mid, sequence.length-1);
    			return verifySquenceOfBST(right);
    		}else if(mid ==sequence.length-1){
    			int[] left = Arrays.copyOfRange(sequence, 0, mid);
        		return verifySquenceOfBST(left);
        		
    		}else{
    			int[] left = Arrays.copyOfRange(sequence, 0, mid);
        		int[] right =Arrays.copyOfRange(sequence, mid, sequence.length-1);
        		return verifySquenceOfBST(left)&&verifySquenceOfBST(right);
    		}
    		
    		
        	
        }else{
        	if(sequence.length==0){
        		return false;
        	}
        	return true;
        }
        
        
    }
	
	public static void main(String[] args){
		int[] nums ={4,6,7,5 };
		System.out.println(verifySquenceOfBST(nums));
	}

}
