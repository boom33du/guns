package cn.stylefeng.guns.modular.wtmm.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.wtmm.entity.Watermeterinfo;
import cn.stylefeng.guns.modular.wtmm.model.params.WatermeterinfoParam;
import cn.stylefeng.guns.modular.wtmm.service.WatermeterinfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 水表硬件信息登记表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:34:08
 */
@Controller
@RequestMapping("/watermeterinfo")
public class WatermeterinfoController extends BaseController {

    private String PREFIX = "/modular/wtmm/watermeterinfo";

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
        return PREFIX + "/watermeterinfo.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/watermeterinfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/watermeterinfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(WatermeterinfoParam watermeterinfoParam) {
        this.watermeterinfoService.add(watermeterinfoParam);
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
    public ResponseData editItem(WatermeterinfoParam watermeterinfoParam) {
        this.watermeterinfoService.update(watermeterinfoParam);
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
    public ResponseData delete(WatermeterinfoParam watermeterinfoParam) {
        this.watermeterinfoService.delete(watermeterinfoParam);
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
    public ResponseData detail(WatermeterinfoParam watermeterinfoParam) {
        Watermeterinfo detail = this.watermeterinfoService.getById(watermeterinfoParam.getId());
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
    public LayuiPageInfo list(@RequestParam(value = "condition", required = false) String condition) {
        // Page<Map<String, Object>> userOfCusms = this.userOfCustomerService.selectUserOfCusms("");//.selectRoles(roleName);
        //Page<Map<String, Object>> wrap = new UserOfCustomerWrapper(userOfCusms).wrap();
        return LayuiPageFactory.createPageInfo(this.watermeterinfoService.selectWatermeters(condition));
        //return this.userOfCustomerService.findPageBySpec(userOfCustomerParam);
        //return
    }
    /**
     * 查询列表
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    /*@ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(WatermeterinfoParam watermeterinfoParam) {
        return this.watermeterinfoService.findPageBySpec(watermeterinfoParam);
    }*/

}


