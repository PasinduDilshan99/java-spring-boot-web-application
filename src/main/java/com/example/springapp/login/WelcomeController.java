package com.example.springapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {


  //  private AuthenticationService authenticationService ;

//    @Autowired
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return authentication.getName();
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String welcomePage
//            (@RequestParam String name, @RequestParam String password, ModelMap model){
//
//        if(authenticationService.authenticate(name,password)){
//            model.put("name", name);
//            model.put("password", password);
//            return "welcome";
//        }
//        model.put("errorMessage","Invalid Credentials ! Please try again");
//        return "login";
//    }
}
