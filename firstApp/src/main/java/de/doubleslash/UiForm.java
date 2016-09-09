package de.doubleslash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;


public class UiForm extends FormLayout implements SucceededListener, FailedListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2970583760814624784L;
	

	private ComboBox cbShopname;
	private ComboBox cbSelect;
	private Upload upDataUpload;
	private Label lblState;
	private String standardWidth = "650px";
	
	@PropertyId("url1")
	private TextField tfUrl1;
	@PropertyId("url2")
	private TextField tfUrl2;
	@PropertyId("url3")
	private TextField tfUrl3;
	
	private Data data;
	
	BeanFieldGroup<Data> beanField;
	
	public UiForm() {
		data = new Data();
		buildLayout();
	    initLayout();
	}

	private void buildLayout(){
		beanField = new BeanFieldGroup<>(Data.class);
		beanField.buildAndBindMemberFields(this);
		beanField.bindMemberFields(data);
		
		Uploader uploader = new Uploader();
		
		
		cbSelect = new ComboBox();
		cbShopname = new ComboBox();
		upDataUpload = new Upload("Upload file", uploader);
		upDataUpload.setReceiver(uploader);
		lblState = new Label("Message");
		upDataUpload.addSucceededListener(this);
		upDataUpload.addFailedListener(this);
		
		lblState.setWidth(standardWidth);
		lblState.setHeight("200px");
		
		cbShopname.setWidth(standardWidth);

		cbSelect.setWidth(standardWidth);
		cbSelect.setNullSelectionAllowed(false);
	
		upDataUpload.setWidth(standardWidth);
		
		tfUrl1.setWidth(standardWidth);
		tfUrl2.setWidth(standardWidth);
		tfUrl3.setWidth(standardWidth);
				
		addComponents(cbShopname, cbSelect, upDataUpload, tfUrl1, tfUrl2, tfUrl3, lblState);
		setSpacing(true);
	    setMargin(true);
		
	}
	
	private void initLayout(){

		cbShopname.setCaption("Shop Name");

		
		cbSelect.setCaption("Certificate typ");
		
		String[] shopArray = readShops();
		String[] typsArray = readTyps();
		
		for(int i = 0; i < shopArray.length; i++){
			cbShopname.addItem(shopArray[i]);
		}
		for(int i = 0; i < typsArray.length;i++){
			cbSelect.addItem(typsArray[i]);
		}
		
		cbShopname.setNullSelectionAllowed(false);
		cbSelect.setNullSelectionAllowed(false);
		
		upDataUpload.setButtonCaption("Upload now");
		upDataUpload.setCaption("Document");

		
		tfUrl1.setCaption("Url");
		tfUrl2.setCaption("Url");
		tfUrl3.setCaption("Url");

	 }

	
	public String[] readShops(){
		String content;
		String[] array = null;
		try {
			content = new String(Files.readAllBytes(Paths.get("/home/uguelenoglu/git/newProject/firstApp/shops.txt")));
			array = content.split(",");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public String[] readTyps(){
		String content;
		String[] array = null;
		try {
			content = new String(Files.readAllBytes(Paths.get("/home/uguelenoglu/git/newProject/firstApp/typs.txt")));
			array = content.split(",");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	@Override
	public void uploadFailed(FailedEvent event) {
		lblState.setValue("File upload failed!");
		
	}

	@Override
	public void uploadSucceeded(SucceededEvent event) {
		
		lblState.setValue("File Uploaded!");
		
	}
	
	
}	
