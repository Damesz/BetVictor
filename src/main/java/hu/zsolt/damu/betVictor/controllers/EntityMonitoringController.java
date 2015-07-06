package hu.zsolt.damu.betVictor.controllers;

import hu.zsolt.damu.betVictor.domains.NotificationMessage;
import hu.zsolt.damu.betVictor.domains.SavedObject;
import hu.zsolt.damu.betVictor.service.SavedObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by TamasZsolt on 01/07/2015.
 */
@Controller
public class EntityMonitoringController {

    private static final String MESSAGE_PREFIX = "New element on the database: ";

    @Autowired
    SavedObjectService savedObjectService;

    @MessageMapping("/add" )
    @SendTo("/topic/showResult")
    public NotificationMessage addMessage(String comment) throws Exception {
        SavedObject object = savedObjectService.createSavedObject(comment);
        NotificationMessage message = new NotificationMessage(MESSAGE_PREFIX + object.toString());
        return message;
    }

    @RequestMapping("/start")
    public String start() {
        return "start";
    }
}