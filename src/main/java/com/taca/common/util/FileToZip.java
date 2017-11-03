package com.taca.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taca.common.constants.IMResp;
import com.taca.common.exception.IMRunTimeException;
import com.taca.controller.mobile.LoginMobileController;

public final class FileToZip {  
	private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);
    private FileToZip(){}  
      
    /** 
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下 
     * @param sourceFilePath :待压缩的文件路径 
     * @param zipFilePath :压缩后存放路径 
     * @param fileName :压缩后文件的名称 
     * @return 
     */  
    public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName){  
        boolean flag = false;  
        File sourceFile = new File(sourceFilePath);  
        FileInputStream fis = null;  
        BufferedInputStream bis = null;  
        FileOutputStream fos = null;  
        ZipOutputStream zos = null;  
          
        
        try {  
        	File zipFile = new File(zipFilePath + "/" + fileName +".zip");  
        	if(zipFile.exists()){  
        		log.info(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");  
        	}else{  
        		File[] sourceFiles = sourceFile.listFiles();  
        		if(null == sourceFiles || sourceFiles.length<1){  
        			log.info("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");  
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
        			flag = true;  
        		}  
        	}  
        } catch (FileNotFoundException e) {  
               
        	throw new IMRunTimeException(IMResp.FILE_ZIP_ERROR);  
        } catch (IOException e) {  
        	throw new IMRunTimeException(IMResp.FILE_ZIP_ERROR); 
        } finally{  
        	//关闭流  
        	try {  
        		if(null != bis) bis.close();  
        		if(null != zos) zos.close();  
        	} catch (IOException e) {  
        		throw new IMRunTimeException(IMResp.FILE_ZIP_ERROR); 
        	}  	
        }  	
        	
        return flag;  
    }  
}