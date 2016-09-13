package de.doubleslash;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;

public class ApplicationConfigurationFactoryTest {

	@Test
	public void shouldGetApplicationConfigurationShopnames() throws FileNotFoundException {
		ApplicationConfigurationFactory factory = new ApplicationConfigurationFactory();
		try {
			Configuration config = factory.getConfig("ApplicationConfigurationTest.properties");
			String[] shopName = config.getStringArray("shop");
			assertEquals(6, shopName.length);
		} catch (ConfigurationException e) {
			System.out.println("file not found!");
		}
	}

	@Test
	public void shouldGetApplicationConfigurationSignatureType() throws FileNotFoundException{
		ApplicationConfigurationFactory factory = new ApplicationConfigurationFactory();
		
		Configuration config;
		try {
			config = factory.getConfig("ApplicationConfigurationTest.properties");
			String[] signatureType = config.getStringArray("signature");
			assertEquals(6, signatureType.length);
		} catch (ConfigurationException e) {
			System.out.println("File not found");
		}
		
		
	}
}
