package hu.zsolt.damu.betVictor.controllers;

import hu.zsolt.damu.betVictor.service.SavedObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by TamasZsolt on 30/06/2015.
 */

@Controller
public class EntranceController {

    @Autowired
    private SavedObjectService savedObjectService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpSession session) { return "index"; }

}
