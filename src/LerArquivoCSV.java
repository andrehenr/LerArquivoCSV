import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoCSV {

	public static void main(String[] args) {
		String csvArquivo = "capturaNMW.csv";
		BufferedReader conteudoCSV = null;
		String linha = "";
		String csvSeparadorCampo = ",";
		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
			while ((linha = conteudoCSV.readLine()) != null) {
				String[] sigla = linha.split(csvSeparadorCampo);
				System.out.println("[Gestor "+sigla[0]+"\tPainel: "+sigla[1]+"]");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: \n" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBounds: \n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Erro: \n" + e.getMessage());
		} finally {
			if (conteudoCSV != null) {
				try {
					conteudoCSV.close();
				} catch (IOException e) {
					System.out.println("IO Erro: \n" + e.getMessage());
				}
			}
		}

	}

}
