package com.example.springsec.Controller;

import com.example.springsec.Records.RegisterRequest;
import com.example.springsec.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserService service;

    public RegistrationController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest("", ""));
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @ModelAttribute RegisterRequest request) {

        service.register(request);
        return ResponseEntity.ok("Registration successful");
    }
}