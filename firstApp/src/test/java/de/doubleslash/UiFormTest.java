package de.doubleslash;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.ComboBoxEditor;

import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Before;
import org.junit.Test;

import com.vaadin.ui.ComboBox;

public class UiFormTest {

	private String filename = "ApplicationConfigurationTest.properties";
	private UiForm uiForm;
	private String[] propertiesValue;
	private ApplicationConfigurationFactory config;
	private ComboBox cbBox;
	
	
	@Before
	public void before() throws ConfigurationException {
		uiForm = new UiForm();
		config = new ApplicationConfigurationFactory();
		cbBox = new ComboBox();
	}

	@Test
	public void addItemToComboBoxShopsTest() throws ConfigurationException {
		uiForm.addItemToComboBox(cbBox, "shop", filename);
		Collection<Object> itemIds = (Collection<Object>) cbBox.getContainerDataSource().getItemIds();
		Object[] array = cbBox.getContainerDataSource().getItemIds().toArray();	
		
		propertiesValue = (config.getConfig(filename).getStringArray("shop"));
		
		assertNotNull(cbBox);
		assertEquals(propertiesValue, array);
		assertEquals(propertiesValue.length, itemIds.size());
		
	}

	@Test
	public void addItemToComboBoxSignatureTypesTest() throws ConfigurationException {
		uiForm.addItemToComboBox(cbBox, "signature", filename);
		Collection<Object> itemIds = (Collection<Object>) cbBox.getContainerDataSource().getItemIds();
		Object[] array = cbBox.getContainerDataSource().getItemIds().toArray();	
		
		propertiesValue = (config.getConfig(filename).getStringArray("signature"));

		assertNotNull(cbBox);
		assertEquals(propertiesValue, array);
		assertEquals(propertiesValue.length, itemIds.size());
	}

}
