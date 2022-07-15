package com.chenhai.springboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Objects;

/**
 * @author hai.chen
 * @date 2022/7/15
 */
public class ChenhaiOnClassCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes =
                metadata.getAnnotationAttributes(ChenhaiConditionalOnClass.class.getName());
        assert annotationAttributes != null;
        String className = (String) annotationAttributes.get("value");

        try {
            Objects.requireNonNull(context.getClassLoader()).loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}
