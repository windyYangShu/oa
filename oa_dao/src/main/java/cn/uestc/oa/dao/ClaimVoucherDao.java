package cn.uestc.oa.dao;


import cn.uestc.oa.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 详细注释参考EmployeeDao
 */
@Repository("claimVoucherDao")
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(int id);
    ClaimVoucher select(int id);
    List<ClaimVoucher> selectByCreateSn(String csn);
    List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
