package ProjetoAulaListaLigada.Classe;

public class Celula {

    //Essa classe ela vai auxiliar a organizar a lista, pois ela vai indicar que é o 
    //proximo e quem sera o anterior.

    private Celula proxima;
    private Celula anterior;
    private Object elemento;
    
    public Celula(Celula proxima, Object elemento){
        this.proxima = proxima;
        this.elemento = elemento;
    }
    public Celula(Object elemento){
        this.elemento = elemento;
    }
    public Object getElemento(){
        return elemento;
    }
    public void setProxima(Celula proxima){
       this.proxima = proxima;
    }
    public Celula getProxima(){
        return proxima;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
    public Celula getAnterior() {
        return anterior;
    }
    
}
