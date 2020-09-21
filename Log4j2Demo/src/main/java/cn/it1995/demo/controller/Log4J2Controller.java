package cn.it1995.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4J2Controller {

    private static final Logger LOG = LogManager.getLogger(Log4J2Controller.class);

    @GetMapping("/test")
    public String test(){

        LOG.debug("Debugging Debugging Debugging Debugging");
        LOG.info("Info Info Info Info Info Info Info Info");
        LOG.warn("Warn Warn Warn Warn Warn Warn Warn Warn");
        LOG.error("Error Error Error Error Error Error Error");
        LOG.fatal("Fatal Fatal Fatal Fatal Fatal Fatal Fatal");
        return "Hello Test";
    }
}
