package cn.swc.myplanhelper.controller;

import cn.swc.myplanhelper.entity.EventPeriod;
import cn.swc.myplanhelper.entity.EventPeriodModel;
import cn.swc.myplanhelper.repository.EventPeriodRepository;
import cn.swc.myplanhelper.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @auther swc
 * @create 2020-02-21 10:50
 */
@Controller
public class ViewController {

    private final PlanService planService;
    private final EventPeriodRepository eventPeriodRepository;

    @Autowired
    public ViewController(EventPeriodRepository eventPeriodRepository, PlanService planService) {
        this.eventPeriodRepository = eventPeriodRepository;
        this.planService = planService;
    }

    @RequestMapping("/getMyEvents")
    @ResponseBody
    public EventPeriodModel ViewCalendar() {
        EventPeriod eventPeriod = eventPeriodRepository.findAll().get(0);
        // 支持了国际化的时间区域自动修改
        EventPeriodModel eventPeriodModel = new EventPeriodModel(eventPeriod);
        return eventPeriodModel;
    }

    @RequestMapping("/Calendar")
    public String calendar() {
        System.out.println("...");
        return "calendar";
    }
}
