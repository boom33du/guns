package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.UserOfCustomer;
import cn.stylefeng.guns.modular.busi.model.params.UserOfCustomerParam;
import cn.stylefeng.guns.modular.busi.service.CustomerinfoService;
import cn.stylefeng.guns.modular.busi.service.UserOfCustomerService;
import cn.stylefeng.guns.modular.busi.wrapper.UserOfCustomerWrapper;
import cn.stylefeng.guns.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
/**
 * 用户客户对应表控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/userOfCustomer")
public class UserOfCustomerController extends BaseController {

    private String PREFIX = "/modular/busi/userOfCustomer";

    @Autowired
    private UserOfCustomerService userOfCustomerService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerinfoService customerinfoService;
    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/userOfCustomer.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add(Model model) {
        //将所有的客户和用户查询出来列出，形成页面的下拉列表
        model.addAttribute("users",userService.list());
        model.addAttribute("customers",customerinfoService.list());
        return PREFIX + "/userOfCustomer_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/userOfCustomer_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(UserOfCustomerParam userOfCustomerParam) {
        this.userOfCustomerService.add(userOfCustomerParam);
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
    public ResponseData editItem(UserOfCustomerParam userOfCustomerParam) {
        this.userOfCustomerService.update(userOfCustomerParam);
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
    public ResponseData delete(UserOfCustomerParam userOfCustomerParam) {
        this.userOfCustomerService.delete(userOfCustomerParam);
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
    public ResponseData detail(UserOfCustomerParam userOfCustomerParam) {
        UserOfCustomer detail = this.userOfCustomerService.getById(userOfCustomerParam.getUserId());
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
        return LayuiPageFactory.createPageInfo(this.userOfCustomerService.selectUserOfCusms(condition));
        //return this.userOfCustomerService.findPageBySpec(userOfCustomerParam);
        //return
    }
    /**
     @Permission
     @RequestMapping(value = "/list")
     @ResponseBody
     public Object list(@RequestParam(value = "roleName", required = false) String roleName) {
     Page<Map<String, Object>> roles = this.roleService.selectRoles(roleName);
     Page<Map<String, Object>> wrap = new RoleWrapper(roles).wrap();
     return LayuiPageFactory.createPageInfo(wrap);
     }
     */

}


