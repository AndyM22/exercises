package com.greenfox.aliaser.Service;

import com.greenfox.aliaser.Model.Link;
import com.greenfox.aliaser.Repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LinkServiceImpl implements LinkService {

    private LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public boolean linkExists(String alias) {
        return this.linkRepository.existsByAlias(alias);
    }

    @Override
    public Link getLinkByAlias(String alias) {
        return this.linkRepository.findByAlias(alias);
    }

    @Override
    public Link getLinkById(Long id) {
        return this.linkRepository.findById(id).get();
    }

    @Override
    public void addLink(Link link) {
        this.linkRepository.save(link);
    }

    @Override
    public void setSecreteCode(Link link) {
        Random random = new Random();
        /*int number = random.nextInt((9999 - 100) + 1) + 10;*/
        String secretCode = String.format("%04d", random.nextInt(10000));
        link.setSecretCode(secretCode);
    }

    @Override
    public void incrementHitCount(Link link) {
        link.setHitCount(link.getHitCount() + 1);
        this.linkRepository.save(link);
    }

    @Override
    public List<Link> getAllLinks() {
        return this.linkRepository.findAll();
    }

    @Override
    public void deleteLink(Link link) {
        this.linkRepository.delete(link);
    }

}
