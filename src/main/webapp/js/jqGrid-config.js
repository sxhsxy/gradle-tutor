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






});