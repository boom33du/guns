layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 下发指令表管理
     */
    var Instructionsissued = {
        tableId: "instructionsissuedTable"
    };

    /**
     * 初始化表格的列
     */
    Instructionsissued.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'waterMeterId', sort: true, title: '要下发到的水表id'},
            {field: 'instructionType', sort: true, title: '指令类型 1、纯指令 2、升级包'},
            {field: 'instructionContent', sort: true, title: '下发指令内容'},
            {field: 'sender', sort: true, title: '发送者'},
            {field: 'SendTime', sort: true, title: '发送时间'},
            {field: 'resultsOfExecution', sort: true, title: '硬件返回的执行结果'},
            {field: 'endTime', sort: true, title: '执行完成时间'},
            {field: 'isFinished', sort: true, title: '是否执行结束 0、失败 1、成功结束'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Instructionsissued.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Instructionsissued.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    Instructionsissued.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加下发指令表',
            content: Feng.ctxPath + '/instructionsissued/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(Instructionsissued.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    Instructionsissued.exportExcel = function () {
        var checkRows = table.checkStatus(Instructionsissued.tableId);
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
    Instructionsissued.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改下发指令表',
            content: Feng.ctxPath + '/instructionsissued/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(Instructionsissued.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Instructionsissued.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/instructionsissued/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Instructionsissued.tableId);
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
        elem: '#' + Instructionsissued.tableId,
        url: Feng.ctxPath + '/instructionsissued/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Instructionsissued.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Instructionsissued.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Instructionsissued.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Instructionsissued.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Instructionsissued.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Instructionsissued.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Instructionsissued.onDeleteItem(data);
        }
    });
});
