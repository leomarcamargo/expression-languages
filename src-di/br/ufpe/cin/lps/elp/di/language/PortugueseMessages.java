package br.ufpe.cin.lps.elp.di.language;

public class PortugueseMessages implements Messages {

	public String getSaudation() {
		return "Ol�, bem vindo ao calculador de express�es aritm�ticas.";
	}

	public String getStandardInput() {
		return "Aguardando a entrada de uma express�o a ser calculada";
	}
	
	public String getFileInput() {
		return "Lendo a express�o do arquivo:"; 
	}
	
	public String getFileNotFound1() {
		return "Arquivo"; 
	}
	
	public String getFileNotFound2() {
		return "n�o encontrado.";
	}
	
	public String getCorrectUse() {
		return "Use o programa da seguinte maneira: \njava ElpParser < arquivo \nOu \njavaElpParser arquivo.";
	}
	
	public String getValidExpression() {
		return "Ok, express�o v�lida. Calculando...";
	}
	
	public String getInvalidExpression() {
		return "A express�o informada n�o � v�lida. \nApenas express�es de adi��o(+), subtra��o(-), multiplica��o(*) e divis�o(/) s�o aceitas."; 
	}
	
	public String getResult() {
		return "Resultado: ";
	}

}