package soon.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;
import soon.advanced.trace.TraceStatus;

class ThreadLocalFieldLogTraceTest {

    ThreadLocalFieldLogTrace trace = new ThreadLocalFieldLogTrace();

    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");

        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalArgumentException());
    }
}