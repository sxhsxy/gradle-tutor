/**
 * Created by xiaohu on 14-4-4.
 */
function insertPagination(pageNoParameterName, paginationRadius, pageSize, pageNo, pageCount) {
    paginationRadius = parseInt(paginationRadius, 10);
    pageSize = parseInt(pageSize, 10);
    pageNo = parseInt(pageNo, 10);
    pageCount = parseInt(pageCount, 10);


    var path = location.pathname;
    var first = pageNo - paginationRadius >= 0 ? pageNo - paginationRadius : 0;
    var last = first + paginationRadius *2 <= pageCount ? first + paginationRadius*2 : pageCount - 1;
    var paginationString = "";

    if(first > 0) {
        paginationString += "<li><a href=\"" + path + "?"+pageNoParameterName+"=" + 1 + "\">" + 1 + "</a></li>\n";
        if(first != 1) {
            var jump = (first - paginationRadius > 1 ? first - paginationRadius : 1);
            paginationString += "<li><a href=\"" + path + "?"+pageNoParameterName+"=" + jump + "\">" + "&lt;" + "</a></li>\n";
        }
    }
    for (i = first + 1; i < last + 2; i++) {
        paginationString += "<li";
        if (i == pageNo + 1) paginationString += " class=\"active\"";
        paginationString += "><a href=\"" + path + "?"+pageNoParameterName+"=" + i + "\">" + i + "</a></li>\n";
    }
    //判断是否需要输出最后一页的链接
    if (last < pageCount-1) {
        //判断何种条件下需要输出">"
        if (last != pageCount-2) {
            //计算并设置">"的跳过页数
            var jump = (last+2 +paginationRadius < pageCount ? last+2 +paginationRadius :pageCount -1);
            paginationString += "<li><a href=\"" + path + "?"+pageNoParameterName+"=" + jump + "\">" + "&gt;" + "</a></li>\n";
        }
        paginationString += "<li><a href=\"" + path + "?"+pageNoParameterName+"=" + pageCount + "\">" + pageCount + "</a></li>\n";
    }
    $("#pagination").html(paginationString);
}