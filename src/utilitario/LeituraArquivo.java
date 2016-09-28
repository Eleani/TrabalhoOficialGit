package utilitario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import data.dao.RotaTaxiDAO;
import domain.RotaTaxi;

public class LeituraArquivo {

	public static String leArquivo(String arquivo) throws FileNotFoundException, IOException {
		File file = new File(arquivo);
		if (!file.exists()) {
			return null;
		}
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		StringBuilder bufSaida = new StringBuilder();
		String linha;
		while ((linha = br.readLine()) != null) {
			bufSaida.append(linha).append("\n");
		}
		br.close();
		return bufSaida.toString();
		// return bufSaida.toString();
	}

	public ArrayList<RotaTaxi> readCsvFile(String arquivo) {

		ArrayList<RotaTaxi> rotasTaxi = new ArrayList<>();
		
		// A estrutura try-catch é usada pois o objeto BufferedWriter exige que
		// as
		// excessões sejam tratadas
		try {

			// Criação de um buffer para a ler de uma stream
			BufferedReader StrR = new BufferedReader(new FileReader(arquivo));

			String Str;
			String[] TableLine;
			String csvDivisor = ",";

			// Essa estrutura do looping while é clássica para ler cada linha
			// do arquivo
			while ((Str = StrR.readLine()) != null) {
				// Aqui usamos o método split que divide a linha lida em um
				// array de String
				// passando como parametro o divisor ";".
				
				String[] pais = Str.split(csvDivisor);
				

				long idTaxi = Long.parseLong(pais[pais.length-4]);
				Timestamp dataHora = Timestamp.valueOf(pais[pais.length-3]);
				double latitude = Double.parseDouble(pais[pais.length-2]);
				double longitude = Double.parseDouble(pais[pais.length-1]);
				
				RotaTaxi rt = new RotaTaxi(idTaxi, dataHora, latitude, longitude);
				rotasTaxi.add(rt);
				
			}
			// Fechamos o buffer
			StrR.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return rotasTaxi;
	}
}
