package fish;
/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL����
 * �����и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 * ����XYZdefabc��
 * @author fish
 *
 */
public class LeftRotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String LeftRotateString(String str,int n) {
		int length = str.length();
		if(n==0||str==null||("").equals(str)){
			return str;
		}else{
			StringBuilder sb = new StringBuilder(str.substring(n%length));
			sb.append(str.substring(0, n%length));
			return sb.toString();
		}
		
        
    }
}
