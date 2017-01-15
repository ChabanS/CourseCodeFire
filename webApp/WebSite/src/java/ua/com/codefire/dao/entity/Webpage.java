/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.dao.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sergey
 */
@Entity
@Table(name = "webpage", catalog = "site", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Webpage.findAll", query = "SELECT w FROM Webpage w"),
    @NamedQuery(name = "Webpage.findById", query = "SELECT w FROM Webpage w WHERE w.id = :id"),
    @NamedQuery(name = "Webpage.findByName", query = "SELECT w FROM Webpage w WHERE w.name = :name"),
    @NamedQuery(name = "Webpage.findByHeader", query = "SELECT w FROM Webpage w WHERE w.header = :header"),
    @NamedQuery(name = "Webpage.findByContent", query = "SELECT w FROM Webpage w WHERE w.content = :content")})
public class Webpage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "header", length = 45)
    private String header;
    @Column(name = "content", length = 45)
    private String content;

    public Webpage() {
    }

    public Webpage(Integer id) {
        this.id = id;
    }

    public Webpage(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Webpage)) {
            return false;
        }
        Webpage other = (Webpage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.codefire.dao.entity.Webpage[ id=" + id + " ]";
    }
    
}
