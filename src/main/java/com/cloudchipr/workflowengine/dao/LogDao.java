package com.cloudchipr.workflowengine.dao;

import java.util.Map;

public interface LogDao {

    void info(String message, String stepId, String userId, Map<String, String> params);
}
