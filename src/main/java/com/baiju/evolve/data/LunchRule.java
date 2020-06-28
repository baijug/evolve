package com.baiju.evolve.data;

import java.util.*;

public class LunchRule {
	public static Map<Integer, MenuData> getLunchData() {
		Map<Integer, MenuData> lunchMap = new TreeMap<Integer,MenuData>();
		// sort order, type, description, mandatory?, multipleAllowed?
		lunchMap.put(1, new LunchData(1,"Main","Sandwich",true,false));
		lunchMap.put(2, new LunchData(2,"Side","Chips",true,true));
		lunchMap.put(3, new LunchData(3,"Drink","Soda",false,false));
		return lunchMap;
	}
	
	

}
