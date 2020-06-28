package com.baiju.evolve.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.baiju.evolve.data.LunchRule;
import com.baiju.evolve.data.MenuData;
import com.baiju.evolve.data.SpecialData;

@Component
public class LunchService extends MenuService  {
	@Override
    public String getType() {
        return "Lunch";
    }
	
	@Override
    public String process(String menuValue) {
		Map<Integer,Integer> inputMap = normalizeInput(menuValue);
		Map<Integer, MenuData> lunchData = LunchRule.getLunchData();
		// sort order, type, description, should be added mandatory?, NO USE YET..
		SpecialData specialData = new SpecialData(3, "Drink", "Water", false, false);
		
		return processMenu(lunchData, inputMap, specialData);
	}
    
}
