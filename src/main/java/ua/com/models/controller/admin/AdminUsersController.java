package ua.com.models.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import ua.com.models.exception.WrongInformationException;
import ua.com.models.model.Role;
import ua.com.models.model.User;
import ua.com.models.service.RoleService;
import ua.com.models.service.UserService;

import java.util.List;

/**
 * ?????-?????????? ??????? ?????????? ?????????? ?????. ? ?????? ??????????? ?
 * ??????????????? ????????? ????? ?????????? ????????????, ??????? ????-????????????.
 * ????????? @Controller ?????? ??? ????????? Spring'? ? ???, ??? ?????? ?????
 * ???????? bean'?? ? ??? ?????????? ?????????? ??? ?????? ??????????.
 * ?????????? @RequestMapping(value = "/admin") ????????, ??? ?????? ??????????
 * ????? ???????????? ??????, URI ???????? "/admin".
 * ?????? ?????? ???????? ? ????????, ???????????? handleRequest ???????, ????????
 * ????? {@link ModelAndView}, ??????? ?????????? ??? ????????? ?????? ? ??? ???????????.
 * ???? ??? ???????????? Model ? View ? MVC ???????.
 *

 */
@Controller
@RequestMapping(value = "/admin")
public class AdminUsersController {
    /**
     * ?????? ??????? ??? ?????? ? ??????????????.
     */
    private final UserService userService;

    /**
     * ?????? ??????? ??? ?????? ? ?????? ?????????????.
     */
    private final RoleService roleService;

