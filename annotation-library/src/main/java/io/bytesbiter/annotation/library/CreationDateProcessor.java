package io.bytesbiter.annotation.library;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("io.bytesbiter.annotation.library.CreationDate")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
//@AutoService(Processor.class)
public class CreationDateProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for ( TypeElement annotation : annotations ) {
            for ( Element element : roundEnv.getElementsAnnotatedWith(annotation) ) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "found @CreationDate at " + element);
            }
        }
        return true;
    }
}
