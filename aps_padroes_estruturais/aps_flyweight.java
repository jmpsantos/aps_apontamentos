/*Flyweight: Padrão de software que permite agregar partes reutilizáveis/estáticas de código de forma a poupar memória 
             permitindo que o estado de um objeto seja partilhado entre múltiplos objetos, no entanto este approach complica o código.
             Para o implementar basta separamos o estado extrínseco/único do estado intrínseco/comum, colocando o segundo num objeto flyweight
             Neste caso, TreeType será a classe flyweight onde ficam guardadas as informações de cada tipo de árvore nos seus objetos, esta informação é estática.
             Cada objeto TreeType será utilizado como atributo pelos objetos Tree os quais apenas contêm em si as suas coordenadas indo buscar a restante 
             informação ao objeto correspondente ao tipo de árvore (TreeType), assim ao criar imensos objetos árvore não estamos a definir exaustivamente a informação 
             relacionada com a sua espécie para cada objeto poupando quantidades enormes de memória. É commum uma factory controlar a pool de flyweights (TreeFactory).
 * 
 * 
 * 
 * 
 * 

 */

 //Guarda toda a informação intrínseca de uma espécie/tipo
public class TreeType {
    private String name;
    private Color color;
    private String otherTreeData;

    public TreeType(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}

//Cria e mantém pool de Flyweights
public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}

//Árvore, contém em si as suas coordenadas e tem a sí associada uma espécie/tipo
public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}

 /*https://refactoring.guru/design-patterns/flyweight/java/example */