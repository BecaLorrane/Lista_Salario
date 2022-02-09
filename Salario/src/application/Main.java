package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Funcionario;

public class Main {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionario> list = new ArrayList<>(); /* lista do tipo funcionario */

		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Emplyoee #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine(); /* Ler dois nomes */
			System.out.print("Salary: ");
			double salario = sc.nextDouble();
			Funcionario func = new Funcionario(id, nome, salario);

			list.add(func);
		}
		System.out.print("Enter the employee id that will have salaty incrase: ");
		int idSalario = sc.nextInt();
		Funcionario func = list.stream().filter(x -> x.getId() == idSalario).findFirst()
				.orElse(null); /*
								 * filtrando a lista somente os funciorarios que tem o id igual ao idSalario e
								 * pega o primeiro,se ele não existir retorna null
								 */
		if(func == null) {
			System.out.println("This id does not exist! ");
		}else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			func.aumento(percent);
		}
		System.out.println();
		System.out.println("List of employess: ");
		for(Funcionario f : list) {
			System.out.println(f);
		}
	}
}
