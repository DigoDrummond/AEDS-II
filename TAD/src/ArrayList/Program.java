package ArrayList;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.println("How many employees will be registered? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("\nID: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.println("NAME: ");
			String name = sc.nextLine();
			System.out.println("SALARY: ");
			Double salary = sc.nextDouble();
			sc.nextLine();

			Employee emp = new Employee(id, name, salary);

			list.add(emp);
		}

		System.out.println("ID of the employee who's gonna get an increase: ");
		int idSalary = sc.nextInt();
		Integer position = hasID(list, idSalary);
		if (position != null) {
			System.out.println("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(position).increaseSalary(percent);
		} else
			System.out.println("This ID doesnt exist");

		System.out.println("\nEmployee List: ");

		for (Employee emp : list)
			System.out.println(emp.toString());

		sc.close();
	}

	// percorre lista procurando por id
	// list.size -> tamanho da lista
	// get pega elemento em um posiçao
	// nesse caso pega o id da posição i na lista
	public static Integer hasID(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id)
				return i;
		}
		return null;
	}
}