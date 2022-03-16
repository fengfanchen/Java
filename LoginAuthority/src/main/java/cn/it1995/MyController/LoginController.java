package cn.it1995.MyController;

import cn.it1995.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String index(HttpServletResponse response,
                        Model model){



        String cookie = loginService.generateCookie();
        String salt = loginService.getSaltByCookie(cookie);
        String offset = loginService.getOffsetByCookie(cookie);
        response.addCookie(new Cookie("token", cookie));
        model.addAttribute("saltStr", salt);
        model.addAttribute("offsetStr", offset);

        return "login.html";
    }

    @PostMapping
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        String cookie = "";
        for(Integer i = 0; i < cookies.length; i++){

            if(cookies[i].getName().equals("token")){

                cookie = cookies[i].getValue();
            }
        }

        if(cookie.equals("")){

            return "redircet:/";
        }

//        String salt = loginService.getSaltByCookie(cookie);
        try{

            boolean passwordCorrect = loginService.isPasswordCorrect(cookie, password);
            System.out.println("The passwordCorrect is " + passwordCorrect);
            if(!passwordCorrect){

                return "redirect:/";
            }
        }
        catch (Exception e){

            e.printStackTrace();
            return "redirect:/";
        }

//        System.out.println(userName);
//        System.out.println(password);
//        System.out.println(salt);

        return "success.html";
    }
}
