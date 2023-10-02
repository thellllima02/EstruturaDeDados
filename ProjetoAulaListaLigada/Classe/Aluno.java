package ProjetoAulaListaLigada.Classe;


public class Aluno {
    
    private String Nome;
    private int Idade;
    private double Nota;
    private String Turma;

    public Aluno(String Nome) {
        this.Nome = Nome;
    }

    public Aluno(String Nome, int Idade, double Nota, String Turma) {
        this.Nome = Nome;
        this.Idade = Idade;
        this.Nota = Nota;
        this.Turma = Turma;
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

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    public String getTurma() {
        return Turma;
    }

    public void setTurma(String Turma) {
        this.Turma = Turma;
    }
    
    @Override
    public String toString (){
        return this.getNome() ;
    }
    //Existe essa diferença do ListaVetor e ListaLigada.
    public boolean equals(Aluno outro){
        return this.Nome.equals(((Aluno)outro).getNome());
        
    }
}
