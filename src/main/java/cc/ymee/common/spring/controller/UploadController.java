package cc.ymee.common.spring.controller;
/* *
 * 
 * @Title :UploadController.java
 * @Description:
 * @Datetime : 2014-4-14 下午2:49
 * @Copyright :Copyright (c) 2012
 *
 * @author :anjero   
 * @version :1.0
 **/

import cc.ymee.common.core.ApplicationConstants;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.httpclient.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UploadController extends HttpServlet {


    private final Logger logger = LoggerFactory.getLogger("upload");
    /**
     *
     */
    private static final long serialVersionUID = 7266614062404344373L;

    @Override
    public void init() throws ServletException {
        logger.info("init common upload servlet");
    }

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response) throws ServletException,
            IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 保存文件路径
        String filePath = DateUtil.formatDate(new Date(), "yyMMdd");
        String realPath = ApplicationConstants.staticPath() + "/upload/" + filePath;
        String imgUrl = ApplicationConstants.staticUrl() + "/static/upload/" + filePath + "/";
        // 判断路径是否存在，不存在则创建
        File dir = new File(realPath);
        if (!dir.isDirectory())
            dir.mkdir();
//            FileUtils.createDir(dir.getPath());
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory dff = new DiskFileItemFactory();
            dff.setRepository(dir);
            dff.setSizeThreshold(1024000);
            ServletFileUpload sfu = new ServletFileUpload(dff);
            try {
                FileItemIterator fii;
                fii = sfu.getItemIterator(request);
                String title = ""; // 图片标题
                String url = ""; // 图片地址
                String fileName = "";
                String state = "SUCCESS";
                while (fii.hasNext()) {
                    FileItemStream fis = fii.next();
                    try {
                        if (!fis.isFormField() && fis.getName().length() > 0) {
                            fileName = fis.getName();
                            Pattern reg = Pattern
                                    .compile("[.]jpg|png|jpeg|gif$");
                            Matcher matcher = reg.matcher(fileName.toLowerCase());
                            if (!matcher.find()) {
                                state = "文件类型不允许！";
                                break;
                            }
                            String filename = UUID.randomUUID().toString().toUpperCase()
                                    + fileName.substring(fileName.lastIndexOf("."), fileName.length());
                            url = realPath + "/" + filename;
                            imgUrl += filename;

                            BufferedInputStream in = new BufferedInputStream(
                                    fis.openStream());// 获得文件输入流
                            FileOutputStream a = new FileOutputStream(new File(
                                    url));
                            BufferedOutputStream output = new BufferedOutputStream(
                                    a);
                            Streams.copy(in, output, true);// 开始把文件写到你指定的上传文件夹
                        } else {
                            String fname = fis.getFieldName();

                            if (fname.indexOf("pictitle") != -1) {
                                BufferedInputStream in = null;
                                try {
                                    in = new BufferedInputStream(
                                            fis.openStream());
                                    byte c[] = new byte[10];
                                    int n;
                                    while ((n = in.read(c)) != -1) {
                                        if (c != null)
                                            title = new String(c, 0, n, "UTF-8");
                                        break;
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } finally {
                                    if (in != null)
                                        in.close();
                                }

                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        state = "上传错误！";
                        break;
                    }
                }
                title = title.replace("&", "&amp;").replace("'", "&qpos;")
                        .replace("\"", "&quot;").replace("<", "&lt;")
                        .replace(">", "&gt;");
                logger.info("add new img:" + imgUrl);
                response.getWriter().print(
                        "{'url':'" + imgUrl + "','title':'" + title
                                + "','state':'" + state + "'}"
                );
            } catch (FileUploadException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
