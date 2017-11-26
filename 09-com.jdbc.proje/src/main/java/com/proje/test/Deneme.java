package com.proje.test;

import java.util.Scanner;

public class Deneme {
	
	public static void main(String[] args) {
		
		int eleman = 0;
		int eleman1453 = -1;
		int kontrol = 0;
		
		for(int i = 0; i!=-1;i++){
			int c = 1;
			
			for(int x = 0; x<=i;x++){
				eleman++;
				
				if(eleman == 1453){
					eleman1453 = c;
					kontrol = 1;
				}
				c = c*(i-x) /(x+1);
			}
			
			if(kontrol !=0) break;
				
		}
		
		if(eleman1453 != -1)
			System.out.println("1453. Eleman :" + eleman1453);
		
	}

}
