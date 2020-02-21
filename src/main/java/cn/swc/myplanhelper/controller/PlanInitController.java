package cn.swc.myplanhelper.controller;

import cn.swc.myplanhelper.entity.EventPeriod;
import cn.swc.myplanhelper.entity.PlanTableInit;
import cn.swc.myplanhelper.repository.PlanTableInitRepository;
import cn.swc.myplanhelper.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 表格初始化控制器
 * @auther swc
 * @create 2020-02-19 10:12
 */
@Controller
public class PlanInitController {

    private final PlanService planService;

    @Autowired
    public PlanInitController(PlanService planService) {
        this.planService = planService;
    }

    @RequestMapping("/initPlanTable")
    public String toTable(PlanTableInit init) {
        if (init != null) {
            planService.addNewlyPlan(init);
            EventPeriod eventPeriod = planService.initTransferToEventPeriod(init);
            planService.addNewEventPeriod(eventPeriod);
        }
        return "calendar";
    }
}
