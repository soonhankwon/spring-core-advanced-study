package soon.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import soon.advanced.trace.strategy.code.strategy.ContextV1;
import soon.advanced.trace.strategy.code.strategy.Strategy;
import soon.advanced.trace.strategy.code.strategy.StrategyLogic1;
import soon.advanced.trace.strategy.code.strategy.StrategyLogic2;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // start business logic 1
        log.info("execute business logic1");
        // end business logic 1
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // start business logic 2
        log.info("execute business logic1");
        // end business logic 2
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("business logic 1");
            }
        };

        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("business logic 2");
            }
        };

        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("business logic 1");
            }
        });
        context1.execute();

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("business logic 2");
            }
        });
        context2.execute();
    }

    @Test
    void strategyV4() {
        ContextV1 context1 = new ContextV1(() -> log.info("business logic 1"));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("business logic 2"));
        context2.execute();
    }
}
