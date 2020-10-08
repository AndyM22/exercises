package com.greenfox.aliaser.Repository;

import com.greenfox.aliaser.Model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByAlias(String alias);

    boolean existsByAlias(String alias);

}
