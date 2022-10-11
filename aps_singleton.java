/*
 * - Padrão de criação que, como o nome indica, garante a instanciação de um único objeto, assim resolvendo o problema de existirem várias instâncias e a difícil gestão destes e o seu uso de recursos
 *
 * 
 * 
 */

class Singleton
{
    private static Singleton obj;
 
    
    private Singleton() {} //Construtor privado para forçar o uso do metodo getInstance
 
    public static Singleton getInstance() //Este método é declarado como estático de forma a permitir que seja chamado sem instanciar a própria classe
    {                                  
        if (obj==null) //Caso não exista referência para um objeto instânciado, é instânciado um novo objeto, caso contrário devolve a referência para o objeto existente 
            obj = new Singleton();
        return obj;
    }s
}


/*   REFS  */
//https://refactoring.guru/design-patterns/singleton