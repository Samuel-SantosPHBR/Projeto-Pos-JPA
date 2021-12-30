/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UseCase;

import conexao.Conexao;
import entidades.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author USER
 */
public class Controller {
    
    public void criar(Livro l){
        EntityManager en = this.entityManager();
        en.getTransaction().begin();
        Query query = en.createNativeQuery("INSERT INTO `livro` (`id`, `nome`, `descricao`, `status`, `avaliacao`) VALUES (NULL, ?, ?, 'N', '0')");
        query.setParameter(1, l.getNome());
        query.setParameter(2, l.getDescricao());
        query.executeUpdate();
        en.getTransaction().commit();
    }
    
    public void update(Livro l){
        EntityManager en = this.entityManager();
        en.getTransaction().begin();
        Query query = en.createNativeQuery("UPDATE Livro set avaliacao=? where id=?");
        query.setParameter(1, l.getAvaliacao());
        query.setParameter(2, l.getId());
        query.executeUpdate();
        en.getTransaction().commit();
    }
    
    public void updateLido(Livro l){
        EntityManager en = this.entityManager();
        en.getTransaction().begin();
        Query query = en.createNativeQuery("UPDATE Livro set status='S' where id=?");
        query.setParameter(1, l.getId());
        query.executeUpdate();
        en.getTransaction().commit();
    }
    
    public List<Livro> find()
    {
        Query query = this.entityManager().createQuery("SELECT l FROM Livro l order by 1 desc");
        query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
        return query.getResultList();
    }
    
    private EntityManager entityManager(){
        
        return Conexao.getInstancia().getFabrica().createEntityManager();
    }
}
