package com.taca.controller;

import com.taca.controller.mobile.LoginMobileController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 芳华 on 2017/9/28.
 */
@Controller
@RequestMapping("icon")
public class IconController {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @RequestMapping(value = "show",method = {RequestMethod.GET,RequestMethod.POST})
    public void showIcon(String iconAddress, HttpServletResponse response){
        FileInputStream fis=null;
        ServletOutputStream sos=null;
        try {
            fis = new FileInputStream(iconAddress);

            int size=fis.available();
            byte[] data=new byte[size];
            fis.read(data);
            response.setContentType("image/*");
            sos=response.getOutputStream();
            sos.write(data);
        }
        catch (Exception e){
            log.info("文件路径出错",e);
        }
        finally {
            try {
                if(fis!=null){
                    fis.close();
                }
                if(sos!=null){
                    sos.close();
                }
            }
            catch (IOException e) {
                log.info("文件流关闭",e);
            }
        }
        }
    }
