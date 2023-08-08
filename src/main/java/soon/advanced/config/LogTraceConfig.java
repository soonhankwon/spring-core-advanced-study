package soon.advanced.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soon.advanced.trace.logtrace.LogTrace;
import soon.advanced.trace.logtrace.ThreadLocalFieldLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalFieldLogTrace();
    }
}
