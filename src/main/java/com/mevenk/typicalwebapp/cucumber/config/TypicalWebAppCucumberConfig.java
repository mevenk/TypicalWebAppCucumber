/**
 * 
 */
package com.mevenk.typicalwebapp.cucumber.config;

import static com.mevenk.typicalwebapp.cucumber.util.TypicalWebAppCucumberUtil.newDirPathHTML;
import static com.mevenk.typicalwebapp.cucumber.util.TypicalWebAppCucumberUtil.newFilePathJSON;
import static com.mevenk.typicalwebapp.cucumber.util.TypicalWebAppCucumberUtil.newFilePathTXT;
import static com.mevenk.typicalwebapp.cucumber.util.TypicalWebAppCucumberUtil.newFilePathXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import cucumber.runtime.formatter.PluginFactory;

/**
 * @author Venkatesh
 *
 */
public class TypicalWebAppCucumberConfig {

	public static Properties APPLICATION_PORPERTIES = new Properties();

	private static PluginFactory pluginFactory = new PluginFactory();

	public enum ApplicationProperty {
		APPLICATION_NAME, TEST_NAME;
		public String propertyKey() {
			switch (this) {
			case APPLICATION_NAME:
				return "";
			case TEST_NAME:
				return "featureName";
			default:
				return "";
			}
		}
	}

	public static String addApplicationProperty(ApplicationProperty property, String value) {
		return (String) APPLICATION_PORPERTIES.put(property.propertyKey(), value);
	}

	public static String getApplicationProperty(ApplicationProperty property) {
		return APPLICATION_PORPERTIES.getProperty(property.propertyKey());
	}

	private static final String PLUGIN_JSON_PREFIX = "json:";
	private static final String PLUGIN_HTML_PREFIX = "html:";
	private static final String PLUGIN_PRETTY_PREFIX = "pretty:";
	private static final String PLUGIN_NULL_PREFIX = "null:";
	private static final String PLUGIN_JUNIT_PREFIX = "junit:";
	private static final String PLUGIN_TESTNG_PREFIX = "testng:";
	private static final String PLUGIN_PROGRESS_PREFIX = "progress:";
	private static final String PLUGIN_USAGE_PREFIX = "usage:";
	private static final String PLUGIN_RERUN_PREFIX = "rerun:";
	private static final String PLUGIN_DEFAULT_SUMMARY_PREFIX = "default_summary:";
	private static final String PLUGIN_NULL_SUMMARY_PREFIX = "null_summary:";

	public static Object pluginPretty() {
		return pluginFactory.create(PLUGIN_PRETTY_PREFIX + newFilePathTXT("Pretty"));
	}

	public static Object pluginNull() {
		return pluginFactory.create(PLUGIN_NULL_PREFIX + newFilePathTXT("Null"));
	}

	public static Object pluginProgress() {
		return pluginFactory.create(PLUGIN_PROGRESS_PREFIX + newFilePathTXT("Progress"));
	}

	public static Object pluginUsage() {
		return pluginFactory.create(PLUGIN_USAGE_PREFIX + newFilePathTXT("Usage"));
	}

	public static Object pluginRerun() {
		return pluginFactory.create(PLUGIN_RERUN_PREFIX + newFilePathTXT("Rerun"));
	}

	public static Object pluginDefaultSummary() {
		return pluginFactory.create(PLUGIN_DEFAULT_SUMMARY_PREFIX + newFilePathTXT("DefaultSummary"));
	}

	public static Object pluginNullSummary() {
		return pluginFactory.create(PLUGIN_NULL_SUMMARY_PREFIX + newFilePathTXT("NullSummary"));
	}

	public static Object pluginJunit() {
		return pluginFactory.create(PLUGIN_JUNIT_PREFIX + newFilePathXML("JunitReport"));
	}

	public static Object pluginTestNg() {
		return pluginFactory.create(PLUGIN_TESTNG_PREFIX + newFilePathXML("TestNG"));
	}

	public static Object pluginJSON() {
		return pluginFactory.create(PLUGIN_JSON_PREFIX + newFilePathJSON());
	}

	public static Object pluginHTML() {
		return pluginFactory.create(PLUGIN_HTML_PREFIX + newDirPathHTML());
	}

	public static List<String> argumentsTypicalWebAppCucumber() {
		List<String> argumentsTypicalWebAppCucumber = new ArrayList<>();
		// argumentsTypicalWebAppCucumber.add("--help");
		argumentsTypicalWebAppCucumber.add("classpath: ");
		return argumentsTypicalWebAppCucumber;
	}

}
