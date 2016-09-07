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


public class RegisterView extends FormLayout implements View{

	@PropertyId("email")
	private TextField tfEmail;
	
	@PropertyId("password")
	private PasswordField tfPassword;
	
	@PropertyId("retype")
	private PasswordField tfRetype;
	
	private CheckBox cbAccept;
	private Button btnRegister;
	private Label lbError;
	
	LoginData logData;
	private BeanFieldGroup<LoginData> registerFieldGroup;
	
	public RegisterView() {
		logData = new LoginData();
		buildLayout();
	    initLayout();
	}
	
	private void buildLayout(){
		registerFieldGroup = new BeanFieldGroup<>(LoginData.class);
	    registerFieldGroup.buildAndBindMemberFields(this);
	    registerFieldGroup.setItemDataSource(logData);
	    
	    tfEmail = new TextField();
	    tfPassword = new PasswordField();
	    tfRetype = new PasswordField();
	    cbAccept = new CheckBox();
	    btnRegister = new Button();
	    lbError = new Label();
	    
	    addComponents(tfEmail, tfPassword, tfRetype, cbAccept, btnRegister, lbError);
		setSpacing(true);
	    setMargin(true);
	}
	
	private void initLayout(){
	      btnRegister.addClickListener(event -> buttonClicked());
	      

	      tfEmail.addValidator(new EmailValidator("It's not a correct email."));
	      tfEmail.focus();
	    
	      tfEmail.setCaption("Email: ");
	      
	      tfPassword.setCaption("Password: ");
	      
	      tfRetype.setCaption("Retype password: ");
	      
	      cbAccept.setCaption("I accept terms and conditions of using this Page.");
	      
	      btnRegister.setCaption("Register");

	      

	   }
	
	@Override
	public void enter(ViewChangeEvent event) {
		
		
	}
	
	
	private void buttonClicked() { 
		
		try{
			registerFieldGroup.commit();
			lbError.setValue("lol");
			if(!cbAccept.isEmpty()){
			getUI().getNavigator().navigateTo("settings");
			}else{
				lbError.setValue("failed hahasadfdsfdsaf");
			}
			
		}catch(FieldGroup.CommitException e) {
	         System.out.println("Invalid data!");
	         lbError.setValue("läuft nicht");
	   		}
		
	 }

}
