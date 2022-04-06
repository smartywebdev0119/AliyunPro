/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.examples.schedulerx.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.schedulerx.worker.domain.JobContext;
import com.alibaba.schedulerx.worker.processor.JavaProcessor;
import com.alibaba.schedulerx.worker.processor.ProcessResult;

/**
 * 演示如何通过实现kill方法正确停止任务运行
 * @author xiaomeng.hxm
 */
@Component
public class KillJob extends JavaProcessor {

    /*
     * log4j2/logback配置schedulerxLogAppender，可以进行日志采集
     */
    private static final Logger logger = LoggerFactory.getLogger("schedulerx");
    private volatile boolean killed = false;

    @Override
    public ProcessResult process(JobContext context) throws Exception {
        while (!killed) {
            System.out.println("do something...");
            Thread.sleep(3000);
        }
        return new ProcessResult(true);
    }

    @Override
    public void kill(JobContext context) {
        System.out.println("start to kill");
        killed = true;
    }
}
