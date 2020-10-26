package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDAO;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //Получим всех пользователей из дао и передадим в представление на отображение
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAO.getAllUsers());
        return "users/index";
    }

    //Получим одного юзера по его id и передадим в представление на отображение
    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id,
                               Model model) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "users/show";
    }

    @DeleteMapping("/{id}")
    public String delUser(@PathVariable("id") int id,
                          Model model) {
        userDAO.delUserById(id);
        return "redirect:/users";
    }

}
