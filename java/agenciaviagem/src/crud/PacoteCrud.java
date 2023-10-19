package crud;
import java.util.Scanner;
import dao.PacoteDAO;
import modelos.Pacotes;

public class PacoteCrud {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        PacoteDAO pacoteDAO = new PacoteDAO();

        int opcao = 0, id = 0;
        String nome = "";
        double preco = 0, quantidade = 0;

        do {
            System.out.println("\n============================== PACOTES =================================\n");
            System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                	System.out.println("\n Digite o numero do pacote:\n");
                    id = s.nextInt();
                    System.out.println("\nDigite o nome do pacote:\n");
                    nome = s.nextLine();
                    System.out.println("\nDigite a quantidade de pacote:\n");
                    quantidade = s.nextDouble();
                    System.out.println("\nDigite o preço do pacote:\n");
                    preco = s.nextDouble();
                    s.nextLine();

                    Pacotes pacote1 = new Pacotes();

                    pacoteDAO.create(pacote1);
                    break;
                case 2:
                    for (Pacotes p : pacoteDAO.read()) {
                        System.out.println(p.toString());
                    }
                    break;
                case 3:
                    System.out.println("\nDigite o numero do pacote:\n");
                    id = s.nextInt();
                    s.nextLine();
                    System.out.println("\nDigite o nome do pacote:\n");
                    nome = s.nextLine();
                    System.out.println("\nDigite a quantidade de pacote:\n");
                    quantidade = s.nextDouble();
                    System.out.println("\nDigite o preço do pacote:\n");
                    preco = s.nextDouble();
                    s.nextLine();
             

                    Pacotes pacote2 = new Pacotes();

                    pacoteDAO.update(pacote2);
                    break;
                case 4:
                    System.out.println("Digite o numero do pacote:");
                    id = s.nextInt();
                    s.nextLine();

                    pacoteDAO.delete(id);
                    break;
                case 5:
                    System.out.println("Digite numero do pacote:");
                    id = s.nextInt();
                    s.nextLine();

                    Pacotes pacote3 = pacoteDAO.readById(id);

                    System.out.println(pacote3.toString());
                    break;
                default:
                    break;
            }

        } while (opcao != 0);

        System.out.println("Até mais!");
        s.close();
    }
}