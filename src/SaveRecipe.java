import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;


public class SaveRecipe extends PrintWriter {

  private ArrayList<String> fileContents;

  public SaveRecipe (String path, ArrayList<String> pFileContents) throws FileNotFoundException {
    super(new File(path));
    fileContents = pFileContents;
  }

  public void save() {
    for (String line : fileContents) {
      print(line);
      print("\n");
    }
    close();
  }

}
