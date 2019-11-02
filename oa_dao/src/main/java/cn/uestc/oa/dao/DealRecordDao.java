package cn.uestc.oa.dao;


import cn.uestc.oa.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 详细注释参考EmployeeDao
 */
@Repository("dealRecordDao")
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    List<DealRecord> selectByClaimVoucher(int cvid);
}
