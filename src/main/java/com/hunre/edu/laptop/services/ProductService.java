package com.hunre.edu.laptop.services;

import com.hunre.edu.laptop.dtos.requests.ProductCreationRequest;
import com.hunre.edu.laptop.dtos.requests.ProductUpdatetion;
import com.hunre.edu.laptop.dtos.responses.ProductResponseAndRelate;
import com.hunre.edu.laptop.dtos.responses.ProductVariantDetailsResponse;
import com.hunre.edu.laptop.dtos.responses.ProductVariantResponse;
import com.hunre.edu.laptop.dtos.responses.ResponseMessage;
import com.hunre.edu.laptop.models.Product;
import com.hunre.edu.laptop.models.ProductVariant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ResponseMessage createProductWithVariants(ProductCreationRequest productCreationRequest);
    ProductVariant getProductVariantById(Long id);
    Page<Product> getProductByKeyword(String keyword, Pageable pageable);
    Page<ProductVariantDetailsResponse> getProductVariantByKeyword(String keyword, Pageable pageable);
    ResponseMessage updateProductStatus(Long id);
    ResponseMessage updateProduct(Long id, ProductUpdatetion product);
    Page<ProductVariantResponse> getAllProductVariants(String keyword, Pageable pageable);
    ProductVariantResponse getProductVariantResponseById(Long id);
    ProductVariantDetailsResponse getProductVariantDetailsResponseById(Long id);
    ProductVariantDetailsResponse getProductVariantDetailsResponseByProductIdAndColorAndSize(Long productId, String color, int size);
    Page<ProductVariantDetailsResponse> getFilteredProducts(int minPrice, int maxPrice, List<Long> brandIds,List<Long> categoryIds, Pageable pageable);
    ProductResponseAndRelate getProductDetailAndRelate(Long id, int size);
    ProductVariantDetailsResponse getProductDetailByColor(String color, Long productId);
    Page<ProductVariantDetailsResponse> getProductVariantsByProductIds(List<Long> productIds, Pageable pageable);
    ResponseMessage deleteProduct(Long id);
    List<ProductVariant> getProductVariantsByProductId(Long productId);
    ResponseMessage deleteVariant(Long id);
    ResponseMessage updateVariant(Long id, ProductVariant productVariant);
    List<ProductVariantDetailsResponse> getTopSellingProducts(int limit);
//    public List<ProductVariantDetailsResponse> getProductsByCategory(int limit, Long categoryId);
    Page<Product> getProductByKeywordAndStatus(String keyword, String status, Pageable pageable);
    List<ProductVariantDetailsResponse> getAllVariantByProductAndColor(Long productId, String color);
    ProductVariant deleteAvatar(Long id);
    ProductVariant addAvatar(Long id, MultipartFile file);
    ProductVariant deleteOtherImage(Long id, String fileCode);
    ProductVariant addOtherImage(Long id, MultipartFile file);
}
