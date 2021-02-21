var Tab = function(config) {
    config = config || {};
    var tabId = config.tabId || "main_tab";
    var thisDiv = $("#" + tabId);
    var tabTitle = thisDiv.find(".nav-tabs");
    var tabDiv = thisDiv.find(".tab-content");

    //自定义事件
    var evt = config.event || {};

    var addItem = function(item) {
        tabTitle.find("li").removeClass("active");
        tabDiv.find("div").removeClass("in").removeClass("active");
        var tabItemId = "tabItem_" + item.id;
        if(tabTitle.find("a[href='#" + tabItemId + "']").length > 0) {
            tabTitle.find("a[href='#" + tabItemId + "']").tab("show");
            return;
        }

        var title = item.title || "标签";
        var tab = $('<li class="active"><a data-toggle="tab" href="#' + tabItemId + '">' + title + '<span class="closeico"><i  class="icon-remove" class="close" ></i></span></a></li>');
        var tabItem =  $('<div class="tab-pane in active" id="'+ tabItemId + '"></div>');
        var iframe = $('<iframe width="100%" class="auto-height" scrolling="no" frameborder="0" name="iframe_id" src="'+ item.url + '"></iframe>');

        tabItem.append(iframe);
        tabTitle.append(tab);
        tabDiv.append(tabItem);
        iframe.iframeAutoHeight({debug: true});

        tab.find(".closeico").click(function(e) {
            var index = tabTitle.find("li").index(tab);
            if(index == tabTitle.find("li").length - 1){
                index--;
            }
            iframe.remove();
            tab.remove();
            tabItem.remove();
            $("#main_tab").find("ul").find("li").eq(index).find("a").tab("show");
        });
    };

    this.addItem = addItem;
    return this;
}
