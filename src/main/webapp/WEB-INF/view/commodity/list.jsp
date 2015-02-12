<%--
  Created by IntelliJ IDEA.
  User: xiaohu
  Date: 14-3-20
  Time: 下午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table id="list" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>Id</th>
        <th>名称</th>
        <th>型号</th>
        <th>批次</th>
        <th>单位</th>
    </tr>
    </thead>
</table>
<div id="pager"></div>
$(function(){
pageInit();
});
function pageInit(){
jQuery("#list").jqGrid(
{
url : ctx+'gradle-tutor/data.json',
datatype : "json",
colNames : [ 'Id', '商品名称', '型号','批次',  '单位'],
colModel : [
{name : 'id',width : 55},
{name : 'name',width : 90},
{name : 'type_number',width : 100},
{name : 'serial_number',width : 80,align : "right"},
{name : 'unit',width : 80,align : "right"}
],
jsonReader: {

root: "rows",

total: "total",

page: "page",

records: "records",

repeatitems: false

},
rowNum : 10,
rowList : [ 10, 20, 30 ],
pager : '#pager',
sortname : 'id',
mtype : "post",
viewrecords : true,
caption : "JSON 实例"
});
jQuery("#list").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false});
}
</body>
</html>