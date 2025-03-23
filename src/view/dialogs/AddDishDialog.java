package view.dialogs;

import controller.RestaurantController;
import model.Dish;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AddDishDialog extends JDialog {
    private final RestaurantController controller;
    private boolean dishAdded = false;
    private final JTextField nameField;
    private final JComboBox<String> categoryComboBox;
    private final JSpinner priceSpinner;
    private final JTextArea recipeArea;
    private final JCheckBox availableCheckBox;

    public AddDishDialog(Window owner, RestaurantController controller) {
        super(owner, "Add New Dish", ModalityType.APPLICATION_MODAL);
        this.controller = controller;

        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name field
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        nameField = new JTextField(20);
        mainPanel.add(nameField, gbc);

        // Category combo box
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Category:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        categoryComboBox = new JComboBox<>();
        List<String> categories = controller.getAllCategories();
        for (String category : categories) {
            categoryComboBox.addItem(category);
        }
        mainPanel.add(categoryComboBox, gbc);

        // Price spinner
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Price:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        SpinnerNumberModel priceModel = new SpinnerNumberModel(0.0, 0.0, 10000.0, 0.1);
        priceSpinner = new JSpinner(priceModel);
        mainPanel.add(priceSpinner, gbc);

        // Recipe instructions
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Recipe:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        recipeArea = new JTextArea(5, 20);
        recipeArea.setLineWrap(true);
        recipeArea.setWrapStyleWord(true);
        JScrollPane recipeScroll = new JScrollPane(recipeArea);
        mainPanel.add(recipeScroll, gbc);

        // Available checkbox
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        availableCheckBox = new JCheckBox("Available", true);
        mainPanel.add(availableCheckBox, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveDish());
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    private void saveDish() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter a dish name.",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        String category = (String) categoryComboBox.getSelectedItem();
        double price = (Double) priceSpinner.getValue();
        String recipe = recipeArea.getText().trim();
        boolean available = availableCheckBox.isSelected();

        Dish dish = new Dish(name, category, price, recipe, available);
        if (controller.addDish(dish)) {
            dishAdded = true;
            dispose();
        }
    }

    public boolean isDishAdded() {
        return dishAdded;
    }
} 