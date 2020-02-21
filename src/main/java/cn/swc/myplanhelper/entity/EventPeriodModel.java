package cn.swc.myplanhelper.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @Description 用于展示事件片段的model
 * @auther swc
 * @create 2020-02-21 13:31
 */
@Getter
@Setter
public class EventPeriodModel {
    private EventPeriod eventPeriod;
    private int[] year = new int[2];
    private int[] month = new int[2];
    private int[] day = new int[2];
    private int[] hour = new int[2];
    private int[] minute = new int[2];

    public EventPeriodModel(EventPeriod eventPeriod) {
        this.eventPeriod = eventPeriod;
        LocalDateTime start = eventPeriod.getStart();
        LocalDateTime end = eventPeriod.getEnd();
        this.year[0] = start.getYear();
        this.year[1] = end.getYear();
        this.month[0] = start.getMonth().getValue();
        this.month[1] = end.getMonth().getValue();
        this.day[0] = start.getDayOfMonth();
        this.day[1] = end.getDayOfMonth();
        this.hour[0] = start.getHour();
        this.hour[1] = end.getHour();
        this.minute[0] = start.getMinute();
        this.minute[1] = end.getMinute();
    }
}
