package com.taca.common.util;

import com.taca.model.Submissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by asus on 2017/10/11.
 */
public class ZIPUtil {

    /**
     * 写入文件并压缩
     */
    private static final Logger log = LoggerFactory.getLogger(ZIPUtil.class);

    public String ZIPUtile(MultipartFile[] file,String userName)throws IOException{
        InputStream inputStream = null;
        String sourceFilePath = "F:\\test\\";
        FileOutputStream outputStream = new FileOutputStream(sourceFilePath+ file[0].getOriginalFilename());
        Submissions submissions = new Submissions();
        try {
            for(int i = 0;i<file.length;i++){
                inputStream = file[i].getInputStream();
                byte[] buffer = new byte[1024];
                int leath = 0;
                while (inputStream.read(buffer) != -1) {
                    log.info("正在写入文件");
                    outputStream.write(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }

        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        File zipFile = null;
        String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        if(sourceFile.exists() == false){
            System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
        }else{
            try {
                zipFile = new File(sourceFile + "/" + date+"_"+userName+".zip");
                if(zipFile.exists()){
                    System.out.println(sourceFile+ "目录下存在名字为:" + date+"_"+userName+".zip" +"打包文件.");
                }else{
                    File[] sourceFiles = sourceFile.listFiles();
                    if(null == sourceFiles || sourceFiles.length<1){
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    }else{
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024*10];
                        for(int i=0;i<sourceFiles.length;i++){
                            //创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            //读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024*10);
                            int read = 0;
                            while((read=bis.read(bufs, 0, 1024*10)) != -1){
                                zos.write(bufs,0,read);
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally{
                //关闭流
                try {
                    if(null != bis) bis.close();
                    if(null != zos) zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return  zipFile.toString();
    }
}
