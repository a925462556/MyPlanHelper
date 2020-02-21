package cn.swc.myplanhelper.repository;

import cn.swc.myplanhelper.entity.EventPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description
 * @auther swc
 * @create 2020-02-21 11:59
 */
public interface EventPeriodRepository extends JpaRepository<EventPeriod, Integer>, JpaSpecificationExecutor<Integer>{
}
