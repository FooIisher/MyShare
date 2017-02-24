package fish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 
 * 
 */

public class Drink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List list = new ArrayList();
		while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            list.add(n);
        }
		
		for(int i=0;i<list.size();i++){
			System.out.println(drink(Integer.parseInt(list.get(i).toString())));
		}
	}
	
	public static int drink(int num){
		int drink = num;
		int change = 0;
		while(num>2){
			drink=drink+num/3;
			change = change + num/3;
			num = num/3 + num % 3;
			
		}
		if(num==2)
			change = change + 1;
			drink=drink+1;
			
		return change;
		
	}

}
