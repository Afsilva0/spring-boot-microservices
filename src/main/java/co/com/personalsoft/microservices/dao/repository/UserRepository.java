package co.com.personalsoft.microservices.dao.repository;

import co.com.personalsoft.microservices.dao.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    /* Se puede usar diferentes tipos de implementaciones solo creando el metodo abstracto
       Es necesario usar lenguaje especifico
       https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
     */

    public List<UserEntity> findByAgeLessThan(int age);


    public List<UserEntity> findByNameLike(String name);


    public List<UserEntity> findByNameContaining(String name);


    public List<UserEntity> findByNameAndLastName(String name, String lastName);


    @Query(value = "SELECT * FROM usuarios WHERE age>?1 AND gender=?2", nativeQuery = true)
    public List<UserEntity> findByAgeGreaterThanAndGender(int age, String gender);
}
