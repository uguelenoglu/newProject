package de.doubleslash;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.StartedListener;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public class UiForm extends FormLayout implements SucceededListener, FailedListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2970583760814624784L;

	private ComboBox cbShopname;
	private ComboBox cbCertificatetyp;
	private Upload upDataUpload;
	private Label lblState;
	private String standardWidth = "650px";
	private Button uploadButton;

	@PropertyId("url1")
	private TextField tfUrl1;
	@PropertyId("url2")
	private TextField tfUrl2;
	@PropertyId("url3")
	private TextField tfUrl3;

	private Data data;

	BeanFieldGroup<Data> beanField;

	public UiForm() throws ConfigurationException {
		data = new Data();
		buildLayout();
		initLayout();
	}

	private void buildLayout() {
		beanField = new BeanFieldGroup<>(Data.class);
		beanField.buildAndBindMemberFields(this);
		beanField.bindMemberFields(data);

		Uploader uploader = new Uploader();

		cbCertificatetyp = new ComboBox();
		cbShopname = new ComboBox();
		upDataUpload = new Upload("Upload file", uploader);
		upDataUpload.setReceiver(uploader);
		lblState = new Label("Message");
		uploadButton = new Button("Start");
		uploadButton.addClickListener(event -> startUpload());

		upDataUpload.addSucceededListener(this);
		upDataUpload.addFailedListener(this);
		upDataUpload.setButtonCaption(null);

		lblState.setWidth(standardWidth);
		lblState.setHeight("200px");

		cbShopname.setWidth(standardWidth);

		cbCertificatetyp.setWidth(standardWidth);
		cbCertificatetyp.setNullSelectionAllowed(false);

		upDataUpload.setWidth(standardWidth);

		tfUrl1.setWidth(standardWidth);
		tfUrl2.setWidth(standardWidth);
		tfUrl3.setWidth(standardWidth);

		addComponents(cbShopname, cbCertificatetyp, upDataUpload, tfUrl1, tfUrl2, tfUrl3, uploadButton, lblState);

		setSpacing(true);
		setMargin(true);
	}

	private void initLayout() throws ConfigurationException {
		cbShopname.setCaption("Shop Name");

		cbCertificatetyp.setCaption("Certificate Type");

		String filename = "ApplicationConfiguration.properties";
		addItemToComboBox(cbShopname, "shop", filename);
		addItemToComboBox(cbCertificatetyp, "signature", filename);

		cbShopname.setNullSelectionAllowed(false);
		cbCertificatetyp.setNullSelectionAllowed(false);

		upDataUpload.setWidth(standardWidth);
		upDataUpload.setCaption("Document");

		tfUrl1.setCaption("Redirect URL on OK");
		tfUrl2.setCaption("Redirect URL on Cancel");
		tfUrl3.setCaption("Redirect URL on on Fail");
	}

	protected void addItemToComboBox(ComboBox cbBox, String configKey, String filename) throws ConfigurationException {
		ApplicationConfigurationFactory configurationFactory = new ApplicationConfigurationFactory();
		Configuration config = configurationFactory.getConfig(filename);
		Object[] obj = config.getStringArray(configKey);
		cbBox.addItems(obj);
	}

	@Override
	public void uploadFailed(FailedEvent event) {
		lblState.setValue("File upload failed!");
	}

	@Override
	public void uploadSucceeded(SucceededEvent event) {
		lblState.setValue("File Uploaded!");
	}

	public void startUpload() {
		upDataUpload.submitUpload();
	}

}
