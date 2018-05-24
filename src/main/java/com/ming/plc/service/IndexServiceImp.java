package com.ming.plc.service;

import com.ming.plc.entity.PlasticPipe;
import com.ming.plc.repository.PlasticpipeI;
import com.ming.plc.utils.Json;
import com.ming.plc.utils.ParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImp {

    @Autowired
    PlasticpipeI  plasticpipeI;

    public Json findListMainData(ParamsUtils params) {
        Json json = new Json(true, "");
        List<PlasticPipe> findListMainData = plasticpipeI.findAll();



        json.setObj(findListMainData);
        return json;
    }
}
