package ungp.sampleng.test;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.WebTarget;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BaseTest {

    @ClassRule
    public static ServerClassRule server = new ServerClassRule();

    @Rule
    public PreConditionRule preConditionRule = new PreConditionRule();

    public static WebTarget getWebTarget() {
        return server.getTarget();
    }

}
