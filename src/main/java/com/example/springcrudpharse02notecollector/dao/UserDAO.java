package com.example.springcrudpharse02notecollector.dao;

import com.example.springcrudpharse02notecollector.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // meken thamai meya dao layer ekk kiyla kiyanne.data patta handle krnwa kiyanne me annotation eken. mekath componant kiyla ek meta annotate wela thmai hadila tiyenne. dao class walata thmai meka danne.dao classes walata kiynwa repository kiyal.
public interface UserDAO extends JpaRepository<UserEntity,String> {
    //jpaRepository - meka generic - apita ona entity type eka supply krnna one mulinma and e enityty eke primery key eke type mkkd kiyala
    //crudRepository dala karannath pluwan. - meka specific wela tiyenne crud operation walata.
}
