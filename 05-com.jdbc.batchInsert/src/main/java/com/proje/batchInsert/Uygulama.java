package com.proje.batchInsert;

import java.util.ArrayList;
import java.util.List;

public class Uygulama {
	
	public static void main(String[] args) {
		
		Personel personel1 = new Personel(110, "ibrahim", "Da�delen", 1997, "b151210104");
		Personel personel2 = new Personel(111, "ibrahim", "Da�delen", 1997, "b151210104");
		Personel personel3 = new Personel(112, "ibrahim", "Da�delen", 1997, "b151210104");
		Personel personel4 = new Personel(113, "ibrahim", "Da�delen", 1997, "b151210104");
		Personel personel5 = new Personel(114, "ibrahim", "Da�delen", 1997, "b151210104");
		
		List<Personel> personels = new ArrayList<>();
		
		personels.add(personel1);
		personels.add(personel2);
		personels.add(personel3);
		personels.add(personel4);
		personels.add(personel5);
		
		DBProcesses.saveListPersonel(personels);
	}

}
