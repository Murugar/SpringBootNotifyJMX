package com.iqmsoft.boot.jmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iqmsoft.boot.jmx.entity.RemoteJMXEntity;
import com.iqmsoft.boot.jmx.service.ClientListener;
import com.iqmsoft.boot.jmx.service.IJmxService;


@Controller
@SessionAttributes("remoteJMXEntity")
public class JmxWebController {

    @Autowired
    private IJmxService jmxService;

    @Autowired
    private RemoteJMXEntity remoteJMXEntity;

    @RequestMapping("/")
    public String startApp(ModelMap modelMap) {
        modelMap.addAttribute("remoteJMXEntity", remoteJMXEntity);
        return "remoteControl";
    }

    @RequestMapping("/remoteControl")
    public String remoteControl(RemoteJMXEntity remoteJMXEntity, ModelMap modelMap) {

        modelMap.addAttribute("remoteJMXEntity", remoteJMXEntity);

        System.out.println("Posting Data");

        jmxService.remoteByEntity(remoteJMXEntity);
        notificate(modelMap);

        return "remoteControl";
    }

    private void notificate(ModelMap modelMap) {

        modelMap.addAttribute("notification", ClientListener.getNotification());
        System.out.println();
    }

}
