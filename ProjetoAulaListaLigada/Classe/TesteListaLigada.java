package ProjetoAulaListaLigada.Classe;

public class TesteListaLigada {
    public static void main(String[] args) {
        Aluno neo1 = new Aluno("Joao");
        Aluno neo2 = new Aluno("Pedro");
        Aluno neo3 = new Aluno("Fernando");
        Aluno neo4 = new Aluno("Paulo");
        Aluno neo5 = new Aluno("Jonas");
        Aluno neo6 = new Aluno("Gusta");
        Aluno neo7 = new Aluno("Gui");
        Aluno neo8 = new Aluno("Loro José");
        
        ListaLigada lista = new ListaLigada();     
        lista.adiciona(neo1);
        lista.adiciona(neo2);
        lista.adiciona(neo3);
        lista.adiciona(neo4);
        lista.adiciona(neo5);
        lista.adiciona(neo6);
        lista.adiciona(neo7);
        lista.adiciona(neo8);
        
        //lista.remove(7);
        //lista.removeDoFim();
        lista.limpaLista();
        lista.removeDoComeco();
        
        
        System.out.println(lista.toString());
        //System.out.println(lista.pega(6));
        System.out.println(lista.tamanho());
       
        

    }
}
