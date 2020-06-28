package com.baiju.evolve.data;

import java.util.*;

public class BreakfastRule {
	public static Map<Integer, MenuData> getBreakfastData() {
		Map<Integer, MenuData> breakfastMap = new TreeMap<Integer,MenuData>();
		// sort order, type, description, mandatory?, multipleAllowed?
		breakfastMap.put(1, new BreakfastData(1,"Main","Eggs",true,false));
		breakfastMap.put(2, new BreakfastData(2,"Side","Toast",true,false));
		breakfastMap.put(3, new BreakfastData(3,"Drink","Coffee",false,true));
		return breakfastMap;
	}

}
