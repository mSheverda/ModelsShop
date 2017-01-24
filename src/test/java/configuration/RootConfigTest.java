package configuration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.com.models.configuration.AppConfig;
import ua.com.models.configuration.HibernateConfiguration;
import ua.com.models.repository.*;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Max on 1/24/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = HibernateConfiguration.class),
        @ContextConfiguration(classes = AppConfig.class)
})
public class RootConfigTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SalePositionRepository salePositionRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeClass
    public static void setUp() {
        System.out.println("\nTesting class \"RootConfig\" - START.\n");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Testing class \"RootConfig\" - FINISH.\n");
    }

    @Test
    public void categoryRepositoryNotNull() throws Exception {
        System.out.print("-> categoryRepository Not Null - ");

        assertNotNull(categoryRepository);

        System.out.println("OK!");
    }

    @Test
    public void orderRepositoryNotNull() throws Exception {
        System.out.print("-> orderRepository Not Null - ");

        assertNotNull(orderRepository);

        System.out.println("OK!");
    }

    @Test
    public void photoRepositoryNotNull() throws Exception {
        System.out.print("-> photoRepository Not Null - ");

        assertNotNull(photoRepository);

        System.out.println("OK!");
    }

    @Test
    public void productRepositoryNotNull() throws Exception {
        System.out.print("-> productRepository Not Null - ");

        assertNotNull(productRepository);

        System.out.println("OK!");
    }

    @Test
    public void roleRepositoryNotNull() throws Exception {
        System.out.print("-> roleRepository Not Null - ");

        assertNotNull(roleRepository);

        System.out.println("OK!");
    }

    @Test
    public void salePositionRepositoryNotNull() throws Exception {
        System.out.print("-> salePositionRepository Not Null - ");

        assertNotNull(salePositionRepository);

        System.out.println("OK!");
    }

    @Test
    public void statusRepositoryNotNull() throws Exception {
        System.out.print("-> statusRepository Not Null - ");

        assertNotNull(statusRepository);

        System.out.println("OK!");
    }

    @Test
    public void userRepositoryNotNull() throws Exception {
        System.out.print("-> userRepository Not Null - ");

        assertNotNull(userRepository);

        System.out.println("OK!");
    }

    @Test
    public void dataSourceTest() throws Exception {
        System.out.print("-> dataSource() - ");

        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        assertNotNull(hibernateConfiguration.dataSource());

        System.out.println("OK!");
    }

    @Test
    public void jpaVendorAdapterTest() throws Exception {
        System.out.print("-> jpaVendorAdapter() - ");

        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        assertNotNull(hibernateConfiguration.jpaVendorAdapter());

        System.out.println("OK!");
    }

    @Test
    public void entityManagerFactoryTest() throws Exception {
        System.out.print("-> entityManagerFactory() - ");

        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        DataSource dataSource = mock(DataSource.class);
        JpaVendorAdapter jpaVendorAdapter = mock(JpaVendorAdapter.class);

        assertNotNull(hibernateConfiguration.entityManagerFactory(dataSource, jpaVendorAdapter));

        System.out.println("OK!");
    }

    @Test
    public void transactionManagerTest() {
        System.out.print("-> transactionManager() - ");

        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        EntityManagerFactory factory = mock(EntityManagerFactory.class);
        assertNotNull(hibernateConfiguration.transactionManager(factory));

        System.out.println("OK!");
    }

    @Test
    public void persistenceTranslationTest() {
        System.out.print("-> persistenceTranslation() - ");

        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        assertNotNull(hibernateConfiguration.persistenceTranslation());

        System.out.println("OK!");
    }

    @Test
    public void multipartResolverTest() {
        System.out.print("-> multipartResolver() - ");

        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        assertNotNull(hibernateConfiguration.multipartResolver());

        System.out.println("OK!");
    }
}
