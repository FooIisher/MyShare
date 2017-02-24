package fish;

import java.util.ArrayList;
import java.util.List;

public class SubStringTest {

	public static void main(String[] args) {

		List<String> hander = new ArrayList<String>();
		for(int i=0;i<1000;i++){
			HugeStr hugeStr = new  HugeStr();
			ImproveStr improveStr = new ImproveStr();
			hander.add(hugeStr.getSubString(1,5));
			hander.add(improveStr.getSubString(1,5));
		}

	}
	
	static class HugeStr{
		private String str = new String(new  char[800000]);
		public String getSubString(int i, int j) {
			return str.substring(i, j);
		}
		
	}
	
static class ImproveStr{
	private String str = new String(new  char[100000000]);
	public String getSubString(int i, int j) {
		return new String(str.substring(i, j));
	}
		
	}

}
