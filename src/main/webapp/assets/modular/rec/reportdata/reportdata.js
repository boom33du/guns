layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 水表上报数据表管理
     */
    var Reportdata = {
        tableId: "reportdataTable"
    };

    /**
     * 初始化表格的列
     */
    Reportdata.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'deviceid', sort: true, title: '设备ID，电信云平台的标志号'},
            {field: 'manuid', sort: true, title: '厂商ID'},
            {field: 'serialnum', sort: true, title: '水表号'},
            {field: 'accumuflowdaily', sort: true, title: '用水总量'},
            {field: 'batterylevel', sort: true, title: '剩余电量'},
            {field: 'timeu', sort: true, title: '发送时间上半部分'},
            {field: 'timed', sort: true, title: '发送时间下半部分'},
            {field: 'checksum', sort: true, title: '校验码'},
            {field: 'receivetime', sort: true, title: '应用系统接收时间'},
            {field: 'eventtime', sort: true, title: '事件时间，来自电信云'},
            {field: 'temp', sort: true, title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Reportdata.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Reportdata.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    Reportdata.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加水表上报数据表',
            content: Feng.ctxPath + '/reportdata/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(Reportdata.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    Reportdata.exportExcel = function () {
        var checkRows = table.checkStatus(Reportdata.tableId);
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
    Reportdata.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改水表上报数据表',
            content: Feng.ctxPath + '/reportdata/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(Reportdata.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Reportdata.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/reportdata/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Reportdata.tableId);
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
        elem: '#' + Reportdata.tableId,
        url: Feng.ctxPath + '/reportdata/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Reportdata.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Reportdata.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Reportdata.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Reportdata.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Reportdata.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Reportdata.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Reportdata.onDeleteItem(data);
        }
    });
});
