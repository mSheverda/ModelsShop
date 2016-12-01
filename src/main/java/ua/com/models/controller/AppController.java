package ua.com.models.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import ua.com.models.model.Product;
import ua.com.models.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/")

public class AppController {

    private final ProductService service;

    @Autowired
    public AppController(ProductService productService) {
        this.service = productService;

    }

    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {

        List<Product> product = service.getAll();
        model.addAttribute("products", product);
        return "client/main";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model
    ) {
        return "client/registration";
    }

    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveEmployee(
                               @RequestParam String url,
                               ModelMap model
                              ) {

        Product product = new Product(url);
        this.service.add(product);


        model.addAttribute("success", "Product " + product.getUrl() + " registered successfully");
        return "client/success";
    }
}