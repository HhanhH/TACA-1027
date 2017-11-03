package com.taca.common.constants;

/**
 * Created by jetty on 17/9/22.
 */
public enum IMResp {

    SUCCESS("000000","操作成功"),
    FIELD_IS_NULL("000001","字段为空"),
    RECEIVE_OVERFLOW("000002","领取次数达到上限"),
    TASK_IS_DOING("000003","任务正在进行中"),
    TASK_IS_MUTEX("000004","存在互斥任务正在进行中"),
    Goods_LOW_STOCK("000005","商品库存不足"),
    PARAM_NULL("000006","必要参数为空"),
    PIC_WRONG("000007","图片格式错误"),
    FILT_SAVE("000008","保存图片异常"),
    FILT_NOT_FOUND("000009","文件不存在"),
    PASSWORD_NOT_SAME("000010","两次输入的密码不一致"),
    RANDOM_UNCORRECT("000011","验证码不正确"),
    NOT_REGISTER("000012","该账号尚未注册"),
    PASSWORD_UNCORRECT("000013","账号或密码不正确"),
    TEMPLATE_LOAD_ERROR("000014","邮件模板读取异常"),
    FILE_SAVE_ERROR("000015","保存图片异常"),
    FILE_NOT_FOUND("000016","文件不存在"),
    DATA_EXISTS("000017","数据已存在"),
    FILE_ERROR("000018","文件格式错误"),
    ACCOUNT_IS_ILLEGAL("000019","账号非法"),
    FILE_NO("000020","请选择文件"),
    USERNAME_IS_NULL("000021","请输入UM账号"),
    STAR_IS_LOWER("000022","星点不足,快去领取任务吧~~"),
    FILE_READ_ERROR("000023","文件读取异常"),
    CANNOT_CHOOSE_SELF("000024","不能选择自己互斥"),
    UNLOGIN("000025","尚未登录，请先登录"),
    HAD_REGISTER("000026","改账号已经注册"),
    GROUPID_GROUPNAME_ERROR("000027","部门ID和部门名称不符"),
    FILE_ZIP_ERROR("000028","文件压缩异常"),
    RANDOMCODE_NOT_GET("000029","请先获取验证码"),
    DATE_COM_ERROR("000030","日期比较出现异常"),
    OLD_PWD_ERROR("000031","旧密码不正确"),
    DBEXCEPTION("555555","数据库异常"),
    FAIL("999999","系统异常"),
    ;

     private String code;
     private String message;
     IMResp(String code,String message){
        this.code=code;
         this.message=message;
    };

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
