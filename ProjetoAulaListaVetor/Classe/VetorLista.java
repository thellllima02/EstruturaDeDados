package ProjetoAulaListaVetor.Classe;

public class VetorLista {
    private Object[] objeto = new Object[100];
    private int totaldeObjetos = 0;
    
    public void adiciona (Object objeto){
        this.garantaEspaco();
        this.objeto[this.totaldeObjetos] = objeto;
        this.totaldeObjetos++;
    }
    public void adiciona (int posicao, Object objeto){
        this.garantaEspaco();
        if(!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição Inválida");
        }
        for(int i = this.totaldeObjetos -1; i >= posicao; i --){
            this.objeto[i+1] = this.objeto[i];
        }
        this.objeto[posicao] = objeto;
        this.totaldeObjetos++;
    }
    public Object pega(int posicao){
       if(!this.posicaoOcupada(posicao)){
           throw new IllegalArgumentException("Posição Inválida");
       } 
       return this.objeto[posicao];     
    }
    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Invalida");
        }
        for(int i = posicao; i < this.totaldeObjetos - 1; i++){
            this.objeto[i] = this.objeto[i+1];
        }
        this.totaldeObjetos--;    
    }
    public boolean contem(Object objeto){
       for(int i = 0; i < this.totaldeObjetos; i++){
           if(objeto.equals(this.objeto[i])){
               return true;
           }
       } 
       return false;
    }
    public int tamanho(){
        return this.totaldeObjetos;
    }
    @Override
    public String toString(){
        if(this.totaldeObjetos == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i = 0; i < this.totaldeObjetos - 1; i++){
            builder.append(this.objeto[i]);
            builder.append(", ");
        }
        builder.append(this.objeto[this.totaldeObjetos - 1]);
        builder.append("]");
        return builder.toString();
    }
    private boolean posicaoOcupada(int posicao){
        return (posicao >=0) && (posicao < this.totaldeObjetos);
    }
    private boolean posicaoValida(int posicao){
        return (posicao >=0) && (posicao <= this.totaldeObjetos);
    }
    public void garantaEspaco(){
        if(this.totaldeObjetos == this.objeto.length){
            Object novaArray[]= new Object[this.objeto.length*2];
            for(int i = 0; i<this.objeto.length; i++){
                novaArray[i]=this.objeto[i];
            }
           this.objeto = novaArray;
        }
    }
    public int tamanhoArray(){
        return objeto.length;
    }
    public void remove(Object objeto){
      int i=0;
      while(i<this.totaldeObjetos){
          if(objeto.equals(this.objeto[i])){
              remove(i);
          }
          else{
              i++;
          }
      }
    }
    public void clear(){
        this.totaldeObjetos = 0;
    }
    public int indexOf(Object objeto){
        for(int i = 0; i < this.totaldeObjetos; i++){
            if(this.objeto[i].equals(objeto)){
                return i; }
           }
        return -1;
    }
    public int lastIndexOf(Object objeto){
        int pos = -1;
        for(int i = 0; i<this.totaldeObjetos; i++){
            if(this.objeto[i].equals(objeto)){
                pos=i;
            }
        }
        return pos;
    }
    public int indexOf(Object objeto, int ocorrencia){
        int pos = -1;
        int quantidadeOcorrencia=0;
        
        for(int i = 0; i < this.totaldeObjetos; i ++){
            if(this.objeto[i].equals(objeto)){
                quantidadeOcorrencia++;
                if(ocorrencia == quantidadeOcorrencia){
                    pos = i;
                }
            }
        }
        return pos;
    }
}
