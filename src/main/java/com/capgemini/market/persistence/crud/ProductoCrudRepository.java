package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//se le pasa la entidad y el tipo de dato del id
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {


    //query nativo diferente al query methods
    //@Query(value="SELECT * FROM productos where id_categoria= ?",nativeQuery = true)
    //query methods:  findBy+(nombre empazando con mayuscula)+(en la clase java id)
  //  List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    //Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);


    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);

}
