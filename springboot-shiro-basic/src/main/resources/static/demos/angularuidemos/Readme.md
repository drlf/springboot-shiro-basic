
##ui-grid-directive.html
ui-grid简单例子

ui-grid 自于angular-ui，原名ng-grid.老版本需要引入jquery，新版似乎去掉了jquery。 
参考https://github.com/angular-ui/ui-grid, 本例子来自与ui-grid/misc/demo/grid-directive.html
**使用步骤：**

1. 引入js和css文件

	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" />
	<link href="//cdn.bootcss.com/angular-ui-grid/3.0.6/ui-grid.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/angular.js/1.2.26/angular.js"></script>
	<script src="//cdn.bootcss.com/angular-ui-grid/3.0.6/ui-grid.js"></script>

2. 在controller中设置gridOptions.columnDefs(列定义)和data(数据)

3. html中定义标签：

	<div ui-grid="gridOptions" class="grid" ui-grid-resize-columns></div>

##grid-in-tabs.html
显示在tabs中的2个grid
去掉例子中的jquery，照样能运行，为啥呢？

##grid-accessiblility.html
ui-grid的扩展属性
enableSorting: false,	title右上角的右键排序菜单是否显示
showGridFooter: true,	grid的footer，如果显示pagination的话，不需要显示该项
enableGridMenu: false,	？不清楚
enableFiltering: true,	在每个title下显示输入框，按输入filter
paginationPageSizes: [25, 50, 75, 100],	指定每页显示条数下拉框可选项
paginationPageSize: 25,		
useExternalPagination: false,	外部分页？内部够用吗，是否支持后台分页？
useExternalSorting: false,		外部排序？

##ui-grid-modal.html
**在模式对话框中显示grid**
selected没有解决？？？

##ui-grid-subgrid.html
**嵌套子表**
gridOptions中设置
expandableRowTemplate: 'subgrid',
expandableRowHeight: 150
数据获取成功后，为每一行执行

	data.forEach(function (d) {
	    d.subGridOptions = {
	        columnDefs: [ { field: "company" }, { field: "email" } ],
	        data: data.slice(0, 100)
	    };
	});

##其它选项
tag中的ui-grid-selection ui-grid-edit ui-grid-importer ui-grid-exporter 这几个标签什么含意?
怎么选中？需要在每行首显示checkbox？
如果数据为空，显示no content怎么做到？
原leak-testing.html中
importerDataAddCallback: function ( grid, newObjects ) {
            $scope.data = $scope.data.concat( newObjects );
          }
importerDataAddCallback ？？难道是导入数据？


##用于生产环境的要求
1、解决no-content的显示问题
2、服务器分页
3、中文显示
4、多选

