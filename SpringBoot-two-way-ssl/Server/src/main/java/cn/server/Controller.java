package cn.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server-app")
public class Controller {

    @GetMapping("/data")
    public String getData(){

        System.out.println("Returning data from server-app data method");
        return "Hello from Server-App-data method";
    }
}
