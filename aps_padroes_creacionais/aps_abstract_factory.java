/* Abstract Factory: Padrão que define a criação de uma interface para cada tipo de produto de uma familia de produtos, seguido da definição de uma outra interface contendo os métodos de criação de todos os produtos dessa familia.
 * 
 * Utilizar quando: - queremos criar objetos/produtos que encaixem num certo tipo/familia mas que sejam essencialmente diferentes entre si.
 * 
 * 
 * Aqui em baixo código é do site, porque tou a fazer isto á pressa e não tenho código do barbosa xd
 */ 

public enum TipoMotor {
	COMBUSTÃO, ELÉTRICO	
}

public interface Veiculo {

	
	
	public String GetMotor();
	public void Show();
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

public class PesadoEletrico implements Veiculo{
	
	@Override
	public String GetMotor() {
		return "Elétrico 250kw 800cv";
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

public class LigeiroEletrico implements Veiculo{
	@Override
	public String GetMotor() {
		return "Elétrico 25kw 100cv";
	}
	
	@Override
	public void Show() {
		System.out.println("Ligeiro : " + this.GetMotor());
	}
}



public abstract class FabricaVeiculosAbstrata {
	abstract Veiculo createVeiculo(TipoVeiculo tipo);
}

public class FabricaVeiculosCombustao extends FabricaVeiculosAbstrata {
	
	@Override
	public Veiculo createVeiculo(TipoVeiculo tipo)
	{
		switch(tipo) {
		case LIGEIRO: return new Ligeiro();
		case PESADO: return new Pesado();
		default: return null;
		}
	}
}

public class FabricaVeiculosEletricos extends FabricaVeiculosAbstrata{
	@Override
	public Veiculo createVeiculo(TipoVeiculo tipo)
	{
		switch(tipo) {
		case LIGEIRO: return new LigeiroEletrico();
		case PESADO: return new PesadoEletrico();
		default: return null;
		}
	}
}



public class ProdutorFabricas {
	public static FabricaVeiculosAbstrata getFabrica(TipoMotor tipo) {
		switch(tipo){
			case COMBUSTÃO: return new FabricaVeiculosCombustao();
			case ELÉTRICO: return new FabricaVeiculosEletricos();
			default: return null;
		}
	}
}

public class DemonstradorAbstractFactory {
	public static void main(String[] args) {
		FabricaVeiculosAbstrata fabrica = ProdutorFabricas.getFabrica(TipoMotor.ELÉTRICO);
		
		Veiculo v = fabrica.createVeiculo(TipoVeiculo.LIGEIRO);
		v.Show();
		fabrica = ProdutorFabricas.getFabrica(TipoMotor.COMBUSTÃO);
		v = fabrica.createVeiculo(TipoVeiculo.PESADO);
		v.Show();
	}
}