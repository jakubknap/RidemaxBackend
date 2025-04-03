package pl.knap.shop.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.knap.shop.category.dto.CategoryProductsDto;
import pl.knap.shop.category.repository.CategoryRepository;
import pl.knap.shop.common.dto.ProductListDto;
import pl.knap.shop.common.model.Category;
import pl.knap.shop.common.model.Product;
import pl.knap.shop.common.repository.ProductRepository;

import java.util.List;

import static pl.knap.shop.category.service.mapper.ProductListMapper.getProductListDtos;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CategoryProductsDto getCategoriesWithProducts(String slug, Pageable pageable) {
        Category category = categoryRepository.findBySlug(slug);
        Page<Product> page = productRepository.findAllByCategoryId(category.getId(), pageable);
        List<ProductListDto> productListDtos = getProductListDtos(page);
        return new CategoryProductsDto(category, new PageImpl<>(productListDtos, pageable, page.getTotalElements()));
    }
}