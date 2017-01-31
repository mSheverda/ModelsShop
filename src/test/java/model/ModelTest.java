package model;

import mocks.MockModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.models.enums.StatusEnum;
import ua.com.models.model.Category;
import ua.com.models.model.Model;
import ua.com.models.model.Status;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Max on 1/31/2017.
 */

public class ModelTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("\nTesting class \"Model\" - START.\n");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Testing class \"Model\" - FINISH.\n");
    }

    @Test
    public void equalsTest() {
        System.out.print("-> equals() - ");

        Category category = new Category();

        assertFalse(category.equals(null));
        assertEquals(category, category);

        System.out.println("OK!");
    }

    @Test
    public void hashCodeTest() {
        System.out.print("-> hashCode() - ");

        Status status = new Status(StatusEnum.NEW, "New");
        assertTrue(status.toString().hashCode() == status.hashCode());

        status.setId((long) 2);
        assertTrue(status.getId().hashCode() == status.hashCode());

        System.out.println("OK!");
    }

    @Test
    public void getUnmodifiableListTest() {
        System.out.print("-> getUnmodifiableList() - ");

        assertEquals(Model.getUnmodifiableList(null), Collections.EMPTY_LIST);

        assertTrue(Model.getUnmodifiableList(MockModel.getTenProducts()).size() == 10);

        System.out.println("OK!");
    }
}
