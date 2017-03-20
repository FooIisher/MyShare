package fish;

import java.util.Scanner;

public class checkMirror {

	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	     int length = in.nextInt();
	     int weith = in.nextInt();
         int[][] map  = new int[length][weith];
       	 for(int i=0;i<weith;i++){
             for(int j =0;j<length;j++){
                 map[i][j] = in.nextInt();
             }
         }
       	 System.out.println(getRoad(map,length,weith));
	 }
	    
	 private static int getRoad(int[][] map, int length, int weith) {
	    for(int i=0;i<weith;i++){
	             for(int j =0;j<length;j++){
//	                  loadRoad(map[i][j]) ;
	             }
	         }
		return -1;
	}

		private static int check(String[] ins){
	        if(ins==null){
	            return 0;
	        }
	        int i=0,j=ins.length-1;
	        while(i<j){
	            if(ins[i].equals(ins[j])){
	                i++;
	                j--;
	            }else{
	                return 0;
	            }
	        }
	        return 1;
	    }

}
