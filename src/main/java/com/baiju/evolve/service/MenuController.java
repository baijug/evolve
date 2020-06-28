package com.baiju.evolve.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baiju.evolve.model.MenuResponse;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/api")
public class MenuController {
	
	@Autowired
	MenuFactory menuFactory;
	
	@GetMapping("/getMenuItems")
	public MenuResponse getMenuResponse(//, defaultValue = "Breakfast 1,2,3"
			@RequestParam(value = "menu") String menu) {
		System.out.println("menu = "+menu);
		
		int indexOfSpace = menu.indexOf(' ');
		String menuType = "";
		if (indexOfSpace > 0) {
			menuType = menu.substring(0, indexOfSpace);
		} else {//Assume no values provided and let it pass
			menuType = menu;
		}
		System.out.println("menuType = "+menuType);
		if (!menuType.equals("Breakfast") || !menuType.equals("Breakfast") ||!menuType.equals("Breakfast")) {
			return new MenuResponse ("Illegal input, please try again");
		}
		
		String menuValue = "";
		if (indexOfSpace > 0) {
			menuValue = menu.substring(indexOfSpace, menu.length());
		}
		menuValue = menuValue.trim();
		System.out.println("menuValue = "+menuValue);
		
		MenuService menuService = MenuFactory.getService(menuType);
		
		MenuResponse mr = new MenuResponse (menuService.process(menuValue));
		System.out.println("return response = "+mr.getResponse());
		return mr;
	}
}
