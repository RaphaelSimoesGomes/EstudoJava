import moldels.Buscar;

import java.io.IOException;
import java.util.Scanner;

public class ConsultarCep {
    public static void main(String[] args) throws IOException, InterruptedException {
        Buscar buscar = new Buscar();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o cep que você deseja procurar\n>>> ");
        String cepDigitado = sc.next();

        cepDigitado = cepDigitado.replace("-", "");

        if (cepDigitado.matches("\\d+") && cepDigitado.length() == 8) {
            System.out.print(buscar.buscarCep(cepDigitado));
        } else {
            System.out.print("Insira um valor valido");
        }


    }
}