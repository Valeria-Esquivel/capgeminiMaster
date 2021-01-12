package com.capgemini.market.domain.service;

import com.capgemini.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

//logica de negocio
@Service
public class ProductService {

    //inicializa el productRepository
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productRepository.getAll();
    }


    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int catgoryId){
        return  productRepository.getByCategory(catgoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
        //otra forma de hacerlo sin landas
        /*
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else{
            return false;
        }*/
    }
}
