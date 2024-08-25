package com.project.hotelbooking.Controllers;

import com.project.hotelbooking.Repository.BookingRequest;
import com.project.hotelbooking.Repository.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/loginform")
    public String showLoginForm(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        return "loginform"; // Returns the login.html view
    }

    @PostMapping("/login")
    public String login(@RequestParam("userName") String username, @RequestParam("password") String password, Model model) {
        // Logic to authenticate the user
        System.out.println("DEBUG");
        System.out.println(username);
        System.out.println(password);
        if (authenticate(username, password)) {
            return "redirect:/home"; // Redirect to a dashboard or home page on success
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginform"; // Return to login page with error message on failure
        }
    }

    private boolean authenticate(String username, String password) {
        // Implement authentication logic here (e.g., check against a database)
        return "user".equals(username) && "password".equals(password); // Example logic
    }
}
