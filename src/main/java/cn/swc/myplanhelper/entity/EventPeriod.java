package cn.swc.myplanhelper.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description 一天之内的某一个用户片段
 * @auther swc
 * @create 2020-02-20 20:22
 */
@Getter
@Setter
@Entity
@Table(name = "event_period")
public class EventPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_period_id")
    private int eventPeriodId;
    @Column(name = "event_period_title")
    private String title;
    @Column(name = "event_period_startTime")
    private LocalDateTime start;
    @Column(name = "event_period_endTime")
    private LocalDateTime end;
    @Column(name = "event_period_backgroundColor")
    private String backgroundColor;
    @Column(name = "event_period_borderColor")
    private String borderColor;
    @Column(name = "event_period_url")
    private String url;
}
