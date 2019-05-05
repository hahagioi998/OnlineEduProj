package com.group7.edu.controller.lxh;

import com.group7.edu.entity.lxh.SysNews;
import com.group7.edu.service.lxh.SysNewsService;
import com.group7.edu.utils.PageEntity;
import com.group7.edu.utils.SysConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author default
 * @date 2019/4/10
 */
@RestController("sysNewsControllerLxh")
@CrossOrigin(value = "*", allowCredentials = "true")
public class SysNewsController {
    @Resource(name = "sysNewsServiceLxh")
    private SysNewsService sysNewsService;
    @RequestMapping("/home/news/list")
    public ResponseEntity findSysCourse(@RequestBody SysNews sysNews) {
        System.out.println("------------------------------------------------------------");
        System.out.println("SysNewsController.findSysCourse");
        System.out.println("sysNews = [" + sysNews + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        List<SysNews> list = sysNewsService.selectAllSysNews(sysNews);

        for (SysNews news : list) {
            news.setCoverUuid(SysConst.IMG_URL2);
            System.out.println("news = " + news);
        }

        return new ResponseEntity( new PageEntity<>(list), HttpStatus.OK);
    }

}
