package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.CustomerWatermeter;
import cn.stylefeng.guns.modular.busi.model.params.CustomerWatermeterParam;
import cn.stylefeng.guns.modular.busi.service.CustomerWatermeterService;
import cn.stylefeng.guns.modular.busi.service.CustomerinfoService;
import cn.stylefeng.guns.modular.wtmm.service.WatermeterinfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 客户水表对应表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/customerWatermeter")
public class CustomerWatermeterController extends BaseController {

    private String PREFIX = "/modular/busi/customerWatermeter";

    @Autowired
    private CustomerWatermeterService customerWatermeterService;

    @Autowired
    private CustomerinfoService customerinfoService;

    @Autowired
    private WatermeterinfoService watermeterinfoService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/customerWatermeter.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add(Model model) {
        //将所有用户和水表查询出来，放在列表中
        model.addAttribute("customers",customerinfoService.list());
        model.addAttribute("watermeters",watermeterinfoService.list());

        return PREFIX + "/customerWatermeter_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit(Model model) {
        //同添加页面
        model.addAttribute("customers",customerinfoService.list());
        model.addAttribute("watermeters",watermeterinfoService.list());

        return PREFIX + "/customerWatermeter_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(CustomerWatermeterParam customerWatermeterParam) {
        this.customerWatermeterService.add(customerWatermeterParam);
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
    public ResponseData editItem(CustomerWatermeterParam customerWatermeterParam) {
        this.customerWatermeterService.update(customerWatermeterParam);
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
    public ResponseData delete(CustomerWatermeterParam customerWatermeterParam) {
        this.customerWatermeterService.delete(customerWatermeterParam);
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
    public ResponseData detail(CustomerWatermeterParam customerWatermeterParam) {
        CustomerWatermeter detail = this.customerWatermeterService.getById(customerWatermeterParam.getWatermeterinfoId());
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
    public LayuiPageInfo list(@RequestParam(value = "condition",required = false) String condition ) {
        return LayuiPageFactory.createPageInfo(this.customerWatermeterService.selectCustomerWaterMeter(condition));
    }

}


