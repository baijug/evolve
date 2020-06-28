package com.baiju.evolve.data;

public class SpecialData extends MenuData {
	
	public SpecialData(int order, String type, String description, boolean isMandatory, boolean isMultiple) {
		// sort order, type, description, mandatory?, multipleAllowed? -- WE DO NOT HAVE CASE FOR MULTIPLE .. YET
		super(order, type, description, isMandatory, false);
	}

}
