package com.nnxy.competition.utils;

import com.nnxy.competition.controller.TeamController;
import com.nnxy.competition.entity.Team;
import com.nnxy.competition.entity.User;
import com.nnxy.competition.service.TeamService;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author :CZS
 * @date :2020/3/27 14:50
 * Email    :642125256@qq.com
 */
public class POIUtils {


    //导出
    public static ResponseEntity<byte[]> userExcel(List<User> list) {
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("报名信息");
        //文档管理员
        //docInfo.setManager("javaboy");
        //设置公司信息
        //docInfo.setCompany("www.javaboy.org");
        //4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("报名信息");
        //文档作者
        summInfo.setAuthor("admin");
        // 文档备注
        summInfo.setComments("本文档由竞赛管理系统导出");
        //5. 创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFSheet sheet = workbook.createSheet("报名信息表");
        //设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 10 * 256);
        sheet.setColumnWidth(2, 20 * 256);
        sheet.setColumnWidth(3, 20 * 256);
        sheet.setColumnWidth(4, 10 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 5 * 256);
        sheet.setColumnWidth(7, 15 * 256);
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        //设置行值
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("序号");
        c0.setCellStyle(headerStyle);

        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("姓名");

        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("学校");

        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("学院");

        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("年级");

        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("班级");

        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("性别");

        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("联系电话");

        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getCollege().getUniversity().getUniversityName());
            row.createCell(3).setCellValue(user.getCollege().getCollegeName());
            row.createCell(4).setCellValue(user.getPeriod());
            row.createCell(5).setCellValue(user.getUserClassName());
            row.createCell(6).setCellValue(user.getSex());
            row.createCell(7).setCellValue(user.getPhone());
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("报名表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static ResponseEntity<byte[]> teamExcel(List<Team> teamList) {
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("队伍报名信息");
        //文档管理员
        //docInfo.setManager("javaboy");
        //设置公司信息
        //docInfo.setCompany("www.javaboy.org");
        //4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("报名信息");
        //文档作者
        summInfo.setAuthor("admin");
        // 文档备注
        summInfo.setComments("本文档由竞赛管理系统导出");
        //5. 创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFSheet sheet = workbook.createSheet("报名信息表");
        //设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 10 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 20 * 256);
        sheet.setColumnWidth(4, 20 * 256);
        sheet.setColumnWidth(5, 10 * 256);
        sheet.setColumnWidth(6, 20 * 256);
        sheet.setColumnWidth(7, 5 * 256);
        sheet.setColumnWidth(8, 15 * 256);
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        //设置行值
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("序号");
        c0.setCellStyle(headerStyle);

        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("队伍名");


        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("姓名");

        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("学校");

        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("学院");

        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("年级");

        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("班级");

        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("性别");

        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("联系电话");

        //当前行，默认1,  0为表头
        Integer nowLine = 1;
        for (int i = 0; i < teamList.size(); i++) {
            Team team = teamList.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(team.getTeamName());
            row.createCell(2).setCellValue(team.getCaptain().getName());
            row.createCell(3).setCellValue(team.getCaptain().getCollege().getUniversity().getUniversityName());
            row.createCell(4).setCellValue(team.getCaptain().getCollege().getCollegeName());
            row.createCell(5).setCellValue(team.getCaptain().getPeriod());
            row.createCell(6).setCellValue(team.getCaptain().getUserClassName());
            row.createCell(7).setCellValue(team.getCaptain().getSex());
            row.createCell(8).setCellValue(team.getCaptain().getPhone());

            //队伍成员标题行
            //6. 创建标题行
            HSSFRow rr0 = sheet.createRow(i + 2);
            //设置行值,从1开始，代表成员偏移一格
            HSSFCell cc1 = rr0.createCell(1);
            cc1.setCellValue("成员序号");
            cc1.setCellStyle(headerStyle);

            HSSFCell cc2 = rr0.createCell(2);
            cc2.setCellStyle(headerStyle);
            cc2.setCellValue("姓名");

            HSSFCell cc3 = rr0.createCell(3);
            cc3.setCellStyle(headerStyle);
            cc3.setCellValue("学校");

            HSSFCell cc4 = rr0.createCell(4);
            cc4.setCellStyle(headerStyle);
            cc4.setCellValue("学院");

            HSSFCell cc5 = rr0.createCell(5);
            cc5.setCellStyle(headerStyle);
            cc5.setCellValue("年级");

            HSSFCell cc6 = rr0.createCell(6);
            cc6.setCellStyle(headerStyle);
            cc6.setCellValue("班级");

            HSSFCell cc7 = rr0.createCell(7);
            cc7.setCellStyle(headerStyle);
            cc7.setCellValue("性别");

            HSSFCell cc8 = rr0.createCell(8);
            cc8.setCellStyle(headerStyle);
            cc8.setCellValue("联系电话");
            //队长信息加队员表头，占两行
            nowLine += 2;

            for (int j = 1; j < team.getUsers().size(); j++) {
                User user = team.getUsers().get(j);
                HSSFRow row1 = sheet.createRow(nowLine);
                row1.createCell(1).setCellValue(j);
                row1.createCell(2).setCellValue(user.getName());
                row1.createCell(3).setCellValue(user.getCollege().getUniversity().getUniversityName());
                row1.createCell(4).setCellValue(user.getCollege().getCollegeName());
                row1.createCell(5).setCellValue(user.getPeriod());
                row1.createCell(6).setCellValue(user.getUserClassName());
                row1.createCell(7).setCellValue(user.getSex());
                row1.createCell(8).setCellValue(user.getPhone());
                nowLine++;
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("报名表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }
        /*
        //导入
        public static List<Employee> excel2Employee(MultipartFile file, List<Nation> allNations, List<Politicsstatus> allPoliticsstatus, List<Department> allDepartments, List<Position> allPositions, List<JobLevel> allJobLevels) {
            List<Employee> list = new ArrayList<>();
            Employee employee = null;
            try {
                //1. 创建一个 workbook 对象
                HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
                //2. 获取 workbook 中表单的数量
                int numberOfSheets = workbook.getNumberOfSheets();
                for (int i = 0; i < numberOfSheets; i++) {
                    //3. 获取表单
                    HSSFSheet sheet = workbook.getSheetAt(i);
                    //4. 获取表单中的行数
                    int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                    for (int j = 0; j < physicalNumberOfRows; j++) {
                        //5. 跳过标题行
                        if (j == 0) {
                            continue;//跳过标题行
                        }
                        //6. 获取行
                        HSSFRow row = sheet.getRow(j);
                        if (row == null) {
                            continue;//防止数据中间有空行
                        }
                        //7. 获取列数
                        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                        employee = new Employee();
                        for (int k = 0; k < physicalNumberOfCells; k++) {
                            HSSFCell cell = row.getCell(k);
                            switch (cell.getCellType()) {
                                case STRING:
                                    String cellValue = cell.getStringCellValue();
                                    switch (k) {
                                        case 1:
                                            employee.setName(cellValue);
                                            break;
                                        //。。。
                                        case 9:
                                            int politicstatusIndex = allPoliticsstatus.indexOf(new Politicsstatus(cellValue));
                                            employee.setPoliticId(allPoliticsstatus.get(politicstatusIndex).getId());
                                            break;
                                        //。。。
                                        case 13:
                                            int jobLevelIndex = allJobLevels.indexOf(new JobLevel(cellValue));
                                            employee.setJobLevelId(allJobLevels.get(jobLevelIndex).getId());
                                            break;
                                        case 14:
                                            int positionIndex = allPositions.indexOf(new Position(cellValue));
                                            employee.setPosId(allPositions.get(positionIndex).getId());
                                            break;
                                        //。。。
                                    }
                            }
                            break;
                        }
                    }
                    list.add(employee);
                }
            }

        } catch (
        IOException e) {
            e.printStackTrace();
        }
        return list;
    }
        */
}
