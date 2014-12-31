package cc.ymee.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import cc.ymee.common.core.ApplicationConstants;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * svwuc
 *
 * @author :anjero
 * @version :1.0
 * @Title :QrCode
 * @Description:
 * @Datetime : 14-8-1 下午8:51
 * @Copyright :Copyright (c) 2012
 *
 */
public class QrCodeUtils {


    public static final String FORMAT = "jpg";


    public static String createQrPic(String url, String name) {
        try {
            //文件是否存在
            String PATH = ApplicationConstants.staticPath() + "/static/qrcode/";
            File outputFile = new File(PATH + name + "." + FORMAT);
            if (!outputFile.exists()) {
                File ff = new File(PATH);
                if (!ff.exists()) {
                    ff.mkdir();
                }
                FileUtil.createDir(PATH);
                int width = 300;
                int height = 300;
                Hashtable hints = new Hashtable();
                hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
                hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
                BitMatrix bitMatrix = new MultiFormatWriter().encode(url,
                        BarcodeFormat.QR_CODE, width, height, hints);
                MatrixToImageWriter.writeToFile(bitMatrix, FORMAT, outputFile);
            }
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) throws WriterException, IOException {
        createQrPic("http://wechat.ichefeng.com/act/cf/anniversary/index", "index");
    }
}
