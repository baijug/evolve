package com.baiju.evolve.data;

import java.util.*;

public class DinnerRule {
	public static Map<Integer, MenuData> getDinnerData() {
		Map<Integer, MenuData> dinnerMap = new TreeMap<Integer,MenuData>();
		// sort order, type, description, mandatory?, multipleAllowed?
		dinnerMap.put(1, new DinnerData(1,"Main","Steak",true,false));
		dinnerMap.put(2, new DinnerData(2,"Side","Potatoes",true,false));
		dinnerMap.put(3, new DinnerData(3,"Drink","Wine",false,false));
		dinnerMap.put(4, new DinnerData(4,"Desert","Cake",true,false));
		return dinnerMap;
	}
}
