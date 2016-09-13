package de.doubleslash;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ApplicationConfigurationFactory {

	public Configuration getConfig(String propertieFilename) throws ConfigurationException {
		final String configurationFilename = propertieFilename;
		Parameters para = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
				PropertiesConfiguration.class).configure(
						para.properties().setFileName((this.getClass().getResource(configurationFilename)).getPath()));

		return builder.getConfiguration();

	}

}
