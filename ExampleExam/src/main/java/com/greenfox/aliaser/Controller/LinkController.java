package com.greenfox.aliaser.Controller;

import com.greenfox.aliaser.Dto.LinkDto;
import com.greenfox.aliaser.Model.Link;
import com.greenfox.aliaser.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping({"/", "/{alias}"})
    public String mainPage(Model model, @PathVariable(required = false) String alias) {
        Link link = this.linkService.getLinkByAlias(alias);
        model.addAttribute("newLink", new Link());
        if (link != null) {
            model.addAttribute("alias", link.getAlias());
            model.addAttribute("secretCode", link.getSecretCode());
        }
        return "index";
    }

    @PostMapping("/save-link")
    public String submitLinkForm(@ModelAttribute Link link) {
        if (this.linkService.linkExists(link.getAlias())) {
            return "redirect:/?aliasInUse";
        } else {
            this.linkService.setSecreteCode(link);
            this.linkService.addLink(link);
            return "redirect:/" + link.getAlias() + "/?success";
        }
    }

    @GetMapping("/a/{alias}")
    public String incrementHitCount(@PathVariable String alias) {
        Link link = this.linkService.getLinkByAlias(alias);
        if (link == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alias does not exist.");
        } else {
            this.linkService.incrementHitCount(link);
            return "redirect:" + link.getUrl();
        }
    }

    @GetMapping("/api/links")
    @ResponseBody
    public List<Link> getLinks () {
        return this.linkService.getAllLinks();
    }

    @DeleteMapping("/api/links/{id}")
    @ResponseBody
    public ResponseEntity deleteLink(@PathVariable Long id, @RequestBody LinkDto linkDto) {
        Link link = this.linkService.getLinkById(id);
        if (link == null) {
            return ResponseEntity.notFound().build();
        } else if (linkDto == null) {
            return ResponseEntity.badRequest().build();
        } else if (!linkDto.getSecretCode().equals(link.getSecretCode())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else {
            this.linkService.deleteLink(link);
            return ResponseEntity.noContent().build();
        }
    }

}
