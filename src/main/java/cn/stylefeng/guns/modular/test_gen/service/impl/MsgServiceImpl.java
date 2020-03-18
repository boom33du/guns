package cn.stylefeng.guns.modular.test_gen.service.impl;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.test_gen.entity.Msg;
import cn.stylefeng.guns.modular.test_gen.mapper.MsgMapper;
import cn.stylefeng.guns.modular.test_gen.model.params.MsgParam;
import cn.stylefeng.guns.modular.test_gen.model.result.MsgResult;
import  cn.stylefeng.guns.modular.test_gen.service.MsgService;
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
 *  服务实现类
 * </p>
 *
 * @author zhuhailin
 * @since 2019-10-06
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements MsgService {

    @Override
    public void add(MsgParam param){
        Msg entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MsgParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MsgParam param){
        Msg oldEntity = getOldEntity(param);
        Msg newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MsgResult findBySpec(MsgParam param){
        return null;
    }

    @Override
    public List<MsgResult> findListBySpec(MsgParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MsgParam param){
        Page pageContext = getPageContext();
        QueryWrapper<Msg> objectQueryWrapper = new QueryWrapper<>();
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(MsgParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Msg getOldEntity(MsgParam param) {
        return this.getById(getKey(param));
    }

    private Msg getEntity(MsgParam param) {
        Msg entity = new Msg();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
