/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "livro", catalog = "trabalho", schema = "")
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l")})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status", nullable = false, length = 2)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "avaliacao", nullable = false)
    private int avaliacao;

    public Livro() {
    }

    public Livro(Integer id) {
        this.id = id;
    }

    public Livro(Integer id, String nome, String descricao, String status, int avaliacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.avaliacao = avaliacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
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
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "<tr>"
                +"<td>"+this.getId()+"</td>"
                +"<td>"+this.getNome()+"</td>"
                +"<td>"+this.getDescricao()+"</td>"
                +"<td>"+this.getStatus()+"</td>"
                +"<td>"+this.getAvaliacao()+"</td>"
                +"<td><a class='btn btn-primary' href='MarcarLido?id="+this.getId()+"'>Marcar Lido</a> <a class='btn btn-success' href='Avaliar.jsp?id="+this.getId()+"'>Avaliar</a></td>"
                +"</tr>";
    }

    public void setStatus(char c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
