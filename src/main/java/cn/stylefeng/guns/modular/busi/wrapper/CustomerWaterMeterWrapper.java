package cn.stylefeng.guns.modular.busi.wrapper;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.guns.core.util.DecimalUtil;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

public class CustomerWaterMeterWrapper extends BaseControllerWrapper {

    public CustomerWaterMeterWrapper(Map<String, Object> single) {
        super(single);
    }
    public CustomerWaterMeterWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }
    public CustomerWaterMeterWrapper(Page<Map<String, Object>> page) {
        super(page);
    }
    public CustomerWaterMeterWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("customerinfoName", ConstantFactory.me().getCustomerinfoName(DecimalUtil.getLong(map.get("customerinfoId"))));//customerinfoId
        map.put("waterMeterDeviceId",ConstantFactory.me().getWaterMeterDeviceId(DecimalUtil.getLong(map.get("watermeterinfoId"))));
    }
}
