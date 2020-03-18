package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressOfCustomerWatermeter;
import cn.stylefeng.guns.modular.busi.model.params.AddressOfCustomerWatermeterParam;
import cn.stylefeng.guns.modular.busi.service.AddressOfCustomerWatermeterService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 客户地址水表对应表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/addressOfCustomerWatermeter")
public class AddressOfCustomerWatermeterController extends BaseController {

    private String PREFIX = "/modular/busi/addressOfCustomerWatermeter";

    @Autowired
    private AddressOfCustomerWatermeterService addressOfCustomerWatermeterService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/addressOfCustomerWatermeter.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/addressOfCustomerWatermeter_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/addressOfCustomerWatermeter_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(AddressOfCustomerWatermeterParam addressOfCustomerWatermeterParam) {
        this.addressOfCustomerWatermeterService.add(addressOfCustomerWatermeterParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(AddressOfCustomerWatermeterParam addressOfCustomerWatermeterParam) {
        this.addressOfCustomerWatermeterService.update(addressOfCustomerWatermeterParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(AddressOfCustomerWatermeterParam addressOfCustomerWatermeterParam) {
        this.addressOfCustomerWatermeterService.delete(addressOfCustomerWatermeterParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(AddressOfCustomerWatermeterParam addressOfCustomerWatermeterParam) {
        AddressOfCustomerWatermeter detail = this.addressOfCustomerWatermeterService.getById(addressOfCustomerWatermeterParam.getWatermeterinfoId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(AddressOfCustomerWatermeterParam addressOfCustomerWatermeterParam) {
        return this.addressOfCustomerWatermeterService.findPageBySpec(addressOfCustomerWatermeterParam);
    }

}


