/**
 * 
 */
package com.mevenk.typicalwebapp.cucumber.util;

import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.getApplicationProperty;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.ApplicationProperty.TEST_NAME;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Venkatesh
 *
 */
public final class TypicalWebAppCucumberUtil {

	public static final String FILE_SEPARATOR = File.separator;
	private static final String EXT_JSON = ".json";
	private static final String DIR_SUFFIX_HTML = "_html";
	private static final String EXT_XML = ".xml";
	private static final String EXT_TXT = ".txt";

	private static final String JSON = "json";
	private static final String HTML = "html";

	public static final char CHAR_UNDERSCORE = '_';
	public static final char CHAR_DOT = '.';

	private static final String PATTERN_SIMPLE_DATE_FORMAT_REPORT_FILE_NAME = "dd_MM_yyyy_HH_mm_ss_SSS";

	public static final String STEPS_BASE_PACKAGE = "com.mevenk.typicalwebapp.cucumber.steps";

	public static final String APP_BASE_DIR = "E:\\work\\temporary\\TypicalWebAppCucumber";

	public static final String RESOURCES = "resources";
	public static final String FEATURES = "features";
	public static final String REPORTS = "reports";
	public static final String TESTLOGS = "testLogs";

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT_REPORT_FILE_NAME = new SimpleDateFormat(
			PATTERN_SIMPLE_DATE_FORMAT_REPORT_FILE_NAME);

	public static final String FEATURES_BASE_DIR = APP_BASE_DIR + FILE_SEPARATOR + RESOURCES + FILE_SEPARATOR
			+ FEATURES;

	public static final String TESTS_LOGS_DIR = APP_BASE_DIR + FILE_SEPARATOR + TESTLOGS;

	public static final String REPORTS_BASE_DIR = APP_BASE_DIR + FILE_SEPARATOR + REPORTS;

	public static final String HTML_REPORTS_BASE_DIR = REPORTS_BASE_DIR + FILE_SEPARATOR + HTML;
	public static final String JSON_REPORTS_BASE_DIR = REPORTS_BASE_DIR + FILE_SEPARATOR + JSON;

	public static synchronized String newFilePathTXT(String fileNamePrefix) {
		return minuteDirectory().getAbsolutePath() + FILE_SEPARATOR + testNameWithDate() + CHAR_UNDERSCORE
				+ fileNamePrefix + EXT_TXT;
	}

	public static synchronized String newFilePathXML(String fileNamePrefix) {
		return minuteDirectory().getAbsolutePath() + FILE_SEPARATOR + testNameWithDate() + CHAR_UNDERSCORE
				+ fileNamePrefix + EXT_XML;
	}

	public static synchronized String newFilePathJSON() {
		return minuteDirectory().getAbsolutePath() + FILE_SEPARATOR + testNameWithDate() + EXT_JSON;
	}

	public static synchronized String newDirPathHTML() {
		return minuteDirectory().getAbsolutePath() + FILE_SEPARATOR + testNameWithDate() + DIR_SUFFIX_HTML;
	}

	private static synchronized File minuteDirectory() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		int month = (calendar.get(Calendar.MONTH) + 1);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);

		String minuleFilePath = REPORTS_BASE_DIR + FILE_SEPARATOR + Integer.toString(year) + FILE_SEPARATOR
				+ Integer.toString(month) + FILE_SEPARATOR + Integer.toString(day) + FILE_SEPARATOR
				+ Integer.toString(hour) + FILE_SEPARATOR + Integer.toString(minute);
		File requiredFileDirectory = new File(minuleFilePath);
		if (!requiredFileDirectory.exists()) {
			requiredFileDirectory.mkdirs();
		}

		return requiredFileDirectory;
	}

	private static synchronized String testNameWithDate() {
		return getApplicationProperty(TEST_NAME) + CHAR_UNDERSCORE
				+ SIMPLE_DATE_FORMAT_REPORT_FILE_NAME.format(new Date());
	}

	/* FEATURES */

	public static final String TYPICALWEBAPP_INITIAL_FEATURE = "TypicalWebAppCucumberInitial.feature";
	public static final String TYPICALWEBAPP_CONTROLLER_FEATURE = "TypicalWebAppController.feature";

	/* FEATURES - END */

	public static final String initialFeaturePath() {
		return FEATURES_BASE_DIR + FILE_SEPARATOR + TYPICALWEBAPP_INITIAL_FEATURE;
	}

	public static final String initialFeatureName() {
		return TYPICALWEBAPP_INITIAL_FEATURE.substring(0, TYPICALWEBAPP_INITIAL_FEATURE.indexOf(CHAR_DOT));
	}

}
