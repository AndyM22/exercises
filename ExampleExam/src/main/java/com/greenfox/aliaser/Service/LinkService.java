package com.greenfox.aliaser.Service;

import com.greenfox.aliaser.Model.Link;

import java.util.List;

public interface LinkService {

    boolean linkExists(String alias);

    Link getLinkByAlias(String alias);

    Link getLinkById (Long id);

    void addLink(Link link);

    void setSecreteCode(Link link);

    void incrementHitCount(Link link);

    List<Link> getAllLinks();

    void deleteLink(Link link);

}
