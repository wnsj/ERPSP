package com.jiubo.erp.common;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.OutputStream;
import java.util.Collection;

public class ExportExcleUtils {

    private static ExportExcleUtils export;

    private ExportExcleUtils() {
    }

    public static ExportExcleUtils getInstance() {
        if (export == null) {
            export = new ExportExcleUtils();
        }
        return export;
    }

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param title       表格标题名
     * @param headerTitle 表格属性列名数组（标题）若为null，默认显示headers
     * @param headers     表格属性列名数组
     * @param dataset     需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *                    javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out         与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern     如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     * @throws Exception
     */
    public String exportExcel(String title, String path, String[] headerTitle, String[] headers, Collection<?> dataSet,
                              String pattern, boolean merge) {

        OutputStream out = null;

        HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个工作簿
        // 设置样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置背景颜色
        style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
        return null;
    }

}
