import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, forneça os argumentos do tabuleiro.");
            return;
        }

        Tabuleiro tabuleiro = new Tabuleiro(args[0]);
        Scanner scanner = new Scanner(System.in);

        while (!tabuleiro.completo()) {
            tabuleiro.exibir();
            System.out.print("Digite sua jogada (x y valor): ");
            String entrada = scanner.nextLine();
            String[] partes = entrada.trim().split(" ");
            if (partes.length != 3) {
                System.out.println("Formato inválido. Use: x y valor");
                continue;
            }

            try {
                int x = Integer.parseInt(partes[0]);
                int y = Integer.parseInt(partes[1]);
                int valor = Integer.parseInt(partes[2]);

                tabuleiro.jogar(x, y, valor);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }

        tabuleiro.exibir();
        System.out.println("Parabéns! Você completou o Sudoku.");
    }
}
