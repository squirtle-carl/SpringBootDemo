package com.squirtle.test.main.commons.config.failureAnalyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class RequiredPropertyFailureAnalyzer extends AbstractFailureAnalyzer<RequiredPropertyException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, RequiredPropertyException cause) {
        return new FailureAnalysis(getDescription(cause),getAction(cause), cause);
    }

    private String getDescription(RequiredPropertyException cause) {
        return String.format("The required property '%s' is missing", cause.getMessage());
    }
    private String getAction(RequiredPropertyException cause) {
        return String.format("Please provide the property '%s' in your application configuration.", cause.getMessage());
    }
}
