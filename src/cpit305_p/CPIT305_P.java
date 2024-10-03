package cpit305_p;

import javax.swing.*;
import java.awt.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CPIT305_P extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JPanel dashboardPanel;

    public CPIT305_P() {
        // إعداد إطار النافذة
        setTitle("Sport Tournament");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // استخدام CardLayout للتنقل بين الشاشات
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // إضافة الشاشة الرئيسية
        mainPanel.add(createMainScreen(), "mainScreen");

        // إضافة شاشة تسجيل الدخول
        mainPanel.add(createLoginScreen(), "loginScreen");

        // إضافة شاشة التسجيل
        mainPanel.add(createSignupScreen(), "signupScreen");

        // إضافة شاشة الداشبورد من الكود الثاني
        dashboardPanel = new JPanel(new BorderLayout());
        mainPanel.add(dashboardPanel, "dashboardScreen");

        // إضافة اللوحة الرئيسية إلى الإطار
        add(mainPanel);

        cardLayout.show(mainPanel, "mainScreen"); // إظهار الشاشة الرئيسية في البداية
    }

    private JPanel createMainScreen() {
        // إنشاء لوحة للشاشة الرئيسية
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // تحميل الصورة الخلفية
                ImageIcon backgroundImage = new ImageIcon("background.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        // إعداد نص SPORT
        JLabel sportLabel = new JLabel("SPORT");
        sportLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 50));
        sportLabel.setForeground(Color.BLACK);
        sportLabel.setBounds(400, 100, 210, 240);
        panel.add(sportLabel);

        // إعداد نص TOURNAMENT
        JLabel tournamentLabel = new JLabel("TOURNAMENT");
        tournamentLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 50));
        tournamentLabel.setForeground(Color.BLACK);
        tournamentLabel.setBounds(300, 200, 360, 200);
        panel.add(tournamentLabel);

        // إعداد زر تسجيل الدخول (Login)
        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(310, 400, 150, 40);
        loginButton.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        loginButton.setBackground(Color.getHSBColor(20, 100, 10));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "loginScreen"));
        panel.add(loginButton);

        // إعداد زر التسجيل (Sign Up)
        JButton signupButton = new JButton("SIGN UP");
        signupButton.setBounds(500, 400, 150, 40);
        signupButton.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        signupButton.setBackground(Color.getHSBColor(20, 100, 10));
        signupButton.setFocusPainted(false);
        signupButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
        signupButton.setOpaque(true);
        signupButton.setBorderPainted(false);
        signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupButton.addActionListener(e -> cardLayout.show(mainPanel, "signupScreen"));
        panel.add(signupButton);

        return panel;
    }

    private JPanel createLoginScreen() {
        // إعداد شاشة تسجيل الدخول
        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("background.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setLayout(null);

        // إنشاء مربع أبيض للنصوص
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255, 255, 255, 150));
        whitePanel.setBounds(300, 150, 400, 250);
        whitePanel.setLayout(null);
        whitePanel.setOpaque(true);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        emailLabel.setBounds(50, 50, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        passwordLabel.setBounds(50, 100, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);

        JButton loginBtn = new JButton("LOG IN");
        loginBtn.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        loginBtn.setBackground(Color.getHSBColor(20, 100, 10));
        loginBtn.setBounds(150, 180, 100, 30);
        loginBtn.addActionListener(e -> {
            // عند الضغط على تسجيل الدخول نعرض صفحة الداشبورد
            showDashboard();
            cardLayout.show(mainPanel, "dashboardScreen");
        });

        // إضافة العناصر إلى المربع الأبيض
        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(loginBtn);

        // إضافة المربع الأبيض إلى اللوحة الرئيسية
        loginPanel.add(whitePanel);

        return loginPanel;
    }

    private JPanel createSignupScreen() {
        // إعداد شاشة التسجيل
        JPanel signupPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("background.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        signupPanel.setLayout(null);

        // إنشاء مربع أبيض للنصوص
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(new Color(255, 255, 255, 150));
        whitePanel.setBounds(300, 160, 400, 350);
        whitePanel.setLayout(null);
        whitePanel.setOpaque(true);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        nameLabel.setBounds(50, 50, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 50, 200, 25);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        phoneLabel.setBounds(50, 100, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 100, 200, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        emailLabel.setBounds(50, 150, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 150, 200, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        passwordLabel.setBounds(50, 200, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 200, 200, 25);

        JButton signupBtn = new JButton("SIGN UP");
        signupBtn.setFont(new Font("Arial", Font.TYPE1_FONT, 16));
        signupBtn.setBackground(Color.getHSBColor(20, 100, 10));
        signupBtn.setBounds(150, 300, 100, 30);

        // إضافة العناصر إلى المربع الأبيض
        whitePanel.add(nameLabel);
        whitePanel.add(nameField);
        whitePanel.add(phoneLabel);
        whitePanel.add(phoneField);
        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(signupBtn);

        // إضافة المربع الأبيض إلى اللوحة الرئيسية
        signupPanel.add(whitePanel);

        return signupPanel;
    }

    private VBox resultArea;  // قم بإضافة هذا المتغير إذا لم يكن موجودًا مسبقًا

    private void showDashboard() {
        // إنشاء JFXPanel لتشغيل محتوى JavaFX في Swing
        JFXPanel fxPanel = new JFXPanel();
        dashboardPanel.add(fxPanel, BorderLayout.CENTER);

        // إنشاء واجهة JavaFX
        Platform.runLater(() -> {
            BorderPane mainLayout = new BorderPane();

            // تحميل الصورة الخلفية
            Image bgImage = null;
            try {
                bgImage = new Image(getClass().getResource("/2.png").toExternalForm());
            } catch (Exception e) {
                System.out.println("Failed to load image: " + e.getMessage());
            }

            if (bgImage != null) {
                BackgroundImage backgroundImage = new BackgroundImage(bgImage,
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
                mainLayout.setBackground(new Background(backgroundImage));
            }

            // Sidebar
            VBox sidebar = createSidebar();
            mainLayout.setLeft(sidebar);

            // Center content
            VBox mainContent = new VBox(10);
            mainContent.setPadding(new Insets(20));
            mainContent.setAlignment(Pos.TOP_CENTER);

            javafx.scene.control.Label header = new javafx.scene.control.Label("Dashboard");
            header.setStyle("-fx-font-size: 30px; -fx-text-fill: #a3c1a4; -fx-font-weight: bold;");
            mainContent.getChildren().add(header);

            resultArea = new VBox();  // إضافة منطقة عرض
            resultArea.setPadding(new Insets(10));
            resultArea.setStyle("-fx-background-color: rgba(255, 255, 255, 0.9); -fx-border-color: #BDC3C7; -fx-border-radius: 5px;");
            resultArea.setPrefHeight(400);
            mainContent.getChildren().add(resultArea);

            mainLayout.setCenter(mainContent);

            // Set up the scene
            Scene scene = new Scene(mainLayout, 1000, 600);
            fxPanel.setScene(scene);
        });
    }

    private VBox createAddTeamForm() {
        VBox form = new VBox(10);
        form.setPadding(new Insets(20));
        form.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #BDC3C7; -fx-border-radius: 5px; -fx-padding: 15px;");
        form.setAlignment(Pos.CENTER); // Center all content in the VBox

        javafx.scene.control.Label title = new javafx.scene.control.Label("Add Team");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #a3c1a4;");
        form.getChildren().add(title);

        javafx.scene.control.TextField nameField = new javafx.scene.control.TextField();
        nameField.setPromptText("Team Name");
        nameField.setMaxWidth(300);

        javafx.scene.control.TextField coachField = new javafx.scene.control.TextField();
        coachField.setPromptText("Coach Name");
        coachField.setMaxWidth(300);

        javafx.scene.control.TextField playersField = new javafx.scene.control.TextField();
        playersField.setPromptText("Number of Players");
        playersField.setMaxWidth(300);

        javafx.scene.control.TextField matchTypeField = new javafx.scene.control.TextField();
        matchTypeField.setPromptText("Match Type");
        matchTypeField.setMaxWidth(300);

        javafx.scene.control.Button addButton = new javafx.scene.control.Button("Add Team");
        addButton.setStyle("-fx-background-color: rgb(252, 244, 204); -fx-text-fill: #a3c1a4; -fx-font-size: 16px; -fx-padding: 10px; -fx-background-radius: 5px;");

        // Center the button
        addButton.setMaxWidth(150);
        addButton.setAlignment(Pos.CENTER);

        // Add action for the button
        addButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String coach = coachField.getText().trim();
            int numberOfPlayers;
            try {
                numberOfPlayers = Integer.parseInt(playersField.getText().trim());
                if (numberOfPlayers <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                showAlert("Invalid number of players!");
                return;
            }
            String matchType = matchTypeField.getText().trim();

            if (name.isEmpty() || coach.isEmpty() || matchType.isEmpty()) {
                showAlert("All fields must be filled out!");
                return;
            }

            // يمكن إضافة الفريق إلى القائمة هنا
            System.out.println("Team added: " + name + " Coach: " + coach + " Players: " + numberOfPlayers + " Match Type: " + matchType);
            nameField.clear();
            coachField.clear();
            playersField.clear();
            matchTypeField.clear();
        });

        form.getChildren().addAll(nameField, coachField, playersField, matchTypeField, addButton);
        return form;
    }

    private void showAddTeamForm() {
        Platform.runLater(() -> {
            VBox form = createAddTeamForm();  // إنشاء نموذج إضافة فريق
            resultArea.getChildren().clear();  // مسح المحتويات الحالية
            resultArea.getChildren().add(form);  // إضافة النموذج الجديد إلى منطقة العرض
        });
    }

    private void viewTeams() {
        System.out.println("View Teams clicked.");
    }

    private void viewMatchResults() {
        System.out.println("View Match Results clicked.");
    }

    private void scheduleMatch() {
        System.out.println("Schedule Match clicked.");
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private VBox createSidebar() {
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: rgba(179, 210, 150, 1); -fx-border-radius: 5px; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 5);");

        sidebar.getChildren().add(createSidebarButton("Dashboard", e -> showDashboard()));
        sidebar.getChildren().add(createSidebarButton("Teams", e -> viewTeams()));
        sidebar.getChildren().add(createSidebarButton("Add Team", e -> showAddTeamForm()));  // هنا نضيف عرض الفورم
        sidebar.getChildren().add(createSidebarButton("Match Results", e -> viewMatchResults()));
        sidebar.getChildren().add(createSidebarButton("Schedule Match", e -> scheduleMatch()));

        return sidebar;
    }

    private javafx.scene.control.Button createSidebarButton(String text, javafx.event.EventHandler<javafx.event.ActionEvent> action) {
        javafx.scene.control.Button button = new javafx.scene.control.Button(text);
        button.setStyle("-fx-background-color: rgb(252, 244, 204); -fx-text-fill: #a3c1a4; -fx-font-size: 16px; -fx-padding: 10px; -fx-alignment: CENTER-LEFT; -fx-background-radius: 20px;");
        button.setOnAction(action);
        button.setPrefWidth(200);
        button.setAlignment(Pos.CENTER_LEFT);

        // Add hover effect
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: rgba(230, 230, 150, 1); -fx-text-fill: #a3c1a4; -fx-font-size: 16px; -fx-padding: 10px; -fx-alignment: CENTER-LEFT; -fx-background-radius: 20px;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: rgb(252, 244, 204); -fx-text-fill: #a3c1a4; -fx-font-size: 16px; -fx-padding: 10px; -fx-alignment: CENTER-LEFT; -fx-background-radius: 20px;"));

        return button;
    }

    class Team {

        private String name;
        private String coach;
        private int numberOfPlayers;
        private String matchType;

        public Team(String name, String coach, int numberOfPlayers, String matchType) {
            this.name = name;
            this.coach = coach;

            this.numberOfPlayers = numberOfPlayers;
            this.matchType = matchType;
        }

        @Override
        public String toString() {
            return String.format("Name: %s, Coach: %s, Players: %d, Match Type: %s", name, coach, numberOfPlayers, matchType);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CPIT305_P gui = new CPIT305_P();
            gui.setVisible(true);
        });
    }
}
