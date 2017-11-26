package com.proje.search;

import java.util.List;

public class Uygulama {
	
	public static void main(String[] args) {
		
		//System.out.println(DBProcesses.findPersonelById(104));
		
		List<Personel> personels = DBProcesses.findPersonels();
		
		for (Personel personel : personels) {
			System.out.println(personel);
		}
	}

}
