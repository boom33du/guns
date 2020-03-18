package cn.stylefeng.guns.modular.busi.controller;

import cn.stylefeng.guns.core.common.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.busi.entity.PostPaymentRecored;
import cn.stylefeng.guns.modular.busi.model.params.PostPaymentRecoredParam;
import cn.stylefeng.guns.modular.busi.service.PostPaymentRecoredService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 客户居民账单_缴费记录表(后付)控制器
 *
 * @author zhuhailin
 * @Date 2019-12-11 14:32:44
 */
@Controller
@RequestMapping("/postPaymentRecored")
public class PostPaymentRecoredController extends BaseController {

    private String PREFIX = "/modular/busi/postPaymentRecored";

    @Autowired
    private PostPaymentRecoredService postPaymentRecoredService;

    /**
     * 跳转到主页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/postPaymentRecored.html";
    }

    /**
     * 新增页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/postPaymentRecored_add.html";
    }

    /**
     * 编辑页面
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/postPaymentRecored_edit.html";
    }

    /**
     * 新增接口
     *
     * @author zhuhailin
     * @Date 2019-12-11
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(PostPaymentRecoredParam postPaymentRecoredParam) {
        this.postPaymentRecoredService.add(postPaymentRecoredParam);
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
    public ResponseData editItem(PostPaymentRecoredParam postPaymentRecoredParam) {
        this.postPaymentRecoredService.update(postPaymentRecoredParam);
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
    public ResponseData delete(PostPaymentRecoredParam postPaymentRecoredParam) {
        this.postPaymentRecoredService.delete(postPaymentRecoredParam);
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
    public ResponseData detail(PostPaymentRecoredParam postPaymentRecoredParam) {
        PostPaymentRecored detail = this.postPaymentRecoredService.getById(postPaymentRecoredParam.getId());
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
    public LayuiPageInfo list(PostPaymentRecoredParam postPaymentRecoredParam) {
        return this.postPaymentRecoredService.findPageBySpec(postPaymentRecoredParam);
    }

}


