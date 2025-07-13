$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/cwSell/list2',
        datatype: "json",
        colModel: [
            { label: '车位id', name: 'id', index: 'id', width: 80 },
            { label: '车主手机号', name: 'phone', index: 'phone', width: 80 },
            { label: '车位编号', name: 'cwNum', index: 'cwNum', width: 80 },
            { label: '车位价格', name: 'price', index: 'price', width: 80 },
            { label: '车位类型', name: 'cwLx', index: 'cwLx', width: 80 },
            { label: '区域位置', name: 'weizhi', index: 'weizhi', width: 80 },
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
        cwSell: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },

        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.cwSell = {};
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
            var url = vm.cwSell.id == null ? "sys/cwSell/saveLease" : "sys/cwSell/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.cwSell),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/cwSell/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function(id){
            $.get(baseURL + "sys/cwSell/info/"+id, function(r){
                vm.cwSell = r.cwSell;
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