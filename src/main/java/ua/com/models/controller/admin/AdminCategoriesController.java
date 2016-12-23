package ua.com.models.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.com.models.model.Category;
import ua.com.models.model.Photo;
import ua.com.models.service.CategoryService;
import ua.com.models.service.PhotoService;
import ua.com.models.service.UserService;

/**
 * Created by Max on 12/4/2016.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminCategoriesController {
    /**
     * Объект сервиса для работы с категориями товаров.
     */
    private final CategoryService categoryService;

    /**
     * Объект сервиса для работы с изображениями категорий.
     */
    private final PhotoService photoService;

    /**
     * Объект сервиса для работы с пользователями.
     */
    private final UserService userService;

    /**
     * Конструктор для инициализации основных переменных контроллера категорий.
     * Помечен аннотацией @Autowired, которая позволит Spring автоматически инициализировать объекты.
     **/
    @Autowired
    public AdminCategoriesController(CategoryService categoryService, PhotoService photoService, UserService userService) {
        this.categoryService = categoryService;
        this.photoService = photoService;
        this.userService = userService;
    }

    /**
     * Возвращает все категории товаров на страницу "admin/category/all".
     * URL запроса "/admin/categories", метод GET.
     *
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView viewAllCategories(ModelAndView modelAndView) {
        modelAndView.addObject("categories", this.categoryService.getAll());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser()); // Авторизированый пользователь.
        modelAndView.setViewName("admin/category/all");
        return modelAndView;
    }

    /**
     * Возвращает категорию с уникальным кодом id на страницу "admin/category/one".
     * URL запроса "/admin/view_category_{id}", метод GET.

     */
    @RequestMapping(value = "/view_category_{id}", method = RequestMethod.GET)
    public ModelAndView viewCategory(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("category", this.categoryService.get(id));
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("admin/category/one");
        return modelAndView;
    }

    /**
     * Возвращает страницу "admin/category/add" для добавления новой категории.
     * URL запроса "/admin/add_category", метод GET.

     */
    @RequestMapping(value = "/add_category", method = RequestMethod.GET)
    public ModelAndView getAddCategoryPage(ModelAndView modelAndView) {
        modelAndView.addObject("photos", this.photoService.getAll());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("admin/category/add");
        return modelAndView;
    }

    /**
     * Сохраняет новую категорию по входящим параметрам и перенаправляет по запросу "/admin/categories".
     * URL запроса "/admin/save_category", метод POST.
     *

     */
    @RequestMapping(value = "/save_category", method = RequestMethod.POST)
    public ModelAndView saveCategory(@RequestParam String title,
                                     @RequestParam String url,
                                     @RequestParam String description,
                                     @RequestParam(value = "photo_title") String photoTitle,
                                     @RequestParam(value = "photo") MultipartFile photoFile,
                                     ModelAndView modelAndView) {
        Photo photo = new Photo(photoTitle, photoFile == null ? null : photoFile.getOriginalFilename(), null);
        Category category = new Category(title, url, description, photo);
        this.categoryService.add(category);
        this.photoService.saveFile(photoFile);
        modelAndView.setViewName("redirect:/admin/categories");
        return modelAndView;
    }


    /**
     * Возвращает страницу "admin/category/edit" для редактирование категории с уникальным кодом,
     * который совпадает с параметром id. URL запроса "/admin/edit_category_{id}", метод GET.
     *
     */
    @RequestMapping(value = "/edit_category_{id}", method = RequestMethod.GET)
    public ModelAndView getEditCategoryPage(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        modelAndView.addObject("category", this.categoryService.get(id));
        modelAndView.addObject("photos", this.photoService.getAll());
        modelAndView.addObject("auth_user", this.userService.getAuthenticatedUser());
        modelAndView.setViewName("admin/category/edit");
        return modelAndView;
    }

    /**
     * Обновляет категорию по входящим параметрам и перенаправляет по запросу "/admin/view_category_{id}".
     * URL запроса "/admin/update_category", метод POST.
     *
       */
    @RequestMapping(value = "/update_category", method = RequestMethod.POST)
    public ModelAndView updateCategory(@RequestParam long id,
                                       @RequestParam String title,
                                       @RequestParam String url,
                                       @RequestParam String description,
                                       @RequestParam(value = "photo_id") long photoId,
                                       @RequestParam(value = "photo_title") String photoTitle,
                                       @RequestParam(value = "photo") MultipartFile photoFile,
                                       ModelAndView modelAndView) {
        Photo photo = this.photoService.get(photoId);
        photo.setTitle(photoTitle);
        String photoLinkShort = photoFile == null || photoFile.getOriginalFilename().isEmpty() ? photo.getPhotoLinkShort()
                : photoFile.getOriginalFilename();
        photo.setPhotoLinkShort(photoLinkShort);

        Category category = this.categoryService.get(id);
        category.initialize(title, url, description, photo);
        this.categoryService.update(category);

        this.photoService.saveFile(photoFile);

        modelAndView.setViewName("redirect:/admin/view_category_" + id);
        return modelAndView;
    }

   /**
     * Удаляет категорию с уникальным кодом, который совпадает с входящим параметром id,
     * и перенаправляет по запросу "/admin/categories".
     * URL запроса "/delete_category_{id}", метод GET.
     *
     */
    @RequestMapping(value = "/delete_category_{id}", method = RequestMethod.GET)
    public ModelAndView deleteCategory(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        this.categoryService.remove(id);
        modelAndView.setViewName("redirect:/admin/categories");
        return modelAndView;
    }

    /**
     * Удаляет все категории и перенаправляет по запросу "/admin/categories".
     * URL запроса "/delete_all_categories", метод GET.
     *
     */
    @RequestMapping(value = "/delete_all_categories", method = RequestMethod.GET)
    public ModelAndView deleteAllCategories(ModelAndView modelAndView) {
        this.categoryService.removeAll();
        modelAndView.setViewName("redirect:/admin/categories");
        return modelAndView;
    }
}