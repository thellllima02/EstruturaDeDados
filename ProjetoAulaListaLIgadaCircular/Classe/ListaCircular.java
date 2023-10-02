package ProjetoAulaListaLIgadaCircular.Classe;

public class ListaCircular {
    private Celula primeiro;
    private Celula ultimo;
    private int totalDeElementos;
    public int cont = 0;
    
       
    public ListaCircular(){
        primeiro = null;
        ultimo = null;
        totalDeElementos = 0;
    }
    public int tamanho(){
        return this.totalDeElementos;
    }
    public void adiciona(Object elemento){
        Celula novo = new Celula(elemento);
        if(this.totalDeElementos == 0){
            this.primeiro = novo;
            this.ultimo = novo;
            novo.setProxima(novo);
            novo.setAnterior(novo);
        }
        else{
        novo.setProxima(primeiro);
        primeiro.setAnterior(novo);
        ultimo.setProxima(novo);
        novo.setAnterior(ultimo);
        ultimo = novo;
        }
        this.totalDeElementos++;
    }
    @Override
    public String toString(){
        if(this.totalDeElementos == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeiro;
        //Pecorrendo até o penultimo elemento
        for(int i = 0; i<this.totalDeElementos-1; i++){
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }
    public void remove(){
        if(this.totalDeElementos == 0){
            throw new IllegalArgumentException("Posição Invalida");
        }
        if(this.totalDeElementos == 1){
            primeiro.setProxima(null);
            primeiro.setAnterior(null);
            primeiro = null;
            ultimo = null;
        }
        else{
            Celula penultima = ultimo.getAnterior();
            penultima.setProxima(primeiro);
            primeiro.setAnterior(penultima);
            ultimo = penultima;
        }
        this.totalDeElementos --;
    }
    public void concatena(ListaCircular L2){
        //L1 e L2 estam vazias
        if(this.totalDeElementos == 0 && L2.totalDeElementos == 0 ){
        }
        //L1 está cheio e L2 esta vazia 
        if(this.totalDeElementos > 0 && L2.totalDeElementos == 0 ){
        }
        //L1 esta fazia e L2 está cheia
        else if(this.totalDeElementos == 0 && L2.totalDeElementos > 0 ){
            this.primeiro = L2.primeiro;
            this.ultimo = L2.ultimo;
            this.totalDeElementos = L2.totalDeElementos;
        }
        //A L1 e L2 estão cheios
        else if(this.totalDeElementos > 0 && L2.totalDeElementos > 0 ){
            this.ultimo.setProxima(L2.primeiro);
            L2.primeiro.setAnterior(this.ultimo);
            L2.ultimo.setProxima(this.primeiro);
            this.primeiro.setAnterior(L2.ultimo);
            this.ultimo = L2.ultimo;
            this.totalDeElementos += L2.totalDeElementos;
        }
    }
    public void intercala(ListaCircular L2){
        if(this.totalDeElementos == 0 && L2.totalDeElementos > 0 ){
            this.primeiro = L2.primeiro;
            this.ultimo = L2.ultimo;
            this.totalDeElementos = L2.totalDeElementos;
        }
        else if(this.totalDeElementos > 0 && L2.totalDeElementos > 0 ){
            ListaCircular L3 = new ListaCircular(); //Lista auxiliar
            Celula atual = this.primeiro;
            Celula atual2 = L2.primeiro;
            
            do {    
                L3.adiciona(atual.getElemento());
                L3.adiciona(atual2.getElemento());
                
                atual = atual.getProxima();
                atual2 = atual2.getProxima();
                
            } while (atual != this.primeiro & atual2 != L2.primeiro);
            
            while (atual != this.primeiro){
                    L3.adiciona(atual.getElemento());
                    atual = atual.getProxima();
                }
            while (atual2 != L2.primeiro){
                    L3.adiciona(atual2.getElemento());
                    atual2 = atual2.getProxima();
                }
            
            this.primeiro = L3.primeiro;
            this.ultimo = L3.ultimo;
            this.totalDeElementos = L3.totalDeElementos;
            
            
            
            //pega a primeira de L1 
            //Pega a primeira de L2
            
            //Do while - enquanto nao for a primeira
            //->Adiconar L3 a atual de L1;
            //-> adicionar L3 o atual de L2
            //Pular para proxima de L1 e L2
            
            //Se ainda existe elementos de L1
            //-> Add os elemeentos de L1 em L2 
            
            //Se ainda existe elementos de L2
            //-> Add os elementos de L2 em L1
            
            //Copiar para L1 o elementos de L3
        }
}
    public void intercala2(ListaCircular L2){
        if(this.totalDeElementos == 0 && L2.totalDeElementos > 0 ){
            this.primeiro = L2.primeiro;
            this.ultimo = L2.ultimo;
            this.totalDeElementos = L2.totalDeElementos;
        }
        else if(this.totalDeElementos>0 & L2.totalDeElementos>0){
            Celula Atual = this.primeiro;
            Celula aux1 = this.primeiro;
            Celula aux2 = L2.primeiro;
        
        while(Atual != this.ultimo && Atual != L2.ultimo) {
            aux1 = Atual.getProxima();
            Atual.setProxima(aux2);
            aux1.setAnterior(aux2);
            aux2.setAnterior(Atual);
            Atual = Atual.getProxima();
            
            if(Atual != L2.ultimo){
                aux2 = Atual.getProxima();
                Atual.setProxima(aux1);
                aux2.setAnterior(aux1);
                Atual = Atual.getProxima();
            }
        }
        if(Atual == this.ultimo){
            Atual.setProxima(aux2);
            this.ultimo = L2.ultimo;
        }
        if(Atual == L2.ultimo){
            Atual.setProxima(aux1);
        }
        this.primeiro.setAnterior(this.ultimo);
        this.ultimo.setProxima(primeiro);
        this.totalDeElementos += L2.totalDeElementos;
    }
    }
    public void limpar(){
        this.totalDeElementos = 0;
    }
    public int tamanho2(ListaCircular L2){
        return this.totalDeElementos += L2.totalDeElementos;
    }
    private Celula pegaCelula(int posicao){
        Celula atual = this.primeiro;
        for(int i = 0; i<posicao; i++){
            atual = atual.getProxima();
        }
        return atual;
    }
}
