package configuration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.models.configuration.SecurityInitializer;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Max on 1/27/2017.
 */
public class SecurityInitializerTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("\nTesting class \"SecurityInitializer\" - START.\n");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Testing class \"SecurityInitializer\" - FINISH.\n");
    }

    @Test
    public void ConstructorTest() throws Exception {
        System.out.print("-> SecurityInitializer() - ");

        assertNotNull(new SecurityInitializer());

        System.out.println("OK!");
    }
}