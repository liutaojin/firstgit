package javahello;

import net.sf.json.JSONObject;

import java.util.Random;

/**
 * Created by Think-Tao on 2017.04.11.
 */

public class helloworld {



    public static void main(String[] args){
        String strmap = "(CLOB) ({\"COORDS\":\"(121.734515,31.106289,6.466555);(121.724515,31.096289,6.466555);(121.723481,31.096178,7.318297)\"})";
        int nposition1 = strmap.indexOf("{");
        int nposition2 = strmap.indexOf("}");

        String strret = strmap.substring(nposition1, nposition2+1);
        //strret = "[" + strret + "]";
        System.out.println(strret);


        JSONObject job = JSONObject.fromObject(strret);
        String strvalue = job.get("COORDS").toString();

        String[] arrPosition = strvalue.split(";");
        for(int x=0; x<arrPosition.length; ++x){
            System.out.println(arrPosition[x]);
        }

        System.out.println("---------------------");

        nposition1 = arrPosition[0].indexOf(",");
        nposition2 = arrPosition[0].lastIndexOf(",");
        String strPx = arrPosition[0].substring(1,nposition1);
        System.out.print(strPx+ " : ") ;

        String strPy = arrPosition[0].substring(nposition1+1,nposition2);
        System.out.println(strPy) ;

        nposition1 = arrPosition[arrPosition.length-1].indexOf(",");
        nposition2 = arrPosition[arrPosition.length-1].lastIndexOf(",");
        strPx = arrPosition[arrPosition.length-1].substring(1,nposition1);
        System.out.print(strPx+ " : ") ;

        strPy = arrPosition[arrPosition.length-1].substring(nposition1+1,nposition2);
        System.out.println(strPy) ;


        System.out.println("---------------------");


//        JSONArray json = JSONArray.fromObject(strret); // 首先把字符串转成 JSONArray  对象
//        System.out.println(json.get("COORDS")) ;
/*        if(json.size()>0){
            for(int i=0;i<json.size();i++){
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                strout = job.get("COORDS").toString();
                System.out.println(strout) ;  // 得到 每个对象中的属性值
            }
        }*/

        c_mySJHuData cTest = new c_mySJHuData();
        funTest(cTest);
        System.out.println(cTest.strLineColor);
        System.out.println(cTest.strLineDesc);


        //生成8位随机数
        String strPwd=new String();//定义变长字符串
        Random random=new Random();
        //随机生成数字，并添加到字符串
        for(int i=0;i<8;i++){
            strPwd+=random.nextInt(10);
        }

        System.out.println("============pwd =======: " + strPwd);

    }

    public static void funTest(c_mySJHuData cparm){
        cparm.strLineColor = "hahaha";
        cparm.strLineDesc = "feichanghao";
    }


}

class c_mySJHuData{
    double dSlon;
    double dSlat;
    double dElon;
    double dElat;
    String strLineColor;
    String strLineDesc;

    c_mySJHuData() {
        this.dSlon = 0.0;
        this.dSlat = 0.0;
        this.dElon = 0.0;
        this.dElat = 0.0;
        this.strLineColor = "blue";
        this.strLineDesc = "道路状况未知";
    }
}

