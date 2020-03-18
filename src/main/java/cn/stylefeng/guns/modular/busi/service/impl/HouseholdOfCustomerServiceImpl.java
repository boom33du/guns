package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.HouseholdOfCustomer;
import cn.stylefeng.guns.modular.busi.mapper.HouseholdOfCustomerMapper;
import cn.stylefeng.guns.modular.busi.model.params.HouseholdOfCustomerParam;
import cn.stylefeng.guns.modular.busi.model.result.HouseholdOfCustomerResult;
import  cn.stylefeng.guns.modular.busi.service.HouseholdOfCustomerService;
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
 * 客户居民用户表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class HouseholdOfCustomerServiceImpl extends ServiceImpl<HouseholdOfCustomerMapper, HouseholdOfCustomer> implements HouseholdOfCustomerService {

    @Override
    public void add(HouseholdOfCustomerParam param){
        HouseholdOfCustomer entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(HouseholdOfCustomerParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(HouseholdOfCustomerParam param){
        HouseholdOfCustomer oldEntity = getOldEntity(param);
        HouseholdOfCustomer newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public HouseholdOfCustomerResult findBySpec(HouseholdOfCustomerParam param){
        return null;
    }

    @Override
    public List<HouseholdOfCustomerResult> findListBySpec(HouseholdOfCustomerParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(HouseholdOfCustomerParam param){
        Page pageContext = getPageContext();
        QueryWrapper<HouseholdOfCustomer> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(HouseholdOfCustomerParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private HouseholdOfCustomer getOldEntity(HouseholdOfCustomerParam param) {
        return this.getById(getKey(param));
    }

    private HouseholdOfCustomer getEntity(HouseholdOfCustomerParam param) {
        HouseholdOfCustomer entity = new HouseholdOfCustomer();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