    /**
     * ??????????? ??? ????????????? ???????? ?????????? ??????????? ??????????????.
     * ??????? ?????????? @Autowired, ??????? ???????? Spring ????????????? ???????????????? ???????.
     *
     * @param userService ?????? ??????? ??? ?????? ? ??????????????.
     * @param roleService ?????? ??????? ??? ?????? ? ?????? ?????????????.
     */
    @Autowired
    public AdminUsersController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    /**
     * ?????????? ???? ????????????? ?? ???????? "admin/user/all".
     * URL ??????? "/admin/users", ????? GET.
     *
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView viewAllPersonnel(ModelAndView modelAndView) {
        modelAndView.addObject("users", this.userService.getPersonnel());
        modelAndView.addObject("admin_role", this.roleService.getAdministrator());
        modelAndView.addObject("manager_role", this.roleService.getManager());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("admin/user/all");
        return modelAndView;
    }

    /**
     * ?????????? ???????????? ? ?????????? ????? id ?? ???????? "admin/user/one".
     * URL ??????? "/admin/view_user_{id}", ????? GET.
     *
     * @param id           ??? ?????????, ??????? ????? ???????.
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/view_user_{id}", method = RequestMethod.GET)
    public ModelAndView viewUser(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("user", this.userService.get(id));
        modelAndView.addObject("admin_role", this.roleService.getAdministrator());
        modelAndView.addObject("manager_role", this.roleService.getManager());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("/admin/user/one");
        return modelAndView;
    }

    /**
     * ?????????? ???????? "admin/user/add" ??? ?????????? ?????? ????????????, ????? ?????????
     * (?????????????? ??? ?????????). URL ??????? "/admin/add_user", ????? GET.
     *
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public ModelAndView getAddUserPage(ModelAndView modelAndView) {

        modelAndView.addObject("roles", this.roleService.getPersonnel());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("/admin/user/add");



        return modelAndView;
    }

    /**
     * ????????? ?????? ???????????? ?? ???????? ?????????? ? ?????????????? ?? ??????? "/admin/users".
     * URL ??????? "/admin/save_user", ????? POST.
     *
     * @param name         ??? ?????? ????????????.
    // * @param roleId       ??? ???? ????????????.
     * @param username     ????? ???????????? ??? ????? ? ??????? ?? ?????.
     * @param password     ?????? ???????????? ??? ????? ? ??????? ?? ?????.
     * @param email        ??????????? ????? ????????????.
     * @param phone        ????? ???????? ????????????.
     * @param vkontakte    ?????? ?? ????????? ? ???. ???? "?????????" ????????????.
     * @param facebook     ?????? ?? ????????? ? ???. ???? "Facebook" ????????????.
     * @param skype        ????? ???????????? ? ?????????? "Skype".
     * @param description  ???????? ????????????.
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public ModelAndView saveUser(@RequestParam String name,
                                 @RequestParam(value = "role") long roleId,
                                 @RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String email,
                                 @RequestParam String phone,
                                 @RequestParam String vkontakte,
                                 @RequestParam String facebook,
                                 @RequestParam String skype,
                                 @RequestParam String description,
                                 ModelAndView modelAndView) {
        User user = new User();
        Role role = this.roleService.get(roleId);
        user.initialize(name, username, password, email, phone, vkontakte, facebook, skype, description, role
        );
        this.userService.add(user);

        modelAndView.setViewName("redirect:/admin/users");
        return modelAndView;
    }



    /**
     * ?????????? ???????? "admin/user/edit" ??? ?????????????? ???????????? ? ?????????? ?????,
     * ??????? ????????? ? ?????????? id. URL ??????? "/admin/edit_user_{id}", ????? GET.
     *
     * @param id           ??? ????????????, ?????????? ? ??????? ????? ???????????????.
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/edit_user_{id}", method = RequestMethod.GET)
    public ModelAndView getEditUserPage(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("user", this.userService.get(id));
        modelAndView.addObject("roles", this.roleService.getPersonnel());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("/admin/user/edit");
        return modelAndView;
    }

    /**
     * ????????? ???????????? ?? ???????? ?????????? ? ?????????????? ?? ??????? "/admin/view_user_{id}".
     * URL ??????? "/admin/update_user", ????? POST.
     *
     * @param id           ??? ???????????? ??? ??????????.
     * @param name         ??? ????????????.
   //  * @param roleId       ??? ???? ????????????.
     * @param username     ????? ???????????? ??? ????? ? ??????? ?? ?????.
     * @param password     ?????? ???????????? ??? ????? ? ??????? ?? ?????.
     * @param email        ??????????? ????? ????????????.
     * @param phone        ????? ???????? ????????????.
     * @param vkontakte    ?????? ?? ????????? ? ???. ???? "?????????" ????????????.
     * @param facebook     ?????? ?? ????????? ? ???. ???? "Facebook" ????????????.
     * @param skype        ????? ???????????? ? ?????????? "Skype".
     * @param description  ???????? ????????????.
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam long id,
                                   @RequestParam String name,
                                   @RequestParam(value = "role") long roleId,
                                   @RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   @RequestParam String phone,
                                   @RequestParam String vkontakte,
                                   @RequestParam String facebook,
                                   @RequestParam String skype,
                                   @RequestParam String description,
                                   ModelAndView modelAndView) {
        User user = this.userService.get(id);
        Role role = this.roleService.get(roleId);
        user.initialize(name, username, password, email, phone, vkontakte, facebook, skype, description, role
        );
        this.userService.update(user);

        modelAndView.setViewName("redirect:/admin/view_user_" + id);
        return modelAndView;
    }



    /**
     * ??????? ???????????? ? ?????????? ?????, ??????? ????????? ? ???????? ?????????? id,
     * ? ?????????????? ?? ??????? "/admin/users".
     * URL ??????? "/delete_user_{id}", ????? GET.
     *
     * @param id           ??? ???????????, ???????? ????? ???????.
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/delete_user_{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        if (this.userService.getMainAdministrator().getId() != id) {
            this.userService.remove(id);
        }
        modelAndView.setViewName("redirect:/admin/users");
        return modelAndView;
    }

    /**
     * ??????? ???? ????????????? ? ?????????????? ?? ??????? "/admin/users".
     * URL ??????? "/delete_all_users", ????? GET.
     *
     * @param modelAndView ?????? ?????? {@link ModelAndView}.
     * @return ?????? ?????? {@link ModelAndView}.
     */
    @RequestMapping(value = "/delete_all_users", method = RequestMethod.GET)
    public ModelAndView deleteAll(ModelAndView modelAndView) {
        this.userService.removePersonnel();
        modelAndView.setViewName("redirect:/admin/users");
        return modelAndView;
    }
}
