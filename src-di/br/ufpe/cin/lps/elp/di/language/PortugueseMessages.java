package br.ufpe.cin.lps.elp.di.language;

public class PortugueseMessages implements Messages {

	public String getSaudation() {
		return "Olá, bem vindo ao calculador de expressões aritméticas.";
	}

	public String getStandardInput() {
		return "Aguardando a entrada de uma expressão a ser calculada";
	}
	
	public String getFileInput() {
		return "Lendo a expressão do arquivo:"; 
	}
	
	public String getFileNotFound1() {
		return "Arquivo"; 
	}
	
	public String getFileNotFound2() {
		return "não encontrado.";
	}
	
	public String getCorrectUse() {
		return "Use o programa da seguinte maneira: \njava ElpParser < arquivo \nOu \njavaElpParser arquivo.";
	}
	
	public String getValidExpression() {
		return "Ok, expressão válida. Calculando...";
	}
	
	public String getInvalidExpression() {
		return "A expressão informada não é válida. \nApenas expressões de adição(+), subtração(-), multiplicação(*) e divisão(/) são aceitas."; 
	}
	
	public String getResult() {
		return "Resultado: ";
	}

}