/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import modul.ChiTietSP;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.CuaHangRepository;
import repository.LoaiSpRepository;

/**
 *
 * @author admin
 */
public class ExcelHelper {

    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private static LoaiSpRepository loaiSpRepository = new LoaiSpRepository();
    private static final int COLUMN_INDEX_IMEI = 0;
    private static final int COLUMN_INDEX_IdLoaiSP = 1;
    private static final int COLUMN_INDEX_IdCuaHang = 2;
    private static final int COLUMN_INDEX_TrangThai = 3;

    public ArrayList<ChiTietSP> readFileExcel(String path) throws FileNotFoundException, IOException {
        ArrayList<ChiTietSP> list = new ArrayList<>();

        InputStream inputStream = new FileInputStream(path);

        Workbook workbook = getWorkbook(inputStream, path);

        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getRowNum() == 0) {
                continue;
            }

            Iterator<Cell> cellIterator = row.cellIterator();
            ChiTietSP ctsp = new ChiTietSP();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);

                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }

                int column_index = cell.getColumnIndex();
                switch (column_index) {
                    case COLUMN_INDEX_IMEI:
                        ctsp.setImei((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_IdLoaiSP:
                        ctsp.setIdLoaiSp(loaiSpRepository.search((String) getCellValue(cell)));
                        break;
                    case COLUMN_INDEX_IdCuaHang:
                        ctsp.setIdCuaHang(cuaHangRepository.search(new BigDecimal((double) cellValue).intValue()));
                        break;
                    case COLUMN_INDEX_TrangThai:
                        ctsp.setTrangThai(new BigDecimal((double) cellValue).intValue());
                        break;
                }
            }
            list.add(ctsp);
        }
        workbook.close();
        inputStream.close();
        return list;
    }

    public void writeFileExcel(ArrayList<ChiTietSP> list) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("danh_sach");
            XSSFRow row = null;
            Cell cell = null;

            row = sheet.createRow(0);

            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue("Id");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Imei");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("IdLoaiSp");

            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue("IdCuaHang");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("NgayThem");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("NgaySua");

            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue("TrangThai");

            for (int i = 0; i < list.size(); i++) {
                ChiTietSP ctsp = list.get(i);
                row = sheet.createRow(i + 1);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(ctsp.getId());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(ctsp.getImei());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ctsp.getIdLoaiSp().toString());

                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(ctsp.getIdCuaHang().getId());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(ctsp.getNgayThem().toString());

                try {
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue(ctsp.getNgaySua().toString());
                } catch (Exception e) {
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue("NULL");
                }

                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue(ctsp.getTrangThai());

            }

            File f = new File("E:\\DuAn1\\ProjectDuAn1\\WriteFile.xlsx");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(f);
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Workbook getWorkbook(InputStream inputStream, String path) throws IOException {
        Workbook workbook = null;

        if (path.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (path.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }

    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluateInCell(cell).getStringCellValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            default:
                throw new AssertionError();
        }
        return cellValue;
    }

    public static void main(String[] args) throws IOException {
        ExcelHelper ex = new ExcelHelper();
        ex.writeFileExcel(ex.readFileExcel("E:\\DuAn1\\ProjectDuAn1\\src\\main\\java\\datapakage\\FileData.xlsx"));
    }
}
