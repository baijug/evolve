package com.baiju.evolve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import java.util.HashMap;

@Service
public class MenuFactory {
	
	@Autowired
	private List<MenuService> services;
	private static final Map<String, MenuService> myServiceList = new HashMap<>();
	
	@PostConstruct
	public void constructList() {
        for(MenuService service : services) {
        	myServiceList.put(service.getType(), service);
        }
    }
	
	public static MenuService getService(String type) {
		MenuService service = myServiceList.get(type);
        return service;
    }

}
