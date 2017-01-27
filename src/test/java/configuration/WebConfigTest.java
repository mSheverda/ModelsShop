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
import ua.com.models.controller.admin.AdminCategoriesController;
import ua.com.models.controller.admin.AdminOrdersController;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Max on 1/27/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = HibernateConfiguration.class),
        @ContextConfiguration(classes = AppConfig.class)
})
public class WebConfigTest {
    @Autowired
    private AdminCategoriesController adminCategoriesController;

    @Autowired
    private AdminOrdersController adminOrdersController;

    @BeforeClass
    public static void setUp() {
        System.out.println("\nTesting class \"WebConfig\" - START.\n");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Testing class \"WebConfig\" - FINISH.\n");
    }

    @Test
    public void adminCategoriesControllerNotNull() {
        System.out.print("-> adminCategoriesController Not Null - ");

        assertNotNull(adminCategoriesController);

        System.out.println("OK!");
    }

    @Test
    public void adminOrdersControllerNotNull() {
        System.out.print("-> adminOrdersController Not Null - ");

        assertNotNull(adminOrdersController);

        System.out.println("OK!");
    }

    @Test
    public void adviceControllerNotNull() {
        System.out.print("-> adviceController Not Null - ");

        assertNotNull(adminOrdersController);

        System.out.println("OK!");
    }

    @Test
    public void viewResolverTest() {
        System.out.print("-> viewResolver() - ");

        AppConfig webConfig = new AppConfig();
        assertNotNull(webConfig.viewResolver());

        System.out.println("OK!");
    }
}