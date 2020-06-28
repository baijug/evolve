package com.baiju.evolve.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.baiju.evolve.data.MenuData;
import com.baiju.evolve.data.SpecialData;
import com.baiju.evolve.data.BreakfastRule;

@Component
public class BreakfastService extends MenuService  {
	
	@Override
    public String getType() {
        return "Breakfast";
    }
	
	@Override
    public String process(String menuValue) {
		Map<Integer,Integer> inputMap = normalizeInput(menuValue);
		Map<Integer, MenuData> breakfastData = BreakfastRule.getBreakfastData();
		// sort order, type, description, should be added mandatory?, NO USE YET..
		SpecialData specialData = new SpecialData(3, "Drink", "Water", false, false);
		
		return processMenu(breakfastData, inputMap, specialData);
	}
    
}
