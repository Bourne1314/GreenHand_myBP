package com.example.demo.Service.Impl;
import com.example.demo.DAO.Ecs;
import com.example.demo.Mapper.EcsMapper;
import com.example.demo.Service.EcsService;
import com.example.demo.Service.ImportExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class ImportExcelServiceImpl implements ImportExcelService {

    @Autowired
    private EcsMapper ecsMapper;

    @Autowired
    EcsService ecsService;

    /**
     * 首先判断文件扩展名
     * 其次获取不同sheet页的内容
     * 然后获取行数据
     * 最后获取单元格数据
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {

        boolean notNull = false;
        List<Ecs> ecsList = new ArrayList<Ecs>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        /**
         * Excel2003以前的版本，扩展名是.xls,使用HSSFWorkbook()
         * Excel2007之后的版本，扩展名是.xlsx,使用XSSFWorkbook()
         */
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        // 获取excel的第一个sheet页
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }
        Ecs ecs;
        // 循环行数
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {
            // 获取sheet的第r行的数据
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            ecs = new Ecs();

            /**
             * int CELL_TYPE_NUMERIC = 0;
             * int CELL_TYPE_STRING = 1;
             * int CELL_TYPE_FORMULA = 2;
             * int CELL_TYPE_BLANK = 3;
             * int CELL_TYPE_BOOLEAN = 4;
             * int CELL_TYPE_ERROR = 5;
             */
//            if( row.getCell(0).getCellType() !=1){
//                throw new Exception("导入失败(第"+(r+1)+"行,姓名请设为文本格式)");
//            }
            if(row.getCell(0)!=null){
                row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
                ecs.setId((int) row.getCell(0).getNumericCellValue());
                ecs.setCoreNumber((int) row.getCell(1).getNumericCellValue());
                ecs.setMemNumber((int) row.getCell(2).getNumericCellValue());
                ecs.setThreeAlpha((float) row.getCell(3).getNumericCellValue());
                ecs.setThreeBeta((float) row.getCell(4).getNumericCellValue());
                ecs.setTwoAlpha((float) row.getCell(5).getNumericCellValue());
                ecs.setTwoBeta((float) row.getCell(6).getNumericCellValue());
                ecs.setOneAlpha((float) row.getCell(7).getNumericCellValue());
                ecs.setOneBeta((float) row.getCell(8).getNumericCellValue());
            }
//            String coreNumber = row.getCell(0).getStringCellValue();
//
////            if(coreNumber == null || coreNumber.isEmpty()){
////                throw new Exception("导入失败(第"+(r+1)+"行,姓名未填写)");
////            }
//
//            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
//            String memNumber = row.getCell(1).getStringCellValue();
//            if(memNumber==null || memNumber.isEmpty()){
//                throw new Exception("导入失败(第"+(r+1)+"行,电话未填写)");
//            }
//            String yearNumber = row.getCell(2).getStringCellValue();
//            if(yearNumber==null){
//                throw new Exception("导入失败(第"+(r+1)+"行,不存在此单位或单位未填写)");
//            }
//
////            Date date;
////            if(row.getCell(3).getCellType() !=0){
////                throw new Exception("导入失败(第"+(r+1)+"行,入职日期格式不正确或未填写)");
////            }else{
////                date = row.getCell(3).getDateCellValue();
////            }
//
////            String des = row.getCell(4).getStringCellValue();
//
//            ecs.setCoreNumber(Integer.parseInt(coreNumber));
//            ecs.setMemNumber(Integer.parseInt(memNumber));
//            ecs.setYearNumber(Integer.parseInt(yearNumber));

            ecsList.add(ecs);
        }
        for (Ecs ecs1 : ecsList) {
            //首先判断该姓名是否已经存在
            Integer id = ecs1.getId();
            System.out.println(ecs1);
            System.out.println(id);
            System.out.println(ecsMapper.selectById(id));
            if (ecsMapper.selectById(id) == null) {
                //不存在即插入
                ecsService.save(ecs1);
                System.out.println(" 插入 "+ecs1);
            } else {
                //存在即更新
                ecsService.updateById(ecs1);
                System.out.println(" 更新 "+ecs1);
            }
        }
        return notNull;
    }
}
