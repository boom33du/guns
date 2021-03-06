package cn.stylefeng.guns.modular.busi.wrapper;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.util.DecimalUtil;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

public class UserOfCustomerWrapper extends BaseControllerWrapper {

    public UserOfCustomerWrapper(Map<String, Object> single) {
        super(single);
    }
    public UserOfCustomerWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }
    public UserOfCustomerWrapper(Page<Map<String, Object>> page) {
        super(page);
    }
    public UserOfCustomerWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }
    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("userName",ConstantFactory.me().getUserAccountById(DecimalUtil.getLong(map.get("userId"))));//customerinfoId
        map.put("customerinfoName",ConstantFactory.me().getCustomerinfoName(DecimalUtil.getLong(map.get("customerinfoId"))));
    }
}
