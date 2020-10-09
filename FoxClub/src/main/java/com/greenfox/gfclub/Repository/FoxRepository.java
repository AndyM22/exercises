package com.greenfox.gfclub.Repository;

import com.greenfox.gfclub.Model.Fox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoxRepository extends JpaRepository <Fox, Long> {

    Fox findByName(String name);

    boolean existsByName(String foxName);

}
