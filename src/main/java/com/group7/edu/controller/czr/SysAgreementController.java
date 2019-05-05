package com.group7.edu.controller.czr;

import com.group7.edu.entity.SysAgreement;
import com.group7.edu.service.czr.SysAgreementService;
import com.group7.edu.utils.ResultData;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author c
 */
@RestController
@CrossOrigin(value = "*", allowCredentials = "true")
public class SysAgreementController {

    @Resource
    private SysAgreementService sysAgreementService;

    /**
     * 根据名称获取相关协议
     * @param name 协议名称
     * @return key:agreement value:协议对象
     */
    @RequestMapping("/agreement/get")
    public ResultData findAgreementByName(String name) {
        System.out.println("------------------------------------------------------------");
        System.out.println("SysAgreementController.findAgreementByName");
        System.out.println("name = [" + name + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        if (StringUtils.isBlank(name)) {
            return ResultData.isFailure("name值非法");
        }

        SysAgreement agreement = sysAgreementService.findAgreementByName(name);
        if (agreement == null) {
            return ResultData.isFailure("未找到相关的协议");
        }

        System.out.println("agreement = " + agreement);

        return ResultData.isSuccess().put("agreement", agreement);
    }

}
