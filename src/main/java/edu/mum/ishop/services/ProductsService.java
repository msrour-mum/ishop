package edu.mum.ishop.services;

import edu.mum.ishop.dao.UsersDAO;
import edu.mum.ishop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsService {

    private UsersDAO dataAccess;

    public ProductsService() {
        this.dataAccess = new UsersDAO();
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
        List<Product> products = new ArrayList<>();

        return products;
    }

    public List<Product> searchProducts(String search)
    {
        List<Product> products = new ArrayList<>();

        return products;
    }
}
