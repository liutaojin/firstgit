package javahello;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-05-19 21:40
 */
public class deletefile {

    public static Timer timer;

    public static void main(String[] args) throws InterruptedException {

        //String strrootpath = "F:/二钢/image/";
        //renameFile(strrootpath+"newname222.jpg", strrootpath+"newname.jpg");

        copyFile("F:/二钢/image/20170706b10e712e1d9b4f5682a9813af7417530.jpg", "F:/二钢/image/active/haha.jpg");
/*
        Scanner sc = new Scanner(System.in); //键盘输入的数字/字符串

        Reminder(10000);// timer

        while (true) {
            if (sc.nextLine().equals("Q")) {
                System.exit(0);
            }
            Thread.sleep(500);
            System.out.println("输入错误！ 退出程序请输入“Q”");
        }*/

        //文件路径
        //String path = args[0];
        //runDelete("C:/Users/Think-Tao/Desktop/delete");
    }

    public static void Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(),
                0,        //initial delay
                seconds);  //subsequent rate
    }

    static class RemindTask extends TimerTask {

        public void run() {
            //删除指定文件路径下的文件（文件夹），保留3个最新文件（文件夹）
            runDelete("C:/Users/Think-Tao/Desktop/delete");
            System.out.println("\n程序正在运行中.... 退出程序请输入“Q”\n");
            //System.exit(0);   //Stops the AWT thread (and everything else)
        }
    }

    private static boolean runDelete(String path) {
        boolean bsuccess = true;
        List<File> list = getFileSort(path);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("------------" + list.get(i).getName());
            if (i >= 3) {
                File subfile = new File(list.get(i).getAbsolutePath());
               /* if(subfile.isDirectory()){
                    subfile.delete();
                }else{
                    list.get(i).delete();
                }*/
                bsuccess = deleteDir(subfile);
            }
        }
        if (bsuccess) {
            System.out.println("\n处理当前目录文件成功！");
            for (File file : list) {
                //当前目录文件（文件夹）
                if (file.lastModified() != 0) {
                    System.out.println("当前目录文件：" + file.getName());
                }

                //删除文件（文件夹）
                if (file.lastModified() == 0) {
                    System.out.println("删除文件：" + file.getName());
                }

            }
        } else {
            System.out.println("\n处理当前目录文件失败！");
        }

        return bsuccess;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 获取目录下所有文件(按时间排序)
     *
     * @param path
     * @return
     */
    public static List<File> getFileSort(String path) {

        List<File> list = getFiles(path, new ArrayList<File>());

        if (list != null && list.size() > 0) {

            Collections.sort(list, new Comparator<File>() {
                public int compare(File file, File newFile) {
                    if (file.lastModified() < newFile.lastModified()) {
                        return 1;
                    } else if (file.lastModified() == newFile.lastModified()) {
                        return 0;
                    } else {
                        return -1;
                    }

                }
            });

        }

        return list;
    }

    /**
     * 获取目录下所有文件
     *
     * @param realpath
     * @param files
     * @return
     */
    public static List<File> getFiles(String realpath, List<File> files) {
        File realFile = new File(realpath);
        if (realFile.isDirectory()) {
            File[] subfiles = realFile.listFiles();
            for (File file : subfiles) {
                if (file.isDirectory()) {
                    //getFiles(file.getAbsolutePath(), files);
                    files.add(file);
                } else {
                    files.add(file);
                }
            }
        }
        return files;
    }

    /**
     * 复制单个文件
     *
     * @param oldPath String 原文件路径 如：c:/fqf.txt
     * @param newPath String 复制后路径 如：f:/fqf.txt
     * @return boolean
     */
    public static void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();

        }

    }

    public static boolean renameFile(String oldpath, String newpath) {
        File f = new File(oldpath);
        File mm = new File(newpath);
        if (f.renameTo(mm)) {
            System.out.println("修改成功!");
            return true;
        } else {
            System.out.println("修改失败");
            return false;
        }
    }


}
