import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.File;
import javax.swing.filechooser.FileSystemView;



public class NewRecipe extends JFrame implements ActionListener {

    private JTextField recipeName;
    private JTextField prepTime;
    private JTextField servingSize;
    private ArrayList<JTextField> ingredientsList;
    private ArrayList<JTextField> ingredientQuantity;
    private JButton saveButton;
    private JButton addIngredient;
    private JButton exitButton;
    private JPanel quantityPanel;
    private JPanel ingredientsNamePanel;
    private JTextArea instructions;


    public NewRecipe () {

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2));
        JLabel recipeNameLabel = new JLabel("Name: ");
        recipeName = new JTextField(20);
        topPanel.add(recipeNameLabel);
        topPanel.add(recipeName);
        JLabel prepTimeLabel = new JLabel("Prep Time: ");
        prepTime = new JTextField(10);
        topPanel.add(prepTimeLabel);
        topPanel.add(prepTime);
        JLabel servingSizeLabel = new JLabel("Serving Size: ");
        servingSize = new JTextField(10);
        topPanel.add(servingSizeLabel);
        topPanel.add(servingSize);

        JPanel fileOptionsPanel = new JPanel();
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        fileOptionsPanel.add(saveButton);
        fileOptionsPanel.add(exitButton);

        quantityPanel = new JPanel();
        quantityPanel.setLayout(new BoxLayout(quantityPanel, BoxLayout.Y_AXIS));

        ingredientsNamePanel = new JPanel();
        ingredientsNamePanel.setLayout(new BoxLayout(ingredientsNamePanel, BoxLayout.Y_AXIS));

        JPanel ingredientsPanel = new JPanel();
        ingredientsPanel.setLayout(new BorderLayout());
        addIngredient = new JButton("Add");
        addIngredient.addActionListener(this);
        ingredientsList = new ArrayList<>();
        ingredientQuantity = new ArrayList<>();
        JLabel ingredientsPanelLabel = new JLabel("Ingredients");
        ingredientsPanel.add(ingredientsPanelLabel, BorderLayout.NORTH);
        ingredientsPanel.add(quantityPanel, BorderLayout.WEST);
        ingredientsPanel.add(ingredientsNamePanel, BorderLayout.EAST);
        ingredientsPanel.add(addIngredient, BorderLayout.SOUTH);

        JPanel instructionsPanel = new JPanel();
        instructions = new JTextArea();
        instructions.setTabSize(4);
        instructions.setLineWrap(true);
        instructions.setColumns(50);
        instructions.setRows(50);
        instructionsPanel.add(instructions);




        JPanel recipiePanel = new JPanel();
        recipiePanel.setLayout(new BoxLayout(recipiePanel, BoxLayout.Y_AXIS));
        recipiePanel.add(ingredientsPanel);
        recipiePanel.add(instructionsPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(recipiePanel, BorderLayout.CENTER);
        mainPanel.add(fileOptionsPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setSize(800, 800);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public void addIngredientToList () {
        ingredientQuantity.add(new JTextField(10));
        ingredientsList.add(new JTextField(30));
        quantityPanel.add(ingredientQuantity.get(ingredientQuantity.size() - 1));
        ingredientsNamePanel.add(ingredientsList.get(ingredientsList.size() - 1));
        quantityPanel.updateUI();
        ingredientsNamePanel.updateUI();
    }

    public void actionPerformed (ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("Add")) {
            addIngredientToList();
            System.out.println("Test");
        } else if (button.equals("Exit")) {
            dispose();
        } else if (button.equals("Save")) {
          boolean i = saveActions();
          System.out.println(i);
        }
    }

    private boolean saveActions () {
      try {
        ArrayList<String> input = getAndPackageInput();
        for (String s : input) {
          System.out.println(s);
        }
        String s = setWorkingDirectory();
        System.out.println(s);
        String path = s + "/" + input.get(0);
        SaveRecipe saveNewRecipe = new SaveRecipe(path, input);
        saveNewRecipe.save();
        return true;
      } catch (Exception e) {
        return false;
      }
    }

    private ArrayList<String> getAndPackageInput () {
      ArrayList<String> input = new ArrayList<>();
      input.add(recipeName.getText());
      input.add(prepTime.getText());
      input.add(servingSize.getText());
      input.add(FileDividers.ingredientDivider);
      for (int i = 0; i < ingredientsList.size(); i++) {
        input.add(ingredientQuantity.get(i).getText());
        input.add(ingredientsList.get(i).getText());
      }
      input.add(FileDividers.instructionsDivider);
      input.add(instructions.getText());
      return input;
    }

    private String setWorkingDirectory () {
      JFileChooser userSetWorkingDir = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      userSetWorkingDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int r = userSetWorkingDir.showOpenDialog(null);
      if (r == JFileChooser.APPROVE_OPTION) {
        return userSetWorkingDir.getSelectedFile().getAbsolutePath();
      }
      else {
        return null;
      }
    }

}
