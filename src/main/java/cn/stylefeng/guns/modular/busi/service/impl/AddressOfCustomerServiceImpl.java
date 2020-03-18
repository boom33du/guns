package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressOfCustomer;
import cn.stylefeng.guns.modular.busi.mapper.AddressOfCustomerMapper;
import cn.stylefeng.guns.modular.busi.model.params.AddressOfCustomerParam;
import cn.stylefeng.guns.modular.busi.model.result.AddressOfCustomerResult;
import  cn.stylefeng.guns.modular.busi.service.AddressOfCustomerService;
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
 * 客户地址表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class AddressOfCustomerServiceImpl extends ServiceImpl<AddressOfCustomerMapper, AddressOfCustomer> implements AddressOfCustomerService {

    @Override
    public void add(AddressOfCustomerParam param){
        AddressOfCustomer entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(AddressOfCustomerParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(AddressOfCustomerParam param){
        AddressOfCustomer oldEntity = getOldEntity(param);
        AddressOfCustomer newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public AddressOfCustomerResult findBySpec(AddressOfCustomerParam param){
        return null;
    }

    @Override
    public List<AddressOfCustomerResult> findListBySpec(AddressOfCustomerParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(AddressOfCustomerParam param){
        Page pageContext = getPageContext();
        QueryWrapper<AddressOfCustomer> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(AddressOfCustomerParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private AddressOfCustomer getOldEntity(AddressOfCustomerParam param) {
        return this.getById(getKey(param));
    }

    private AddressOfCustomer getEntity(AddressOfCustomerParam param) {
        AddressOfCustomer entity = new AddressOfCustomer();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
