layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 月结记录表管理
     */
    var MonthlyStatementRecord = {
        tableId: "monthlyStatementRecordTable"
    };

    /**
     * 初始化表格的列
     */
    MonthlyStatementRecord.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'year', sort: true, title: '年份'},
            {field: 'month', sort: true, title: '月份'},
            {field: 'recordtime', sort: true, title: '月结时间'},
            {field: 'operid', sort: true, title: '操作人'},
            {field: 'begintime', sort: true, title: '开始时间'},
            {field: 'endtime', sort: true, title: '结束时间'},
            {field: 'allcount', sort: true, title: '月结用户数'},
            {field: 'succount', sort: true, title: '月结成功用户数'},
            {field: 'detail', sort: true, title: '月结记录'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MonthlyStatementRecord.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(MonthlyStatementRecord.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    MonthlyStatementRecord.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加月结记录表',
            content: Feng.ctxPath + '/monthlyStatementRecord/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(MonthlyStatementRecord.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    MonthlyStatementRecord.exportExcel = function () {
        var checkRows = table.checkStatus(MonthlyStatementRecord.tableId);
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
    MonthlyStatementRecord.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改月结记录表',
            content: Feng.ctxPath + '/monthlyStatementRecord/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(MonthlyStatementRecord.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    MonthlyStatementRecord.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/monthlyStatementRecord/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MonthlyStatementRecord.tableId);
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
        elem: '#' + MonthlyStatementRecord.tableId,
        url: Feng.ctxPath + '/monthlyStatementRecord/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MonthlyStatementRecord.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MonthlyStatementRecord.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        MonthlyStatementRecord.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        MonthlyStatementRecord.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MonthlyStatementRecord.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MonthlyStatementRecord.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MonthlyStatementRecord.onDeleteItem(data);
        }
    });
});
