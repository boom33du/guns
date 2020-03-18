layui.use(['table', 'admin', 'ax'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    /**
     * 水表硬件信息登记表管理
     */
    var Watermeterinfo = {
        tableId: "watermeterinfoTable"
    };

    /**
     * 初始化表格的列
     */
    Watermeterinfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'deviceid', sort: true, title: '设备ID'},

            {field: 'watermeterTypeName', sort: true, title: '水表型号'},
            //{field: 'watermetertypeId', sort: true, title: '水表型号'},
            {field: 'manuid', sort: true, title: '生产厂商'},
            {field: 'serialnum', sort: true, title: '水表号'},
            {field: 'firewareVersion', sort: true, title: '固件版本号'},
            {field: 'status', sort: true, title: '状态', templet: function (d) {
                    if (d.status === 0) {
                        return "新添加，未激活";
                    } else if(d.status === 1){
                        return "激活，未绑定";
                    }else if(d.status === 2){
                        return "激活，绑定了";
                    }else if(d.status === 3){
                        return "删除了";
                    }else if(d.status === 4){
                        return "损坏";
                    }else if(d.status === 5){
                        return "欠费";
                    }else
                    {
                        return d.status;
                    }
                }},
           // 0新添加，未激活 1激活，未绑定 2激活，绑定了 3删除了；4损坏；5欠费
            {field: 'electricquantityLeft', sort: true, title: '剩余电量'},
            //{field: 'eventtime', sort: true, title: '添加时间'},
            {field: 'dateManufacture', sort: true, title: '生产日期'},
            //{field: 'accumuflowdaily', sort: true, title: '用水总量'},
            //{field: 'updatetime', sort: true, title: '更新时间'},
            //{field: 'gatewayid', sort: true, title: '网关ID'},
            //{field: 'nbiotId', sort: true, title: 'NB-IOT芯片ID'},
            //{field: 'dateInstall', sort: true, title: '安装日期'},
            //{field: 'dateDiscontinuation', sort: true, title: '停用日期'},
            //{field: 'temp', sort: true, title: '备注（水表用户ID）'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Watermeterinfo.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Watermeterinfo.tableId, {where: queryData});
    };

    /**
     * 弹出添加对话框
     */
    Watermeterinfo.openAddDlg = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加水表信息',
            content: Feng.ctxPath + '/watermeterinfo/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(Watermeterinfo.tableId);
            }
        });
    };

    /**
     * 导出excel按钮
     */
    Watermeterinfo.exportExcel = function () {
        var checkRows = table.checkStatus(Watermeterinfo.tableId);
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
    Watermeterinfo.openEditDlg = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '修改水表信息',
            content: Feng.ctxPath + '/watermeterinfo/edit?id=' + data.id,
            end: function () {
                admin.getTempData('formOk') && table.reload(Watermeterinfo.tableId);
            }
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Watermeterinfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/watermeterinfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Watermeterinfo.tableId);
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
        elem: '#' + Watermeterinfo.tableId,
        url: Feng.ctxPath + '/watermeterinfo/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Watermeterinfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Watermeterinfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Watermeterinfo.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Watermeterinfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Watermeterinfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Watermeterinfo.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Watermeterinfo.onDeleteItem(data);
        }
    });
});
