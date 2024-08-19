import java.util.*;

class Main{

	public static void main(String[] args){
	
		Scanner scan = new Scanner(System.in);

		int desejada = scan.nextInt();

		int lida = scan.nextInt();

		int diff = desejada - lida;

		System.out.println(diff);

		scan.close();

	}

}
