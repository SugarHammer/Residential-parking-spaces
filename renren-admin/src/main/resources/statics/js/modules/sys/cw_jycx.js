$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/cwJycx/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'id', index: 'id', width: 80 },
            { label: '交易订单号', name: 'ddh', index: 'ddh', width: 80 },
            { label: '车位信息', name: 'cwInfo', index: 'cwInfo', width: 80 },
            { label: '交易类型', name: 'beizhu2', index: 'beizhu2', width: 80 },
            { label: '交易金额', name: 'money', index: 'money', width: 80 },
            { label: '支付方式', name: 'zffs', index: 'zffs', width: 80 },
            { label: '备注信息', name: 'beizhu', index: 'beizhu', width: 80 },
            { label: '交易时间', name: 'jyTime', index: 'jyTime', width: 80 },
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title: null,
        cwJycx: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },

        update: function (event) {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },


        saveOrUpdate: function (event) {
            var url = vm.cwJycx.id == null ? "sys/cwJycx/save" : "sys/cwJycx/update2";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.cwJycx),
                success: function(r){
                    if(r.code === 0){
                        alert('购买成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        getInfo: function(id){
            $.get(baseURL + "sys/cwJycx/info/"+id, function(r){
                vm.cwJycx = r.cwJycx;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
        }
    }
});