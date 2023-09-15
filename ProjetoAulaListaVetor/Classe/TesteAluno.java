package ProjetoAulaListaVetor.Classe;

public class TesteAluno {
     public static void main(String[] args) {
        
        //Adicionando na classe Aluno.
        Aluno neo1 = new Aluno("Joao");
        Aluno neo2 = new Aluno("Paulo",20,9.5,"GB202302");
        Aluno neo3 = new Aluno("Gustavo",22,9,"GB202303");
        Aluno neo4 = new Aluno("Josias",25,7.5,"GB202304");
        Aluno neo5 = new Aluno("Fernan",18,5.5,"GB202305");
        Aluno neo6 = new Aluno("Gui");
        
        
        //Direcionando da classe Aluno para a classe VetorAluno
        VetorAluno lista = new VetorAluno();
        lista.adiciona(neo1);
        lista.adiciona(neo2);
        lista.adiciona(neo3);
        lista.adiciona(neo4);
        lista.adiciona(neo5);
        lista.adiciona(neo6);
        
        
        //Outra forma de adicionar, onde posso escolher a posição 
        //lista.adiciona(2, neo6);
                
        //Mostra a informação que esta no indice escolhido 
        //System.out.println(lista.pega(2));
                
        //Forma de remoção 
        //lista.remove(5);
                
        //Forma de saber se tal aluno esta matriculado
        //System.out.println(lista.contem(neo3));
                
        //Para saber a quantidade de alunos matriculados
        //System.out.println(lista.tamanho());
        
        //Para saber o tamanho do vetor
        //System.out.println(lista.tamanhoArray());        
        
        //Formas de saida da lista completa de nomes
        //System.out.println(lista);
        System.out.println(lista.toString());
        
        //Procura o índice da primeira ocorrência de um elemento passado como parâmentro
        //System.out.println(lista.indexOf(neo4));
            
        //Procura o índice da ultima ocorrência de um elemento passado como parâmentro
        System.out.println(lista.lastIndexOf(neo4));
        
        //Deve ser passado o Objeto a ser procurado e o numero da ocorrência do objeto na lista.
        System.out.println(lista.indexOf(neo6, 1));
    }
}
