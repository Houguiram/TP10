import java.io.IOException;
import java.util.Scanner;

public class Motus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Dictionnaire dico = new Dictionnaire();
		String path = "./dico.txt";
		while (dico.words == null) {
			try {
				dico.setDictionnary(path);
			} catch (IOException e) {
				System.out.println("Erreur :" + e);
				System.out.println("Veuillez entrer l'emplacement du dictionnaire ou écrire end pour quitter :");
				path = sc.nextLine();
				if (path.equals("end")) {
					System.exit(0);
				}
			}
		}
		String solution = dico.choose();
		String feedback = "x";
		String input = "";
		int score = 0;
		System.out.println("Bienvenue dans Motus ! Ecrivez end pour quitter le jeu");
		System.out.println("Le mot a " + solution.length() + " lettres et commence par la lettre \""
				+ solution.substring(0, 1) + "\"");
		while (true) {
			input = sc.nextLine();
			if (input.equals("end")) {
				break;
			}
			try {
				feedback = evaluer(solution, input);
			} catch (Exception e) {
				System.out.println("Mauvaise longueur de mot !");
			}
			System.out.println(feedback);
			score++;
			if (!feedback.matches(".*[-x].*")) {
				System.out.println("Bravo ! Vous avez gagné en " + score + " essai(s) !");
				break;
			}
		}
		sc.close();
	}

	public static String evaluer(String solution, String proposition) throws Exception {
		if (solution.length() != proposition.length()) {
			throw new Exception();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < solution.length(); i++) {
			if (("" + solution.charAt(i)).equals(("" + proposition.charAt(i)))) {
				sb.append("o");
			} else if (solution.matches((".*" + proposition.charAt(i) + ".*"))) {
				sb.append("-");
			} else {
				sb.append("x");
			}
		}
		return sb.toString();
	}

}
