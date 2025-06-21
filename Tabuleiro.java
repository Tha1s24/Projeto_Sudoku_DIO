public class Tabuleiro {
    private final Celula[][] grid = new Celula[9][9];

    public Tabuleiro(String argumentos) {
        // Inicializa com células vazias
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                grid[y][x] = new Celula(0, false);
            }
        }

        String[] items = argumentos.split(" ");
        for (String item : items) {
            String[] parts = item.split(";");
            String[] pos = parts[0].split(",");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            int valor = Integer.parseInt(parts[1]);
            boolean fixa = Boolean.parseBoolean(parts[2]);
            grid[y][x] = new Celula(valor, fixa);
        }
    }

    public boolean jogar(int x, int y, int valor) {
        if (x < 0 || x >= 9 || y < 0 || y >= 9 || valor < 1 || valor > 9) {
            System.out.println("Jogada inválida.");
            return false;
        }

        Celula cel = grid[y][x];
        if (cel.isFixa()) {
            System.out.println("Essa célula não pode ser alterada.");
            return false;
        }

        if (!validaJogada(x, y, valor)) {
            System.out.println("Jogada viola regras do Sudoku.");
            return false;
        }

        cel.setValor(valor);
        return true;
    }

    public boolean validaJogada(int x, int y, int valor) {
        // Verifica linha e coluna
        for (int i = 0; i < 9; i++) {
            if (grid[y][i].getValor() == valor || grid[i][x].getValor() == valor) {
                return false;
            }
        }

        // Verifica bloco 3x3
        int blocoX = (x / 3) * 3;
        int blocoY = (y / 3) * 3;
        for (int i = blocoY; i < blocoY + 3; i++) {
            for (int j = blocoX; j < blocoX + 3; j++) {
                if (grid[i][j].getValor() == valor) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean completo() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (grid[y][x].getValor() == 0) return false;
            }
        }
        return true;
    }

    public void exibir() {
        System.out.println("    0 1 2   3 4 5   6 7 8");
        for (int y = 0; y < 9; y++) {
            if (y % 3 == 0) System.out.println("  +-------+-------+-------+");
            System.out.print(y + " | ");
            for (int x = 0; x < 9; x++) {
                System.out.print(grid[y][x] + " ");
                if ((x + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println("  +-------+-------+-------+");
    }
}
