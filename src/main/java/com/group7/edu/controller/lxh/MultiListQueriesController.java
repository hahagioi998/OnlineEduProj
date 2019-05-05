package com.group7.edu.controller.lxh;

import com.group7.edu.entity.lxh.*;
import com.group7.edu.entity.lxh.MultiListQueries;
import com.group7.edu.service.lxh.MultiListQueriesService;
import com.group7.edu.utils.PageEntity;
import com.group7.edu.utils.SysConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author default
 * @date 2019/4/11
 */
@RestController("multiListQueriesControllerLxh")
@CrossOrigin(value = "*", allowCredentials = "true")
public class MultiListQueriesController {

    @Resource(name = "multiListQueriesServiceLxh")
    private MultiListQueriesService multiListQueriesService;
    @RequestMapping("/home/multi/list")
    public List multiListQueries(@RequestBody(required = false) MultiListQueries multiListQueries ) {
        System.out.println("------------------------------------------------------------");
        System.out.println("MultiListQueriesController.multiListQueries");
        System.out.println("multiListQueries = [" + multiListQueries + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");

        System.out.println(multiListQueries.getPageSize()+"\t"+multiListQueries.getPageNum());

        Map<String, Object> map = new HashMap<>();
        Integer pageNum  = multiListQueries.getPageNum();
        Integer pageSize = multiListQueries.getPageSize();
        String  params   = multiListQueries.getParams();

        System.out.println(pageNum+"\t"+pageSize+"\t"+params);

            SysNews sysNews = new SysNews();
            sysNews.setParams(params);
            sysNews.setPageNum(pageNum);
            sysNews.setPageSize(pageSize);
            List<?> news = newsList(sysNews);
            for (Object news1 : news) {
                System.out.println("\t\t\tnews:"+news1.toString());

            }


        SysCourse sysCourse = new SysCourse();
            sysCourse.setParams(params);
            sysCourse.setPageNum(pageNum);
            sysCourse.setPageSize(pageSize);
            List<?> course = courseList(sysCourse);
            for (Object course1 : course) {
                System.out.println("\t\t\t course:"+course1.toString());
            }

            SysIndustryInfo sysIndustryInfo = new SysIndustryInfo();
            sysIndustryInfo.setParams(params);
            sysIndustryInfo.setPageNum(pageNum);
            sysIndustryInfo.setPageSize(pageSize);
            List<?> info = infoList(sysIndustryInfo);
                for (Object industryInfo : info) {
                    System.out.println("\t\t\tindustryInfo:"+industryInfo.toString());
                }


            SysSubject sysSubject = new SysSubject();
            sysSubject.setParams(params);
            sysSubject.setPageNum(pageNum);
            sysSubject.setPageSize(pageSize);
            List<?> subject = subjectList(sysSubject);

            System.out.println(subject.toString());
            for (Object subject1 : subject) {

                System.out.println("\t\t\tsysSubjects:"+subject1.toString());

            }

           map.put("news",news);
           map.put("info",info);
           map.put("subject",subject);
           map.put("course",course);

        List list = mapTransitionList(map);
        for (Object o : list) {
            System.out.println("\t\t\tobject:"+o.toString());
        }
           // List<MultiListQueries> list = multiListQueriesService.multiListQueries(multiListQueries);
    return list;
      //  return  new ResponseEntity( new PageEntity<>(list), HttpStatus.OK);
    }


     public List<?> newsList(@RequestBody SysNews news){
         System.out.println("------------------------------------------------------------");
         System.out.println("MultiListQueriesController.newsList");
         System.out.println("news = [" + news + "]");
         System.out.println("time = " + new Date());
         System.out.println("------------------------------------------------------------");
         List<SysNews> list = multiListQueriesService.newsList(news);

         list.forEach(sysNews -> {
             sysNews.setCoverUuid(SysConst.IMG_URL);
         });

         return list;
     }

    @RequestMapping("/home/new/list")
    public ResponseEntity findNewsList(@RequestBody SysNews news){
        System.out.println("------------------------------------------------------------");
        System.out.println("MultiListQueriesController.findNewsList");
        System.out.println("news = [" + news + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        List<SysNews> list = multiListQueriesService.newsList(news);

        list.forEach(sysNews -> {
            sysNews.setCoverUuid(SysConst.IMG_URL);
        });

        return   new ResponseEntity( new PageEntity<>(list), HttpStatus.OK);
    }
    //@RequestMapping("/home/course/listl")
    public List<?> courseList(@RequestBody SysCourse sysCourse){
        System.out.println("------------------------------------------------------------");
        System.out.println("MultiListQueriesController.courseList");
        System.out.println("sysCourse = [" + sysCourse + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        List<SysCourse> list = multiListQueriesService.courseList(sysCourse);

        return list;
    }

    @RequestMapping("/home/info/list")
    public  List<?> infoList(@RequestBody SysIndustryInfo info){
        System.out.println("------------------------------------------------------------");
        System.out.println("MultiListQueriesController.infoList");
        System.out.println("info = [" + info + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        List<SysIndustryInfo> list = multiListQueriesService.infoList(info);

        list.forEach(sysIndustryInfo -> {
            sysIndustryInfo.setImageUuid(SysConst.IMG_URL);
        });

        return list;
    }

    @RequestMapping("/home/subject/list")
    public List<?> subjectList(@RequestBody SysSubject subject){
        System.out.println("------------------------------------------------------------");
        System.out.println("MultiListQueriesController.subjectList");
        System.out.println("subject = [" + subject + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        List<SysSubject> list = multiListQueriesService.subjectList(subject);

        return list;
    }


    public static List mapTransitionList(Map map) {
        System.out.println("------------------------------------------------------------");
        System.out.println("MultiListQueriesController.mapTransitionList");
        System.out.println("map = [" + map + "]");
        System.out.println("time = " + new Date());
        System.out.println("------------------------------------------------------------");
        List list = new ArrayList();
        Iterator iter = map.entrySet().iterator(); // 获得map的Iterator
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            list.add(entry.getKey());
            list.add(entry.getValue());
        }
        return list;
    }

}
