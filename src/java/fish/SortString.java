package fish;

public class SortString {

	public static void main(String[] args) {

//		String result = sortSring("asdfgh");
//		System.out.println(result);
		System.out.println(findNumberOf1(5));
	}

	private static int findNumberOf1(int i) {
		int sum =0;
		while(i%2!=0){
			sum = sum +i%2;
			i=i>>2;
		}

		return sum;
	}

	private static String sortSring(String string) {
		char[] in = string.toCharArray();
		
		return null;
	}

}
