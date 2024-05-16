package org.application;

import org.application.dto.DtoAddress;
import org.application.services.ApiService;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        String cep;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o CEP: ");
        cep = scan.nextLine();
        int option = showMenu();


        try {
            DtoAddress dtoAddress = apiService.getAddress(cep);
            switch (option){
                case 0:
                    System.out.println(dtoAddress);
                    break;
                case 1:
                    System.out.println(dtoAddress.getLogradouro());
                    break;
                case 2:
                    System.out.println(dtoAddress.getBairro());
                    break;
                case 3:
                    System.out.println(dtoAddress.getLocalidade());
                    break;
                case 4:
                    System.out.println(dtoAddress.getUf());
                    break;
                case 5:
                    System.out.println(dtoAddress.getDdd());
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static int showMenu(){
        int option;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Quais informações acerca do CEP deseja mostrar? Digite o numero correspondente.");
        System.out.println("Todas as informações disponíveis - <0>");
        System.out.println("Logradouro - <1>");
        System.out.println("Bairro - <2>");
        System.out.println("Localidade - <3>");
        System.out.println("UF - <4>");
        System.out.println("DDD - <5>");

        option = teclado.nextInt();

        return option;
    }
}
