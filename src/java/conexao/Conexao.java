/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USER
 */
public class Conexao {
    private static Conexao instancia = new Conexao();
    private EntityManagerFactory fabrica;
    
    private Conexao()
    {
        fabrica = Persistence.createEntityManagerFactory("ProjetoPos");
    }

    public static Conexao getInstancia() {
        return instancia;
    }

    public EntityManagerFactory getFabrica() {
        return fabrica;
    }
    
}
