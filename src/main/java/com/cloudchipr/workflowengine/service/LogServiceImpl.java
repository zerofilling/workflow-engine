package com.cloudchipr.workflowengine.service;

import com.cloudchipr.workflowengine.dao.LogDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogDao logDao;

    //todo implement get logs by filtering
}
