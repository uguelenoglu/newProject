package de.doubleslash;


import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.validator.*;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;


public class UiForm extends FormLayout {

	@PropertyId("email")
	private TextField tfShopname;
	

	private TextField tfUrl1 = new TextField("Url");
	private TextField tfUrl2 = new TextField("Url"); 
	private TextField tfUrl3 = new TextField("Url");
	
	
	public UiForm() {
		buildLayout();
	    initLayout();
	}
	
	private void buildLayout(){

		addComponents(tfShopname, tfUrl1, tfUrl2, tfUrl3);
		setSpacing(true);
	    setMargin(true);
		
	}
	
	private void initLayout(){


	      

	 }
	
	
	
	private void buttonClicked() { 

	 }

}
