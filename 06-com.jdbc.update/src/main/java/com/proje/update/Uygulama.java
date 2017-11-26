package com.proje.update;



public class Uygulama {
	
	public static void main(String[] args) {
		
		Personel personel = new Personel(101, "Ýbrahim", "Daðdelen", 2012, "b151210104");
		
		personel.setDogumYili(2000);
		
		DBProcesses.updatePersonel(personel);
	}

}
