/**
 * Created by Think-Tao on 2017.04.14.
 */


/*new_element=document.createElement("script");
new_element.setAttribute("type","text/javascript");
new_element.setAttribute("src","\/js_a.js");
document.body.appendChild(new_element);
function fun_b ()
{
    alert("b");
    Fun_a();
}*/

//document.write(" <script language=\"javascript\" src=\"./js_a.js\" > <\/script>");

document.scripts[0].src="./js_a.js"

function fun_b ()
{
    //alert("b");
    //Fun_a();
    //var a = Math.round(Math.random()*100000000);

    //var a=Math.random();
    //a=Math.floor(a*100000000);

    //var re = /(\w)*(\w)\2{2}(\w)*/g;

    //var a = re.test("12223456656");


    var re = /(\w)*(\w)\2{2}(\w)*/g;

    var pwd;

    while (true){
        pwd = Math.floor(Math.random()*100000000);
        if( !re.test(pwd) ){
            break;
        }
    }


    alert(pwd);
}



