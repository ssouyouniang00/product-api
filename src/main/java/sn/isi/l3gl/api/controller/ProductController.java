package sn.isi.l3gl.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.domain.Product;
import sn.isi.l3gl.core.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @PutMapping("/{id}")
    public Product updateQuantity(@PathVariable Long id, @RequestParam int quantity) {
        return productService.updateQuantity(id, quantity);
    }

    @GetMapping("/low-stock/count")
    public long countLowStockProducts() {
        return productService.countLowStockProducts();
    }
}
