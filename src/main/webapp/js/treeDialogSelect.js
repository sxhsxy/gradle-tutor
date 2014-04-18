define([
		'jquery',
		'dialog',
        'ztree'
　　　　],
　　　　function($, dialog) {
			var url;
			var caller;
			var znodes;
			function showTree(response, status, xhr) {
				        var znodes_defaults =[
							{id:1, pId:0, name:"没有数据", open:true}
							
						];
						znodes = response?response:znodes_defaults;
						var zTree;
						var setting = {
							view: {
								showLine: true,
								selectedMulti: false
							},
							data: {
								simpleData: {
									enable:true,
									idKey: "id",
									pIdKey: "pId",
									rootPId: ""
								}
							},
							
						};


						var t = $("#tree");
						t = $.fn.zTree.init(t, setting, znodes);
						// demoIframe = $("#testIframe");
						// demoIframe.bind("load", loadReady);
						var zTree = $.fn.zTree.getZTreeObj("tree");
						//zTree.selectNode(zTree.getNodeByParam("id", 101));						
			}
			function clickOk() {
					var ztree = $.fn.zTree.getZTreeObj("tree");
					var node = ztree.getSelectedNodes()[0];
					updateInputControl(node);
			}


			var updateInputControl = function(selectedNode) {
				var parent = $(caller).parent();
				$(parent).siblings("#nodeId").val(selectedNode.id);
				$(parent).siblings("#nodeName").val(selectedNode.name);
			};
　　　　　　var treeDialogSelect = function() {
				caller = this;
				url = $(this).parent().parent().data("url");
				var znodes =[
					{id:1, pId:0, name:"[core] Dialog Tree Root", open:true},
					{id:101, pId:1, name:"最简单x的树 --  标准 JSON 数据", file:"core/standardData"},
					{id:102, pId:1, name:"最简单的树 --  简单 JSON 数据", file:"core/simpleData"},
					{id:103, pId:1, name:"不显示 连接线", file:"core/noline"},
					{id:104, pId:1, name:"不显示 节点 图标", file:"core/noicon"},
					{id:105, pId:1, name:"自定义图标 --  icon 属性", file:"core/custom_icon"},
					{id:106, pId:1, name:"自定义图标 --  iconSkin 属性", file:"core/custom_iconSkin"},
					{id:107, pId:1, name:"自定义字体", file:"core/custom_font"},
					{id:115, pId:1, name:"超链接演示", file:"core/url"},
					{id:108, pId:1, name:"异步加载 节点数据", file:"core/async"},
					{id:109, pId:1, name:"用 zTree 方法 异步加载 节点数据", file:"core/async_fun"},
					{id:110, pId:1, name:"用 zTree 方法 更新 节点数据", file:"core/update_fun"},
					{id:111, pId:1, name:"单击 节点 控制", file:"core/click"},
					{id:112, pId:1, name:"展开 / 折叠 父节点 控制", file:"core/expand"},
					{id:113, pId:1, name:"根据 参数 查找 节点", file:"core/searchNodes"},
					{id:114, pId:1, name:"其他 鼠标 事件监听", file:"core/otherMouse"},

					{id:2, pId:0, name:"[excheck] 复/单选框功能 演示", open:false},
					{id:201, pId:2, name:"Checkbox 勾选操作", file:"excheck/checkbox"},
					{id:206, pId:2, name:"Checkbox nocheck 演示", file:"excheck/checkbox_nocheck"},
					{id:207, pId:2, name:"Checkbox chkDisabled 演示", file:"excheck/checkbox_chkDisabled"},
					{id:208, pId:2, name:"Checkbox halfCheck 演示", file:"excheck/checkbox_halfCheck"},
					{id:202, pId:2, name:"Checkbox 勾选统计", file:"excheck/checkbox_count"},
					{id:203, pId:2, name:"用 zTree 方法 勾选 Checkbox", file:"excheck/checkbox_fun"},
					{id:204, pId:2, name:"Radio 勾选操作", file:"excheck/radio"},
					{id:209, pId:2, name:"Radio nocheck 演示", file:"excheck/radio_nocheck"},
					{id:210, pId:2, name:"Radio chkDisabled 演示", file:"excheck/radio_chkDisabled"},
					{id:211, pId:2, name:"Radio halfCheck 演示", file:"excheck/radio_halfCheck"},
					{id:205, pId:2, name:"用 zTree 方法 勾选 Radio", file:"excheck/radio_fun"}

				];
				var d = dialog({
				    title: "选择",
				    content: '<div><ul id="tree" class="ztree" /></div>',
				    onshow: function(){$.get(url, showTree)},
				    ok: clickOk,
				    cancel: function(){}
				});
				d.showModal();
				//treedialog('Tree Dialog',znodes, updateInputControl);
			};
			var bind = function(index, element) {
				url = $(element).data("url");
				$(element).addClass("input-group");
				$(element).html('<input type="hidden" id="nodeId" /><input type="text" id="nodeName" class="form-control" disabled="true" /><span class="input-group-btn"><div id="treeDialogSelect" class="btn btn-default">查找</div></span>');
				$("div", $(element)).click(treeDialogSelect);

			}
			var initialize = function() {
				$("[data-type='treeDialogSelectControl']").each(bind);


			}
			initialize();
			return treeDialogSelect;
			
　　　　}
　　);