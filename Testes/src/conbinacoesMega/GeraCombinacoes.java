package conbinacoesMega;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class GeraCombinacoes {

	static final int SENA = 61;
	static final int NUMCOMBINA = 6;
	static final int QTDCOMBINA = 11;
	//inicio dos numeros randomicos nas sequencias
	//0 para todos
	//1 para n-1, 2 para n-2
	//onde n = NUMCOMBINA
	static final int INICIOCOMBINA = 0;

	public static void main(String[] args) {
		//adicionar os numeros fixos
		//numero minimo deve ser igual a NUMCOMBINA
		ArrayList<int[]> combo = new ArrayList<int[]>();
		int seq[] = {17, 23, 3, 4, 5, 6, 7, 8, 9, 10};
		File arq = new File("C:/Mega.txt");
		

		for( int i = 0; i < QTDCOMBINA; i++){


			//inicio dos numeros randomicos nas sequencias
			//0 para todos

			seq = adicionaNum(seq, NUMCOMBINA, INICIOCOMBINA);
			combo.add(seq.clone());
		}

		for(int x = 0; x < QTDCOMBINA; x++){
			  
	        seq = combo.get(x);
	        try {
				
				PrintStream printString = new PrintStream(new FileOutputStream(arq));
					
			for(int j = 0; j < NUMCOMBINA; j++){

				if (j != NUMCOMBINA - 1){
					printString.print(seq[j]+",");
					//System.out.print(seq[j]+",");
					
				}else{
					printString.print(seq[j]+".\n");
				}
				printString.close();

			}
	        } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private static int[] adicionaNum(int[] seq, int t, int inicio) {
		Random qtd = new Random();

		laco: for(int i = inicio ; i < t; i++){

			int nu = qtd.nextInt(SENA);

			//o primeiro é adicionado se for != de 0
			//após entra no laço para verificar se não se repete
			if(nu != 0 && i != 0){

				for( int j = i-1 ; j >= 0; j--){

					if(nu == seq[j]){				
						i--;
						continue laco;
					}else{
						seq[i] = nu;
					}
				}
			}else{
				if (nu != 0){
					seq[i] = nu;
				}else{
					i--;
				}
			}

		}

		return seq;
	}

}
