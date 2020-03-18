package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressOfCustomerWatermeter;
import cn.stylefeng.guns.modular.busi.mapper.AddressOfCustomerWatermeterMapper;
import cn.stylefeng.guns.modular.busi.model.params.AddressOfCustomerWatermeterParam;
import cn.stylefeng.guns.modular.busi.model.result.AddressOfCustomerWatermeterResult;
import  cn.stylefeng.guns.modular.busi.service.AddressOfCustomerWatermeterService;
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
 * 客户地址水表对应表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class AddressOfCustomerWatermeterServiceImpl extends ServiceImpl<AddressOfCustomerWatermeterMapper, AddressOfCustomerWatermeter> implements AddressOfCustomerWatermeterService {

    @Override
    public void add(AddressOfCustomerWatermeterParam param){
        AddressOfCustomerWatermeter entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(AddressOfCustomerWatermeterParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(AddressOfCustomerWatermeterParam param){
        AddressOfCustomerWatermeter oldEntity = getOldEntity(param);
        AddressOfCustomerWatermeter newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public AddressOfCustomerWatermeterResult findBySpec(AddressOfCustomerWatermeterParam param){
        return null;
    }

    @Override
    public List<AddressOfCustomerWatermeterResult> findListBySpec(AddressOfCustomerWatermeterParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(AddressOfCustomerWatermeterParam param){
        Page pageContext = getPageContext();
        QueryWrapper<AddressOfCustomerWatermeter> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(AddressOfCustomerWatermeterParam param){
        return param.getWatermeterinfoId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private AddressOfCustomerWatermeter getOldEntity(AddressOfCustomerWatermeterParam param) {
        return this.getById(getKey(param));
    }

    private AddressOfCustomerWatermeter getEntity(AddressOfCustomerWatermeterParam param) {
        AddressOfCustomerWatermeter entity = new AddressOfCustomerWatermeter();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
