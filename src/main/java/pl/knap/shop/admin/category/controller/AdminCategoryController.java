package pl.knap.shop.admin.category.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.knap.shop.admin.category.controller.dto.AdminCategoryDto;
import pl.knap.shop.admin.category.model.AdminCategory;
import pl.knap.shop.admin.category.service.AdminCategoryService;

import java.util.List;

import static pl.knap.shop.admin.category.controller.mapper.AdminCategoryMapper.mapToAdminCategory;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    public static final Long EMPTY_ID = null;
    private final AdminCategoryService categoryService;

    @GetMapping
    public List<AdminCategory> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public AdminCategory getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public AdminCategory createCategory(@RequestBody @Valid AdminCategoryDto adminCategoryDto) {
        return categoryService.createCategory(mapToAdminCategory(adminCategoryDto, EMPTY_ID));
    }

    @PutMapping("/{id}")
    public AdminCategory updateCategory(@PathVariable Long id, @RequestBody @Valid AdminCategoryDto adminCategoryDto) {
        return categoryService.updateCategory(mapToAdminCategory(adminCategoryDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}