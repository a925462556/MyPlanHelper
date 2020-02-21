package cn.swc.myplanhelper.service;

import cn.swc.myplanhelper.entity.EventPeriod;
import cn.swc.myplanhelper.entity.PlanTableInit;

/**
 * @Description
 * @auther swc
 * @create 2020-02-21 21:06
 */
public interface PlanService {
    // 将获取到的初始计划按照条件和一定的逻辑转化为对应时间段的方法
    EventPeriod initTransferToEventPeriod(PlanTableInit planTableInit);

    // 将新的计划加入事件表
    void addNewlyPlan(PlanTableInit planTableInit);

    // 将从计划转化而成的事件片段存入数据库
    void addNewEventPeriod(EventPeriod eventPeriod);
}
