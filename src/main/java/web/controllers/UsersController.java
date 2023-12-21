package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit (@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update( @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";
        userService.saveAndFlush(user);
        return  "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }
}
