layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 水表型号表管理
     */
    var TypeOfWatermeter = {
        tableId: "typeOfWatermeterTable"
    };

    /**
     * 初始化表格的列
     */
    TypeOfWatermeter.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'watermeterType', sort: true, title: '型号'},
            {field: 'caliber', sort: true, title: '口径'},
            {field: 'ishavevalve', sort: true, title: '是否带阀', templet: function (d) {
                    if (d.ishavevalve === '0') {
                        return "不带阀";
                    } else {
                        return "带阀";
                    }
                }},
            {field: 'isnbiot', sort: true, title: '是否是NB-IOT表', templet: function (d) {
                    if (d.isnbiot === '0') {
                        return "不是";
                    } else {
                        return "是";
                    }
                }},
            {field: 'protocol', sort: true, title: '通信协议'},
            {field: 'manufacturercode', sort: true, title: '生产厂商代码'},
            {field: 'manufacturer', sort: true, title: '生产厂商'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    TypeOfWatermeter.search = function () {
        var queryData = {};
        queryData['watermeterType'] = $("#watermeterType").val();
        table.reload(TypeOfWatermeter.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    TypeOfWatermeter.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加水表型号',
            content: Feng.ctxPath + '/typeOfWatermeter/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(TypeOfWatermeter.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    TypeOfWatermeter.exportExcel = function () {
        var checkRows = table.checkStatus(TypeOfWatermeter.tableId);
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
    TypeOfWatermeter.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改水表型号',
            content: Feng.ctxPath + '/typeOfWatermeter/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(TypeOfWatermeter.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    TypeOfWatermeter.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/typeOfWatermeter/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(TypeOfWatermeter.tableId);
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
        elem: '#' + TypeOfWatermeter.tableId,
        url: Feng.ctxPath + '/typeOfWatermeter/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: TypeOfWatermeter.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        TypeOfWatermeter.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        TypeOfWatermeter.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        TypeOfWatermeter.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + TypeOfWatermeter.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            TypeOfWatermeter.openEditDlg(data);
        } else if (layEvent === 'delete') {
            TypeOfWatermeter.onDeleteItem(data);
        }
    });
});
