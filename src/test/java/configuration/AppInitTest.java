package configuration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;
import ua.com.models.configuration.AppInitializer;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Max on 1/24/2017.
 */
public class AppInitTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("\nTesting class \"AppInitializer\" - START.\n");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Testing class \"AppInitializer\" - FINISH.\n");
    }

    @Test
    public void getServletConfigClassesTest() throws Exception {
        System.out.print("-> getServletConfigClasses() - ");
        AppInitializer appInitializer = new AppInitializer();
        assertNotNull(appInitializer.getServletConfigClasses());
        System.out.println("OK!");
    }

    @Test
    public void getRootConfigClassesTest() throws Exception {
        System.out.print("-> getRootConfigClasses() - ");
        AppInitializer appInitializer = new AppInitializer();
        assertNotNull(appInitializer.getRootConfigClasses());
        System.out.println("OK!");
    }

    @Test
    public void getServletMappingsTest() throws Exception {
        System.out.print("-> getServletMappings() - ");

        AppInitializer appInitializer = new AppInitializer();
        assertNotNull(appInitializer.getServletMappings());

        System.out.println("OK!");
    }

    @Test
    public void createDispatcherServletTest() throws Exception {
        System.out.print("-> createDispatcherServlet() - ");

        AppInitializer appInitializer = new AppInitializer();
        WebApplicationContext context = mock(WebApplicationContext.class);
        assertNotNull(appInitializer.createDispatcherServlet(context));

        System.out.println("OK!");
    }
}

