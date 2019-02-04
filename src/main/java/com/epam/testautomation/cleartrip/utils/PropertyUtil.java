package com.epam.testautomation.cleartrip.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.testautomation.cleartrip.constant.Index;

@Component
public class PropertyUtil {

	private static final String DEFAULT_PROPERTY_LOCATION = System.getProperty(Index.System.USER_DIR) + Index.Path.TEST_RESOURCES_PATH + Index.Folder.DATA_PROVIDER + Index.FlatFile.DEFAULT_PROPERTIES_FILE;
	private static final Logger LOGGER = Logger.getLogger(PropertyUtil.class.getName());
	@Autowired
	private Properties properties;
	private FileInputStream inputStream;
	private FileOutputStream outputStream;
	private File file;
	private String path;
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	/**
	 * Fetch property file at location
	 * @param location
	 * @return
	 */
	public PropertyUtil fetchPropertyFile(final String location) {
		this.path = location;
		this.file = new File(this.path);
		try {
			this.inputStream = new FileInputStream(this.file);
			this.properties.load(this.inputStream);
		} catch (FileNotFoundException fileNotFoundException) {
			LOGGER.info(fileNotFoundException.getCause().getMessage());
		} catch (IOException ioException) {
			LOGGER.info(ioException.getCause().getMessage());
		}
		return this;
	}
	
	/**
	 * Update property file with key and value
	 * @param key
	 * @param value
	 * @return
	 */
	public PropertyUtil updatePropertyFile(final String key, final String value) {
		try {
			this.outputStream = new FileOutputStream(this.file);
			this.properties.setProperty(key, value);
			this.properties.store(this.outputStream, "Updated By : " + System.getProperty(Index.System.USER_NAME));
		} catch (FileNotFoundException fileNotFound) {
			LOGGER.info(fileNotFound.getCause().getMessage());
		} catch (IOException ioException) {
			LOGGER.info(ioException.getCause().getMessage());
		}
		return this;
	}
	
	/**
	 * Fetch property value provided with the key
	 * @param key
	 * @return
	 */
	public Object fetchValueWithKey(final String key) {
		return this.properties.get(key);
	}
	
	/**
	 * fetch all the property file data in key value maps
	 * @return
	 */
	public Map<String, Object> fetchAll() {
		Map<String, Object> objectMapper = new HashMap<String, Object>();
		for (Object key : this.properties.keySet()) {
			objectMapper.put(String.valueOf(key), fetchValueWithKey(String.valueOf(key)));
		}
		return objectMapper;
	}
	
	/**
	 * Fetch default property file in classpath
	 * @return
	 */
	public Properties fetchDefaultPropertiesFile() {
		fetchPropertyFile(DEFAULT_PROPERTY_LOCATION);
		return this.properties;
	}
	
	/**
	 * fetch value from default property file In classpath
	 * @param key
	 * @return
	 */
	public Object fetchValueFromDefaultPropertiesFile(final String key) {
		fetchPropertyFile(DEFAULT_PROPERTY_LOCATION);
		return fetchValueWithKey(key);
	}
	
	
	public String fetchDecodedValue(final String key) {
		return new String(Base64.getDecoder().decode(this.properties.getProperty(key)));
	}

}
