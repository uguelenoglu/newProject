package com.vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private Navigator navigator;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final CssLayout topBar = new CssLayout();
        final CssLayout viewLayout = new CssLayout();
//        layout.addComponents(topBar, createNavigationButton("register"));
        layout.addComponents(topBar, createNavigationButton("settings"));
        layout.addComponent(viewLayout);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        navigator = new Navigator(this, viewLayout);
		navigator.addView("register", RegisterView.class);
		navigator.addView("settings", SettingsView.class);
		
		navigator.navigateTo("register");
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    
    private Button createNavigationButton(String view){
		return new Button("Go to "+view , new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				navigator.navigateTo(view);
				
			}
		});
	}
    
}
