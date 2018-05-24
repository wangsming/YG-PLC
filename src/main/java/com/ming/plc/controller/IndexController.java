package com.ming.plc.controller;

import com.ming.plc.service.IndexServiceImp;
import com.ming.plc.utils.Json;
import com.ming.plc.utils.ParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    private String URL = "/";
//
    @Autowired
    IndexServiceImp indexServiceImp;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(ModelMap map){

        map.addAttribute("leftMenu","");

        return URL + "index";
    }


    @ResponseBody
    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public Json searchData(ParamsUtils params){

        Json json = indexServiceImp.findListMainData(params);

        return json;
    }




}
