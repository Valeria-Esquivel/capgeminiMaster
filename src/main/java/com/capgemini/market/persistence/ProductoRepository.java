package com.capgemini.market.persistence;

import com.capgemini.market.domain.repository.ProductRepository;
import com.capgemini.market.domain.service.Product;
import com.capgemini.market.persistence.crud.ProductoCrudRepository;
import com.capgemini.market.persistence.entity.Producto;
import com.capgemini.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {

    //le dice a spring que se encarge de estas instancias para que las inicialice
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;



    public List<Product> getAll(){
        //se hace un casteo de iterable a lista
        List<Producto> productosList = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productosList);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        //return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScaaseProducts(int quantity, boolean active) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,active);
        return productos.map(prods -> mapper.toProducts(prods));
    }



    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }



    /*public Optional<List<Product>> getEscasos(int quantity,boolean active){
      //  return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,estado);
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,active);
        return productos.map(prods -> mapper.toProducts(prods));

    }*/

    /*public Optional<Product> getProducto(int idProduct){
        //return productoCrudRepository.findById(idProducto);
        //el findById ya regresa u n optional por lo cual no necesita uno
        return productoCrudRepository.findById(idProduct).map(producto -> mapper.toProduct(producto));
    }*/
    //metodos para guardar y eliminar un producto
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}
