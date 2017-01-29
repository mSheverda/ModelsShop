package mocks;

import ua.com.models.controller.admin.AdminCategoriesController;
import ua.com.models.controller.admin.AdminOrdersController;
import ua.com.models.controller.admin.AdminProductsController;
import ua.com.models.controller.admin.AdminUsersController;
import ua.com.models.controller.AppController;
import ua.com.models.service.*;



/**
 * Created by Max on 1/29/2017.
 */

public final class MockController {

    private static AdminCategoriesController adminCategoriesController;
    private static AdminOrdersController adminOrdersController;
    private static AdminProductsController adminProductsController;
    private static AdminUsersController adminUsersController;
    private static AppController homeController;

    public static AdminCategoriesController getAdminCategoriesController() {
        if (adminCategoriesController == null) {
            adminCategoriesController = initAdminCategoriesController();
        }
        return adminCategoriesController;
    }

    public static AdminOrdersController getAdminOrdersController() {
        if (adminOrdersController == null) {
            adminOrdersController = initAdminOrdersController();
        }
        return adminOrdersController;
    }

    public static AdminProductsController getAdminProductsController() {
        if (adminProductsController == null) {
            adminProductsController = initAdminProductsController();
        }
        return adminProductsController;
    }

    public static AdminUsersController getAdminUsersController() {
        if (adminUsersController == null) {
            adminUsersController = initAdminUsersController();
        }
        return adminUsersController;
    }

    public static AppController getHomeController() {
        if (homeController == null) {
            homeController = initAppController();
        }
        return homeController;
    }

    private static AdminCategoriesController initAdminCategoriesController() {
        CategoryService categoryService = getCategoryService();
        PhotoService photoService = getPhotoService();
        UserService userService = getUserService();
        return new AdminCategoriesController(categoryService, photoService, userService);
    }

    private static AdminOrdersController initAdminOrdersController() {
        OrderService orderService = getOrderService();
        StatusService statusService = getStatusService();
        UserService userService = getUserService();
        RoleService roleService = getRoleService();
        return new AdminOrdersController(orderService, statusService, userService, roleService);
    }

    private static AdminProductsController initAdminProductsController() {
        ProductService productService = getProductService();
        CategoryService categoryService = getCategoryService();
        PhotoService photoService = getPhotoService();
        UserService userService = getUserService();
        return new AdminProductsController(productService, categoryService, photoService, userService);
    }

    private static AdminUsersController initAdminUsersController() {
        UserService userService = getUserService();
        RoleService roleService = getRoleService();
        return new AdminUsersController(userService, roleService);
    }

    private static AppController initAppController() {
        ProductService productService = getProductService();
        CategoryService categoryService = getCategoryService();
        ShoppingCartService shoppingCartService = getShoppingCartService();
        OrderService orderService = getOrderService();
        StatusService statusService = getStatusService();
        RoleService roleService = getRoleService();
        return new AppController(productService, categoryService, shoppingCartService,
                orderService, statusService, roleService);
    }

}
