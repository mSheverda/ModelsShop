package configuration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.com.models.configuration.AppConfig;
import ua.com.models.configuration.HibernateConfiguration;
import ua.com.models.service.RoleService;
import ua.com.models.service.UserService;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Max on 1/27/2017.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = HibernateConfiguration.class),
        @ContextConfiguration(classes = AppConfig.class)
})
public class SecurityConfigTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @BeforeClass
    public static void setUp() {
        System.out.println("\nTesting class \"curityConfig\" - START.\n");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Testing class \"curityConfig\" - FINISH.\n");
    }

    @Test
    public void userServiceNotNull() throws Exception {
        System.out.print("-> userService Not Null - ");

        assertNotNull(userService);

        System.out.println("OK!");
    }

    @Test
    public void roleServiceNotNull() throws Exception {
        System.out.print("-> roleService Not Null - ");

        assertNotNull(roleService);

        System.out.println("OK!");
    }
}
