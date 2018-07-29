package javahello;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-06-14 14:35
 */
public class stringtest {

    public static void main(String[] args) throws InterruptedException {

/*        String stroldname2 = "name2.jpg";


        System.out.println(!(stroldname2 == "name2.jpg"));
        System.out.println(!(stroldname2 == ""));
        System.out.println(!(stroldname2 == null));
        System.out.println(!(stroldname2 == "name2.jpg"));

        if(!(stroldname2 == null) && !(stroldname2 == "") && !(stroldname2 == "name2.jpg")){
            System.out.println("hello ------------");
        }*/


/*        ArrayList<String> liststr = new ArrayList<String>();
        liststr.add(1, "a");
        liststr.add(0, "a");

        System.out.println(liststr.size());

        System.out.println(liststr.get(0));
        System.out.println(liststr.get(1));*/

        boolean bflag = saveUrlAs("http://dfs.anhouse.cn/view/document/05d4eac9f3f7f2fedd5da9f09ef8a7c41bf7f8d8.xls",
                "E:/aaa.xls");
        int a= 1;




    }

    public static boolean saveUrlAs(String photoUrl, String fileName){
        try {
            URL url = new URL(photoUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName.trim()));
            byte[] buffer = new byte[4096];
            int count = 0;
            while ((count = in.read(buffer)) > 0){
                out.write(buffer, 0, count);
            }
            out.close();
            in.close();
            return true;

        }catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
