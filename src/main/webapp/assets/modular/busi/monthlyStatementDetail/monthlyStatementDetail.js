layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 月结明细表管理
     */
    var MonthlyStatementDetail = {
        tableId: "monthlyStatementDetailTable"
    };

    /**
     * 初始化表格的列
     */
    MonthlyStatementDetail.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'recordId', sort: true, title: '月结记录表'},
            {field: 'addressOfCustomerId', sort: true, title: '客户地址id'},
            {field: 'wmId', sort: true, title: '水表ID'},
            {field: 'addressTypeId', sort: true, title: '地址类型'},
            {field: 'year', sort: true, title: '年份'},
            {field: 'month', sort: true, title: '月份'},
            {field: 'LASTRECORDid', sort: true, title: '上次月结ID'},
            {field: 'recordtime', sort: true, title: '月结时间'},
            {field: 'curresult', sort: true, title: '当前水表读数'},
            {field: 'totalWaterL', sort: true, title: '当前用水总量'},
            {field: 'waterconsume', sort: true, title: '本周期用水量'},
            {field: 'detail', sort: true, title: '月结记录'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MonthlyStatementDetail.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(MonthlyStatementDetail.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    MonthlyStatementDetail.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加月结明细表',
            content: Feng.ctxPath + '/monthlyStatementDetail/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(MonthlyStatementDetail.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    MonthlyStatementDetail.exportExcel = function () {
        var checkRows = table.checkStatus(MonthlyStatementDetail.tableId);
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
    MonthlyStatementDetail.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改月结明细表',
            content: Feng.ctxPath + '/monthlyStatementDetail/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(MonthlyStatementDetail.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    MonthlyStatementDetail.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/monthlyStatementDetail/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MonthlyStatementDetail.tableId);
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
        elem: '#' + MonthlyStatementDetail.tableId,
        url: Feng.ctxPath + '/monthlyStatementDetail/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MonthlyStatementDetail.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MonthlyStatementDetail.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        MonthlyStatementDetail.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        MonthlyStatementDetail.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MonthlyStatementDetail.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MonthlyStatementDetail.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MonthlyStatementDetail.onDeleteItem(data);
        }
    });
});
