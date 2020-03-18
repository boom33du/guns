layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 地址类型表管理
     */
    var AddressType = {
        tableId: "addressTypeTable"
    };

    /**
     * 初始化表格的列
     */
    AddressType.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'addresstypecontent', sort: true, title: '地址类型'},
            {field: 'scale', sort: true, title: '级别'},
            {field: 'temp', sort: true, title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    AddressType.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(AddressType.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    AddressType.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加地址类型表',
            content: Feng.ctxPath + '/addressType/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(AddressType.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    AddressType.exportExcel = function () {
        var checkRows = table.checkStatus(AddressType.tableId);
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
    AddressType.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改地址类型表',
            content: Feng.ctxPath + '/addressType/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(AddressType.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    AddressType.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/addressType/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(AddressType.tableId);
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
        elem: '#' + AddressType.tableId,
        url: Feng.ctxPath + '/addressType/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: AddressType.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        AddressType.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        AddressType.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        AddressType.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + AddressType.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            AddressType.openEditDlg(data);
        } else if (layEvent === 'delete') {
            AddressType.onDeleteItem(data);
        }
    });
});
