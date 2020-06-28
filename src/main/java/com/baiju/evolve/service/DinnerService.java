package com.baiju.evolve.service;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.baiju.evolve.data.DinnerRule;
import com.baiju.evolve.data.MenuData;
import com.baiju.evolve.data.SpecialData;

@Component
public class DinnerService extends MenuService  {
	@Override
    public String getType() {
        return "Dinner";
    }
	
	@Override
    public String process(String menuValue) {
		Map<Integer,Integer> inputMap = normalizeInput(menuValue);
		Map<Integer, MenuData> dinnerData = DinnerRule.getDinnerData();
		// sort order, type, description, should be added mandatory?, NO USE YET..
		SpecialData specialData = new SpecialData(3, "Drink", "Water", true, false);
		
		return processMenu(dinnerData, inputMap, specialData);
	}
}
