package com.frejdh.util.common.annotations.processors;

import com.frejdh.util.common.annotations.Warning;
import com.google.auto.service.AutoService;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Collections;
import java.util.Set;
import static javax.tools.Diagnostic.Kind.WARNING;

@SupportedAnnotationTypes({"com.frejdh.util.common.annotations.DefaultFalse", "com.frejdh.util.common.annotations.DefaultTrue"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class DefaultBooleanProcessor extends AbstractProcessor {

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Collections.singleton(Warning.class.getName());
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (TypeElement annotation : annotations) {
			Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Warning.class);
			for (Element element : elements) {
				processingEnv.getMessager().printMessage(WARNING, "@Warning: " + element.getAnnotation(Warning.class).value(), element);
			}
		}
		return true;
	}

}
