package com.project.hotelbooking.Controllers;

import com.project.hotelbooking.Models.Users;
import com.project.hotelbooking.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UsersService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "loginform"; // returns the HTML form
    }

    // Display the user registration form
    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new Users()); // Pass an empty User object to the form
        return "adduser"; // returns the HTML form
    }

    // Handle the form submission
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute Users user, Model model) {
        userService.saveUser(user); // Save the user
        model.addAttribute("message", "User added successfully!");
        return "loginform"; // Redirect to a success page
    }

    // Display the index page after successful login
    @GetMapping("/index")
    public String showIndexPage(Model model) {
        model.addAttribute("message", "Welcome to the index page!");
        return "index"; // Returns the index.html template
    }
}
