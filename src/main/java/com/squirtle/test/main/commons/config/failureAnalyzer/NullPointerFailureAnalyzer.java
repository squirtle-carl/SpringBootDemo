package com.squirtle.test.main.commons.config.failureAnalyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * @author admin
 * @version 1.0.0
 * @describe 空指针故障分析器
 * @date 2024/04/12
 */
public class NullPointerFailureAnalyzer extends AbstractFailureAnalyzer<NullPointerException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, NullPointerException cause) {
        return new FailureAnalysis(getDescription(cause),getAction(cause), cause);
    }

    private String getDescription(NullPointerException cause) {
        return String.format("The required property '%s' is missing", cause.getMessage());
    }
    private String getAction(NullPointerException cause) {
        return String.format("Please provide the property '%s' in your application configuration.", cause.getMessage());
    }
}
