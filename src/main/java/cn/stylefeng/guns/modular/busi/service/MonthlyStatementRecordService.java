package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.MonthlyStatementRecord;
import cn.stylefeng.guns.modular.busi.model.params.MonthlyStatementRecordParam;
import cn.stylefeng.guns.modular.busi.model.result.MonthlyStatementRecordResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 月结记录表 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface MonthlyStatementRecordService extends IService<MonthlyStatementRecord> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(MonthlyStatementRecordParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(MonthlyStatementRecordParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(MonthlyStatementRecordParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    MonthlyStatementRecordResult findBySpec(MonthlyStatementRecordParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<MonthlyStatementRecordResult> findListBySpec(MonthlyStatementRecordParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(MonthlyStatementRecordParam param);

}
