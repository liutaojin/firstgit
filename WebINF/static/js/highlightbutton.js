/**
 * Created by Think-Tao on 2017.04.21.
 */

function showStructLine(node) {
    showHighLightBtn(node)
}

function showHighLightBtn(node) {
    var oDivListNode = document.getElementById("selectlist");
    var collUlNodes = oDivListNode.getElementsByTagName("input");

    for (var x = 0; x < collUlNodes.length; ++x) {
        if (collUlNodes[x] == node)
            collUlNodes[x].className = "open";
        else
            collUlNodes[x].className = "close";
    }
}