package ProjetoAulaListaVetor.Classe;

public class VetorLista {
    private Object[] objeto = new Object[100];
    private int totaldeObjetos = 0;
    
    
    public void adiciona (Object objeto){
        /*Esse metodo ele pega o vetor e a quantidade de objetos que vao
    receber o objeto que vai ser adicionado.
    E soma mais um na variavel que esta calculando a quantidade de 
    objetos.
    */
        this.garantaEspaco();
        this.objeto[this.totaldeObjetos] = objeto;
        this.totaldeObjetos++;
    }
    public void adiciona (int posicao, Object objeto){
        /*A diferença desse metodo para o anterior é que aqui voce pode 
        escolher em qual indice sera adicionado o objeto.
        Prmeiro vc tem que arrumar os indices maiores do que a posicão que vai 
        receber o objeto para não perde a informação/dado que tem no indice 
        desejado.
        */
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
        /*Esse metodo voce consegue acessar o indice pela sua posição
        */
       if(!this.posicaoOcupada(posicao)){
           throw new IllegalArgumentException("Posição Inválida");
       } 
       return this.objeto[posicao];     
    }
    public void remove(int posicao){
        /*Esse metodo realiza a exclusao do objeto e realiza sua realocação
        dos demais.
        Dentro do laço de repetição ocorre: O indice escolhido para ser 
        retirado vai receber o objetos que estão a sua frente
        Pois não excluimos apenas gravamos por cima
        */
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Invalida");
        }
        for(int i = posicao; i < this.totaldeObjetos - 1; i++){
            this.objeto[i] = this.objeto[i+1];
        }
        this.totaldeObjetos--;    
    }
    public boolean contem(Object objeto){
        /*Um laço para pecorrer o vetor que vai ate o total de objeto e 
        procura por um objeto igual ao passado. Nesse metodo ele olha o 
        conteudo  
        */
       for(int i = 0; i < this.totaldeObjetos; i++){
           if(objeto.equals(this.objeto[i])){
               return true;
           }
       } 
       return false;
    }
    public int tamanho(){
        /*Ele passa o tamanho de objetos cadastrados
        */
        return this.totaldeObjetos;
    }
    @Override
    public String toString(){
        /*Primeiramente a classe tem que ter um metodo toString para que ocorra
        tudo certo.
        Tem que se criar uma classe Stringbuilder e usar o append da propria 
        classe.
        Um for para pecorrer o vetor e adicionando ", " para que fique 
        organizado
        por ultimo deve retornar o toString
        */
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
        /*Metodo para a validação
        Ela deve ser maior que 0 e menor o total de objetos cadastrados*/
        return (posicao >=0) && (posicao < this.totaldeObjetos);
    }
    private boolean posicaoValida(int posicao){
        /*Metodo para a validação
        Ela deve ser maior que 0 e menor ou igual a total de objetos 
        cadastrados*/
        return (posicao >=0) && (posicao <= this.totaldeObjetos);
    }
    public void garantaEspaco(){
        /*Uma solução para que o vetor sempre tenha espaço 
        ele simplismente cria ou vetor com o dobro de tamanho do primeiro
        e passa os dados para o novo vetor. Pois não conseguimos mudar o 
        tamanho do vetor.
        */
        if(this.totaldeObjetos == this.objeto.length){
            Object novaArray[]= new Object[this.objeto.length*2];
            for(int i = 0; i<this.objeto.length; i++){
                novaArray[i]=this.objeto[i];
            }
           this.objeto = novaArray;
        }
    }
    public int tamanhoArray(){
        /*Ele retorna o tamanho do vetor que esta sendo usado*/
        return objeto.length;
    }
    public void remove(Object objeto){
        /*Um metodo que faz a comparação e exclusao do que esta dentro do vetor
        Ele apaga todos os objetos igual ao que foi passado como parâmetro
        */
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
        /*Um metodo tecnicamente parecido com o metodo de contem a diferença é 
        que aqui retornamos o valor do indice
        */
        for(int i = 0; i < this.totaldeObjetos; i++){
            if(this.objeto[i].equals(objeto)){
                return i; }
           }
        return -1;
    }
    public int lastIndexOf(Object objeto){
        /*
        */
        int pos = -1;
        for(int i = 0; i<this.totaldeObjetos; i++){
            if(this.objeto[i].equals(objeto)){
                pos=i;
            }
        }
        return pos;
    }
    public int indexOf(Object objeto, int ocorrencia){
        /*Retorna o indice da ocorrencia que foi passada.
        */
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
