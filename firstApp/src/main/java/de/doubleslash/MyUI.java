package de.doubleslash;

import org.apache.commons.configuration2.ex.ConfigurationException;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;



/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("valo")
public class MyUI extends UI {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2766649861137797219L;

	@Override
    protected void init(VaadinRequest vaadinRequest) {
    	UiForm form;
		try {
			form = new UiForm();
			setContent(form);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
			new Notification("Properties file could not be founded! App can not start!", Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
		}
    	
    }
   
}
