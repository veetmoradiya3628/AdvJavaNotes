package onlinestoremanagement.services;

import onlinestoremanagement.entities.Product;

public interface ProductManagementService {
    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);
}
