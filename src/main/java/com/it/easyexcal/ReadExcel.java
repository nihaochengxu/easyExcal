package com.it.easyexcal;

/**
 * @Author WQC
 * @Date 2022/6/19 0:19
 * @Version 1.0
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static void main(String[] args) {

        //读取excel文件
//        String path = "C:\\Users\\Desktop\\Mytest.xlsx";
        String path = "E:\\ideaProject\\pythonStudy\\test.xlsx";
//1.大文件写HSSF
//缺点：最多只能处理65535行，否则会抛出异常
//
//优点：过程中写入缓存，不操作磁盘，最后一次性写入磁盘。速度快
//
//2.大文件写XSSF
//缺点:写数据时速度非常快，非常耗内存，也会发生内存溢出，如100万条
//
//优点：可以写较大的数据量，如20万条
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            //创建一个Workbook对象读取xlsx文件
            Workbook workbook = new XSSFWorkbook(is);
            Workbook workbook1 = new SXSSFWorkbook(100);

            //读取sheet
            //获取sheet的数量
            int numberOfSheets = workbook.getNumberOfSheets();
            System.out.println("sheet的数量是："+numberOfSheets);
            //获取对应的sheet表
            //直接通过工作表的名称获取对应的工作表对象
            //如果获取的名称不存在，返回null
//            Sheet sheet1 = workbook.getSheet("sheet1");
            Sheet sheet1 = workbook.getSheetAt(0);

            //通过工作表获取行
            //获取sheet1中的所有的行（物理的行数：只有写了内容的行数才会算）
            int numberOfRows = sheet1.getPhysicalNumberOfRows();

            //DataFormatter formatter = new DataFormatter();
            System.out.println("行数:"+numberOfRows);
            for (int i = 0; i < numberOfRows; i++) {
                Row row = sheet1.getRow(i);
                //通过每一行获取所有的列
                //获取列数
                int numberOfCells = row.getPhysicalNumberOfCells();
                System.out.println("第"+(i+1)+"行的列数："+numberOfCells);
                //获取每一列的内容
                for (int j = 0; j < numberOfCells; j++) {

                    //获取每一列的cell对象
                    Cell cell = row.getCell(j);
                    //获取坐标对象。
                    //CellReference reference = new CellReference(row.getRowNum(), cell.getColumnIndex());

                    //获取所有的内容
//					String value = cell.getStringCellValue();
//					System.out.println("value="+value);
                    //获取每一个数据的类型
                    try {
                        //将所有的类型都转化成字符串
                        //System.out.println("value-->"+reference.formatAsString()+":"+formatter.formatCellValue(cell));
                        if (cell.getCellComment() != null) {
                            System.out.println(cell.getCellComment().getAuthor());
                            System.out.println(cell.getCellComment().getString());
                        }
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BLANK:
                                System.out.println("空白");
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                System.out.println("布尔类型："+cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                System.out.println("警告类型："+cell.getErrorCellValue());
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                System.out.println("公式类型："+cell.getCellFormula());
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    //判断是否是时间类型
                                    System.out.println("时间类型："+cell.getDateCellValue());
                                } else {
                                    System.out.println("数字类型："+cell.getNumericCellValue());
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.println("字符串型："+cell.getStringCellValue());
                                break;
                            default:
                                System.out.println("其他类型");
                                break;
                        }
//						System.out.println("第"+(j+1)+"列："+cell.getCellType());
                    } catch (Exception e) {
                        System.out.println("第"+(j+1)+"列：null");
                    }
//					Cell.CELL_TYPE_BLANK --> 空白
//					Cell.CELL_TYPE_BOOLEAN --> 布尔类型
//					Cell.CELL_TYPE_ERROR --> 警告
//					Cell.CELL_TYPE_FORMULA --> 函数
//					Cell.CELL_TYPE_NUMERIC --> 数字
//					Cell.CELL_TYPE_STRING --> 字符串
                }
                System.out.println("----------------------------");
            }


            System.out.println("Cell.CELL_TYPE_BLANK-->"+Cell.CELL_TYPE_BLANK);
            System.out.println("Cell.CELL_TYPE_BOOLEAN-->"+Cell.CELL_TYPE_BOOLEAN);
            System.out.println("Cell.CELL_TYPE_ERROR-->"+Cell.CELL_TYPE_ERROR);
            System.out.println("Cell.CELL_TYPE_FORMULA-->"+Cell.CELL_TYPE_FORMULA);
            System.out.println("Cell.CELL_TYPE_NUMERIC-->"+Cell.CELL_TYPE_NUMERIC);
            System.out.println("Cell.CELL_TYPE_STRING-->"+Cell.CELL_TYPE_STRING);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

