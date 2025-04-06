package com.hunre.edu.laptop.services.impls;

import com.hunre.edu.laptop.models.Product;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.hunre.edu.laptop.services.DataExporter;

import java.io.IOException;
import java.util.List;

public class DataExporterImpl implements DataExporter {
    private List<Product> productList;

    // Constructor để khởi tạo danh sách sản phẩm
    public DataExporterImpl(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void export(HttpServletResponse response) throws IOException {
        // Tạo workbook và sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");

        // Tạo row đầu tiên cho header
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Name", "Description", "Price", "Brand", "Category", "Created At", "Updated At", "Status", "Gender", "Deleted"};

        // Thêm header vào sheet
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        // Thêm dữ liệu sản phẩm vào sheet
        int rowCount = 1;
        for (Product product : productList) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(product.getId());
            row.createCell(1).setCellValue(product.getName());
            row.createCell(2).setCellValue(product.getDescription());
            row.createCell(3).setCellValue(product.getPrice());
            row.createCell(4).setCellValue(product.getBrand().getName());  // Lấy tên brand
            row.createCell(5).setCellValue(product.getCategory() != null ? product.getCategory().getName() : "N/A");  // Lấy tên category
            row.createCell(6).setCellValue(product.getCreatedAt().toString());
//            row.createCell(7).setCellValue(product.getUpdatedAt().toString());
            row.createCell(8).setCellValue(product.isStatus() ? "Active" : "Inactive");
            row.createCell(9).setCellValue(product.getGender() != null ? product.getGender().name() : "N/A");
            row.createCell(10).setCellValue(product.isDeleted() ? "Yes" : "No");
        }

        // Tạo header để tải file Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String headerValue = "attachment; filename=products.xlsx";
        response.setHeader("Content-Disposition", headerValue);

        // Ghi file vào response output stream
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
