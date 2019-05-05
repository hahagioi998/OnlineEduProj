package com.group7.edu.controller.wjy;

import com.group7.edu.entity.SysVideo;
import com.group7.edu.service.wjy.SysVideoService;
import com.group7.edu.utils.PageEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: WangJinYue
 * @Description:
 * @Date: Created in 8:52 2019/4/17
 * @Modified By:
 */
@RestController
@CrossOrigin(value = "*", allowCredentials = "true")
public class SysVideoController {

    @Resource(name = "sysVideoServiceWjy")
    private SysVideoService sysVideoService;

    @RequestMapping("/sys/my_collections")
    public ResponseEntity myCollections(SysVideo sysVideo){
        System.out.println("------------------------------------------------------------");
        System.out.println("SysVideoController.myCollections");
        System.out.println("sysVideo = [" + sysVideo + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        List<SysVideo> list = sysVideoService.findMyCollections();
        return new ResponseEntity(new PageEntity<>(list), HttpStatus.OK);
    }
}
