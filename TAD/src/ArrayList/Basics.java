package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basics {

	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		List<String> str = new ArrayList<>();
		
		integers.add(3);
		str.add("Andre");
		str.add("Andreia");
		str.add("Pedro");
		str.add(2, "Rodrigo");//adiciona no indice
		str.add("Heitor");
		str.add("Ana");
		
		System.out.println(str.size());
		
		for(String x : str)
			System.out.println(x);
		
		str.remove("Pedro");//remove por string
		str.remove(0);//remove por indice
		str.removeIf(x -> x.charAt(0) == 'H');//remove elemento H
		//charAt retorna se elemento na posição 0 é H, se começar retorna true
		//então removeIf remove
		//usa função lambida ->
		
		
		System.out.println("----------");
		System.out.println(str.size());
		for(String x : str)
			System.out.println(x);
		
		
		System.out.println("----------");
		System.out.println("Index of Como estas?: " + str.indexOf("Como estas?"));
		//indexOf retorna -1 se não encontra
		System.out.println("Index of bonjuor: " + str.indexOf("Bonjuor!"));
		
		System.out.println("----------");
		//nova lista somente com elementos filtrados, nesse caso que começam com A
		List<String> result = str.stream().filter(x-> x.charAt(0) == 'A').collect(Collectors.toList());
		
		for(String y: result)
			System.out.println(y);
		
		System.out.println("----------");
		//pega primeiro elemento da string que atende condição, se não retorna nulo
		String name = str.stream().filter(x->x.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println(name);
	}

}
