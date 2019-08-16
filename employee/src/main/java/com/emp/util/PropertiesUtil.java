package com.emp.util;

import java.io.InputStream;
import java.util.Properties;
/**
 * Singleton that can be used to load properties
 * @author manoh
 *
 */
public class PropertiesUtil {

	public static final PropertiesUtil PROPERTIES_INSTANCE = new PropertiesUtil();
	private final Properties properties = new Properties();

	private PropertiesUtil() {
		try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("message.properties")) {

			if (input == null) {
				throw new RuntimeException("Properties message.properties not found");

			}

			// load a properties file from class path, inside static method
			properties.load(input);

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public  String getMessage(String messageKey) {
		return properties.getProperty(messageKey);
	}

}
