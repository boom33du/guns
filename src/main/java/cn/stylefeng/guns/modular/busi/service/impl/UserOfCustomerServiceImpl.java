package cn.stylefeng.guns.modular.busi.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.UserOfCustomer;
import cn.stylefeng.guns.modular.busi.mapper.UserOfCustomerMapper;
import cn.stylefeng.guns.modular.busi.model.params.UserOfCustomerParam;
import cn.stylefeng.guns.modular.busi.model.result.UserOfCustomerResult;
import  cn.stylefeng.guns.modular.busi.service.UserOfCustomerService;
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
 * 用户客户对应表 服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-12-11
 */
@Service
public class UserOfCustomerServiceImpl extends ServiceImpl<UserOfCustomerMapper, UserOfCustomer> implements UserOfCustomerService {

    @Override
    public void add(UserOfCustomerParam param){
        UserOfCustomer entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(UserOfCustomerParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(UserOfCustomerParam param){
        UserOfCustomer oldEntity = getOldEntity(param);
        UserOfCustomer newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public UserOfCustomerResult findBySpec(UserOfCustomerParam param){
        return null;
    }

    @Override
    public List<UserOfCustomerResult> findListBySpec(UserOfCustomerParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(UserOfCustomerParam param){
        Page pageContext = getPageContext();
        QueryWrapper<UserOfCustomer> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(UserOfCustomerParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private UserOfCustomer getOldEntity(UserOfCustomerParam param) {
        return this.getById(getKey(param));
    }

    private UserOfCustomer getEntity(UserOfCustomerParam param) {
        UserOfCustomer entity = new UserOfCustomer();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

    /**
     * 根据条件查询角色列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    public Page<Map<String, Object>> selectUserOfCusms(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectUserOfCusms(page, condition);
    }

}
