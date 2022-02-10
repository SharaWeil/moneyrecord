package com.hzh.moneyrecord.controller;


import com.hzh.moneyrecord.enmus.ConstantAttribute;
import com.hzh.moneyrecord.enmus.Status;
import com.hzh.moneyrecord.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2022-02-09
 */
@RestController
@RequestMapping("/record")
public class ConsumerRecordController extends BaseController {


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Result testHttp(){
        HashMap<String, Object> result = new HashMap<>(12);
        result.put(ConstantAttribute.STATUS, Status.SUCCESS);
        result.put(ConstantAttribute.DATA_LIST,"testResult");
        return returnDataList(result);
    }
}
