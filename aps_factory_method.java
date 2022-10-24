/* factory Method: Padrão que implementa a contrução de um objeto através de um método dentro de uma classe criadora/factory base que chama ás classes/factories concretas os métodos de criação do objeto correspondente
 * 
 * Problemas que resolve: - um código muito dependente em condições especificos e infléxivel
 * 
 * Utilizar quando: - uma classe não consegue antecipar que tipo de objeto terá de implementar ou as suas dependências
 * 
 * 
 *                  - queremos poupar o uso de recursos internos reutilizando objetos existentes em vez de os reconstruir a cada vez
 * 
 * 
 *
 */ 

public interface Veiculo {

	
	
	public String GetMotor();
	public void Show();
}

public enum TipoVeiculo {
	LIGEIRO, PESADO
}


public class Pesado implements Veiculo{
	
	@Override
	public String GetMotor() {
		return "DIESEL 4000CC 300cv";
	}
	
	@Override
	public void Show() {
		System.out.println("Pesado : " + this.GetMotor());
	}
}



public class Ligeiro implements Veiculo{

	@Override
	public String GetMotor() {
		return "Gasolina 2000CC 130cv";
	}
	
	@Override
	public void Show() {
		System.out.println("Ligeiro : " + this.GetMotor());
	}
}


public class FabricaVeiculos {
	public Veiculo createVeiculo(TipoVeiculo tipo)
	{
		switch(tipo) {
		case LIGEIRO: return new Ligeiro();
		case PESADO: return new Pesado();
		default: return null;
		}
	}
}

public class DemonstrarFactory {
	public static void main(String[] args) {
		FabricaVeiculos fabrica = new FabricaVeiculos();
		Veiculo v1 = fabrica.createVeiculo(TipoVeiculo.LIGEIRO);
		v1 = fabrica.createVeiculo(TipoVeiculo.PESADO);
		v1.Show();
	}
}
