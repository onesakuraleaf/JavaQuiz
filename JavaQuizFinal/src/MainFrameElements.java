//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainFrameElements extends JFrame {
    public MainFrameElements() {
        try {
            this.initComponents();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initComponents() throws IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setTitle("Java alapok");
        GridBagLayout layout = new GridBagLayout();
        JPanel panel = new JPanel(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel titleLabel = new JLabel("Java alapok elsajátítása");
        titleLabel.setFont(new Font("Times New Roman", 1, 35));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = 10;
        gbc.insets = new Insets(10, 10, 50, 10);
        panel.add(titleLabel, gbc);
        String[] buttonLabels = new String[]{"Motiváció", "Tananyag", "Gyakorlás", "Tesztelés"};
        String[] iconPaths = new String[]{"icons/launch_motivation.png", "icons/launch_learn.png", "icons/launch_practice.png", "icons/launch_test.png"};

        for(int i = 0; i < buttonLabels.length; ++i) {
            InputStream inputStream = MainFrameElements.class.getResourceAsStream(iconPaths[i]);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            ImageIcon originalIcon = new ImageIcon(bufferedImage);
            Image image = originalIcon.getImage().getScaledInstance(30, 30, 4);
            ImageIcon resizedIcon = new ImageIcon(image);
            final JButton button = new JButton(buttonLabels[i]);
            button.setPreferredSize(new Dimension(250, 50));
            button.setIcon(resizedIcon);
            if (buttonLabels[i].equals("Motiváció")) {
                button.addActionListener((e) -> {
                    frame.dispose();
                    this.showMotivationScreen();
                });
            }

            if (buttonLabels[i].equals("Tananyag")) {
                button.addActionListener((e) -> {
                    frame.dispose();
                    this.showLearningScreen();
                });
            }

            if (buttonLabels[i].equals("Gyakorlás")) {
                button.addActionListener((e) -> {
                    frame.dispose();
                    this.showPracticeFrame();
                });
            }

            if (buttonLabels[i].equals("Tesztelés")) {
                button.addActionListener((e) -> {
                    frame.dispose();
                    this.showTestFrame();
                });
            }

            gbc.gridx = 0;
            gbc.gridy = i + 2;
            gbc.gridwidth = 1;
            gbc.anchor = 10;
            gbc.insets = new Insets(5, 10, 5, 10);
            panel.add(button, gbc);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2, true));
            button.setBackground(new Color(70, 130, 180));
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Times New Roman", 1, 30));
            button.setOpaque(true);
            button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            button.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    button.setBackground(new Color(120, 160, 250));
                }

                public void mouseExited(MouseEvent evt) {
                    button.setBackground(new Color(70, 130, 180));
                }

                public void mousePressed(MouseEvent evt) {
                    button.setBackground(new Color(30, 60, 120));
                }

                public void mouseReleased(MouseEvent evt) {
                    button.setBackground(new Color(70, 130, 180));
                }
            });
        }

        frame.add(panel);
        frame.setLocationRelativeTo((Component)null);
        frame.setVisible(true);
    }

    private void showMotivationScreen() {
        JFrame motivacioFrame = new JFrame("Motivációs Szöveg");
        motivacioFrame.setSize(610, 800);
        motivacioFrame.setResizable(true);
        motivacioFrame.setDefaultCloseOperation(3);
        String motivacioSzoveg = ReadContentFromDatabase.readFileContent("motivacio.txt");
        JTextArea textArea = new JTextArea(motivacioSzoveg);
        textArea.setEditable(false);
        textArea.setFont(new Font("Times New Roman", 0, 25));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(20, 20, 20, 20));
        textArea.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        JButton backButton = new JButton("Vissza a főmenübe");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial Narrow", 1, 25));
        backButton.addActionListener((ev) -> {
            motivacioFrame.dispose();
            new MainFrameElements();
        });
        bottomPanel.add(backButton);
        motivacioFrame.setLayout(new BorderLayout());
        motivacioFrame.add(scrollPane, "Center");
        motivacioFrame.add(bottomPanel, "South");
        motivacioFrame.setLocationRelativeTo((Component)null);
        motivacioFrame.setVisible(true);
    }

    private void showLearningScreen() {
        String[] topics = new String[]{"Bevezető", "Hello World", "Alapvető adattípusok", "Változók deklarálása", "Operátorok", "Elágazások", "Ciklusok", "Függvények", "Objektum Orientált Programozás", "Kivételkezelés"};
        JFrame learnFrame = new JFrame("Tananyag");
        learnFrame.setSize(1000, 800);
        learnFrame.setResizable(true);
        learnFrame.setLayout(new BorderLayout());
        learnFrame.setDefaultCloseOperation(3);
        JList<String> topicList = new JList(topics);
        topicList.setSelectionMode(0);
        topicList.setFont(new Font("Times New Roman", 1, 17));
        topicList.setFixedCellHeight(40);
        JScrollPane listScrollPane = new JScrollPane(topicList);
        listScrollPane.setPreferredSize(new Dimension(260, learnFrame.getHeight()));
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        JLabel titleLabel = new JLabel("Válassz egy témakört!", 0);
        titleLabel.setFont(new Font("Times New Roman", 1, 30));
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        JTextArea contentTextArea = new JTextArea();
        contentTextArea.setFont(new Font("Times New Roman", 0, 20));
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);
        contentTextArea.setEditable(false);
        contentTextArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane contentScrollPane = new JScrollPane(contentTextArea);
        DefaultListModel<String> listModel = new DefaultListModel();
        listModel.addElement("Bevezető");
        listModel.addElement("Hello World");
        listModel.addElement("Alapvető adattípusok");
        listModel.addElement("Változók deklarálása");
        listModel.addElement("Operátorok");
        listModel.addElement("Elágazások");
        listModel.addElement("Ciklusok");
        listModel.addElement("Függvények");
        listModel.addElement("Objektum Orientált Programozás");
        listModel.addElement("Kivételkezelés");
        Map<String, String> topicToFileMap = new HashMap();
        topicToFileMap.put("Bevezető", "bevezeto.txt");
        topicToFileMap.put("Hello World", "helloworld.txt");
        topicToFileMap.put("Alapvető adattípusok", "datatype.txt");
        topicToFileMap.put("Változók deklarálása", "variables.txt");
        topicToFileMap.put("Operátorok", "operators.txt");
        topicToFileMap.put("Elágazások", "conditions.txt");
        topicToFileMap.put("Ciklusok", "loops.txt");
        topicToFileMap.put("Függvények", "functions.txt");
        topicToFileMap.put("Objektum Orientált Programozás", "oop.txt");
        topicToFileMap.put("Kivételkezelés", "exception.txt");
        topicList.addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                String selectedTopic = (String)topicList.getSelectedValue();
                titleLabel.setText(selectedTopic);
                String fileName = (String)topicToFileMap.get(selectedTopic);
                if (fileName != null) {
                    contentTextArea.setText(ReadContentFromDatabase.readFileContent(fileName));
                } else {
                    contentTextArea.setText("Nincs tartalom ehhez a témához.");
                }

                contentTextArea.setCaretPosition(0);
                contentTextArea.revalidate();
                contentTextArea.repaint();
            }

        });
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        JButton exitButton = new JButton("Vissza a főmenübe");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial Narrow", 1, 25));
        exitButton.setOpaque(true);
        exitButton.addActionListener((ev) -> {
            learnFrame.dispose();
            new MainFrameElements();
        });
        bottomPanel.add(exitButton, "West");
        JPanel navButtons = new JPanel(new FlowLayout(2));
        navButtons.setBackground(Color.LIGHT_GRAY);
        JPanel backButtonsFrame = new JPanel(new FlowLayout(0));
        backButtonsFrame.setBackground(Color.LIGHT_GRAY);
        JButton prevButton = new JButton("Előző");
        JButton nextButton = new JButton("Következő");
        prevButton.setForeground(Color.BLACK);
        prevButton.setBackground(Color.GREEN);
        prevButton.setFont(new Font("Arial Narrow", 1, 25));
        prevButton.setOpaque(true);
        nextButton.setForeground(Color.BLACK);
        nextButton.setBackground(Color.GREEN);
        nextButton.setFont(new Font("Arial Narrow", 1, 25));
        nextButton.setOpaque(true);
        prevButton.addActionListener((e) -> {
            int index = topicList.getSelectedIndex();
            if (index > 0) {
                topicList.setSelectedIndex(index - 1);
            }

        });
        nextButton.addActionListener((e) -> {
            int index = topicList.getSelectedIndex();
            if (index < topics.length - 1) {
                topicList.setSelectedIndex(index + 1);
            }

        });
        navButtons.add(prevButton);
        navButtons.add(nextButton);
        backButtonsFrame.add(exitButton);
        bottomPanel.add(backButtonsFrame, "West");
        bottomPanel.add(navButtons, "East");
        learnFrame.add(listScrollPane, "West");
        learnFrame.add(contentScrollPane, "Center");
        learnFrame.add(bottomPanel, "South");
        learnFrame.setLocationRelativeTo((Component)null);
        learnFrame.setVisible(true);
        contentPanel.add(titleLabel, "North");
        contentPanel.add(contentScrollPane, "Center");
        learnFrame.add(contentPanel, "Center");
    }

    private void showPracticeFrame() {
        // Kérdések és válaszok adatbázisa
        ArrayList<Question> questions = new ArrayList<>();

        // 1. kérdés
        questions.add(new Question(
                "Melyik kulcsszóval deklarálunk egy osztályt Java-ban?",
                new String[]{"class", "Class", "CLASS"},
                0
        ));

        // 2. kérdés
        questions.add(new Question(
                "Melyik adattípus tárol egész számokat Java-ban?",
                new String[]{"int", "Integer", "INT"},
                0
        ));

        // 3. kérdés
        questions.add(new Question(
                "Hogyan hozunk létre egy új objektumot?",
                new String[]{"new Objektum()", "új Objektum()", "create Objektum()"},
                0
        ));

        // 4. kérdés
        questions.add(new Question(
                "Melyik metódus ír ki szöveget a konzolra?",
                new String[]{"System.out.println()", "Console.print()", "System.print()"},
                0
        ));

        // 5. kérdés
        questions.add(new Question(
                "Melyik kulcsszó segítségével hozhatunk létre IGAZ/HAMIS értéket tároló változókat Java-ban?",
                new String[]{"String", "int", "boolean"},
                2
        ));

        // 6. kérdés
        questions.add(new Question(
                "Melyik operátor használható objektumok összehasonlítására?",
                new String[]{"equals()", "==", "="},
                0
        ));

        // 7. kérdés
        questions.add(new Question(
                "Melyik ciklus fut le biztosan legalább egyszer?",
                new String[]{"do-while", "while", "for"},
                0
        ));

        // 8. kérdés
        questions.add(new Question(
                "Hogyan kezeljük a kivételeket Java-ban?",
                new String[]{"try-catch", "error-handle", "exception"},
                0
        ));

        // 9. kérdés
        questions.add(new Question(
                "Melyik NEM hozzáférés kezelő kulcsszó Java-ban?",
                new String[]{"local", "public", "private"},
                0
        ));

        // 10. kérdés
        questions.add(new Question(
                "A felsorolt lehetőségek közül melyik definiálja az Objektum fogalmát?",
                new String[]{"Az osztály példánya", "Elrejtjük a bonyolult implementációt, és csak a lényeges funkciókat mutatjuk meg", "Egy tervrajz"},
                0
        ));

        // 11. kérdés
        questions.add(new Question(
                "Melyik kulcsszó jelöl egy konstans értéket?",
                new String[]{"final", "const", "static"},
                0
        ));

        // 12. kérdés
        questions.add(new Question(
                "Mi a függvények hivatalos megnevezése Java-ban?",
                new String[]{"metódus", "osztály", "struktúra"},
                0
        ));

        // 13. kérdés
        questions.add(new Question(
                "Melyik NEM Java kulcsszó?",
                new String[]{"function", "void", "return"},
                0
        ));

        // 14. kérdés
        questions.add(new Question(
                "Melyik az a ciklus, amelyiknek nincs megszabva a maximális iterációja,\n hanem addig megy amíg egy feltétel nem teljesül?",
                new String[]{"for", "while", "continue"},
                1
        ));

        // 15. kérdés
        questions.add(new Question(
                "Mire valók a függvények Java-ban?",
                new String[]{"Segítenek a kód struktúráltabbá tételében", "Arra, hogy grafikus felületeket hozzunk létre a programban.", "Arra, hogy logikai értékeket tároljunk a programban."},
                0
        ));

        // 16. kérdés
        questions.add(new Question(
                "Melyik annotáció jelöl egy felülírt metódust?",
                new String[]{"@Override", "@Overwrite", "@New"},
                0
        ));

        // 17. kérdés
        questions.add(new Question(
                "Melyik csomag tartozik az alap Java könyvtárba?",
                new String[]{"java.util", "javax.swing", "org.junit"},
                0
        ));

        // 18. kérdés
        questions.add(new Question(
                "Melyik NEM Java verzió?",
                new String[]{"Java 3.0", "Java 8", "Java 11"},
                0
        ));

        // 19. kérdés
        questions.add(new Question(
                "Melyik metódus indít egy szálat?",
                new String[]{"start()", "run()", "execute()"},
                0
        ));

        // 20. kérdés
        questions.add(new Question(
                "Melyik NEM Java IDE?",
                new String[]{"JavaCode", "Eclipse", "IntelliJ IDEA"},
                0
        ));

        // Keverjük össze a kérdéseket, majd válasszunk ki 10-et
        Collections.shuffle(questions);
        ArrayList<Question> selectedQuestions = new ArrayList<>(questions.subList(0, 10));

        JFrame practiceFrame = new JFrame("Gyakorlás");
        practiceFrame.setSize(1600, 800);
        practiceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        practiceFrame.setLayout(new BorderLayout());

        // Progress bar
        JProgressBar progressBar = new JProgressBar(1, 10);
        progressBar.setValue(1);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        practiceFrame.add(progressBar, BorderLayout.NORTH);

        // Központi panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Kérdés megjelenítése
        JLabel questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Válasz gombok
        JButton[] answerButtons = new JButton[3];
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
            answerButtons[i].setBackground(Color.WHITE);
            answerButtons[i].setPreferredSize(new Dimension(600, 50));
        }

        // Eredmény label
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Gomb panel (3 gomb egymás mellett)
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        // Előző kérdés gomb
        JButton prevButton = new JButton("Vissza az előzőre");
        prevButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        prevButton.setBackground(new Color(100, 149, 237));
        prevButton.setForeground(Color.WHITE);
        prevButton.setEnabled(false);

        // Automatikus kitöltés gomb
        JButton autoFillButton = new JButton("Automatikus kitöltés");
        autoFillButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        autoFillButton.setBackground(new Color(70, 130, 180));
        autoFillButton.setForeground(Color.WHITE);

        // Következő kérdés gomb
        JButton nextButton = new JButton("Következő kérdés");
        nextButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        nextButton.setBackground(new Color(70, 130, 180));
        nextButton.setForeground(Color.WHITE);
        nextButton.setEnabled(false);

        buttonPanel.add(prevButton);
        buttonPanel.add(autoFillButton);
        buttonPanel.add(nextButton);

        // Vissza gomb
        JButton backButton = new JButton("Vissza a főmenübe");
        backButton.setFont(new Font("Arial Narrow", Font.BOLD, 25));
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);

        // Layout beállítás
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        centerPanel.add(questionLabel, gbc);
        for (JButton button : answerButtons) {
            centerPanel.add(button, gbc);
        }
        centerPanel.add(resultLabel, gbc);
        centerPanel.add(buttonPanel, gbc);

        // Alsó panel a vissza gombbal (középre igazítva)
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);

        practiceFrame.add(centerPanel, BorderLayout.CENTER);
        practiceFrame.add(bottomPanel, BorderLayout.SOUTH);

        // Változók a játék állapotának követésére
        final int[] currentQuestionIndex = {0};
        final List<Integer> answeredQuestions = new ArrayList<>();
        final List<Integer> userAnswers = new ArrayList<>();

        // Kérdés megjelenítése
        Runnable showQuestion = () -> {
            if (currentQuestionIndex[0] < selectedQuestions.size()) {
                Question currentQuestion = selectedQuestions.get(currentQuestionIndex[0]);
                questionLabel.setText(currentQuestion.getQuestionText());

                for (int i = 0; i < answerButtons.length; i++) {
                    answerButtons[i].setText(currentQuestion.getAnswers()[i]);
                    answerButtons[i].setBackground(Color.WHITE);
                    answerButtons[i].setEnabled(true);
                }

                resultLabel.setText("");
                nextButton.setEnabled(false);
                autoFillButton.setEnabled(true);

                // Előző gomb állapotának beállítása
                prevButton.setEnabled(currentQuestionIndex[0] > 0);

                // Ha már válaszolt erre a kérdésre, jelenítsük meg a választ
                if (answeredQuestions.contains(currentQuestionIndex[0])) {
                    int answerIndex = userAnswers.get(answeredQuestions.indexOf(currentQuestionIndex[0]));
                    answerButtons[answerIndex].setBackground(
                            answerIndex == currentQuestion.getCorrectAnswerIndex() ? Color.GREEN : Color.RED);
                    answerButtons[currentQuestion.getCorrectAnswerIndex()].setBackground(Color.GREEN);
                    nextButton.setEnabled(true);
                    autoFillButton.setEnabled(false);
                }

                progressBar.setValue(currentQuestionIndex[0] + 1);
            } else {
                // Végeredmény megjelenítése
                questionLabel.setText("Vége a gyakorlásnak!");
                for (JButton button : answerButtons) {
                    button.setVisible(false);
                }
                resultLabel.setText("");
                nextButton.setVisible(false);
                autoFillButton.setVisible(false);
                prevButton.setVisible(false);
            }
        };

        // Válasz gombok eseménykezelői
        for (int i = 0; i < answerButtons.length; i++) {
            final int buttonIndex = i;
            answerButtons[i].addActionListener(e -> {
                Question currentQuestion = selectedQuestions.get(currentQuestionIndex[0]);

                // Ha még nem válaszolt erre a kérdésre, mentse el a választ
                if (!answeredQuestions.contains(currentQuestionIndex[0])) {
                    answeredQuestions.add(currentQuestionIndex[0]);
                    userAnswers.add(buttonIndex);
                }

                boolean isCorrect = (buttonIndex == currentQuestion.getCorrectAnswerIndex());

                if (isCorrect) {
                    answerButtons[buttonIndex].setBackground(Color.GREEN);
                    resultLabel.setText("Helyes válasz!");
                    resultLabel.setForeground(Color.GREEN);
                } else {
                    answerButtons[buttonIndex].setBackground(Color.RED);
                    answerButtons[currentQuestion.getCorrectAnswerIndex()].setBackground(Color.GREEN);
                    resultLabel.setText("Helytelen válasz!");
                    resultLabel.setForeground(Color.RED);
                }

                for (JButton button : answerButtons) {
                    button.setEnabled(false);
                }

                nextButton.setEnabled(true);
                autoFillButton.setEnabled(false);
            });
        }

        // Automatikus kitöltés gomb eseménykezelője
        autoFillButton.addActionListener(e -> {
            Question currentQuestion = selectedQuestions.get(currentQuestionIndex[0]);
            int correctIndex = currentQuestion.getCorrectAnswerIndex();

            // Mentés, ha még nem válaszolt
            if (!answeredQuestions.contains(currentQuestionIndex[0])) {
                answeredQuestions.add(currentQuestionIndex[0]);
                userAnswers.add(correctIndex);
            }

            answerButtons[correctIndex].setBackground(Color.GREEN);
            resultLabel.setText("Automatikus kitöltés - helyes válasz kijelölve");
            resultLabel.setForeground(Color.BLUE);

            for (JButton button : answerButtons) {
                button.setEnabled(false);
            }

            nextButton.setEnabled(true);
            autoFillButton.setEnabled(false);
        });

        // Következő gomb eseménykezelője
        nextButton.addActionListener(e -> {
            currentQuestionIndex[0]++;
            showQuestion.run();
        });

        // Előző gomb eseménykezelője
        prevButton.addActionListener(e -> {
            if (currentQuestionIndex[0] > 0) {
                currentQuestionIndex[0]--;
                showQuestion.run();
            }
        });

        // Vissza gomb eseménykezelője
        backButton.addActionListener(e -> {
            practiceFrame.dispose();
            new MainFrameElements();
        });

        // Első kérdés megjelenítése
        showQuestion.run();

        practiceFrame.setLocationRelativeTo(null);
        practiceFrame.setVisible(true);
    }

    private void showTestFrame() {
        // Kérdések betöltése
        ArrayList<Question> questions = new ArrayList<>();

        // 1. kérdés
        questions.add(new Question(
                "Melyik kulcsszóval deklarálunk egy osztályt Java-ban?",
                new String[]{"class", "Class", "CLASS"},
                0
        ));

        // 2. kérdés
        questions.add(new Question(
                "Melyik adattípus tárol egész számokat Java-ban?",
                new String[]{"int", "Integer", "INT"},
                0
        ));

        // 3. kérdés
        questions.add(new Question(
                "Hogyan hozunk létre egy új objektumot?",
                new String[]{"new Objektum()", "új Objektum()", "create Objektum()"},
                0
        ));

        // 4. kérdés
        questions.add(new Question(
                "Melyik metódus ír ki szöveget a konzolra?",
                new String[]{"System.out.println()", "Console.print()", "System.print()"},
                0
        ));

        // 5. kérdés
        questions.add(new Question(
                "Melyik kulcsszó segítségével hozhatunk létre IGAZ/HAMIS értéket tároló változókat Java-ban?",
                new String[]{"String", "int", "boolean"},
                2
        ));

        // 6. kérdés
        questions.add(new Question(
                "Melyik operátor használható objektumok összehasonlítására?",
                new String[]{"equals()", "==", "="},
                0
        ));

        // 7. kérdés
        questions.add(new Question(
                "Melyik ciklus fut le biztosan legalább egyszer?",
                new String[]{"do-while", "while", "for"},
                0
        ));

        // 8. kérdés
        questions.add(new Question(
                "Hogyan kezeljük a kivételeket Java-ban?",
                new String[]{"try-catch", "error-handle", "exception"},
                0
        ));

        // 9. kérdés
        questions.add(new Question(
                "Melyik NEM hozzáférés kezelő kulcsszó Java-ban?",
                new String[]{"local", "public", "private"},
                0
        ));

        // 10. kérdés
        questions.add(new Question(
                "A felsorolt lehetőségek közül melyik definiálja az Objektum fogalmát?",
                new String[]{"Az osztály példánya", "Elrejtjük a bonyolult implementációt, és csak a lényeges funkciókat mutatjuk meg", "Egy tervrajz"},
                0
        ));

        // 11. kérdés
        questions.add(new Question(
                "Melyik kulcsszó jelöl egy konstans értéket?",
                new String[]{"final", "const", "static"},
                0
        ));

        // 12. kérdés
        questions.add(new Question(
                "Mi a függvények hivatalos megnevezése Java-ban?",
                new String[]{"metódus", "osztály", "struktúra"},
                0
        ));

        // 13. kérdés
        questions.add(new Question(
                "Melyik NEM Java kulcsszó?",
                new String[]{"function", "void", "return"},
                0
        ));

        // 14. kérdés
        questions.add(new Question(
                "Melyik az a ciklus, amelyiknek nincs megszabva a maximális iterációja,\n hanem addig megy amíg egy feltétel nem teljesül?",
                new String[]{"for", "while", "continue"},
                1
        ));

        // 15. kérdés
        questions.add(new Question(
                "Mire valók a függvények Java-ban?",
                new String[]{"Segítenek a kód struktúráltabbá tételében", "Arra, hogy grafikus felületeket hozzunk létre a programban.", "Arra, hogy logikai értékeket tároljunk a programban."},
                0
        ));

        // 16. kérdés
        questions.add(new Question(
                "Melyik annotáció jelöl egy felülírt metódust?",
                new String[]{"@Override", "@Overwrite", "@New"},
                0
        ));

        // 17. kérdés
        questions.add(new Question(
                "Melyik csomag tartozik az alap Java könyvtárba?",
                new String[]{"java.util", "javax.swing", "org.junit"},
                0
        ));

        // 18. kérdés
        questions.add(new Question(
                "Melyik NEM Java verzió?",
                new String[]{"Java 3.0", "Java 8", "Java 11"},
                0
        ));

        // 19. kérdés
        questions.add(new Question(
                "Melyik metódus indít egy szálat?",
                new String[]{"start()", "run()", "execute()"},
                0
        ));

        // 20. kérdés
        questions.add(new Question(
                "Melyik NEM Java IDE?",
                new String[]{"JavaCode", "Eclipse", "IntelliJ IDEA"},
                0
        ));

        Collections.shuffle(questions);
        ArrayList<Question> selectedQuestions = new ArrayList<>(questions.subList(0, 10));

        JFrame testFrame = new JFrame("Tesztelés");
        testFrame.setSize(1600, 800);
        testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        testFrame.setLayout(new BorderLayout());

        // Progress bar
        JProgressBar progressBar = new JProgressBar(1, 10);
        progressBar.setValue(1);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Times New Roman", Font.BOLD, 16));
        testFrame.add(progressBar, BorderLayout.NORTH);

        // Központi panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Kérdés megjelenítése
        JLabel questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Válasz gombok
        JButton[] answerButtons = new JButton[3];
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
            answerButtons[i].setBackground(Color.WHITE);
            answerButtons[i].setPreferredSize(new Dimension(600, 50));
        }

        // Eredmény label
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Gomb panel (csak 2 gomb - nincs automatikus kitöltés)
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));

        // Következő kérdés gomb
        JButton nextButton = new JButton("Következő kérdés");
        nextButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        nextButton.setBackground(new Color(70, 130, 180));
        nextButton.setForeground(Color.WHITE);
        nextButton.setEnabled(false);

        buttonPanel.add(nextButton);

        // Vissza gomb (csak a teszt végén jelenik meg)
        JButton backButton = new JButton("Vissza a főmenübe");
        backButton.setFont(new Font("Arial Narrow", Font.BOLD, 25));
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setVisible(false);

        // Layout beállítás
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        centerPanel.add(questionLabel, gbc);
        for (JButton button : answerButtons) {
            centerPanel.add(button, gbc);
        }
        centerPanel.add(resultLabel, gbc);
        centerPanel.add(buttonPanel, gbc);

        // Alsó panel a vissza gombbal
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);

        testFrame.add(centerPanel, BorderLayout.CENTER);
        testFrame.add(bottomPanel, BorderLayout.SOUTH);

        // Változók a játék állapotának követésére
        final int[] currentQuestionIndex = {0};
        final int[] score = {0};
        final List<Integer> userAnswers = new ArrayList<>();

        // Kérdés megjelenítése
        Runnable showQuestion = () -> {
            if (currentQuestionIndex[0] < selectedQuestions.size()) {
                Question currentQuestion = selectedQuestions.get(currentQuestionIndex[0]);
                questionLabel.setText(currentQuestion.getQuestionText());

                for (int i = 0; i < answerButtons.length; i++) {
                    answerButtons[i].setText(currentQuestion.getAnswers()[i]);
                    answerButtons[i].setBackground(Color.WHITE);
                    answerButtons[i].setEnabled(true);
                }

                resultLabel.setText("");
                nextButton.setEnabled(false);

                // Ha már válaszolt erre a kérdésre, jelenítsük meg a választ
                if (currentQuestionIndex[0] < userAnswers.size()) {
                    int answerIndex = userAnswers.get(currentQuestionIndex[0]);
                    answerButtons[answerIndex].setBackground(
                            answerIndex == currentQuestion.getCorrectAnswerIndex() ? Color.GREEN : Color.RED);
                    answerButtons[currentQuestion.getCorrectAnswerIndex()].setBackground(Color.GREEN);
                    nextButton.setEnabled(true);
                }

                progressBar.setValue(currentQuestionIndex[0] + 1);
            } else {
                // Végeredmény megjelenítése
                questionLabel.setText("Teszt eredménye: " + score[0] + "/10");
                for (JButton button : answerButtons) {
                    button.setVisible(false);
                }
                resultLabel.setText(score[0] >= 6 ? "Gratulálok, sikeres teszt!" : "Sajnos nem sikerült, próbáld újra!");
                resultLabel.setForeground(score[0] >= 5 ? Color.GREEN : Color.RED);
                nextButton.setVisible(false);
                backButton.setVisible(true);
            }
        };

        // Válasz gombok eseménykezelői
        for (int i = 0; i < answerButtons.length; i++) {
            final int buttonIndex = i;
            answerButtons[i].addActionListener(e -> {
                Question currentQuestion = selectedQuestions.get(currentQuestionIndex[0]);

                // Válasz mentése
                if (currentQuestionIndex[0] >= userAnswers.size()) {
                    userAnswers.add(buttonIndex);
                } else {
                    userAnswers.set(currentQuestionIndex[0], buttonIndex);
                }

                // Pontszám számítás
                if (buttonIndex == currentQuestion.getCorrectAnswerIndex()) {
                    score[0]++;
                    // answerButtons[buttonIndex].setBackground(Color.GREEN);
                    //resultLabel.setText("Helyes válasz!");
                    // resultLabel.setForeground(Color.GREEN);
                } else {
                  /*  answerButtons[buttonIndex].setBackground(Color.RED);
                    answerButtons[currentQuestion.getCorrectAnswerIndex()].setBackground(Color.GREEN);
                    resultLabel.setText("Helytelen válasz!");
                    resultLabel.setForeground(Color.RED);*/
                }

                for (JButton button : answerButtons) {
                    button.setEnabled(false);
                }

                nextButton.setEnabled(true);
            });
        }

        // Következő gomb eseménykezelője
        nextButton.addActionListener(e -> {
            currentQuestionIndex[0]++;
            showQuestion.run();
        });

        // Vissza gomb eseménykezelője
        backButton.addActionListener(e -> {
            testFrame.dispose();
            new MainFrameElements();
        });

        // Első kérdés megjelenítése
        showQuestion.run();

        testFrame.setLocationRelativeTo(null);
        testFrame.setVisible(true);
    }

}
