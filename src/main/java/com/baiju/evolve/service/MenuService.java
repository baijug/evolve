package com.baiju.evolve.service;

import java.util.*;

import com.baiju.evolve.data.MenuData;
import com.baiju.evolve.data.SpecialData;

public abstract class MenuService {
	public abstract String getType();
	public abstract String process(String menuValue);
	
	public Map<Integer,Integer> normalizeInput(String menuValue) {
		if (menuValue == null || menuValue.contentEquals("")) {
			return null;
		}
		//NOT performing any validation here except null check 
		List<String> items = Arrays.asList(menuValue.split("\\s*,\\s*"));
		Map<Integer,Integer> menuMap = new HashMap<Integer,Integer>();
		
		for (String str : items) {
			Integer key = Integer.parseInt(str);
			if (menuMap.containsKey(key)) {
				menuMap.put(key, (menuMap.get(key)+1) );
			} else {
				menuMap.put(key, 1 );
			}
		}
		
		return menuMap;
	}
	
	public String processMenu(Map<Integer, MenuData> menuMap, Map<Integer,Integer> inputMap, SpecialData specialData) {
		
		StringBuffer errorMsg = new StringBuffer();
		StringBuffer validMsg = new StringBuffer();
		boolean isValid = true;
		
		for (Map.Entry<Integer, MenuData> entry : menuMap.entrySet()) {
			Integer menuKey = entry.getKey();
			MenuData menuData = entry.getValue();
			System.out.println("menuKey = "+menuKey+"|type = "+menuData.getType());
			
			// --- V A L I D A T I O N      S T A R T --------
			//Check if the mandatory values are present
			if (menuData.isMandatory()) {
				if (inputMap == null || !inputMap.containsKey(menuKey)) {
					isValid = false;
					errorMsg.append(menuData.getType()).append(" is missing, ");
				}
			}
			//check if invalid multiple items are ordered
			if (!menuData.isMultipleAllow()) {
				if (inputMap != null && inputMap.containsKey(menuKey)) {
					if (inputMap.get(menuKey).intValue() > 1) {
						isValid = false;
						errorMsg.append(menuData.getDescription()).append(" cannot be ordered more than once, ");
					}
				}
			}
			// --- V A L I D A T I O N      E N D --------
			
			//Collect valid messages
			if (isValid && inputMap != null && inputMap.containsKey(menuKey)) {
				validMsg.append(menuData.getDescription());
				if (inputMap.get(menuKey).intValue() > 1) {
					validMsg.append('(').append(inputMap.get(menuKey).intValue()).append(')');
				}
				validMsg.append(", ");
			}
			// PROCESS special case. For case when its to be added only when not found .. isOptional = true
			//		OR simply add it if NOT isOptional = false.
			//		you can make a long complex if statement or just break it up for clarity .. Simple :)
			if (isValid && specialData != null && menuKey.equals(specialData.getOrder())) {
				if (specialData.isMandatory() || (!specialData.isMandatory() && inputMap != null && !inputMap.containsKey(menuKey)) ) {
					validMsg.append(specialData.getDescription()).append(", ");
				}
			}
			
			
		}
		//chop-off the last comma -- the elegant way would be to avoid adding comma for the last item
		String returnMsg = "";
		if (isValid) {
			returnMsg = validMsg.substring(0, validMsg.length()-2);
		} else {
			returnMsg = "Unable to process: " + errorMsg.substring(0, errorMsg.length()-2);
		}
			
		System.out.println("returnMsg = "+returnMsg);
		
		return returnMsg;
	}
	
}
