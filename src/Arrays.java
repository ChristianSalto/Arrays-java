

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Arrays {
	private static Scanner sc = new Scanner(System.in);
	private static Scanner scs = new Scanner(System.in);
	private static ArrayList<Integer> myArrayInt;
	private static int valor;
	private static boolean validator = false;
	private static int count = 0;

	public Arrays() {
	}

	private static void showArray(ArrayList<Integer> a) {
		for (Integer i : a) {
			System.out.print(i + " ");
		}
	}

	private static void getShowArray(int bi[][]) {
		for (int x = 0; x < bi.length; x++) {
			System.out.print("|");
			for (int y = 0; y < bi[x].length; y++) {
				System.out.print(bi[x][y]);
				if (y != bi[x].length - 1) {
					System.out.print("\t");
				}
			}
			System.out.println("|");
		}
	}

	private static void getPositionArrayBi(int bi[][]) {
		String conti;
		validator = true;
		while (validator) {
			valor = controlInt();
			for (int x = 0; x < bi.length; x++) {
				for (int y = 0; y < bi[x].length; y++) {
					if (bi[x][y] == valor) {
						System.out.println("El numero se encuentra en la posicion de la fila " + x
								+ " y en la posicion de la columna " + y);
						validator = false;
					}
				}
			}

			if (validator != false) {
				System.out.println("No se encontro el " + valor + " en la matriz");
				System.out.println("�Desea seguir buscando?(s/n)");
				conti = scs.nextLine();
				if (!conti.contains("s")) {
					validator = false;
					System.out.println("Gracias por participar.....");
				}
			}

		}
	}

	private static int controlInt() {
		boolean v = true;
		do {
			try {
				System.out.println("Por favor introduce el numero a buscar: ");
				valor = sc.nextInt();
				v = false;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Por favor introduce un numero y no un String please....");
				sc.next();
			}
		} while (v);
		return valor;
	}

	/*********************************************************************************************/

	/*
	 * 19- Realiza un programa que lea desde teclado 10 n�meros y posteriormente
	 * muestre solamente los que sean pares.
	 */

	public static void onlyPar() {
		myArrayInt = new ArrayList<>();

		System.out.println("Por favor ingrese numeros: ");
		for (int i = 0; i < 10; i++) {
			valor = sc.nextInt();
			if (valor % 2 == 0) {
				myArrayInt.add(valor);
			}
		}
		System.out.println("Estos son los numeros pares: ");
		showArray(myArrayInt);
	}

	/*
	 * 20. Realiza un programa que lea desde teclado 9 n�meros. A continuaci�n nos
	 * pedir� que busquemos un n�mero entre los introducidos, y nos dir� si ha sido
	 * encontrado o no. En el caso en el que haya sido encontrado, nos indicar�
	 * cu�ntas veces se ha introducido. El programa nos preguntar� si queremos
	 * seguir buscando m�s n�meros o no: ��Desea seguir buscando?(s/n)�.
	 */

	public static void findNumber() {
		myArrayInt = new ArrayList<>();
		Scanner scString = new Scanner(System.in);
		String myValidator = "";

		System.out.println("Por favor ingrese numeros: ");
		for (int i = 0; i < 9; i++) {
			valor = sc.nextInt();
			myArrayInt.add(valor);
		}

		System.out.println("Por favor ingrese el numero que desea buscar: ");

		do {
			valor = sc.nextInt();

			for (Integer i : myArrayInt) {
				if (i == valor) {
					validator = true;
					count++;
				}
			}

			if (validator) {
				System.out.println("El numero " + valor + " ha sido encontrado " + " y se repite -> " + count);
				break;
			} else {
				System.out.println("�Desea seguir buscando?(s/n)");
				myValidator = scString.nextLine();
			}
		} while (myValidator.equals("s"));

		System.out.println("Gracias por jugar....");
	}

	/*
	 * 21. Realiza un programa que lea desde teclado 11 n�meros enteros, para
	 * posteriormente mostrarlos en el orden inverso al que fueron introducidos.
	 */

	public static void reverseNumber() {
		myArrayInt = new ArrayList<>();

		System.out.println("Por favor ingrese numeros: ");
		for (int i = 0; i < 11; i++) {
			valor = sc.nextInt();
			myArrayInt.add(valor);
		}

		Collections.reverse(myArrayInt);
		showArray(myArrayInt);
	}

	/*
	 * 22. Realiza un programa que lea desde teclado 10 n�meros sin repetir. Si el
	 * usuario introduce alg�n n�mero repetido se le debe notificar, y no ha de ser
	 * contabilizado.
	 */

	public static void notRepeat() {
		myArrayInt = new ArrayList<>();

		int countNumbers = 9;
		System.out.println("Por favor ingrese numeros: ");
		valor = sc.nextInt();
		myArrayInt.add(valor);
		for (int i = 0; i < countNumbers; i++) {
			valor = sc.nextInt();
			for (Integer x : myArrayInt) {
				if (valor == x) {
					System.out.println("Por favor trate de no repetir los numeros");
					validator = true;
					countNumbers++;
				}
			}

			if (!validator) {
				myArrayInt.add(valor);
			}
			validator = false;
		}

		showArray(myArrayInt);
	}

	/*
	 * 23.Realiza un programa que lea 25 n�meros para posteriormente mostrarlos en
	 * orden ascendente..
	 */

	public static void ascendentNumber() {
		myArrayInt = new ArrayList<>();

		System.out.println("Por favor ingrese numeros: ");
		for (int i = 0; i < 25; i++) {
			valor = sc.nextInt();
			myArrayInt.add(valor);
		}

		Collections.sort(myArrayInt);
		showArray(myArrayInt);
	}

	/*
	 * 24. Realiza un programa que cargue desde teclado una tabla bidimensional de
	 * 3x3 de n�meros enteros. Posteriormente el programa pedir� un n�mero a buscar,
	 * y en caso de encontrarlo indicar� el n�mero de fila y columna donde se ha
	 * encontrado por primera vez. El programa ofrecer� al usuario la opci�n de
	 * seguir buscando m�s n�meros: ��Desea seguir buscando?(s/n)�.
	 */

	public static void arrayBidimensional() {
		int bi[][] = new int[3][3];
		int valorArray = 0;
		myArrayInt = new ArrayList<>();
		System.out.println("Por favor ingrese numeros: ");
		for (int x = 0; x < bi.length; x++) {
			for (int y = 0; y < bi[x].length; y++) {
				valor = sc.nextInt();
				myArrayInt.add(valor);
				validator = true;
				if (myArrayInt.size() > 1) {
					for (int i = 1; i < myArrayInt.size(); i++) {
						valorArray = myArrayInt.get(i - 1);
						if (valorArray == valor) {
							validator = false;
							y--;
						}
					}
					if (validator) {
						bi[x][y] = valor;
					}
				} else {
					bi[x][y] = valor;
				}

			}
		}

		getShowArray(bi);
		getPositionArrayBi(bi);

	}
}
