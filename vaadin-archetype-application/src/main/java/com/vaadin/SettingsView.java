package com.vaadin;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SettingsView extends VerticalLayout implements View{
	
	private String name;
	
	private TextField email = new TextField("Your email: ");
	private TextField username = new TextField("Your username: ");
	
	private Button save = new Button("Save changes");
	private Button cancel = new Button("Cnacel changes");
	private Button recipes = new Button("Your recipes");
	
	
	public SettingsView() {
		
		addComponents(save,cancel, recipes);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
