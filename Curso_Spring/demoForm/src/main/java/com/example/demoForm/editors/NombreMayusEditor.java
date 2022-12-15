package com.example.demoForm.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		super.setAsText(text);
		setValue(text.toUpperCase().trim());
	}

}