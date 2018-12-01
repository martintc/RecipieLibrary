import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class ReadRecipe extends Scanners {

  /*
   * not connected yet
   */

  private ArrayList<String> fileContents;

  public ReadRecipe (String pFileName) throws FileNotFoundException {
    super(new File(pFileName));
    fileContents = new ArrayList<>();
  }

  public ArrayList<String> readFile () {
    while (hasNextLine()) {
      fileContents.add(nextLine());
    }
    return fileContents;
  }

}
