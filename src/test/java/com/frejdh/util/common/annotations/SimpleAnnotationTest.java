package com.frejdh.util.common.annotations;

/**
 * Simple test to see if the annotation processor is working inside of the IDE
 */
public class SimpleAnnotationTest {

	@Warning("My warning")
	public void warningAnnotatedMethod() {

	}

	public void callingAnnotatedMethods() {
		warningAnnotatedMethod();
	}
}
