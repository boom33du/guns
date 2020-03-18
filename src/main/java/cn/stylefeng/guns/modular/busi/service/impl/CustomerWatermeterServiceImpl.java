package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.CustomerWatermeter;
import cn.stylefeng.guns.modular.busi.mapper.CustomerWatermeterMapper;
import cn.stylefeng.guns.modular.busi.model.params.CustomerWatermeterParam;
import cn.stylefeng.guns.modular.busi.model.result.CustomerWatermeterResult;
import  cn.stylefeng.guns.modular.busi.service.CustomerWatermeterService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户水表对应表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class CustomerWatermeterServiceImpl extends ServiceImpl<CustomerWatermeterMapper, CustomerWatermeter> implements CustomerWatermeterService {

    @Override
    public void add(CustomerWatermeterParam param){
        CustomerWatermeter entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(CustomerWatermeterParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(CustomerWatermeterParam param){
        CustomerWatermeter oldEntity = getOldEntity(param);
        CustomerWatermeter newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public CustomerWatermeterResult findBySpec(CustomerWatermeterParam param){
        return null;
    }

    @Override
    public List<CustomerWatermeterResult> findListBySpec(CustomerWatermeterParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(CustomerWatermeterParam param){
        Page pageContext = getPageContext();
        QueryWrapper<CustomerWatermeter> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(CustomerWatermeterParam param){
        return param.getWatermeterinfoId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private CustomerWatermeter getOldEntity(CustomerWatermeterParam param) {
        return this.getById(getKey(param));
    }

    private CustomerWatermeter getEntity(CustomerWatermeterParam param) {
        CustomerWatermeter entity = new CustomerWatermeter();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

    /**
     * 查询所有水表分配情况
     */
    public Page<Map<String, Object>> selectCustomerWaterMeter(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectCustomerWaterMeter(page, condition);
    }
}
