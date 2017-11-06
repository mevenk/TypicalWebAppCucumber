/**
 * 
 */
package com.mevenk.typicalwebapp.cucumber.runner;

import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.addApplicationProperty;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginDefaultSummary;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginHTML;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginJSON;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginJunit;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginNull;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginNullSummary;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginPretty;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginProgress;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginRerun;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginTestNg;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.pluginUsage;
import static com.mevenk.typicalwebapp.cucumber.config.TypicalWebAppCucumberConfig.ApplicationProperty.TEST_NAME;
import static com.mevenk.typicalwebapp.cucumber.util.TypicalWebAppCucumberUtil.initialFeatureName;
import static com.mevenk.typicalwebapp.cucumber.util.TypicalWebAppCucumberUtil.initialFeaturePath;

import java.io.IOException;

import com.mevenk.typicalwebapp.cucumber.steps.TypicalWebAppCucumberInitialSteps;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

/**
 * @author Venkatesh
 *
 */
public class TypicalWebAppCucumberInitialRunner {

	public static void main(String args[]) throws Throwable {

		addApplicationProperty(TEST_NAME, "TEST_FEATURE_" + initialFeatureName());

		byte exitstatus = run();
		System.out.println(exitstatus);
		System.exit(exitstatus);
	}

	public static byte run() throws IOException {

		Class<? extends TypicalWebAppCucumberInitialSteps> classTypicalWebAppCucumberInitialTest = TypicalWebAppCucumberInitialSteps.class;

		ClassLoader classLoaderclassTypicalWebAppCucumberInitialTest = classTypicalWebAppCucumberInitialTest
				.getClassLoader();

		ResourceLoader resourceLoader = new MultiLoader(classLoaderclassTypicalWebAppCucumberInitialTest);

		RuntimeOptionsFactory runtimeOptionsFactory = new RuntimeOptionsFactory(classTypicalWebAppCucumberInitialTest);
		RuntimeOptions runtimeOptions = runtimeOptionsFactory.create();
		runtimeOptions.getGlue().clear();
		runtimeOptions.getGlue().add("classpath:");

		runtimeOptions.getFeaturePaths().clear();
		runtimeOptions.getFeaturePaths().add(initialFeaturePath());

		runtimeOptions.addPlugin(pluginPretty());
		runtimeOptions.addPlugin(pluginJSON());
		runtimeOptions.addPlugin(pluginHTML());
		runtimeOptions.addPlugin(pluginJunit());
		runtimeOptions.addPlugin(pluginTestNg());
		runtimeOptions.addPlugin(pluginDefaultSummary());
		runtimeOptions.addPlugin(pluginNull());
		runtimeOptions.addPlugin(pluginNullSummary());
		runtimeOptions.addPlugin(pluginProgress());
		runtimeOptions.addPlugin(pluginRerun());
		runtimeOptions.addPlugin(pluginUsage());

		ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader,
				classLoaderclassTypicalWebAppCucumberInitialTest);
		Runtime runtime = new Runtime(resourceLoader, classFinder, classLoaderclassTypicalWebAppCucumberInitialTest,
				runtimeOptions);
		runtime.run();

		return runtime.exitStatus();
	}
}
