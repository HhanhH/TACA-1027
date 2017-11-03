package com.taca.action;

import com.taca.common.constants.Constants;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.NoticeStatus;
import com.taca.common.exception.IMRunTimeException;
import com.taca.common.util.Page;
import com.taca.model.NoticeInfo;
import com.taca.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by 芳华 on 2017/9/28.
 */
@Component("noticeAction")
public class NoticeAction {

    @Autowired
    private NoticeService noticeService;

    public List<NoticeInfo> getNoticeList(){
        return noticeService.getNoticeList();
    }
    public List<NoticeInfo> getListByPage(Map<String, Object> map , NoticeInfo noticeInfo, Page page) {
        map.put("noticeInfo", noticeInfo);

        int count=noticeService.countByMap(map);
        page.setTotalNumber(count);
        page.count();
        map.put("page", page);
        List<NoticeInfo> list=null;
        list= noticeService.getListByPage(map);
        return list;
    }


    public NoticeInfo getById(Long id){
        return noticeService.getById(id);
    }

    public Integer update(MultipartFile file,NoticeInfo noticeInfo){
        if(StringUtils.isEmpty(file.getOriginalFilename())){
            noticeInfo.setIconAddress(null);
        }else{
            String fileName = file.getOriginalFilename();
            String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            fileName = date+"_"+fileName;
            String path  = Constants.PIC_PATH+fileName;
            File file2 = new File(path);

            try {
                file.transferTo(file2);
            } catch (IllegalStateException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            } catch (IOException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            }
            path = path.replace("\\", "/");
            noticeInfo.setIconAddress(path);
        }
        return noticeService.update(noticeInfo);
    }

    public Integer updateForActive(NoticeInfo noticeInfo){

        if(NoticeStatus.ACTIVE.name().equals(noticeInfo.getStatus())){
            noticeInfo.setStatus(NoticeStatus.INACTIVE.name());
        }else{
            noticeInfo.setStatus(NoticeStatus.ACTIVE.name());
        }
        return noticeService.update(noticeInfo);
    }

    public Integer add(MultipartFile file, NoticeInfo noticeInfo){

        if(StringUtils.isEmpty(file.getOriginalFilename())){
            noticeInfo.setIconAddress(null);
        }else{
            String fileName = file.getOriginalFilename();
            String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            fileName = date+"_"+fileName;
            String path  = Constants.PIC_PATH+fileName;
            File file2 = new File(path);

            try {
                file.transferTo(file2);
            } catch (IllegalStateException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            } catch (IOException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            }
            path = path.replace("\\", "/");
            noticeInfo.setIconAddress(path);
        }
        return noticeService.add(noticeInfo);
    }
}
