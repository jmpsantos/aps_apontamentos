/* Protótipo: Padrão que permite a cópia de objetos existentes sem dependência das suas classes
 * 
 * Problemas que resolve: - Ao copiar um objeto não há acesso aos seus atributos privados
 *                        - Objeto copiado fica dependente da classe do objeto inicial
 *                        - No caso de implementação por interface, não temos acesso á classe em concreto
 * 
 *  A solução passa por delegar a função de clonagem para o objeto a ser copiado
 * 
 * Utilizar quando: - o código depender fortemente de código passado por interfaces de terceiros
 * 
 *                  - for necessário reduzir o número de subclasses que pouco diferem em implemntação
 * 
 */




//A classe Shape serve de prototipo base
class Shape{
    private int x;
    private int y;

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    } 
    //Construtor do prototipo
    public Shape(Shape target){
        if(target != null){
            this.x = target.x;
            this.x = target.x;
        }
    }

    //Metodo de clonagem, devolve um objeto clone
    public abstract Shape clone();

    
}

/*Prototipo concreto. O metodo de clonagem chama o construtor desta classe e
 passa o objeto inicial como parâmetro */
public class Circle extends Shape {
    public int radius;

    public Circle() {
    }

    public Circle(Circle target) {
        super(target); //Metodo "super" chama o construtor do parent de forma a clonar os seus atributos privados
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

}

/*Prototipo concreto. O metodo de clonagem chama o construtor desta classe e
 passa o objeto inicial como parâmetro */
public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle() {
    }

    public Rectangle(Rectangle target) {
        super(target); //Metodo "super" chama o construtor do parent de forma a clonar os seus atributos privados
        if (target != null) {
            this.width = target.width;
            this.height = target.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
}

/*https://refactoring.guru/design-patterns/prototype*/
