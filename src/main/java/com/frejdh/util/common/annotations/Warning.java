package com.frejdh.util.common.annotations;

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import java.lang.annotation.*;

/**
 * Provides a warning
 */
@Inherited
@Documented // Annotation will be visible in javadoc
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public @interface Warning {
	String value() default "";
}