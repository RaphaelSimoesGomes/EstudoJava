
import moldels.ConsultaCep;
import moldels.Endereco;
import moldels.GeradorDeArquivo;


import java.util.Scanner;

public class CodigoPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu CEP:\n>>> ");
        String cep = sc.nextLine();

        ConsultaCep consultaCep = new ConsultaCep();
        consultaCep.setCep(cep);

        Endereco endereco = consultaCep.buscaEndereco(cep);

        System.out.println(endereco);
        System.out.print(consultaCep.toString());

        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
        try {
        geradorDeArquivo.salvarJson(endereco);

        }catch (Exception e) {
            System.out.println(e);
            System.out.println("Finalizando");
        }


    }

}