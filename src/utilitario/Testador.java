package utilitario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.dao.RotaTaxiDAO;
import data.util.Conexao;
import domain.RotaTaxi;

public class Testador {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Conexao conexao = new Conexao();
		LeituraArquivo la = new LeituraArquivo();
		RotaTaxiDAO rtd = new RotaTaxiDAO(conexao);
		ArrayList<RotaTaxi> rotasTaxi = new ArrayList<>();
		
		
		
		/*
		long tempoInicial = System.currentTimeMillis();
		rtd.getOne(10630L);
		long elapsed = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo total em milisegundos consulta latitude "+ elapsed);
		*/
		
		
		long tempoInicial = System.currentTimeMillis();
		// 100k
		//rtd.getLatLon(117.12985, 40.14802);
		// 10k
		rtd.getLatLon(116.78758, 39.77363);
		long elapsed = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo total em milisegundos consulta latitude e longitude "+ elapsed);
		conexao.fecharConexao();
		
		
		/*
		// Obtem todos os arquivos da pasta
		File arquivos[];
		String nomeDiretorio = "D:\\Faculdade\\Banco de Dados II\\Trabalho Prova Oficial\\Arquivos\\10k\\";
		File diretorio = new File(nomeDiretorio);
		arquivos = diretorio.listFiles();
		long tempoInicial = System.currentTimeMillis();
		for(int i = 0; i < arquivos.length; i++){
			
			// Obtem a lista de RotaTaxi gerado atraves dos dados dentro do arquivo
			rotasTaxi = la.readCsvFile(nomeDiretorio + arquivos[i].getName());
			// Salva a lista gerada dentro do banco de dado
			System.out.println(arquivos[i].getName());
			for (RotaTaxi rotaTaxi : rotasTaxi) {
				rtd.save(rotaTaxi);
			}
		}
		
		conexao.fecharConexao();
		
		long elapsed = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo total em milisegundos "+ elapsed);
		*/
	}

}
