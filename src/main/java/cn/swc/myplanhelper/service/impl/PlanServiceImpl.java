package cn.swc.myplanhelper.service.impl;

import cn.swc.myplanhelper.entity.EventPeriod;
import cn.swc.myplanhelper.entity.PlanTableInit;
import cn.swc.myplanhelper.repository.EventPeriodRepository;
import cn.swc.myplanhelper.repository.PlanTableInitRepository;
import cn.swc.myplanhelper.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Description 计划表的主要逻辑实现
 * @auther swc
 * @create 2020-02-21 21:06
 */
@Service
public class PlanServiceImpl implements PlanService{

    private final PlanTableInitRepository planTableInitRepository;
    private final EventPeriodRepository eventPeriodRepository;

    @Autowired
    public PlanServiceImpl(PlanTableInitRepository planTableInitRepository, EventPeriodRepository eventPeriodRepository) {
        this.planTableInitRepository = planTableInitRepository;
        this.eventPeriodRepository = eventPeriodRepository;
    }

    /**
     * 将原始计划,按照一定的逻辑,转化为单个事件片段
     * @param planTableInit 原始计划对象
     * @return 单个事件片段对象
     */
    @Override
    public EventPeriod initTransferToEventPeriod(PlanTableInit planTableInit) {
        // 首先查询数据库中的数据,以便于比较重要性(时间占比),和紧急性(优先级)

        // 进行比较

        // 模拟逻辑(用于测试)
        EventPeriod eventPeriod = new EventPeriod();
        eventPeriod.setTitle(planTableInit.getPlanName());
        if (planTableInit.getImportantLevel()*planTableInit.getEmergencyLevel() >= 15) {
            eventPeriod.setBackgroundColor("#00c0ef");
            eventPeriod.setBorderColor("#00c0ef");
            eventPeriod.setStart(LocalDateTime.of(2020,2,21,8,0));
            eventPeriod.setEnd(LocalDateTime.of(2020,2,21,10,0));
            eventPeriod.setUrl("hello world");
        } else {
            eventPeriod.setBackgroundColor("green");
            eventPeriod.setBorderColor("green");
            eventPeriod.setStart(LocalDateTime.of(2020,2,21,13,0));
            eventPeriod.setEnd(LocalDateTime.of(2020,2,21,14,0));
        }

        // 确定插入位置后,存入数据库
        eventPeriodRepository.save(eventPeriod);

        return eventPeriod;
    }

    /**
     * 将原始计划表存入数据库
     * @param planTableInit 原始计划对象
     */
    @Override
    public void addNewlyPlan(PlanTableInit planTableInit) {
        planTableInitRepository.save(planTableInit);
    }

    /**
     * 将事件片段加入数据库
     * @param eventPeriod 事件片段
     */
    @Override
    public void addNewEventPeriod(EventPeriod eventPeriod) {
        eventPeriodRepository.save(eventPeriod);
    }
}
