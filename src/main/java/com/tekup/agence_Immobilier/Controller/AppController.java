package com.tekup.agence_Immobilier.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tekup.agence_Immobilier.entities.User;
import com.tekup.agence_Immobilier.repository.UserRepository;
 
@Controller
public class AppController {
 
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping("/")
    public  String homeForm(Model model) {
        model.addAttribute("user", new User());
        return "Home";
    }
    
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userRepo.save(user);
         
        return "register_success";
    }

    @GetMapping("/about")
    public String aboutUsForm(Model model) {  
        return "about";
    }
    @GetMapping("/contact")
    public  String conctUsForm(Model model) {
  
        return "contact";
    }
    @GetMapping("/projects")
    public  String projectsForm(Model model) { 
        return "Projects";
    }
    @GetMapping("/Adminpage")
    public  String adminForm() {   
        return "Adminpage";
    }
    @GetMapping("/login")
    public  String loginForm(Model model) {
     
         
        return "login";
    }
    
  
    
}





