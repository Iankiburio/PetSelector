import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PetSelector extends JFrame {

    private JLabel imageLabel;

    public PetSelector() {
        setTitle("RadioButtonDemo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        HashMap<String, String> petImages = new HashMap<>();
        petImages.put("Bird", "bird.jpeg");
        petImages.put("Cat", "cat.jpeg");
        petImages.put("Dog", "dog.jpeg");
        petImages.put("Rabbit", "rabbit.jpeg");
        petImages.put("Pig", "pig.jpeg");

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        ButtonGroup group = new ButtonGroup();
        for (String pet : petImages.keySet()) {
            JRadioButton button = new JRadioButton(pet);
            group.add(button);
            radioPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ImageIcon petIcon = new ImageIcon(getClass().getResource(petImages.get(pet)));
                    imageLabel.setIcon(petIcon);
                }
            });
        }

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetSelector frame = new PetSelector();
            frame.setVisible(true);
        });
    }
}
