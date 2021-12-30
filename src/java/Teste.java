
import UseCase.Controller;
import entidades.Livro;


public class Teste {
    public static void main(String[] args) {
        Controller c = new Controller();
        
        for(Livro u: c.find()){
            System.out.println(u.getAvaliacao());
        }
    }
}
