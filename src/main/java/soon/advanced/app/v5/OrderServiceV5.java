package soon.advanced.app.v5;

import org.springframework.stereotype.Service;
import soon.advanced.trace.callback.TraceCallback;
import soon.advanced.trace.callback.TraceTemplate;
import soon.advanced.trace.logtrace.LogTrace;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace log) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(log);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
