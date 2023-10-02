package ProjetoAulaListaLigada.Classe;

public class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos = 0;
    
    public void adicionaNoComeco(Object elemento){
        //Aqui sempre vai adicionar no inicil, tanto faz esta cheia ou vazia.
        //Quando a lista estiver vazia e ele declara que a primeira e a
        //ultima são os valores da nova
        if(this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        }
        else{
            //Cria uma nova celula
            Celula nova = new Celula(this.primeira, elemento);
            //Para mudar o valor da primeira é preciso setar um valor
            //Que sera a o valor da nova
            this.primeira.setAnterior(nova);
            //Depois ela vai receber o valor da nova.
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }
    public void adiciona(Object elemento){
        //Quando estiver fazio a lista, ja existe um metodo para isso
        if(this.totalDeElementos == 0){
            this.adicionaNoComeco(elemento);
        }
        else{
            //Cria uma nova celula 
            Celula nova = new Celula(elemento);
            //A ultima celula vai apontar para quem vai ser a proxima que sera
            //a nova celua
            this.ultima.setProxima(nova);
            //A nova vai apontar para quem é a sua anterior que era a ultima
            nova.setAnterior(this.ultima);
            //A nova agora sera a ultima 
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }
    public void adiciona(int posicao, Object elemento){
    if(posicao == 0){
        this.adicionaNoComeco(elemento);
    }
    //Metodo ja existe, pois si por coincidência o local ja for o ultimo.
    else if(posicao == this.totalDeElementos){
        this.adiciona(elemento);
    }
    else {
        //Preciso saber quem é a sua anterio e sua proxima
        //Por isso tem esses dois comandos aqui 
        //A anterior sera uma antes da proxima
        //Achar quem sera a anterior
        Celula anterior = this.pegaCelula(posicao -1);
        //A proxima vai receber o valor da anterior
        Celula proxima = anterior.getProxima();
        
        //Cria se uma nova celula passando o local e o elemento
        Celula nova = new Celula(anterior.getProxima(), elemento);
        
        //A nova celula aponta para a sua anterior 
        nova.setAnterior(anterior);
        //A celula anterior esta apontando para a nova celula
        anterior.setProxima(nova);
        //proxima esta apontando para a nova celula 
        proxima.setAnterior(nova);
        this.totalDeElementos++;
    }
    }
    public Object pega(int posicao){
        return this.pegaCelula(posicao).getElemento();
    }
    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Invalida");
        }
        if(posicao == 0){
            this.removeDoComeco();
        }
        else if(posicao == this.totalDeElementos-1){
            this.removeDoFim();
        }
        else{
            Celula anterior = this.pegaCelula(posicao-1);
            //A atual esta passando quem é a sua anterior para a proxima
            Celula atual = anterior.getProxima();
            //A proxima esta recebendo quem é a anterior da anterior
            Celula proxima = atual.getProxima();
            
            //A anterior esta setando 
            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            
            this.totalDeElementos --;
        }
    }
    public int tamanho(){
        return this.totalDeElementos;
    }
    public void limpaLista(){
        this.primeira = null;
        this.ultima = null;
        this.totalDeElementos = 0;
    }
    public boolean contem(Object elemento){
        Celula atual = this.primeira;
        while(atual !=null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }
    public void removeDoComeco(){
        if(!this.posicaoOcupada(0)){
            throw new IllegalArgumentException("Posição não existe");
        }
        this.primeira = this.primeira.getProxima();
        if(primeira!=null)//Se ainda não existe celula
            this.primeira.setAnterior(null);
        this.totalDeElementos--;
        if(this.totalDeElementos == 0){
            this.ultima = null;
        }
    }
    public void removeDoFim(){
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        }else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }
    public String toString(){
        //Verificando se a lista esta vazia
        if(this.totalDeElementos == 0 ){
            return "[]";
        }
        //Cria se uma clase StringBuilder é passa o primeiro paramentro
        StringBuilder builder = new StringBuilder("[");
        //Cria se um Celula e indica quem é a primeira 
        Celula atual = primeira;
        //Pecorrendo ate o penúltimo elemento.
        for(int i=0; i<this.totalDeElementos-1; i++){
            //a atual esta mostrando o conteudo da celula 
            builder.append(atual.getElemento());
            builder.append(", ");
            //Atual esta mostrando quem é a sua proxima.
            atual = atual.getProxima();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }
    private boolean posicaoOcupada(int posicao){
        return (posicao>=0)&&(posicao<=this.totalDeElementos);
    }
    private Celula pegaCelula(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Invalidade");
        }
        //Criase uma variavel do tipo celula, ela vai saber que é a primeira 
        //e pecorrer ate a posicao desejada e ela vai saber é a proxima da 
        //posicao de lhe foi passada
        Celula atual = this.primeira;
        //O vetor esta pecorrendo ate a posicão passada.
        for(int i = 0; i < posicao; i++){
            //atual esta pegando o valor de quem é a sua proxima. 
            atual = atual.getProxima();
        }
       //retorno o valor encontrado 
        return atual;
    }
    
}
