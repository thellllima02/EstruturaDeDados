package ProjetoAulaListaLIgadaCircular.Classe;

public class Aluno {
    private String Nome;
    private int Idade;
    private Aluno proximo;

    public Aluno(String Nome) {
        this.Nome = Nome;
    }

    public Aluno(String Nome, int Idade, Aluno proximo) {
        this.Nome = Nome;
        this.Idade = Idade;
        this.proximo = proximo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public Aluno getProximo() {
        return proximo;
    }

    public void setProximo(Aluno proximo) {
        this.proximo = proximo;
    }
    
    public String toString(){
        return this.Nome;
    }
    
    public boolean equals(Aluno outro){
        return this.Nome.equals(((Aluno)outro).getNome());
        
    }
}
