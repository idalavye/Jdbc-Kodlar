package com.proje.insert4;


public class Uygulama4 {

	public static void main(String[] args) {
		
		Personel personel1 = new Personel(107, "�brahim", "Da�delen", 1997, "b151210104");
		
		DBProcesses.savePersonel(personel1);		
	}
		
}