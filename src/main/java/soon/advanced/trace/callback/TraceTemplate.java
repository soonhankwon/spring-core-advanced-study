package soon.advanced.trace.callback;

import lombok.RequiredArgsConstructor;
import soon.advanced.trace.TraceStatus;
import soon.advanced.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class TraceTemplate {

    private final LogTrace trace;

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직 호출
            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
