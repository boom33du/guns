package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.modular.busi.entity.Customerinfo;
import cn.stylefeng.guns.modular.busi.mapper.CustomerinfoMapper;
import cn.stylefeng.guns.modular.busi.model.params.CustomerinfoParam;
import cn.stylefeng.guns.modular.busi.model.result.CustomerinfoResult;
import  cn.stylefeng.guns.modular.busi.service.CustomerinfoService;
import cn.stylefeng.guns.modular.system.entity.User;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 客户信息表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class CustomerinfoServiceImpl extends ServiceImpl<CustomerinfoMapper, Customerinfo> implements CustomerinfoService {

    @Override
    public void add(CustomerinfoParam param){
        ShiroUser user = ShiroKit.getUserNotNull();

        param.setCreator(user.getAccount()+"-"+user.getName());
        param.setCreattime(new Date());
        param.setWatermetercount(0);
        Customerinfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(CustomerinfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(CustomerinfoParam param){
        Customerinfo oldEntity = getOldEntity(param);
        Customerinfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public CustomerinfoResult findBySpec(CustomerinfoParam param){
        return null;
    }

    @Override
    public List<CustomerinfoResult> findListBySpec(CustomerinfoParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(CustomerinfoParam param){
        Page pageContext = getPageContext();
        QueryWrapper<Customerinfo> objectQueryWrapper = new QueryWrapper<>();
        /*objectQueryWrapper.and(
                wrapper  -> wrapper
                        .like("customername",param.getCondition())
                        .like("customercode",param.getCondition()));
         */
        objectQueryWrapper
                .like("customername",param.getCondition())
                .or()
                .like("customercode",param.getCondition());
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(CustomerinfoParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Customerinfo getOldEntity(CustomerinfoParam param) {
        return this.getById(getKey(param));
    }

    private Customerinfo getEntity(CustomerinfoParam param) {
        Customerinfo entity = new Customerinfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
