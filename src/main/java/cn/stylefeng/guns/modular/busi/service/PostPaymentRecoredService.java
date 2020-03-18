package cn.stylefeng.guns.modular.busi.service;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.PostPaymentRecored;
import cn.stylefeng.guns.modular.busi.model.params.PostPaymentRecoredParam;
import cn.stylefeng.guns.modular.busi.model.result.PostPaymentRecoredResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户居民账单_缴费记录表(后付) 服务类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
public interface PostPaymentRecoredService extends IService<PostPaymentRecored> {

    /**
     * 新增
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void add(PostPaymentRecoredParam param);

    /**
     * 删除
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void delete(PostPaymentRecoredParam param);

    /**
     * 更新
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    void update(PostPaymentRecoredParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    PostPaymentRecoredResult findBySpec(PostPaymentRecoredParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    List<PostPaymentRecoredResult> findListBySpec(PostPaymentRecoredParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
     LayuiPageInfo findPageBySpec(PostPaymentRecoredParam param);

}
