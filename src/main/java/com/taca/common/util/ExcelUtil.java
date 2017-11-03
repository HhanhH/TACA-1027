package com.taca.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import com.taca.common.constants.IMResp;
import com.taca.common.exception.IMRunTimeException;
import com.taca.model.UserInfo;



public class ExcelUtil<T> {

   
    public static List<UserInfo> readExcle(File file){
        InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			throw new IMRunTimeException(IMResp.FAIL);
		}
         Workbook workbook=null;
        List<UserInfo> list=new ArrayList<UserInfo>();
        try {
            if(file.getName().endsWith(".xls"))
                workbook = new HSSFWorkbook(is);
            else
                workbook = new XSSFWorkbook(is);
        } catch (IOException e) {
           throw new IMRunTimeException(IMResp.FAIL);
        }
        UserInfo userInfo = null;

        // Read the Sheet
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            Sheet sheet = workbook.getSheetAt(numSheet);
            if (sheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
               Row row = sheet.getRow(rowNum);
                if (row != null) {
                    userInfo = new UserInfo();
                    Cell um = row.getCell(0);
                    Cell userNameCn=row.getCell(1);
                    Cell groupId=row.getCell(2);
                    Cell groupName=row.getCell(3);
                    userInfo.setUm(um.getStringCellValue());
                    userInfo.setUserNameCn(userNameCn.getStringCellValue());
                    userInfo.setGroupId(new Long((long)groupId.getNumericCellValue()));
                    //userInfo.setGroupId(new Long((long)Integer.parseInt(groupId.getStringCellValue())));
                    userInfo.setGroupName(groupName.getStringCellValue());
                    list.add(userInfo);
                }
            }
        }
        return  list;
    }

    public static List<UserInfo> readXlsx(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<UserInfo> list=new ArrayList<UserInfo>();
        UserInfo userInfo=null;
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }

            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    userInfo = new UserInfo();
                    XSSFCell um = xssfRow.getCell(0);
                    XSSFCell userNameCn=xssfRow.getCell(1);
                    XSSFCell groupId=xssfRow.getCell(2);
                    XSSFCell groupName=xssfRow.getCell(3);
                    userInfo.setUm(um.getStringCellValue());
                    userInfo.setUserNameCn(userNameCn.getStringCellValue());
                    userInfo.setGroupId(new Long((long)Integer.parseInt(groupId.getStringCellValue())));
                    userInfo.setGroupName(groupName.getStringCellValue());
                    list.add(userInfo);
                }
            }
        }
        return list;
    }
    public static List<UserInfo> readXls(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<UserInfo> list=new ArrayList<UserInfo>();
        UserInfo userInfo=null;
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    userInfo = new UserInfo();
                    HSSFCell um = hssfRow.getCell(0);
                    HSSFCell userNameCn=hssfRow.getCell(1);
                    HSSFCell groupId=hssfRow.getCell(2);
                    HSSFCell groupName=hssfRow.getCell(3);
                    
                   
                    userInfo.setUm(um.getStringCellValue());
                    userInfo.setUserNameCn(userNameCn.getStringCellValue());
                    userInfo.setGroupId(new Long((long)Integer.parseInt(groupId.getStringCellValue())));
                    userInfo.setGroupName(groupName.getStringCellValue());
                    list.add(userInfo);
                }
            }
        }
        return list;
    }


    /*public static <T> List<T> getModelsFromexcel(Class<T> t, File file) {
        List<T> models = null;
        try {
            Workbook wb = readExcel(file);
            String[] titles = readExcelTitle(wb);
            models = readExcelContent(titles, wb, t);
        } catch (Exception e) {
            logger.error("getModelsFromexcel() error", e);
        }
        logger.info("getModelsFromexcel() models数据 " + models);
        logger.info("getModelsFromexcel() end");
        return models;
    }

    public static Workbook readExcel(File file) {
        Workbook wb = null;
        try {
            InputStream is = new FileInputStream(file);
            wb = new XSSFWorkbook(is);
        } catch (Exception e) {
            logger.error("readExcel() error", e);
        }
        return wb;
    }


    *//**
     * 获取excel的title
     * 这一步可以通过反射实现
     *
     * @return title
     * @throws Exception
     *//*
    public static String[] readExcelTitle(Workbook wb) {
        logger.info("readExcelTitle() start");
        String[] titles = null;
        try {
            if (wb == null) {
                throw new Exception("Workbook对象为空！");
            }
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(0);
            // 标题总列数
            int colNum = row.getPhysicalNumberOfCells();
            titles = new String[colNum];
            for (int i = 0; i < colNum; i++) {
                titles[i] = row.getCell(i).getStringCellValue();
            }
        } catch (Exception e) {
            logger.error("title读取失败", e);
        }
        logger.info("readExcelTitle() end");
        return titles;
    }

    *//**
     * 获取到文件的数据
     *
     * @return
     * @throws Exception
     *//*
    public static <T> List<T> readExcelContent(String[] titles, Workbook wb, Class<T> clazz) {
        logger.info("readExcelContent() start");
        List<T> models = null;
        boolean isError = false;
        T t = null;
        if (wb == null) {
            return models;
        }
        models = new ArrayList();

        int numofSheet = wb.getNumberOfSheets();
        //考虑到可能有多页sheet
        for (int m = 0; m < numofSheet; m++) {
            Sheet sheet = wb.getSheetAt(m);
            // 得到总行数
            int rowNum = sheet.getLastRowNum();
            Row row = sheet.getRow(0);
            int colNum = row.getPhysicalNumberOfCells();
            // 正文内容应该从第二行开始,第一行为表头的标题

            for (int i = 1; i <= rowNum; i++) {
                row = sheet.getRow(i);
                try {
                    t = clazz.newInstance();
                } catch (Exception e) {
                    logger.error("clazz没找到", e);
                }
                for (int j = 0; j < colNum; j++) {
                    try {
                        Object obj = getCellFormatValue(row.getCell(j));

                        Field field = clazz.getDeclaredField(titles[j]);

                        obj = transform(field.getType(), obj);

                        field.setAccessible(true);
                        field.set(t, obj);
                    } catch (Exception e) {
                        isError = true;
                        logger.error("解析出现错误 行 列" + (i + 1) + "  " + (j + 1), e);
                    }
                    if (!isError) {
                        models.add(t);
                    }
                    if (isError) {
                        isError = false;
                        break;
                    }
                }

            }

        }

        logger.info("readExcelContent() models" + models);
        logger.info("readExcelContent() end");
        return models;
    }


    *//**
     * 在对field的set的过程中 需要强制类型
     * 并不一致的类型会导致数据无法正常写入
     *
     * @param type
     * @param obj
     * @return
     *//*
    private static Object transform(Class<?> type, Object obj) {
        if (obj == null || obj.equals(""))
            return null;

        String objStr = obj.toString();
        if (type == Long.class) {
            obj = Long.parseLong(objStr);
        } else if (type == Integer.class) {
            obj = Integer.parseInt(objStr);
        } else if (type == Boolean.class) {
            obj = Boolean.parseBoolean(objStr);
        } else if (type == Double.class) {
            obj = Double.parseDouble(objStr);
        } else if (type == Float.class) {
            obj = Float.parseFloat(objStr);
        } else if (type == Short.class) {
            obj = Short.parseShort(objStr);
        } else if (type == Date.class) {
            obj = new Date(objStr);
        }
        return obj;
    }

    *//**
     * 根据cell的具体类型 获取到相应的数据
     *
     * @param cell
     * @return
     *//*
    private static Object getCellFormatValue(Cell cell) {
        Object cellvalue = null;
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    cellvalue = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    cellvalue = "";
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                case Cell.CELL_TYPE_FORMULA: {
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_STRING:
                    cellvalue = cell.getStringCellValue();
                    break;
                default:
                    cellvalue = "";
            }
        }
        return cellvalue;
    }

    public static <T> Workbook parseListToWorkbook(List<T> list, Class<T> clazz) {
        logger.info("ParseListToWorkbook() start:" + list + clazz);
        if (list == null) {
            return null;
        }

        Workbook workbook = new XSSFWorkbook();
        List<String> titles = writeExcelTitle(clazz, workbook);
        writeExcelContent(list, clazz, titles, workbook);

        return workbook;

    }


    public static void writeExcel(Workbook workbook, String filePath) {
        logger.info("writeExcel() start:" + workbook + filePath);
        OutputStream out = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = simpleDateFormat.format(new Date());

            filePath = filePath + File.separator + date + ".xlsx";

            out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            logger.error("writeExcel异常" + e);
        }

    }

    public static List<String> writeExcelTitle(Class clazz, Workbook workbook) {
        logger.info("writeExcelTitle() start:" + clazz + workbook);
        List<String> titles = new ArrayList<String>();
        if (workbook == null) {
            return null;
        }
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        Field[] fields = clazz.getDeclaredFields();
        int cellNum = 0;

        for (Field field : fields) {
            field.getModifiers();
            Cell cell = row.createCell(cellNum);
            if (field.getName() != "serialVersionUID") {
                titles.add(field.getName());
                cell.setCellValue(titles.get(cellNum++));
            }

        }
        logger.info("writeExcelTitle()" + titles);
        return titles;
    }


    public static <T> void writeExcelContent(List<T> models, Class clazz, List<String> titles, Workbook workbook) {
        logger.info("wirteExcelContent() start:" + models + clazz + titles + workbook);

        try {
            if (workbook == null) {
                logger.info("writeExcelContent():workbook == null");
                return;
            }
            int countSheet = workbook.getNumberOfSheets();
            int sheetNum = 0;
            while (sheetNum < countSheet) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                int rowNum = 1;
                for (Object model : models) {
                    Row row = sheet.createRow(rowNum);
                    int cellNum = 0;
                    for (String title : titles) {
                        title = title.substring(0, 1).toUpperCase() + title.substring(1);
                        String methodName = "get" + title;
                        Method method = clazz.getDeclaredMethod(methodName);
                        Object object = method.invoke(model);

                        Cell cell = row.createCell(cellNum);
                        setCellValue(object, cell);
                        cellNum++;
                    }
                    rowNum++;

                }
                sheetNum++;
            }

        } catch (Exception e) {
            logger.error("writeExcelContent():写入内容异常" + e);
        }

    }

    private static void setCellValue(Object object, Cell cell) {
        if (object != null) {
            if (object.getClass() == Date.class) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = simpleDateFormat.format(object);
                cell.setCellValue(date);
            } else {
                cell.setCellValue(object.toString());
            }
        } else {
            cell.setCellValue("");
        }
    }


    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-beans.xml");
//        BaseService baseService = (BaseService) context.getBean("mockEnvironmentServiceImpl");
//
//        ExcelUtil.writeExcel(ExcelUtil.parseListToWorkbook(baseService.getList(null), MockEnvironment.class), "D:");
        getModelsFromexcel(UserInfo.class, new File("D:/20160801162802.xlsx"));
    }

}
*/
}