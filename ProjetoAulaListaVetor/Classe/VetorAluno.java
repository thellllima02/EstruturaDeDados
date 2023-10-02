package ProjetoAulaListaVetor.Classe;

public class VetorAluno {
    private Aluno[] aluno = new Aluno[100];
    private int totalDeAlunos = 0;
    
    public void adiciona (Aluno aluno){
        this.garantaEspaco();
        this.aluno[this.totalDeAlunos] = aluno;
        this.totalDeAlunos++;
    }
    public void adiciona (int posicao, Aluno aluno){
        this.garantaEspaco();
        if(!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        for(int i = this.totalDeAlunos -1; i >= posicao; i --){
            this.aluno[i+1] = this.aluno[i];
        }
        this.aluno[posicao] = aluno;
        this.totalDeAlunos++;
    }
    public Aluno pega(int posicao){
       if(!this.posicaoOcupada(posicao)){
           throw new IllegalArgumentException("Posição Inválida");
       } 
       return this.aluno[posicao];     
    }
    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Invalida");
        }
        for(int i = posicao; i < this.totalDeAlunos - 1; i++){
            this.aluno[i] = this.aluno[i+1];
        }
        this.totalDeAlunos--;    
    }
    public void removerNoFinal(){
        this.aluno[this.totalDeAlunos] = null;
        this.totalDeAlunos --;
     }
    public boolean contem(Aluno aluno){
       for(int i = 0; i < this.totalDeAlunos; i++){
           if(aluno.equals(this.aluno[i])){
               return true;
           }
       } 
       return false;
    }
    public int tamanho(){
        return this.totalDeAlunos;
    }
    @Override
    public String toString(){
        if(this.totalDeAlunos == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < this.totalDeAlunos - 1; i++){
            builder.append(this.aluno[i]);
            builder.append(", ");
        }
        builder.append(this.aluno[this.totalDeAlunos - 1]);
        builder.append("]");
        return builder.toString();
    }
    private boolean posicaoOcupada(int posicao){
        return (posicao >=0) && (posicao < this.totalDeAlunos);
    }
    private boolean posicaoValida(int posicao){
        return (posicao >=0) && (posicao <= this.totalDeAlunos);
    }
    public void garantaEspaco(){
        if(this.totalDeAlunos == this.aluno.length){
            Aluno novaArray[]= new Aluno[this.aluno.length*2];
            for(int i = 0; i<this.aluno.length; i++){
                novaArray[i]=this.aluno[i];
            }
           this.aluno = novaArray;
        }
    }
    public int tamanhoArray(){
        return aluno.length;
    }
    public void remove(Aluno aluno){
      int i=0;
      while(i<this.totalDeAlunos){
          if(aluno.equals(this.aluno[i])){
              remove(i);
          }
          else{
              i++;
          }
      }
    }
    public void clear(){
        this.totalDeAlunos = 0;
    }
    public int indexOf(Aluno aluno){
        for(int i = 0; i < this.totalDeAlunos; i++){
            if(this.aluno[i].equals(aluno)){
                return i; }
           }
        return -1;
    }
    public int lastIndexOf(Aluno aluno){
        int pos = -1;
        for(int i = 0; i<this.totalDeAlunos; i++){
            if(this.aluno[i].equals(aluno)){
                pos=i;
            }
        }
        return pos;
    }
    public int indexOf(Aluno aluno, int ocorrencia){
        int pos = -1;
        int quantidadeOcorrencia=0;
        
        for(int i = 0; i < this.totalDeAlunos; i ++){
            if(this.aluno[i].equals(aluno)){
                quantidadeOcorrencia++;
                if(ocorrencia == quantidadeOcorrencia){
                    pos = i;
                }
            }
        }
        return pos;
    }
    public void intercalação(VetorAluno L2){
        if (this.totalDeAlunos > 0 && L2.totalDeAlunos > 0){
            Aluno novaarray [] = new Aluno [(this.aluno.length + L2.aluno.length)];
            int cont = 0;
            int cont2 = 0;
            for(int i = 0; i <this.totalDeAlunos*2; i=i+2){
                    novaarray[i] = this.aluno[cont++];
             }
            for(int i = 1; i <L2.totalDeAlunos*2; i=i+2){
               novaarray[i] = L2.aluno[cont2++]; 
            }
            this.totalDeAlunos += L2.totalDeAlunos;
            this.aluno = novaarray;
            for(int i=0; i<this.totalDeAlunos; i++){
            if(this.aluno[i] == null){
            this.aluno[i]=this.aluno[i+1];}
            }
        }
        else if(this.totalDeAlunos == 0 & L2.totalDeAlunos >0){
            for(int i = 0; i< L2.totalDeAlunos; i++){
            this.aluno[i] = L2.aluno[i];
            this.totalDeAlunos = L2.totalDeAlunos;
            }
        }
    }
}
