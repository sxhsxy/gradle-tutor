$(function() {

    $.extend($.jgrid.defaults, {
        datatype: 'json',
        mtype: 'GET',
        jsonReader : {
            repeatitems:false,
            total: "totalPages",
            records: "totalElements",
            page: function(result) {
                return result.number+1;
            },
            root: "content"
        },
        //prmNames: {
        //    page: "page.page",
        //    rows: "page.size",
        //    sort: "page.sort",
        //    order: "page.sort.dir"
        //},
        height: 'auto',
        autowidth: true,
        viewrecords: true,
        rowList: [10, 20, 50],
        altRows: false,
        sortname: "id",
        loadError: function(xhr, status, error) {
            alert(error);
        }

    });

    $.extend($.jgrid.edit, {
        closeAfterEdit: true,
        closeAfterAdd: true,
        ajaxEditOptions: { contentType: "application/json" },
        mtype: 'PUT',
        serializeEditData: function(data) {
            delete data.oper;
            return JSON.stringify(data);
        }
    });
    $.extend($.jgrid.del, {
        mtype: 'DELETE',
        serializeDelData: function() {
            return "";
        }
    });

    $.jgrid.extend({
        initNavGrid: function() {
            this.each( function() {
                    var xurl = this.p.url;
                    var editOptions = {
                        onclickSubmit: function (params, postdata) {
                            params.url = xurl + '/' + postdata.list_id;
                        }
                    };
                    var addOptions = {
                        mtype: "POST",
                        onclickSubmit: function (params, postdata) {
                            postdata.id = "";
                            //var pd = $("#pdata").jqGrid('getGridParam','postData');
                            //pd.param1 = null;
                            //$("#pdata").jqGrid('setGridParam','postData',pd);
                        }
                    };
                    var delOptions = {
                        onclickSubmit: function (params, postdata) {
                            params.url = xurl + '/' + postdata;
                        }
                    };

                    var options = {
                        height: 'auto',
                        ondblClickRow: function (rowid) {
                            jQuery(this).jqGrid('editGridRow', rowid, editOptions);
                        }
                    };

                    $(this).jqGrid("setGridParam", options)
                        .jqGrid("navGrid", '#pager',
                        {edit: true, add: true, del: true, search: false}, //options
                        editOptions,
                        addOptions,
                        delOptions,
                        {} // search options
                    );
                }
            );
        }
    });



});