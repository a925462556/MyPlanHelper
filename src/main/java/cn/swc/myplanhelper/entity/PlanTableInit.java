package cn.swc.myplanhelper.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Description 计划表实体类
 * @auther swc
 * @create 2020-02-19 10:14
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "t_plan_init")
public class PlanTableInit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "init_id")
    private int id;
    @Column(name = "init_importantLevel")
    private int importantLevel;
    @Column(name = "init_emergencyLevel")
    private int emergencyLevel;
    @Column(name = "init_planName")
    private String planName;
    @Column(name = "init_duringTime")
    private int duringTime;
}
