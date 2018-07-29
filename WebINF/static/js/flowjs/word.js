(function(){
    function writeTextOnCanvas(cns, lh, rw, text){
        var cns = document.getElementById(cns);
        var ctx = cns.getContext("2d");
        var lineheight = lh;
        var text = text;

        ctx.width = cns.width;
        ctx.height = cns.height;

        ctx.clearRect(0, 0, ctx.width, ctx.height);
        ctx.font = "16px 微软雅黑";
        ctx.fillStyle = "#f00";
        function getTrueLength(str){//获取字符串的真实长度（字节长度）
            var len = str.length, truelen = 0;
            for(var x = 0; x < len; x++){
                if(str.charCodeAt(x) > 128){
                    truelen += 2;
                }else{
                    truelen += 1;
                }
            }
            return truelen;
        }
        function cutString(str, leng){//按字节长度截取字符串，返回substr截取位置
            var len = str.length, tlen = len, nlen = 0;
            for(var x = 0; x < len; x++){
                if(str.charCodeAt(x) > 128){
                    if(nlen + 2 < leng){
                        nlen += 2;
                    }else{
                        tlen = x;
                        break;
                    }
                }else{
                    if(nlen + 1 < leng){
                        nlen += 1;
                    }else{
                        tlen = x;
                        break;
                    }
                }
            }
            return tlen;
        }
        for(var i = 1; getTrueLength(text) > 0; i++){
            var tl = cutString(text, rw);
            ctx.fillText(text.substr(0, tl).replace(/^\s+|\s+$/, ""), 10, i * lineheight + 50);
            text = text.substr(tl);
        }
    }
    writeTextOnCanvas("ft", 22, 40, document.getElementById("input").value);
    document.getElementById("input").onkeyup = function(){
        writeTextOnCanvas("ft", 22, 40, this.value);
    }
})();