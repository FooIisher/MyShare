package fish;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= "codingfish";
		System.out.println("s1�ĵ�ַ��"+s1.hashCode());
		String s2= "coding";
		System.out.println("s2�ĵ�ַ��"+s2.hashCode());
		String s3= "fish";
		System.out.println("s3�ĵ�ַ��"+s3.hashCode());
		String s4= s2 + s3;
		System.out.println("s4�ĵ�ַ��"+s4.hashCode());
		String s5=  "coding" + "fish";
		System.out.println(s1==s4);
		System.out.println(s1==s5);
	}

}
