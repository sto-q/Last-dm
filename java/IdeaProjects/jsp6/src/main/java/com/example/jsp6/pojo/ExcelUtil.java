package com.example.jsp6.pojo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
private  static final int MAX_COUNT_PER_SHEET=5000;

//    public static void main(String[] args) throws FileNotFoundException {
//        InputStream is=new FileInputStream("C:\\Users\\seto\\Desktop\\学生信息表.xlsx");
//        importExcel(is,student.class);
//    }
public static void main(String[] args) throws FileNotFoundException {
    List<student> students=new ArrayList<>();
            for(int i=0;i<40000;i++){
            student stu=new student();
            stu.setAge(18+i);
            stu.setSex(i%2==0?"男":"女");
            stu.setClassName("计科"+i+"班");
            stu.setName("张三"+i);
            students.add(stu);
        }
            OutputStream os=new FileOutputStream("C:\\Users\\seto\\Desktop\\学生信息表1.xlsx");

            exportExcel(os,student.class,"学生信息表1",students);

}

    public static <T> void exportExcel(OutputStream os,Class<T> clazz,String sheetName,List<T> datalist){
        ExcelWriter writer=EasyExcel.write(os,clazz).build();
        int size=datalist.size();//数据总条数
        int sheetCount=size/MAX_COUNT_PER_SHEET;
        if(size % MAX_COUNT_PER_SHEET>0){
            sheetCount+=1;
        }
        for(int i=0;i<sheetCount;i++){
            int start=i* MAX_COUNT_PER_SHEET;
            int end=(i+1)*MAX_COUNT_PER_SHEET;
            end=end>size-1?size-1:end;
            List<T> sheetData=datalist.subList(start,end);
            WriteSheet sheet=new WriteSheet();
            sheet.setSheetNo(i);
            sheet.setSheetName(sheetName+(i+1));
            writer.write(sheetData,sheet);
        }
        writer.finish();
    }
    public static<T> List<T> importExcel(InputStream is,  Class<T> Clazz) {
        List<T> dataList=new ArrayList<>();
        ReadListener<T> listener= new ReadListener<>() {
            @Override
            public void invoke(T t, AnalysisContext analysisContext) {
                System.out.println("读取了一行数据" + t);
                dataList.add(t);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("excel读取一个sheet完成");
            }
        };
        EasyExcel.read(is,Clazz,listener).doReadAll();
        return dataList;

    }
//    public static void main(String[] args){
//        List<student> students=new ArrayList<>();
//        for(int i=0;i<100;i++){
//            student stu=new student();
//            stu.setAge(18);
//            stu.setSex(i%2==0?"男":"女");
//            stu.setClassName("计科1班");
//            stu.setName("刘欢"+i);
//            students.add(stu);
//        }
//        String recelPath="C:\\Users\\seto\\Desktop\\学生信息表.xlsx";
//        writeExcel(recelPath, student.class,"学生信息表",students);
//        String recelPath="C:\\Users\\seto\\Desktop\\学生信息表.xlsx";
//        List<student> students = readExcel(recelPath,"学生信息表", student.class);
//        System.out.println(students.size());
//    }

    public static<T> List<T> readExcel(String path,String sheetName,Class<T> Clazz) {
        List<T> dataList=new ArrayList<>();
        ReadListener<T> listener=new ReadListener<T>() {


            @Override
            public void invoke(T t, AnalysisContext analysisContext) {
                System.out.println("读取了一行数据"+t);
                dataList.add(t);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("excel读取一个sheet完成");
            }
        };
        //excel需要读取位置，类型，因为这个类型中就指定了excel表头与类型定义的映射关系，还需要指定行的监听器，因为EasyExcel是按行读取的，这个监听器就是感知一行的读取过程
        EasyExcel.read(path,Clazz,listener).sheet(sheetName).doRead();
        return dataList;
    }

    public static<T> void writeExcel(String Path,Class<T> clazz,String sheetName, List<T> datalist) {
        EasyExcel.write(Path,clazz).sheet(sheetName).doWrite(datalist);
    }
}
