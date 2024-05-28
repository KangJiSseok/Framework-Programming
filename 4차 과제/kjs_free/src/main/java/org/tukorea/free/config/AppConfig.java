package org.tukorea.free.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.tukorea.free.aop.LogTraceAspect;
import org.tukorea.free.logtrace.ThreadLocalLogTrace;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.tukorea.free")
public class AppConfig {
    @Bean
    public static ThreadLocalLogTrace threadLocalLogTrace() {
        return new ThreadLocalLogTrace();
    }

    @Bean
    public static LogTraceAspect logTraceAspect() {
        return new LogTraceAspect(threadLocalLogTrace());
    }
}
