package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.AddressOfCustomer;
import cn.stylefeng.guns.modular.busi.model.params.AddressOfCustomerParam;
import cn.stylefeng.guns.modular.busi.service.AddressOfCustomerService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 客户地址表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/addressOfCustomer")
public class AddressOfCustomerController extends BaseController {

    private String PREFIX = "/modular/busi/addressOfCustomer";

    @Autowired
    private AddressOfCustomerService addressOfCustomerService;


    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/addressOfCustomer.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/addressOfCustomer_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/addressOfCustomer_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(AddressOfCustomerParam addressOfCustomerParam) {
        this.addressOfCustomerService.add(addressOfCustomerParam);
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
    public ResponseData editItem(AddressOfCustomerParam addressOfCustomerParam) {
        this.addressOfCustomerService.update(addressOfCustomerParam);
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
    public ResponseData delete(AddressOfCustomerParam addressOfCustomerParam) {
        this.addressOfCustomerService.delete(addressOfCustomerParam);
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
    public ResponseData detail(AddressOfCustomerParam addressOfCustomerParam) {
        AddressOfCustomer detail = this.addressOfCustomerService.getById(addressOfCustomerParam.getId());
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
    public LayuiPageInfo list(AddressOfCustomerParam addressOfCustomerParam) {
        return this.addressOfCustomerService.findPageBySpec(addressOfCustomerParam);
    }

}


