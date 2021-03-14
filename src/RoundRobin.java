// CPU = Caixa
// Pessoas na fila = processo
// Conta = tempo

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoundRobin {
    public static Integer quantum;
    public static Integer totalProcessos;
    public static List<Integer> processos = new ArrayList<>();
    public static List<Integer> nProcessos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(":::: ROUND ROBIN ::::");
        System.out.print("Digite o número máximo de tempo que pode ser gasto na CPU: ");
        quantum = in.nextInt();
        System.out.print("Digite o número de processos: ");
        totalProcessos = in.nextInt();
        System.out.println(" ");
        tempo();
        fila();
        System.out.println(":::: EXIT ::::");
        in.close();
    }
    static void tempo() {
        Scanner in = new Scanner(System.in);
        for (Integer i = 1; i <= totalProcessos; i++) {
            System.out.print("Digite o tempo que o processo "+ i + " vai levar: ");
            Integer numero = in.nextInt();
            processos.add(numero);
            nProcessos.add(i);
        }
        in.close();
        System.out.println(" ");
    }
    static void fila() {
        int i = 0;
        do {
            if (processos.get(i) <= quantum) {
                System.out.println("Processo " + nProcessos.get(i) + " executado e concluido em " + processos.get(i) + "ms");
                processos.remove(i);
                nProcessos.remove(i);
                continue;
            } else {
                Integer total = processos.get(i) - quantum;
                if (total > 0) {
                    System.out.println("Processo " + nProcessos.get(i) + " executado porém resta: " + total + "ms");
                    processos.remove(0);
                    processos.add(total);
                    nProcessos.add(nProcessos.get(i));
                    nProcessos.remove(i);
                }
            }
        } while (processos.size() != i);

        System.out.println(" ");
        System.out.println("Todos os processos foram executados!");
    }
}
