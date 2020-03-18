package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.PostPaymentRecored;
import cn.stylefeng.guns.modular.busi.mapper.PostPaymentRecoredMapper;
import cn.stylefeng.guns.modular.busi.model.params.PostPaymentRecoredParam;
import cn.stylefeng.guns.modular.busi.model.result.PostPaymentRecoredResult;
import  cn.stylefeng.guns.modular.busi.service.PostPaymentRecoredService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 客户居民账单_缴费记录表(后付) 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class PostPaymentRecoredServiceImpl extends ServiceImpl<PostPaymentRecoredMapper, PostPaymentRecored> implements PostPaymentRecoredService {

    @Override
    public void add(PostPaymentRecoredParam param){
        PostPaymentRecored entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(PostPaymentRecoredParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(PostPaymentRecoredParam param){
        PostPaymentRecored oldEntity = getOldEntity(param);
        PostPaymentRecored newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public PostPaymentRecoredResult findBySpec(PostPaymentRecoredParam param){
        return null;
    }

    @Override
    public List<PostPaymentRecoredResult> findListBySpec(PostPaymentRecoredParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(PostPaymentRecoredParam param){
        Page pageContext = getPageContext();
        QueryWrapper<PostPaymentRecored> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(PostPaymentRecoredParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private PostPaymentRecored getOldEntity(PostPaymentRecoredParam param) {
        return this.getById(getKey(param));
    }

    private PostPaymentRecored getEntity(PostPaymentRecoredParam param) {
        PostPaymentRecored entity = new PostPaymentRecored();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
