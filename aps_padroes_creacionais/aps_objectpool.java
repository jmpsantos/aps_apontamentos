/* Object Pool: Padrão que permite o armazenamento de instâncias de uma classe. Quando um processo deixa de utilizar um objeto, este devolve o objeto á pool 
                para que seja aramazenado e reutilizado mais tarde. Caso não existam objetos suficientes a pool pode instanciar novos objetos, da mesma forma 
                que pode limpar objetos inutilizados em excesso.
 * 
 * Problemas que resolve: - Performance: Ao controlar e facilitar a reutilização de objetos, estamos a 
 *                          melhorar o performance do código poupando memória e tempo de execução gastos
 *                          na instanciação e limpeza de objetos. 
 *      
 * 
 * Nota: - É recomendado que todos os objetos não utilizados sejam guardados na mesma pool, para facilitar a sua gestão
 * 
 */


public abstract class Pool <T> {  //Classe abstrata genérica de uma pool 
    private int size;
    
    protected BlockingQueue objetos; //BlockingQueue é basicamente um array automatizado pelo Java
    
    public Pool(int size){
        this.size = size;
        inicializar();
    }
    
    private void inicializar(){    //Conforme o tamanho escolhido para a pool, iniciamos as instâncias
        objetos = new LinkedBlockingQueue<T>(this.size);
        for(int i = 0; i < size; i++){
            addObj();
        }
    }
    
    public abstract void addObj();
    
    public abstract T get();
    
    public abstract void release(T objetos);
}

public class Impressora {
    private String nome;

    public Impressora(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void Imprimir(String texto){
        System.out.println("Impressora " + nome + ":" + texto);
    }

    @Override
    public String toString() {
        return "Impressora{" + this.hashCode() + '}';
    }
    
    
}



public class PoolImpressoras extends Pool<Impressora>{

    public PoolImpressoras(int size) {
        super(size);
    }

    @Override
    public void addObj() {  //Adicionamos objeto á pool 
        this.objetos.add(new Impressora("HP Laserjet"));
    }

    @Override
    public Impressora get() {  //Retiramos objeto da pool para uso
        try{
           Impressora imp = (Impressora) this.objetos.take();

        } catch(InterruptedException ex){
            Logger.getLogger(PoolImpressoras.class.getName().log(Level.SEVERE));
        }
        return imp;
    }

    @Override
    public void release(Impressora objeto) { //Devolvemos objeto á pool
        if(objeto == null){
            throw new NullPointerException("Referência para impressora a nulo");
        }
        Boolean res = this.objetos.offer(objeto);
        if(res == false){
            System.out.println("Pool cheia???");
        }
        
    }
    
    public void ListaImpressoras(){  //Imprime todas as instâncias presentes na pool
        System.out.println("IMPRESSORAS:");
        for(Impressora imp : this.objetos){
            System.out.println("\t\t" + imp);
        }
    }
    
}

/*   REFS  */
 /*https://sourcemaking.com/design_patterns/object_pool - No enanto utilizei o ex4 como exemplo pois parece mais simples e claro*/ 