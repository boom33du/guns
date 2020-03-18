layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 客户居民账单_缴费记录表(后付)管理
     */
    var PostPaymentRecored = {
        tableId: "postPaymentRecoredTable"
    };

    /**
     * 初始化表格的列
     */
    PostPaymentRecored.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'addressOfCustomerId', sort: true, title: '客户地址id，外键'},
            {field: 'monthlyStatementDetailId', sort: true, title: '月结明细表id，外键'},
            {field: 'wmWaterSupplyNumber', sort: true, title: '给水号（不可修改）'},
            {field: 'price', sort: true, title: '当前价格'},
            {field: 'waterconsume', sort: true, title: '本周期用水量'},
            {field: 'TOTALconsume', sort: true, title: '发生金额，根据月结生成'},
            {field: 'begintime', sort: true, title: '费用开始时间'},
            {field: 'endtime', sort: true, title: '费用结束时间'},
            {field: 'watermeterbeginrecord', sort: true, title: '费用开始水表读数'},
            {field: 'watermeterendrecord', sort: true, title: '费用结束水表读数'},
            {field: 'payTime', sort: true, title: '缴费时间'},
            {field: 'PaymentChannel', sort: true, title: '缴费渠道（0微信、1支付宝、2银行卡、3前台）'},
            {field: 'paymentDetailId', sort: true, title: '交易明细id，交费明细表主键，外键'},
            {field: 'isfinish', sort: true, title: '是否完成 0未完成 1完成，默认0'},
            {field: 'operid', sort: true, title: '操作人，用户表主键，外键'},
            {field: 'opertime', sort: true, title: '操作时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    PostPaymentRecored.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(PostPaymentRecored.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    PostPaymentRecored.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加客户居民账单_缴费记录表(后付)',
            content: Feng.ctxPath + '/postPaymentRecored/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(PostPaymentRecored.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    PostPaymentRecored.exportExcel = function () {
        var checkRows = table.checkStatus(PostPaymentRecored.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    PostPaymentRecored.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改客户居民账单_缴费记录表(后付)',
            content: Feng.ctxPath + '/postPaymentRecored/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(PostPaymentRecored.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    PostPaymentRecored.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/postPaymentRecored/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(PostPaymentRecored.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + PostPaymentRecored.tableId,
        url: Feng.ctxPath + '/postPaymentRecored/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: PostPaymentRecored.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        PostPaymentRecored.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        PostPaymentRecored.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        PostPaymentRecored.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + PostPaymentRecored.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            PostPaymentRecored.openEditDlg(data);
        } else if (layEvent === 'delete') {
            PostPaymentRecored.onDeleteItem(data);
        }
    });
});
