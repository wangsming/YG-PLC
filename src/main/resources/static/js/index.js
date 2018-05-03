$(function () {

    search.initTable();
});

var search = {
    url: "plc/getList",
    initTable:function(){
        console.log("getList");
        $("#main_table").DataTable({
            language: lang, //提示信息
            autoWidth: false, //禁用自动调整列宽
            stripeClasses: ["odd", "even"], //为奇偶行加上样式，兼容不支持CSS伪类的场合
            processing: true, //隐藏加载提示,自行处理
            serverSide: true, //启用服务器端分页
            searching: false, //禁用原生搜索
            orderMulti: false, //启用多列排序
            scrollX: false,
            order: [], //取消默认排序查询,否则复选框一列会出现小箭头
            renderer: "bootstrap", //渲染样式：Bootstrap和jquery-ui
            pagingType: "simple_numbers", //分页样式：simple,simple_numbers,full,full_numbers
            rowId: 'id',
            ordering:false,
            columnDefs: [{
                "targets": 'nosort', //列的样式名
                "orderable": false //包含上样式名‘nosort'的禁止排序
            }],
            ajax: function (data, callback, settings) {
                //封装请求参数
                var param = {};
                param.offset = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.pageNumber = (data.start / data.length)+1;//当前页码
                // param.major=$("#major").val();
                // param.token=userToken;
                // param.userName=userName;
                // param.isPage='true';
                // console.log(param);

                //ajax请求数据
                $.ajax({
                    type: "POST",
                    url: search.url,
                    cache: false, //禁用缓存
                    data: param, //传入组装的参数
                    dataType: "json",
                    success: function (result) {
                        //console.log(result);
                        //setTimeout仅为测试延迟效果
                        setTimeout(function () {
                            //封装返回数据
                            var returnData = {};
                            returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                            returnData.recordsTotal = result.totalElements;//返回数据全部记录
                            returnData.recordsFiltered = result.totalElements;//后台不实现过滤功能，每次查询均视作全部结果
                            returnData.data = result.content;//返回的数据列表
                            //console.log(returnData);
                            //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                            callback(returnData);
                        }, 200);
                    }
                });
            },
            "fnDrawCallback":function(){
                // var api =this.api();
                // var startIndex= api.context[0]._iDisplayStart;        //获取到本页开始的条数 　
                // api.column(0).nodes().each(function(cell, i) {
                //     cell.innerHTML = startIndex + i + 1;
                // });
            },

            //列表表头字段
            columns: [
                { data: null, "searchable": false, "orderable": false , "sClass": "dt-center"},
//				{ data: "workSheet.factory" , "sClass": "dt-center"},
                { data: "workSheet.device" , "sClass": "dt-center"},
                { data: "workSheet.major" , "sClass": "dt-center"},
                { data: "workSheet.equipmentType"   , "defaultContent": "", "sClass": "dt-center"},
                { data: "workSheet.projectNumber"   , "defaultContent": ""},
                { data: "workSheet.headline"   , "defaultContent": "", "sClass": "dt-center"},
                { data: "workSheet.equipmentNumber"   , "defaultContent": "", "sClass": "dt-center"},
                { data: "createDate" },
                { data: "pStatus" , "sClass": "dt-center"},

                { data: "id", "sClass": "dt-center"}
            ],
            "fnCreatedRow":function(nRow,aData,iDataIndex){
                // if(aData.pStatus=="草稿"){
                //     $('td:eq(9)',nRow).html("<center><span class='glyphicon glyphicon-folder-open' style='cursor: pointer;' data_id='"+aData.id+"'></span>&nbsp;&nbsp;&nbsp;<span class='glyphicon glyphicon-trash' style='cursor: pointer;' data_id='"+aData.id+"'></span>" +
                //         "&nbsp;&nbsp;&nbsp;<span class='row-details row-details-close' data_id='"+aData.id+"'></span>" +
                //         "&nbsp;&nbsp;&nbsp;<span class='glyphicon glyphicon-export' data_id='"+aData.id+"'></span>" +
                //         "</center>");
                // }else{
                //     $('td:eq(9)',nRow).html("<center><span class='glyphicon glyphicon-folder-open' style='cursor: pointer;' data_id='"+aData.id+"'></span>&nbsp;&nbsp;&nbsp;<span class='row-details row-details-close' data_id='"+aData.id+"'></span>" +
                //         "&nbsp;&nbsp;&nbsp;<span class='glyphicon glyphicon-export' data_id='"+aData.id+"'></span>" +
                //         "</center>");
                // }
            }
        });

    }


}

