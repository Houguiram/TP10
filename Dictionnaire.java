import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Dictionnaire {
	public List<String> words;

	public Dictionnaire() {
		words = null;
	}

	public void setDictionnary(String file) throws IOException {
		words = Files.readAllLines(Paths.get(file), Charset.forName("ISO-8859-1"));
	}

	public boolean find(String word) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(word)) {
				return true;
			}
		}
		return false;
	}

	public String choose() {
		Random rand = new Random();
		int randIndex = rand.nextInt(words.size() + 1);
		return words.get(randIndex);
	}

}
