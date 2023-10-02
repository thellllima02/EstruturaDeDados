package ProjetoAulaListaLIgadaCircular.Classe;

public class TesteCircular {
    public static void main(String[] args) {
        Aluno neo1 = new Aluno("João 1");
        Aluno neo2 = new Aluno("Mario 3");
        Aluno neo3 = new Aluno("Pedro 5");
        Aluno neo4 = new Aluno("Gusta 7");
        Aluno neo5 = new Aluno("João 2");
        Aluno neo6 = new Aluno("Mario 4");
        Aluno neo7 = new Aluno("Pedro 6");
        Aluno neo8 = new Aluno("Gusta 8");
        
        
        ListaCircular lista = new ListaCircular();
        lista.adiciona(neo1);
        lista.adiciona(neo2);
        lista.adiciona(neo3);
        lista.adiciona(neo4);
        
        ListaCircular lista2 = new ListaCircular();
        lista2.adiciona(neo5);
        lista2.adiciona(neo6);
        lista2.adiciona(neo7);
        lista2.adiciona(neo8);
        
        
        
        ListaCircular lista3 = new ListaCircular();
        //lista.concatena(lista2);
        //lista.limpar();
        //lista.tamanho2(lista2);
        System.out.println(lista.toString());
        System.out.println(lista2.toString());
        System.out.println(lista3.toString());
        
        //lista.intercala(lista2, lista3);
        
        System.out.println(lista.toString());
        System.out.println(lista3.toString());
        System.out.println("O for rodou = "+lista.cont);
    }
}
