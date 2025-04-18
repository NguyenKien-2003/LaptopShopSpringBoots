package com.hunre.edu.laptop.controllers;

import com.hunre.edu.laptop.dtos.requests.ProductCreationRequest;
import com.hunre.edu.laptop.dtos.requests.ProductUpdatetion;
import com.hunre.edu.laptop.dtos.responses.ProductVariantDetailsResponse;
import com.hunre.edu.laptop.models.Product;
import com.hunre.edu.laptop.models.ProductVariant;
import com.hunre.edu.laptop.repositories.OrderRepository;
import com.hunre.edu.laptop.repositories.ProductRepository;
import com.hunre.edu.laptop.services.ProductService;
import com.hunre.edu.laptop.services.impls.DataExporterImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/staff/create")
    public ResponseEntity<?> createProduct(@ModelAttribute ProductCreationRequest productCreationRequest) {
        return ResponseEntity.ok(productService.createProductWithVariants(productCreationRequest));
    }
    @GetMapping("/export/excel")
    public void exportProductsToExcel(HttpServletResponse response) throws IOException {
        // Lấy danh sách sản phẩm từ cơ sở dữ liệu
        List<Product> products = productRepository.findAll();

        // Khởi tạo DataExporter và xuất dữ liệu
        DataExporterImpl dataExporter = new DataExporterImpl(products);
        dataExporter.export(response);
    }


//    @GetMapping("/public/variant/{id}")
//    public ResponseEntity<?> getProductVariant(@PathVariable Long id) {
//        return ResponseEntity.ok(productService.getProductVariantById(id));
//    }

    @GetMapping("/variants/all")
    public ResponseEntity<?> getAllProductVariantDefaults(@RequestParam(defaultValue = "") String keyword,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                                           @RequestParam(value = "order", defaultValue = "desc") String order) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(productService.getProductVariantByKeyword(keyword, pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "") String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "order", defaultValue = "desc") String order) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(productService.getProductByKeywordAndStatus(keyword, status, pageable));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<ProductVariantDetailsResponse>> filterProducts(
            @RequestParam(defaultValue = "0") int minPrice,
            @RequestParam(defaultValue = "100000000") int maxPrice,
            @RequestParam(required = false) List<Long> brandIds,
            @RequestParam(required = false) List<Long> categoryIds,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "order", defaultValue = "desc") String order) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(productService.getFilteredProducts(minPrice, maxPrice, brandIds,categoryIds, pageable));
    }

    @GetMapping("/variants-for-sell/all")
    public ResponseEntity<?> getAllProductVariants(@RequestParam(defaultValue = "") String keyword,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size,
                                                   @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                                                   @RequestParam(value = "order", defaultValue = "desc") String order) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(productService.getAllProductVariants(keyword, pageable));
    }

    @GetMapping("/public/variant/{id}")
    public ResponseEntity<?> getProductVariantResponse(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductVariantDetailsResponseById(id));
    }

    @GetMapping("/public/variant/details/{id}")
    public ResponseEntity<?> getProductVariantDetailsResponse(@PathVariable Long id,
                                                              @RequestParam(defaultValue = "4") int size) {
        return ResponseEntity.ok(productService.getProductDetailAndRelate(id, size));
    }

    @PutMapping("/staff/update/status/{id}")
    public ResponseEntity<?> updateProductStatus(@PathVariable Long id) {
        return ResponseEntity.ok(productService.updateProductStatus(id));
    }

    @GetMapping("/public/variant/details-change/{productId}")
    public ResponseEntity<?> getProductVariantDetailsResponseByProductIdAndColor(
            @PathVariable Long productId,
            @RequestParam(required = false, defaultValue = "#00FF00") String color) {
        return ResponseEntity.ok(productService.getProductDetailByColor(color, productId));
    }

    @GetMapping("/public/variant/details-full/{productId}")
    public ResponseEntity<?> getProductVariantDetailsResponseByProductIdAndColorAndSize(@PathVariable Long productId,
                                                                                       @RequestParam(required = false, defaultValue = "#00FF00") String color,
                                                                                       @RequestParam(required = false, defaultValue = "0") int size) {
        return ResponseEntity.ok(productService.getProductVariantDetailsResponseByProductIdAndColorAndSize(productId, color, size));
    }

    @GetMapping("/public/variant/details-change-color/{productId}")
    public ResponseEntity<List<ProductVariantDetailsResponse>> getAllProductVariantDetailsResponseByProductIdAndColor(
            @PathVariable Long productId,
            @RequestParam(required = false, defaultValue = "#00FF00") String color) {
        return ResponseEntity.ok(productService.getAllVariantByProductAndColor(productId, color));
    }

    @GetMapping("/admin/variants/{productIds}")
    public ResponseEntity<?> getProductVariantsByProductIds(@PathVariable List<Long> productIds,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size,
                                                           @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                                                           @RequestParam(value = "order", defaultValue = "desc") String order) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(productService.getProductVariantsByProductIds(productIds, pageable));
    }

    @GetMapping("/admin/variants/")
    public ResponseEntity<?> getProductVariantsByProductIds(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size,
                                                            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
                                                            @RequestParam(value = "order", defaultValue = "desc") String order) {
        Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @DeleteMapping("/staff/variant/delete/{id}")
    public ResponseEntity<?> deleteProductVariant(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteVariant(id));
    }

    @GetMapping("/staff/variants/{productId}")
    public ResponseEntity<?> getProductVariantsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductVariantsByProductId(productId));
    }

    @PutMapping("/staff/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductUpdatetion product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @GetMapping("/staff/variant/{variantId}")
    public ResponseEntity<?> getProductVariant(@PathVariable Long variantId) {
        return ResponseEntity.ok(productService.getProductVariantById(variantId));
    }

    @PutMapping("/staff/variant/update/{variantId}")
    public ResponseEntity<?> updateVariant(@PathVariable Long variantId, @RequestBody ProductVariant productVariant) {
        return ResponseEntity.ok(productService.updateVariant(variantId, productVariant));
    }

    @GetMapping("/public/top-selling")
    public ResponseEntity<?> getTopSellingProducts(@RequestParam(defaultValue = "4") int limit) {
        return ResponseEntity.ok(productService.getTopSellingProducts(limit));
    }

//    @GetMapping("/public/category-products/{categoryId}")
//    public ResponseEntity<?> getProductsByCategory(
//            @PathVariable Long categoryId,
//            @RequestParam(defaultValue = "4") int limit) {
//
//        return ResponseEntity.ok(productService.getProductsByCategory(limit, categoryId));
//    }


    @DeleteMapping("/staff/delete-avatar/{id}")
    public ResponseEntity<?> deleteAvatarVariant(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteAvatar(id));
    }

    @PutMapping("/staff/add-avatar/{id}")
    public ResponseEntity<?> addAvatarVariant(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(productService.addAvatar(id, file));
    }

    @DeleteMapping("/staff/delete-other-image/{id}/{fileCode}")
    public ResponseEntity<?> deleteOtherImageVariant(@PathVariable Long id, @PathVariable String fileCode) {
        return ResponseEntity.ok(productService.deleteOtherImage(id, fileCode));
    }

    @PutMapping("/staff/add-other-image/{id}")
    public ResponseEntity<?> addOtherImageVariant(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(productService.addOtherImage(id, file));
    }
}
