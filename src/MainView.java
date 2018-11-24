import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class MainView extends JFrame implements ActionListener {

    private JLabel mainLabel;
    private JButton searchRecipeButton;
    private JButton newRecipeButton;
    private JButton aboutButton;
    private JButton exitButton;


    public MainView () {

        JPanel topPanel = new JPanel();
        mainLabel = new JLabel("Recipie Tracker");
        topPanel.add(mainLabel);

        JPanel optionsPanel = new JPanel();
        searchRecipeButton = new JButton("Search");
        searchRecipeButton.addActionListener(this);
        newRecipeButton = new JButton("New");
        newRecipeButton.addActionListener(this);
        optionsPanel.add(searchRecipeButton);
        optionsPanel.add(newRecipeButton);

        JPanel bottomPanel = new JPanel();
        aboutButton = new JButton("About");
        aboutButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        bottomPanel.add(aboutButton);
        bottomPanel.add(exitButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(optionsPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);


        setSize(300, 200);
        setResizable(false);
        add(mainPanel);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent e) {
        String event = e.getActionCommand();
        if (event.equals("Exit")) {
            System.exit(-1);
        } else if (event.equals("New")) {
            NewRecipe newRecipie = new NewRecipe();
        }
    }

}
