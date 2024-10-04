package cpit305_p;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class CPIT305_P extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JPanel dashboardPanel;

    public CPIT305_P() {

        setTitle("Sport Tournament");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createMainScreen(), "mainScreen");

        mainPanel.add(createLoginScreen(), "loginScreen");

        mainPanel.add(createSignupScreen(), "signupScreen");

        dashboardPanel = new JPanel(new BorderLayout());
        mainPanel.add(dashboardPanel, "dashboardScreen");

        add(mainPanel);

        cardLayout.show(mainPanel, "mainScreen");
    }

    private JPanel createMainScreen() {

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon backgroundImage = new ImageIcon("background.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JLabel sportLabel = new JLabel("SPORT");
        sportLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 50));
        sportLabel.setForeground(Color.BLACK);
        sportLabel.setBounds(400, 100, 210, 240);
        panel.add(sportLabel);

        JLabel tournamentLabel = new JLabel("TOURNAMENT");
        tournamentLabel.setFont(new Font("Arial", Font.TYPE1_FONT, 50));
        tournamentLabel.setForeground(Color.BLACK);
        tournamentLabel.setBounds(300, 200, 360, 200);
        panel.add(tournamentLabel);

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

        JPanel loginPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("background.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        loginPanel.setLayout(null);

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

            showDashboard();
            cardLayout.show(mainPanel, "dashboardScreen");
        });

        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(loginBtn);

        loginPanel.add(whitePanel);

        return loginPanel;
    }

    private JPanel createSignupScreen() {

        JPanel signupPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("background.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        signupPanel.setLayout(null);

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

        whitePanel.add(nameLabel);
        whitePanel.add(nameField);
        whitePanel.add(phoneLabel);
        whitePanel.add(phoneField);
        whitePanel.add(emailLabel);
        whitePanel.add(emailField);
        whitePanel.add(passwordLabel);
        whitePanel.add(passwordField);
        whitePanel.add(signupBtn);

        signupPanel.add(whitePanel);

        return signupPanel;
    }

    private VBox resultArea;

    private void showDashboard() {
        JFXPanel fxPanel = new JFXPanel();
        dashboardPanel.add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {

            BorderPane mainLayout = new BorderPane();

            Image bgImage = new Image("2.png");

            if (bgImage != null) {
                BackgroundImage backgroundImage = new BackgroundImage(bgImage,
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
                mainLayout.setBackground(new Background(backgroundImage));
            }

            VBox sidebar = createSidebar();
            mainLayout.setLeft(sidebar);

            VBox mainContent = new VBox(10);
            mainContent.setPadding(new Insets(20));
            mainContent.setAlignment(Pos.TOP_CENTER);

            javafx.scene.control.Label header = new javafx.scene.control.Label("Dashboard");
            header.setStyle("-fx-font-size: 30px; -fx-text-fill: #a3c1a4; -fx-font-weight: bold;");
            mainContent.getChildren().add(header);

            resultArea = new VBox();
            resultArea.setPadding(new Insets(10));
            resultArea.setStyle("-fx-background-color: rgba(255, 255, 255, 0.9); -fx-border-color: #BDC3C7; -fx-border-radius: 5px;");
            resultArea.setPrefHeight(400);
            mainContent.getChildren().add(resultArea);

            mainLayout.setCenter(mainContent);

            Scene scene = new Scene(mainLayout, 1000, 600);
            fxPanel.setScene(scene);
        });
    }

    private void showHome() {
        Platform.runLater(() -> {
            VBox homeLayout = new VBox(20);
            homeLayout.setPadding(new Insets(20));
            homeLayout.setAlignment(Pos.TOP_CENTER);

            javafx.scene.control.Label titleLabel = new javafx.scene.control.Label("WELCOME TO SPORT TOURNAMENT APPLICATION !!");
            titleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: #a3c1a4;");
            homeLayout.getChildren().add(titleLabel);

            VBox matchBox = new VBox(10);
            matchBox.setAlignment(Pos.CENTER);
            matchBox.setPadding(new Insets(20));
            matchBox.setStyle("-fx-background-color: rgba(240, 240, 240, 0.7); -fx-border-color: #BDC3C7; -fx-border-radius: 5px;");

            javafx.scene.control.Label recentMatchLabel = new javafx.scene.control.Label("RECENT MATCH");
            recentMatchLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

            HBox matchContent = new HBox(20);
            matchContent.setAlignment(Pos.CENTER);

            Image team1Logo = new Image("Team1.png");
            Image team2Logo = new Image("Team2.png");

            ImageView team1ImageView = new ImageView(team1Logo);
            team1ImageView.setFitHeight(90);
            team1ImageView.setFitWidth(70);

            ImageView team2ImageView = new ImageView(team2Logo);
            team2ImageView.setFitHeight(90);
            team2ImageView.setFitWidth(95);

            javafx.scene.control.Label matchResult = new javafx.scene.control.Label("  2 - 1");
            matchResult.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

            matchContent.getChildren().addAll(team1ImageView, matchResult, team2ImageView);
            matchBox.getChildren().addAll(recentMatchLabel, matchContent);
            homeLayout.getChildren().add(matchBox);

            VBox coachBox = new VBox(10);
            coachBox.setAlignment(Pos.CENTER);
            coachBox.setPadding(new Insets(20));
            coachBox.setStyle("-fx-background-color: rgba(240, 240, 240, 0.7); -fx-border-color: #BDC3C7; -fx-border-radius: 5px;");

            javafx.scene.control.Label bestCoachLabel = new javafx.scene.control.Label("BEST COACH");
            bestCoachLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

            HBox coachDetails = new HBox(20);
            coachDetails.setAlignment(Pos.CENTER);

            javafx.scene.control.TextField coachName = new javafx.scene.control.TextField("Coach Name");
            coachName.setPrefWidth(200);
            coachName.setStyle("-fx-background-color: rgba(200, 200, 200, 0.5); -fx-font-size: 18px; -fx-font-weight: bold;");
            coachName.setEditable(false);

            javafx.scene.control.TextField teamName = new javafx.scene.control.TextField("Team");
            teamName.setPrefWidth(200);
            teamName.setStyle("-fx-background-color: rgba(200, 200, 200, 0.5); -fx-font-size: 18px; -fx-font-weight: bold;");
            teamName.setEditable(false);

            coachDetails.getChildren().addAll(coachName, teamName);

            coachBox.getChildren().addAll(bestCoachLabel, coachDetails);
            homeLayout.getChildren().add(coachBox);

            resultArea.getChildren().clear();
            resultArea.getChildren().add(homeLayout);
        });
    }

    private VBox createAddTeamForm() {
        VBox form = new VBox(10);
        form.setPadding(new Insets(20));
        form.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #BDC3C7; -fx-border-radius: 5px; -fx-padding: 15px;");
        form.setAlignment(Pos.CENTER);

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

        addButton.setMaxWidth(150);
        addButton.setAlignment(Pos.CENTER);

        form.getChildren().addAll(nameField, coachField, playersField, matchTypeField, addButton);
        return form;
    }

    private void showAddTeamForm() {
        Platform.runLater(() -> {
            VBox form = createAddTeamForm();
            resultArea.getChildren().clear();
            resultArea.getChildren().add(form);
        });
    }

    private void viewTeams() {
        Platform.runLater(() -> {

            VBox teamLayout = new VBox(20);
            teamLayout.setPadding(new Insets(20));
            teamLayout.setAlignment(Pos.TOP_CENTER);

            javafx.scene.control.Label titleLabel = new javafx.scene.control.Label("Team List");
            titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #a3c1a4;");

            TableView<Team> teamTable = new TableView<>();
            teamTable.setPrefSize(400, 400);

            TableColumn<Team, String> nameColumn = new TableColumn<>("Team Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            nameColumn.setPrefWidth(150);

            TableColumn<Team, String> coachColumn = new TableColumn<>("Coach Name");
            coachColumn.setCellValueFactory(new PropertyValueFactory<>("coach"));
            coachColumn.setPrefWidth(150);

            TableColumn<Team, Integer> playersColumn = new TableColumn<>("Players");
            playersColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPlayers"));
            playersColumn.setPrefWidth(150);

            TableColumn<Team, String> SportsColumn = new TableColumn<>("Sport Type");
            SportsColumn.setCellValueFactory(new PropertyValueFactory<>("SportType"));
            SportsColumn.setPrefWidth(150);

            teamTable.getColumns().addAll(nameColumn, coachColumn, playersColumn, SportsColumn);

            teamLayout.getChildren().addAll(titleLabel, teamTable);

            resultArea.getChildren().clear();
            resultArea.getChildren().add(teamLayout);
        });
    }

    private void viewMatchResults() {
        Platform.runLater(() -> {
            VBox matchResultsLayout = new VBox(10);
            matchResultsLayout.setPadding(new Insets(20));
            matchResultsLayout.setAlignment(Pos.TOP_CENTER);

            javafx.scene.control.Label titleLabel = new javafx.scene.control.Label("Match History");
            titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #a3c1a4;");

            javafx.scene.image.ImageView awardIcon;

            Image image = new Image("Cup2.png");
            awardIcon = new ImageView(image);
            ;

            awardIcon.setFitHeight(75);
            awardIcon.setFitWidth(60);

            HBox headerBox = new HBox(10);
            headerBox.setAlignment(Pos.CENTER);
            headerBox.getChildren().addAll(titleLabel, awardIcon);

            VBox matchList = new VBox(10);
            matchList.setPadding(new Insets(10));
            matchList.setStyle("-fx-background-color: rgba(255, 255, 255, 0.9); -fx-border-color: #BDC3C7; -fx-border-radius: 5px;");
            matchList.setPrefHeight(400);

            for (int i = 1; i <= 5; i++) {

                VBox matchBox = new VBox(5);
                matchBox.setStyle("-fx-background-color: rgba(240, 240, 240, 1); -fx-border-color: #BDC3C7; -fx-border-radius: 5px;");
                matchBox.setPadding(new Insets(10));
                matchBox.setAlignment(Pos.CENTER);

                javafx.scene.control.Label matchLabel = new javafx.scene.control.Label("Match " + ": Team " + "\t\t\t" + "vs\t\t Team" + "\t\t\t" + " Result:  ");
                matchLabel.setStyle("-fx-font-size: 16px;");

                matchBox.getChildren().add(matchLabel);

                matchList.getChildren().add(matchBox);
            }

            resultArea.getChildren().clear();
            resultArea.getChildren().addAll(headerBox, matchList);
        });
    }

    private void scheduleMatch() {
        Platform.runLater(() -> {
            VBox scheduleMatchLayout = new VBox(15);
            scheduleMatchLayout.setPadding(new Insets(20));
            scheduleMatchLayout.setAlignment(Pos.TOP_CENTER);
            scheduleMatchLayout.setStyle("-fx-background-color: #f7f7f7; -fx-border-color: #a3c1a4; -fx-border-radius: 10px; -fx-padding: 20px;");

            javafx.scene.control.Label titleLabel = new javafx.scene.control.Label("Schedule a Match");
            titleLabel.setStyle("-fx-font-size: 28px; -fx-text-fill: #4a4a4a; -fx-font-weight: bold;");

            javafx.scene.control.TextField sportTypeField = new javafx.scene.control.TextField();
            sportTypeField.setPromptText("Enter Sport Type");
            sportTypeField.setMaxWidth(400);
            sportTypeField.setMinHeight(40);
            sportTypeField.setStyle("-fx-padding: 10px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4a4a4a; -fx-background-color: #FFFFFF; -fx-border-color: #a3c1a4; -fx-border-radius: 10px;");

            ComboBox<String> team1ComboBox = new ComboBox<>();
            ComboBox<String> team2ComboBox = new ComboBox<>();
            team1ComboBox.getItems().addAll("Team A", "Team B", "Team C");
            team2ComboBox.getItems().addAll("Team A", "Team B", "Team C");
            team1ComboBox.setPromptText("Select Team 1");
            team2ComboBox.setPromptText("Select Team 2");
            team1ComboBox.setMaxWidth(400);
            team2ComboBox.setMaxWidth(400);
            team1ComboBox.setMinHeight(40);
            team2ComboBox.setMinHeight(40);
            team1ComboBox.setStyle("-fx-padding: 1px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4a4a4a; -fx-background-color: #FFFFFF; -fx-border-color: #a3c1a4; -fx-border-radius: 10px;");
            team2ComboBox.setStyle("-fx-padding: 1px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4a4a4a; -fx-background-color: #FFFFFF; -fx-border-color: #a3c1a4; -fx-border-radius: 10px;");

            HBox teamSelectionBox = new HBox(20);
            teamSelectionBox.setAlignment(Pos.CENTER);
            teamSelectionBox.getChildren().addAll(team1ComboBox, team2ComboBox);

            DatePicker datePicker = new DatePicker();
            datePicker.setPromptText("Select Match Date");
            datePicker.setMaxWidth(400);
            datePicker.setMinHeight(40);
            datePicker.setStyle("-fx-padding: 10px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4a4a4a; -fx-background-color: #FFFFFF; -fx-border-color: #a3c1a4; -fx-border-radius: 10px;");

            ComboBox<Integer> hourComboBox = new ComboBox<>();
            ComboBox<Integer> minuteComboBox = new ComboBox<>();
            for (int i = 0; i < 24; i++) {
                hourComboBox.getItems().add(i);
            }
            for (int i = 0; i < 60; i += 5) {
                minuteComboBox.getItems().add(i);
            }

            hourComboBox.setPromptText("Hour");
            minuteComboBox.setPromptText("Minute");
            hourComboBox.setMaxWidth(150);
            minuteComboBox.setMaxWidth(150);
            hourComboBox.setMinHeight(40);
            minuteComboBox.setMinHeight(40);
            hourComboBox.setStyle("-fx-padding: 1px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4a4a4a; -fx-background-color: #FFFFFF; -fx-border-color: #a3c1a4; -fx-border-radius: 10px;");
            minuteComboBox.setStyle("-fx-padding: 1px; -fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4a4a4a; -fx-background-color: #FFFFFF; -fx-border-color: #a3c1a4; -fx-border-radius: 10px;");

            HBox timeBox = new HBox(20);
            timeBox.setAlignment(Pos.CENTER);
            timeBox.getChildren().addAll(hourComboBox, minuteComboBox);

            javafx.scene.control.Button saveButton = new javafx.scene.control.Button("Save Match Schedule");
            saveButton.setStyle("-fx-background-color: #e9f5e9; -fx-text-fill: #4a4a4a; -fx-font-size: 16px; -fx-font-weight: bold; -fx-border-radius: 10px; -fx-padding: 10px;");
            saveButton.setMaxWidth(250);

            saveButton.setOnAction(e -> {
                String team1 = team1ComboBox.getValue();
                String team2 = team2ComboBox.getValue();
                LocalDate matchDate = datePicker.getValue();
                Integer matchHour = hourComboBox.getValue();
                Integer matchMinute = minuteComboBox.getValue();
                String sportType = sportTypeField.getText();

            });

            scheduleMatchLayout.getChildren().addAll(titleLabel, sportTypeField, teamSelectionBox, datePicker, timeBox, saveButton);

            resultArea.getChildren().clear();
            resultArea.getChildren().add(scheduleMatchLayout);
        });
    }

    private VBox createSidebar() {
        VBox sidebar = new VBox(15);
        sidebar.setPadding(new Insets(20));
        sidebar.setStyle("-fx-background-color: rgba(179, 210, 150, 1); -fx-border-radius: 5px; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 10, 0, 0, 5);");

        sidebar.getChildren().add(createSidebarButton("Home", e -> showHome()));
        sidebar.getChildren().add(createSidebarButton("Teams", e -> viewTeams()));
        sidebar.getChildren().add(createSidebarButton("Add Team", e -> showAddTeamForm()));
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
