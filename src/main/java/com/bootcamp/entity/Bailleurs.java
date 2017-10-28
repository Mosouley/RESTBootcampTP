//Creation d'une ressource representant la liste des ressources bailleurs
package com.bootcamp.entity;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author soul
 */
@XmlRootElement(name = "bailleurs")
public class Bailleurs {

    protected Collection<Bailleur> bailleurs;
    protected List<Link> links;

    @XmlElementRef
    public Collection<Bailleur> getBailleurs() {
        return bailleurs;
    }

    public void setBailleurs(Collection<Bailleur> bailleurs) {
        this.bailleurs = bailleurs;
    }

    @XmlElement(name = "link")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @XmlTransient
    public URI getNext() {
        if (links == null) {
            return null;
        }
        for (Link link : links) {
            if ("next".equals(link.getRel())) {
                return link.getUri();
            }
        }
        return null;
    }

    @XmlTransient
    public URI getPrevious() {
        if (links == null) {
            return null;
        }
        for (Link link : links) {
            if ("previous".equals(link.getRel())) {
                return link.getUri();
            }
        }
        return null;
    }
}

