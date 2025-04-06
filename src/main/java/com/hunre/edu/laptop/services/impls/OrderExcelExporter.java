package com.hunre.edu.laptop.services.impls;

import com.hunre.edu.laptop.models.Order;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderExcelExporter {
    private List<Order> orderList;

    public OrderExcelExporter(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void export(HttpServletResponse response) throws IOException {
        // Tạo workbook và sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Orders");

        // Tạo row đầu tiên cho header
        Row headerRow = sheet.createRow(0);
        String[] headers = {
                "Order ID", "User", "Staff", "Order Type", "Payment Type", "Address",
                "Order Time", "Total Price", "Total Discount", "Status", "Paid",
                "Discount Amount", "Discount Details", "Created At", "Payment Time"
        };

        // Thêm header vào sheet
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        // Thêm dữ liệu đơn hàng vào sheet
        int rowCount = 1;
        for (Order order : orderList) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(order.getId());
            row.createCell(1).setCellValue(order.getUser() != null ? order.getUser().getName() : "N/A");
            row.createCell(2).setCellValue(order.getStaff() != null ? order.getStaff().getName() : "N/A");
            row.createCell(3).setCellValue(order.getOrderType().name());
            row.createCell(4).setCellValue(order.getPaymentType().name());
            row.createCell(5).setCellValue(order.getAddress() != null ? order.getAddress() : "N/A");
            row.createCell(6).setCellValue(order.getOrderTime() != null ? order.getOrderTime().toString() : "N/A");
            row.createCell(7).setCellValue(order.getTotalPrice());
            row.createCell(8).setCellValue(order.getTotalDiscount());
            row.createCell(9).setCellValue(order.getStatus().name());
            row.createCell(10).setCellValue(order.isPaid() ? "Yes" : "No");
            row.createCell(11).setCellValue(order.getDiscountAmount());
            row.createCell(12).setCellValue(order.getDiscountDetails() != null ? order.getDiscountDetails() : "N/A");
            row.createCell(13).setCellValue(order.getCreatedAt().toString());
            row.createCell(14).setCellValue(order.getPaymentTime() != null ? order.getPaymentTime().toString() : "N/A");
        }

        // Set header để tải file Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        String headerValue = "attachment; filename=orders.xlsx";
        response.setHeader("Content-Disposition", headerValue);

        // Ghi file vào output stream của response
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
