package hu.zsolt.damu.betVictor.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TamasZsolt on 04/07/2015.
 */

@RestController
public class BonusController {

    private static final String JSON = "application/json";

    @Value("${version:1.0}")
    private String version;

    @RequestMapping(value = "/bonus/version", method = RequestMethod.GET, produces = JSON)
    public String getAppVersion() {
        return version;
    }

    @RequestMapping(value = "/bonus/check", method = RequestMethod.GET, produces = JSON)
    public String isRunning() {
        return "OK";
    }
}
