package com.cloudchipr.workflowengine.dao;

import java.util.Map;

public interface ProcessStepDao {


    void saveParams(String stepId, Map<String, String> params);

}
