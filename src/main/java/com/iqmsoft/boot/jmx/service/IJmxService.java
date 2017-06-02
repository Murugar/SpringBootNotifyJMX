package com.iqmsoft.boot.jmx.service;

import org.springframework.web.servlet.ModelAndView;

import com.iqmsoft.boot.jmx.entity.RemoteJMXEntity;


public interface IJmxService {

    void remoteByEntity(RemoteJMXEntity remoteJMXEntity);

}
