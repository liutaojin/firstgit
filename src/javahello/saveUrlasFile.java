package javahello;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LIUTAOJIN940 on 2018/7/6.
 */
public class saveUrlasFile {

    public static void main(String[] args) {

        String strUrl = "http://dfs.anhouse.cn/view/document/8902a995d38d1dde026a5d20803ec25592e34f88.xls";
        String fileName = "modoulname.xls";
        try {
            downloadLog(strUrl, fileName);
        } catch (Exception e) {

            System.out.println("====================================" + e);
        }

    }

    public static String downloadLog(String loadUrl,String fileName) throws Exception {
        URL url = new URL(loadUrl);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setConnectTimeout(50 * 1000);

        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream inputStream = null;
        FileOutputStream fos = null;
        inputStream = conn.getInputStream();

        //路径目录
        File saveDir = new File("D:/test");
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        File file = new File(saveDir + File.separator + fileName);

        fos = new FileOutputStream(file);
        readInputStream(fos, inputStream);

        return file.toString();
    }


    /**
     * 用流把数据写到本地文件上
     *
     * @param inputStream
     * @return
     * @throws Exception
     * @throws IOException
     */
    public static void readInputStream(FileOutputStream fos,
                                       InputStream inputStream) throws Exception {
        byte[] buffer = new byte[1024];
        int len = 0;

        try {
            while ((len = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, len);

            }
            fos.flush();

        } catch (Exception e) {
            System.out.println("readInputStream文件可能太大导致");
            throw new  Exception(e);

        } finally {

            try {

                fos.close();
                inputStream.close();
            } catch (IOException e) {

            }
        }

    }

}
