package cc.ymee.common.utils;

import cc.ymee.common.core.ApplicationConstants;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 文件操作类
 *
 * @author Administrator
 */
public class FileUtil {

    /**
     * 文件大小
     *
     * @param longSize
     * @return String
     */
    public static String getFileSize(long longSize) {

        String fileSize = "";

        long SIZE_BT = 1024L;

        long SIZE_KB = SIZE_BT * 1024;

        long SIZE_MB = SIZE_KB * 1024;

        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        if (longSize == 0) {
            fileSize = "0";
        } else if (longSize < SIZE_BT && longSize > 0) {// 如果是小于1K
            fileSize = longSize + "B";
        } else if (longSize >= SIZE_BT && longSize < SIZE_KB) {// 如果是>1K and <1M
            fileSize = df.format(((double) longSize / (double) SIZE_BT)) + "K";
        } else if (longSize >= SIZE_KB && longSize < SIZE_MB) {// 再否则是>1M and
            // <1G
            fileSize = df.format(((double) longSize / (double) SIZE_KB)) + "M";
        } else {
            fileSize = "1G";
        }

        return fileSize;
    }

    /**
     * 获取行字符串
     *
     * @param columnStrs
     * @return
     */
    public static String getLineStr(String[] columnStrs) {
        // 行字符串
        String lineStr = "";
        for (int i = 0; i < columnStrs.length; i++) {
            if (i == 0) {
                lineStr += columnStrs[i];
            } else {
                lineStr += "\t" + columnStrs[i];
            }

        }
        return lineStr;
    }

    /** */
    /**
     * 创建目录
     *
     * @param destDirName 目标目录名
     * @return 目录创建成功返回true，否则返回false
     */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        // 创建目录
        if (dir.mkdirs()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 逐行读取文件
     *
     * @return
     * @throws java.io.IOException
     */
    public static List<String> readFiles(String filePath) throws IOException {
        List<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "UTF-8"));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            list.add(line);
        }
        br.close();
        return list;
    }

    public static void deleteFile(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                System.gc();
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定文件夹下所有.req文件 param path 文件夹完整绝对路径
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].endsWith(".req")) {
                if (path.endsWith(File.separator)) {
                    temp = new File(path + tempList[i]);
                } else {
                    temp = new File(path + File.separator + tempList[i]);
                }
                if (temp.isFile()) {
                    temp.delete();
                }
                if (temp.isDirectory()) {
                    delAllFile(path + tempList[i]);// 删除文件夹里面的文件
                    flag = true;
                }
            }
        }
        return flag;
    }

    /**
     * 删除文件夹 param folderPath 文件夹完整绝对路径
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadFile(String url, String target) {
        URLConnection con = null;
        URL theUrl = null;
        try {
            theUrl = new URL(url);// 建立地址
            con = theUrl.openConnection();// 打开连接
            con.setConnectTimeout(30000);
            con.connect();// 连接
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String type = con.getContentType();
        if (type != null) {
            byte[] buffer = new byte[4 * 1024];
            int read;
            try {
                FileOutputStream os = new FileOutputStream(target);
                InputStream in = con.getInputStream();// 重定向输入
                while ((read = in.read(buffer)) > 0) {// 读取输出
                    os.write(buffer, 0, read);// 写入本地文件
                }
                os.close();
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("file not found");
        }
    }

    public static String getFileNameSufix(String filename) {
        int n = filename.lastIndexOf(".");
        return filename.substring(n, filename.length()).toLowerCase();
    }

    public static String getRandomFileName(String filename) {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "")
                + getFileNameSufix(filename);
    }

    /**
     * 判断文件夹是否存在，如果不存在则创建.
     */
    public static void isExsit(String path) {
        File file = new File(path);
        // 判断文件夹是否存在,如果不存在则创建文件夹
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * 从文件路径中获取文件名
     *
     * @return
     */
    public static String getFileNameFromPath(String filePath) {
        int n = filePath.lastIndexOf("/");
        return filePath.substring(n + 1, filePath.length()).toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(getFileNameFromPath("c://sbc/text.txt"));
    }

    public static String uploadFile(CommonsMultipartFile file,
                                    String uploadPath) {
        String tempDir = DateUtil.formatDate(new Date(),"yyMMdd") + "/";
        String savePath = "static/upload/" + uploadPath + tempDir;
//		String uploadpath = request.getSession().getServletContext()
//				.getRealPath(Constants.UPLOAD_PATH)+"/"
//				+ uploadPath + tempDir;
        String uploadpath = ApplicationConstants.staticPath()
                + "static/upload/" + uploadPath + tempDir;
        FileUtil.createDir(uploadpath);
        String path = "";
        try {
            if (file != null) {
                String filename = FileUtil.getRandomFileName(file
                        .getOriginalFilename());
                FileOutputStream fileOS = new FileOutputStream(uploadpath
                        + filename);
                fileOS.write(file.getBytes());
                fileOS.close();
                path = savePath + filename;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
