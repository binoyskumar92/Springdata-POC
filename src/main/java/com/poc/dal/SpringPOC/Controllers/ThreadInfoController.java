package com.poc.dal.SpringPOC.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadInfoController {

    private static final Logger logger = LoggerFactory.getLogger(ThreadInfoController.class);

    @GetMapping("/thread-info")
    public String getThreadInfo() {
        Thread currentThread = Thread.currentThread();
        boolean isVirtual = currentThread.isVirtual();
        String threadInfo = "Thread details: "+ currentThread+", Thread Name: " + currentThread.getName() + ", Is Virtual: " + isVirtual;

        logger.info(threadInfo);
        return threadInfo;
    }
}

