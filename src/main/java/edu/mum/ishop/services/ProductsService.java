package edu.mum.ishop.services;

import edu.mum.ishop.dao.DataAccessManager;
import edu.mum.ishop.dao.UsersDAO;
import edu.mum.ishop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsService {

    private DataAccessManager dataAccess;

    public ProductsService() {
        this.dataAccess = new DataAccessManager();
    }

    public List<Product> getProducts(String search)
    {
        List<Product> products;

        if(search != "")
        {
            products = searchProducts(search);
        }
        else
        {
            products = getAllProducts();
        }

        return products;
    }
    public List<Product> getAllProducts()
    {
        List<Product> products = dataAccess.Product_SelectAll();
        return products;
    }
    public Product getProduct(int id)
    {
        Product product = dataAccess.Product_SelectOne(id);
        return product;
    }

    public List<Product> searchProducts(String search)
    {
        List<Product> products = dataAccess.Product_SelectAll();
        return products;
    }
}
