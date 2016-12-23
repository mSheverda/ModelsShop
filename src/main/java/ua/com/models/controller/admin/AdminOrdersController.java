package ua.com.models.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.models.model.Order;
import ua.com.models.model.Status;
import ua.com.models.model.User;
import ua.com.models.service.OrderService;
import ua.com.models.service.RoleService;
import ua.com.models.service.StatusService;
import ua.com.models.service.UserService;

import java.util.Date;

/**
 * Created by Max on 12/9/2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminOrdersController {
    /**
     * Объект сервиса для работы с заказами клиентов.
     */
    private final OrderService orderService;

    /**
     * Объект сервиса для работы с статусами выполнения заказов.
     */
    private final StatusService statusService;

    /**
     * Объект сервиса для работы с пользователями.
     */
    private final UserService userService;

    /**
     * Объект сервиса для работы с ролями.
     */
    private final RoleService roleService;

    /**
     * Конструктор для инициализации основных переменных контроллера заказов.
     * Помечен аннотацией @Autowired, которая позволит Spring автоматически инициализировать объекты.
     */
    @Autowired
    public AdminOrdersController(OrderService orderService, StatusService statusService,
                                 UserService userService, RoleService roleService) {
        this.orderService = orderService;
        this.statusService = statusService;
        this.userService = userService;
        this.roleService = roleService;
    }

    /**
     * Возвращает все заказы, сделаные клиентами, на страницу "admin/order/all".
     * URL запроса {"/admin", "/admin/orders"}, метод GET.
     */
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView viewAllOrders(ModelAndView modelAndView) {
        modelAndView.addObject("orders", this.orderService.getAll());
        modelAndView.addObject("status_new", this.statusService.getDefault());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("admin/order/all");
        return modelAndView;
    }

   /**
     * Возвращает заказ с уникальным кодом id на страницу "admin/order/one".
     * URL запроса "/admin/view_order_{id}", метод GET.
     */
    @RequestMapping(value = "/view_order_{id}", method = RequestMethod.GET)
    public ModelAndView viewOrder(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        Order order = this.orderService.get(id);
        modelAndView.addObject("order", order);
        modelAndView.addObject("sale_positions", order.getSalePositions());
        modelAndView.addObject("order_price", order.getPrice());
        modelAndView.addObject("status_new", this.statusService.getDefault());
        modelAndView.addObject("admin_role", this.roleService.getAdministrator());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("admin/order/one");
        return modelAndView;
    }

    /**
     * Возвращает страницу "admin/order/edit" для редактирование заказа с уникальным кодом,
     * который совпадает с параметром id. URL запроса "/admin/edit_order_{id}", метод GET.
     */
    @RequestMapping(value = "/edit_order_{id}", method = RequestMethod.GET)
    public ModelAndView getEditOrderPage(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        Order order = this.orderService.get(id);
        modelAndView.addObject("order", order);
        modelAndView.addObject("sale_positions", order.getSalePositions());
        modelAndView.addObject("order_price", order.getPrice());
        modelAndView.addObject("statuses", this.statusService.getAll());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("admin/order/edit");
        return modelAndView;
    }

    /**
     * Обновляет заказ по входящим параметрам и перенаправляет по запросу "/admin/view_order_{id}".
     * URL запроса "/admin/update_order", метод POST.
     */
    @RequestMapping(value = "/update_order", method = RequestMethod.POST)
    public ModelAndView updateOrder(@RequestParam long id,
                                    @RequestParam(value = "auth_user") long managerId,
                                    @RequestParam String number,
                                    @RequestParam(value = "status") long statusId,
                                    @RequestParam(value = "user_name") String name,
                                    @RequestParam(value = "user_email") String email,
                                    @RequestParam(value = "user_phone") String phone,
                                    @RequestParam(value = "shipping-address") String shippingAddress,
                                    @RequestParam(value = "shipping-details") String shippingDetails,
                                    @RequestParam String description,
                                    ModelAndView modelAndView) {
        Order order = this.orderService.get(id);

        User client = order.getClient();
        client.setName(name);
        client.setEmail(email);
        client.setPhone(phone);

        Status status = this.statusService.get(statusId);
        User manager = this.userService.get(managerId);

        order.initialize(number, new Date(), shippingAddress, shippingDetails, description, status, client, manager);
        this.orderService.update(order);

        modelAndView.setViewName("redirect:/admin/view_order_" + id);
        return modelAndView;
    }

    /**
     * Удаляет заказ с уникальным кодом, который совпадает с входящим параметром id,
     * и перенаправляет по запросу "/admin/orders".
     * URL запроса "/delete_orders_{id}", метод GET.
     */
    @RequestMapping(value = "/delete_order_{id}", method = RequestMethod.GET)
    public ModelAndView deleteOrder(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        this.orderService.remove(id);
        modelAndView.setViewName("redirect:/admin/orders");
        return modelAndView;
    }

    /**
     * Удаляет все заказы и перенаправляет по запросу "/admin/orders".
     * URL запроса "/delete_all_orders", метод GET.
     */
    @RequestMapping(value = "/delete_all_orders", method = RequestMethod.GET)
    public ModelAndView deleteAllOrders(ModelAndView modelAndView) {
        this.orderService.removeAll();
        modelAndView.setViewName("redirect:/admin/orders");
        return modelAndView;
    }
}