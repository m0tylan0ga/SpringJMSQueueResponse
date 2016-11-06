package com.example;

import com.example.models.QueueDao;
import com.example.models.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppController {

    static final Logger log = LoggerFactory.getLogger(AppController.class);
    
    @Autowired
    private QueueDao queueDao;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String prepareOrder(ModelMap model) {
        model.addAttribute("subscribers", queueDao.getAllSubscribedQueues());
        return "user";
    }

}
