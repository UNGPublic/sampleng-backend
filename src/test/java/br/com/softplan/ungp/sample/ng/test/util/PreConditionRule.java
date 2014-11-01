package br.com.softplan.ungp.sample.ng.test.util;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PreConditionRule implements TestRule {

    @Override
    public Statement apply(final Statement base, final Description description) {

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Condition condition = getCondition(description);

                try {
                    if (condition != null) {
                        condition.prepare(description);
                    }

                    base.evaluate();

                } catch (Throwable e) {
                    throw new RuntimeException(e);

                } finally {
                    if (condition != null) {
                        condition.done(description);
                    }
                }

            }
        };
    }

    protected Condition getCondition(Description description) {
        PreCondition preCondition = description.getAnnotation(PreCondition.class);
        try {
            return preCondition != null ? preCondition.value().newInstance() : null;

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
