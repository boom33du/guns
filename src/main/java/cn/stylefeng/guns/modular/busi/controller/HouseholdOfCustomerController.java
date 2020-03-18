package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.HouseholdOfCustomer;
import cn.stylefeng.guns.modular.busi.model.params.HouseholdOfCustomerParam;
import cn.stylefeng.guns.modular.busi.service.HouseholdOfCustomerService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 客户居民用户表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/householdOfCustomer")
public class HouseholdOfCustomerController extends BaseController {

    private String PREFIX = "/modular/busi/householdOfCustomer";

    @Autowired
    private HouseholdOfCustomerService householdOfCustomerService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/householdOfCustomer.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/householdOfCustomer_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/householdOfCustomer_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(HouseholdOfCustomerParam householdOfCustomerParam) {
        this.householdOfCustomerService.add(householdOfCustomerParam);
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
    public ResponseData editItem(HouseholdOfCustomerParam householdOfCustomerParam) {
        this.householdOfCustomerService.update(householdOfCustomerParam);
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
    public ResponseData delete(HouseholdOfCustomerParam householdOfCustomerParam) {
        this.householdOfCustomerService.delete(householdOfCustomerParam);
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
    public ResponseData detail(HouseholdOfCustomerParam householdOfCustomerParam) {
        HouseholdOfCustomer detail = this.householdOfCustomerService.getById(householdOfCustomerParam.getId());
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
    public LayuiPageInfo list(HouseholdOfCustomerParam householdOfCustomerParam) {
        return this.householdOfCustomerService.findPageBySpec(householdOfCustomerParam);
    }

}


