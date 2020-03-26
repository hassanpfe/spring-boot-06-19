package ma.ht.springboot.app;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int numbers[]={1,3,5,7,9,11,13,15};
		
		
		System.out.println(numbers.length);
		List list =new ArrayList<Integer>(2);
		
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		
		
		list.stream().forEach(System.out::println);
		for(int i=0;i<numbers.length;i++) {
			for(int j=0;j<numbers.length;j++) {
				for(int k=0;k<numbers.length;k++) {
					if (numbers[i]+numbers[j]+numbers[k]==30) {
						System.out.println(numbers[i]+" + "+numbers[j]+" + "+numbers[k]+" = 30");
					}
					
				}
			}
		}
		
	}

}
