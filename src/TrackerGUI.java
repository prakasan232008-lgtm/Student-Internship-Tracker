package src;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TrackerGUI extends JFrame {

    JPanel mainPanel;
    JLabel studentCountLabel;
    JLabel skillCountLabel;
    JLabel internshipCountLabel;

    Font titleFont = new Font("Segoe UI", Font.BOLD, 30);
    Font subtitleFont = new Font("Segoe UI", Font.PLAIN, 15);
    Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
    Font cardTitleFont = new Font("Segoe UI", Font.BOLD, 13);
    Font numberFont = new Font("Segoe UI", Font.BOLD, 34);

    Color backgroundColor = new Color(238, 243, 250);
    Color headerColor = new Color(27, 38, 59);
    Color white = Color.WHITE;

    Color blue = new Color(52, 152, 219);
    Color green = new Color(39, 174, 96);
    Color purple = new Color(142, 68, 173);
    Color orange = new Color(230, 126, 34);
    Color red = new Color(231, 76, 60);
    Color cyan = new Color(0, 150, 180);
    Color darkBlue = new Color(41, 70, 120);

    public TrackerGUI() {

        setTitle("Student Skill & Internship Tracker");
        setSize(1250, 780);
        setMinimumSize(new Dimension(1100, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();

        setVisible(true);
    }

    void createGUI() {

        mainPanel = new JPanel(new BorderLayout(0, 15));
        mainPanel.setBackground(backgroundColor);
        mainPanel.setBorder(
            new EmptyBorder(0, 20, 20, 20)
        );

        createHeader();
        createDashboard();
        createButtons();

        add(mainPanel);
    }

    void createHeader() {

        JPanel header = new JPanel(
            new BorderLayout()
        );

        header.setBackground(headerColor);
        header.setBorder(
            new EmptyBorder(25, 30, 25, 30)
        );

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(
            new BoxLayout(
                titlePanel,
                BoxLayout.Y_AXIS
            )
        );

        titlePanel.setOpaque(false);

        JLabel title = new JLabel(
            "STUDENT SKILL & INTERNSHIP TRACKER"
        );

        title.setFont(titleFont);
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel(
            "Your complete student career management dashboard"
        );

        subtitle.setFont(subtitleFont);
        subtitle.setForeground(
            new Color(190, 210, 230)
        );

        titlePanel.add(title);
        titlePanel.add(
            Box.createVerticalStrut(6)
        );
        titlePanel.add(subtitle);

        JLabel logo = new JLabel("🎓");

        logo.setFont(
            new Font(
                "Segoe UI Emoji",
                Font.PLAIN,
                52
            )
        );

        header.add(
            titlePanel,
            BorderLayout.WEST
        );

        header.add(
            logo,
            BorderLayout.EAST
        );

        mainPanel.add(
            header,
            BorderLayout.NORTH
        );
    }

    void createDashboard() {

        JPanel dashboard = new JPanel(
            new GridLayout(1, 3, 18, 18)
        );

        dashboard.setOpaque(false);

        dashboard.setBorder(
            new EmptyBorder(0, 0, 0, 0)
        );

        studentCountLabel =
            createDashboardCard(
                dashboard,
                "TOTAL STUDENTS",
                blue,
                "👨‍🎓"
            );

        skillCountLabel =
            createDashboardCard(
                dashboard,
                "TOTAL SKILLS",
                green,
                "⭐"
            );

        internshipCountLabel =
            createDashboardCard(
                dashboard,
                "TOTAL INTERNSHIPS",
                purple,
                "💼"
            );

        updateDashboard();

        mainPanel.add(
            dashboard,
            BorderLayout.CENTER
        );
    }

    JLabel createDashboardCard(
        JPanel parent,
        String title,
        Color accent,
        String icon
    ) {

        JPanel card = new JPanel(
            new BorderLayout(15, 5)
        );

        card.setBackground(Color.WHITE);

        card.setBorder(
            BorderFactory.createCompoundBorder(
                new MatteBorder(
                    0,
                    6,
                    0,
                    0,
                    accent
                ),
                new EmptyBorder(
                    18,
                    20,
                    18,
                    20
                )
            )
        );

        JLabel iconLabel =
            new JLabel(icon);

        iconLabel.setFont(
            new Font(
                "Segoe UI Emoji",
                Font.PLAIN,
                32
            )
        );

        JPanel textPanel = new JPanel();
        textPanel.setLayout(
            new BoxLayout(
                textPanel,
                BoxLayout.Y_AXIS
            )
        );

        textPanel.setOpaque(false);

        JLabel titleLabel =
            new JLabel(title);

        titleLabel.setFont(cardTitleFont);
        titleLabel.setForeground(
            new Color(100, 110, 125)
        );

        JLabel numberLabel =
            new JLabel("0");

        numberLabel.setFont(numberFont);
        numberLabel.setForeground(accent);

        textPanel.add(titleLabel);
        textPanel.add(
            Box.createVerticalStrut(4)
        );
        textPanel.add(numberLabel);

        card.add(
            iconLabel,
            BorderLayout.WEST
        );

        card.add(
            textPanel,
            BorderLayout.CENTER
        );

        parent.add(card);

        return numberLabel;
    }

    void createButtons() {

        JPanel container =
            new JPanel(new BorderLayout(0, 8));

        container.setOpaque(false);

        JLabel menuTitle =
            new JLabel("QUICK ACTIONS");

        menuTitle.setFont(
            new Font(
                "Segoe UI",
                Font.BOLD,
                16
            )
        );

        menuTitle.setForeground(
            new Color(60, 70, 85)
        );

        menuTitle.setBorder(
            new EmptyBorder(0, 5, 3, 0)
        );

        container.add(
            menuTitle,
            BorderLayout.NORTH
        );

        JPanel buttonPanel =
            new JPanel(
                new GridLayout(4, 4, 12, 12)
            );

        buttonPanel.setOpaque(false);

        addButton(
            buttonPanel,
            "Add Student",
            blue,
            e -> addStudent()
        );

        addButton(
            buttonPanel,
            "Add Skill",
            green,
            e -> addSkill()
        );

        addButton(
            buttonPanel,
            "Add Internship",
            purple,
            e -> addInternship()
        );

        addButton(
            buttonPanel,
            "View Students",
            cyan,
            e -> viewStudents()
        );

        addButton(
            buttonPanel,
            "View Skills",
            green,
            e -> viewSkills()
        );

        addButton(
            buttonPanel,
            "View Internships",
            orange,
            e -> viewInternships()
        );

        addButton(
            buttonPanel,
            "Search Student",
            darkBlue,
            e -> searchStudent()
        );

        addButton(
            buttonPanel,
            "Update Internship",
            purple,
            e -> updateInternship()
        );

        addButton(
            buttonPanel,
            "Progress Report",
            blue,
            e -> progressReport()
        );

        addButton(
            buttonPanel,
            "Student Profile",
            cyan,
            e -> studentProfile()
        );

        addButton(
            buttonPanel,
            "Linked Records",
            darkBlue,
            e -> linkedRecords()
        );

        addButton(
            buttonPanel,
            "Delete Record",
            red,
            e -> deleteRecord()
        );

        addButton(
            buttonPanel,
            "Save Data",
            green,
            e -> saveData()
        );

        addButton(
            buttonPanel,
            "Refresh Dashboard",
            cyan,
            e -> updateDashboard()
        );

        addButton(
            buttonPanel,
            "About",
            orange,
            e -> showAbout()
        );

        addButton(
            buttonPanel,
            "Exit",
            red,
            e -> exitApplication()
        );

        container.add(
            buttonPanel,
            BorderLayout.CENTER
        );

        mainPanel.add(
            container,
            BorderLayout.SOUTH
        );
    }

    void addButton(
        JPanel panel,
        String text,
        Color color,
        ActionListener action
    ) {

        JButton button =
            new JButton(text);

        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setBackground(color);

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);

        button.setCursor(
            new Cursor(
                Cursor.HAND_CURSOR
            )
        );

        button.setBorder(
            new EmptyBorder(
                12,
                8,
                12,
                8
            )
        );

        button.addActionListener(action);

        button.addMouseListener(
            new MouseAdapter() {

                public void mouseEntered(
                    MouseEvent e
                ) {

                    button.setBackground(
                        color.brighter()
                    );

                    button.setFont(
                        new Font(
                            "Segoe UI",
                            Font.BOLD,
                            15
                        )
                    );
                }

                public void mouseExited(
                    MouseEvent e
                ) {

                    button.setBackground(color);

                    button.setFont(buttonFont);
                }
            }
        );

        panel.add(button);
    }

    void updateDashboard() {

        studentCountLabel.setText(
            String.valueOf(
                Main.students.size()
            )
        );

        skillCountLabel.setText(
            String.valueOf(
                Main.skills.size()
            )
        );

        internshipCountLabel.setText(
            String.valueOf(
                Main.internships.size()
            )
        );
    }

    Student chooseStudent() {

        if (Main.students.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "No students available.\nPlease add a student first.",
                "No Students",
                JOptionPane.WARNING_MESSAGE
            );

            return null;
        }

        ArrayList<Student> students =
            Main.students;

        String[] options =
            new String[students.size()];

        for (int i = 0;
             i < students.size();
             i++) {

            Student student =
                students.get(i);

            options[i] =
                student.studentId +
                " - " +
                student.name;
        }

        String selected =
            (String) JOptionPane.showInputDialog(
                this,
                "Select Student:",
                "Student Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

        if (selected == null) {
            return null;
        }

        int id =
            Integer.parseInt(
                selected.split(" - ")[0]
            );

        return Main.findStudentById(id);
    }

    void addStudent() {

        JTextField idField =
            new JTextField();

        JTextField nameField =
            new JTextField();

        JTextField emailField =
            new JTextField();

        JTextField departmentField =
            new JTextField();

        JPanel panel =
            createFormPanel();

        panel.add(
            createLabel("Student ID:")
        );
        panel.add(idField);

        panel.add(
            createLabel("Name:")
        );
        panel.add(nameField);

        panel.add(
            createLabel("Email:")
        );
        panel.add(emailField);

        panel.add(
            createLabel("Department:")
        );
        panel.add(departmentField);

        int result =
            JOptionPane.showConfirmDialog(
                this,
                panel,
                "➕ Add Student",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        try {

            int id =
                Integer.parseInt(
                    idField.getText().trim()
                );

            String name =
                nameField.getText().trim();

            String email =
                emailField.getText().trim();

            String department =
                departmentField.getText().trim();

            if (
                name.isEmpty() ||
                email.isEmpty() ||
                department.isEmpty()
            ) {

                showWarning(
                    "Please fill all fields."
                );

                return;
            }

            if (
                Main.findStudentById(id)
                != null
            ) {

                showWarning(
                    "Student ID already exists."
                );

                return;
            }

            Main.students.add(
                new Student(
                    id,
                    name,
                    email,
                    department
                )
            );

            Main.saveData();
            updateDashboard();

            showSuccess(
                "Student added successfully!"
            );

        } catch (
            NumberFormatException e
        ) {

            showWarning(
                "Student ID must be a number."
            );
        }
    }

    void addSkill() {

        Student student =
            chooseStudent();

        if (student == null) {
            return;
        }

        JTextField skillField =
            new JTextField();

        String[] levels = {
            "Beginner",
            "Intermediate",
            "Advanced",
            "Expert"
        };

        JComboBox<String> levelBox =
            new JComboBox<>(levels);

        JPanel panel =
            createFormPanel();

        panel.add(
            createLabel("Skill Name:")
        );

        panel.add(skillField);

        panel.add(
            createLabel("Skill Level:")
        );

        panel.add(levelBox);

        int result =
            JOptionPane.showConfirmDialog(
                this,
                panel,
                "⭐ Add Skill",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

        if (
            result !=
            JOptionPane.OK_OPTION
        ) {
            return;
        }

        String skillName =
            skillField.getText().trim();

        if (skillName.isEmpty()) {

            showWarning(
                "Please enter a skill name."
            );

            return;
        }

        String level =
            (String)
            levelBox.getSelectedItem();

        Main.skills.add(
            new Skill(
                student.studentId,
                skillName,
                level
            )
        );

        Main.saveData();
        updateDashboard();

        showSuccess(
            "Skill added successfully!"
        );
    }

    void addInternship() {

        Student student =
            chooseStudent();

        if (student == null) {
            return;
        }

        JTextField companyField =
            new JTextField();

        JTextField roleField =
            new JTextField();

        JTextField durationField =
            new JTextField();

        String[] statuses = {
            "Applied",
            "Shortlisted",
            "Interview",
            "Selected",
            "Rejected"
        };

        JComboBox<String> statusBox =
            new JComboBox<>(statuses);

        JPanel panel =
            createFormPanel();

        panel.add(
            createLabel("Company:")
        );
        panel.add(companyField);

        panel.add(
            createLabel("Role:")
        );
        panel.add(roleField);

        panel.add(
            createLabel("Status:")
        );
        panel.add(statusBox);

        panel.add(
            createLabel("Duration (months):")
        );
        panel.add(durationField);

        int result =
            JOptionPane.showConfirmDialog(
                this,
                panel,
                "💼 Add Internship",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

        if (
            result !=
            JOptionPane.OK_OPTION
        ) {
            return;
        }

        try {

            String company =
                companyField.getText().trim();

            String role =
                roleField.getText().trim();

            String status =
                (String)
                statusBox.getSelectedItem();

            int duration =
                Integer.parseInt(
                    durationField
                        .getText()
                        .trim()
                );

            if (
                company.isEmpty() ||
                role.isEmpty() ||
                duration <= 0
            ) {

                showWarning(
                    "Please enter valid internship details."
                );

                return;
            }

            Main.internships.add(
                new Internship(
                    student.studentId,
                    company,
                    role,
                    status,
                    duration
                )
            );

            Main.saveData();
            updateDashboard();

            showSuccess(
                "Internship added successfully!"
            );

        } catch (
            NumberFormatException e
        ) {

            showWarning(
                "Duration must be a number."
            );
        }
    }

    void viewStudents() {

        if (Main.students.isEmpty()) {

            showMessage(
                "No students available."
            );

            return;
        }

        StringBuilder text =
            new StringBuilder();

        text.append(
            "================ STUDENTS ================\n\n"
        );

        for (
            Student student :
            Main.students
        ) {

            int skillCount = 0;
            int internshipCount = 0;

            for (
                Skill skill :
                Main.skills
            ) {

                if (
                    skill.studentId ==
                    student.studentId
                ) {
                    skillCount++;
                }
            }

            for (
                Internship internship :
                Main.internships
            ) {

                if (
                    internship.studentId ==
                    student.studentId
                ) {
                    internshipCount++;
                }
            }

            text.append(
                "ID          : "
            ).append(
                student.studentId
            ).append("\n");

            text.append(
                "Name        : "
            ).append(
                student.name
            ).append("\n");

            text.append(
                "Email       : "
            ).append(
                student.email
            ).append("\n");

            text.append(
                "Department  : "
            ).append(
                student.department
            ).append("\n");

            text.append(
                "Skills      : "
            ).append(
                skillCount
            ).append("\n");

            text.append(
                "Internships : "
            ).append(
                internshipCount
            ).append("\n");

            text.append(
                "--------------------------------------------\n"
            );
        }

        showTextWindow(
            "👨‍🎓 View Students",
            text.toString()
        );
    }

    void viewSkills() {

        if (Main.skills.isEmpty()) {

            showMessage(
                "No skills available."
            );

            return;
        }

        StringBuilder text =
            new StringBuilder();

        text.append(
            "================ SKILLS ================\n\n"
        );

        for (
            Skill skill :
            Main.skills
        ) {

            Student student =
                Main.findStudentById(
                    skill.studentId
                );

            String studentName =
                student == null
                ? "Unknown"
                : student.name;

            text.append(
                "Student : "
            ).append(
                studentName
            ).append("\n");

            text.append(
                "Skill   : "
            ).append(
                skill.skillName
            ).append("\n");

            text.append(
                "Level   : "
            ).append(
                skill.skillLevel
            ).append("\n");

            text.append(
                "------------------------------------------\n"
            );
        }

        showTextWindow(
            "⭐ View Skills",
            text.toString()
        );
    }

    void viewInternships() {

        if (
            Main.internships.isEmpty()
        ) {

            showMessage(
                "No internships available."
            );

            return;
        }

        StringBuilder text =
            new StringBuilder();

        text.append(
            "================ INTERNSHIPS ================\n\n"
        );

        for (
            Internship internship :
            Main.internships
        ) {

            Student student =
                Main.findStudentById(
                    internship.studentId
                );

            String studentName =
                student == null
                ? "Unknown"
                : student.name;

            text.append(
                "Student  : "
            ).append(
                studentName
            ).append("\n");

            text.append(
                "Company  : "
            ).append(
                internship.companyName
            ).append("\n");

            text.append(
                "Role     : "
            ).append(
                internship.role
            ).append("\n");

            text.append(
                "Status   : "
            ).append(
                internship.status
            ).append("\n");

            text.append(
                "Duration : "
            ).append(
                internship.duration
            ).append(
                " months\n"
            );

            text.append(
                "----------------------------------------------\n"
            );
        }

        showTextWindow(
            "💼 View Internships",
            text.toString()
        );
    }

    void searchStudent() {

        Student student =
            chooseStudent();

        if (student == null) {
            return;
        }

        StringBuilder text =
            new StringBuilder();

        text.append(
            "========== STUDENT SEARCH RESULT ==========\n\n"
        );

        text.append(
            "Student ID : "
        ).append(
            student.studentId
        ).append("\n");

        text.append(
            "Name       : "
        ).append(
            student.name
        ).append("\n");

        text.append(
            "Email      : "
        ).append(
            student.email
        ).append("\n");

        text.append(
            "Department : "
        ).append(
            student.department
        ).append("\n\n");

        text.append(
            "SKILLS\n"
        );

        text.append(
            "------------------------------------\n"
        );

        boolean hasSkill = false;

        for (
            Skill skill :
            Main.skills
        ) {

            if (
                skill.studentId ==
                student.studentId
            ) {

                hasSkill = true;

                text.append(
                    "• "
                ).append(
                    skill.skillName
                ).append(
                    " - "
                ).append(
                    skill.skillLevel
                ).append("\n");
            }
        }

        if (!hasSkill) {

            text.append(
                "No skills added.\n"
            );
        }

        text.append(
            "\nINTERNSHIPS\n"
        );

        text.append(
            "------------------------------------\n"
        );

        boolean hasInternship = false;

        for (
            Internship internship :
            Main.internships
        ) {

            if (
                internship.studentId ==
                student.studentId
            ) {

                hasInternship = true;

                text.append(
                    "• "
                ).append(
                    internship.companyName
                ).append(
                    " - "
                ).append(
                    internship.role
                ).append(
                    " - "
                ).append(
                    internship.status
                ).append("\n");
            }
        }

        if (!hasInternship) {

            text.append(
                "No internships added.\n"
            );
        }

        showTextWindow(
            "🔎 Search Student",
            text.toString()
        );
    }

    void updateInternship() {

        if (
            Main.internships.isEmpty()
        ) {

            showMessage(
                "No internships available."
            );

            return;
        }

        String[] options =
            new String[
                Main.internships.size()
            ];

        for (
            int i = 0;
            i < Main.internships.size();
            i++
        ) {

            Internship internship =
                Main.internships.get(i);

            Student student =
                Main.findStudentById(
                    internship.studentId
                );

            String studentName =
                student == null
                ? "Unknown"
                : student.name;

            options[i] =
                studentName +
                " - " +
                internship.companyName +
                " - " +
                internship.role;
        }

        String selected =
            (String)
            JOptionPane.showInputDialog(
                this,
                "Select Internship:",
                "Update Internship",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

        if (selected == null) {
            return;
        }

        int index = 0;

        for (
            int i = 0;
            i < options.length;
            i++
        ) {

            if (
                options[i].equals(
                    selected
                )
            ) {

                index = i;
                break;
            }
        }

        Internship internship =
            Main.internships.get(index);

        String[] statuses = {
            "Applied",
            "Shortlisted",
            "Interview",
            "Selected",
            "Rejected"
        };

        String newStatus =
            (String)
            JOptionPane.showInputDialog(
                this,
                "Select new status:",
                "Update Status",
                JOptionPane.QUESTION_MESSAGE,
                null,
                statuses,
                internship.status
            );

        if (newStatus == null) {
            return;
        }

        internship.status = newStatus;

        Main.saveData();

        showSuccess(
            "Internship status updated successfully!"
        );
    }

    void progressReport() {

        Student student =
            chooseStudent();

        if (student == null) {
            return;
        }

        int skillCount = 0;
        int internshipCount = 0;
        int selectedCount = 0;

        StringBuilder text =
            new StringBuilder();

        text.append(
            "========== PROGRESS REPORT ==========\n\n"
        );

        text.append(
            "Student ID : "
        ).append(
            student.studentId
        ).append("\n");

        text.append(
            "Name       : "
        ).append(
            student.name
        ).append("\n");

        text.append(
            "Department : "
        ).append(
            student.department
        ).append("\n\n");

        text.append(
            "SKILLS\n"
        );

        text.append(
            "--------------------------------------\n"
        );

        for (
            Skill skill :
            Main.skills
        ) {

            if (
                skill.studentId ==
                student.studentId
            ) {

                skillCount++;

                text.append(
                    "• "
                ).append(
                    skill.skillName
                ).append(
                    " : "
                ).append(
                    skill.skillLevel
                ).append("\n");
            }
        }

        if (skillCount == 0) {

            text.append(
                "No skills added.\n"
            );
        }

        text.append(
            "\nINTERNSHIPS\n"
        );

        text.append(
            "--------------------------------------\n"
        );

        for (
            Internship internship :
            Main.internships
        ) {

            if (
                internship.studentId ==
                student.studentId
            ) {

                internshipCount++;

                if (
                    internship.status.equals(
                        "Selected"
                    )
                ) {

                    selectedCount++;
                }

                text.append(
                    "• "
                ).append(
                    internship.companyName
                ).append(
                    " | "
                ).append(
                    internship.role
                ).append(
                    " | "
                ).append(
                    internship.status
                ).append("\n");
            }
        }

        if (
            internshipCount == 0
        ) {

            text.append(
                "No internships added.\n"
            );
        }

        text.append(
            "\nSUMMARY\n"
        );

        text.append(
            "--------------------------------------\n"
        );

        text.append(
            "Total Skills        : "
        ).append(
            skillCount
        ).append("\n");

        text.append(
            "Total Internships   : "
        ).append(
            internshipCount
        ).append("\n");

        text.append(
            "Selected Internships: "
        ).append(
            selectedCount
        ).append("\n");

        showTextWindow(
            "📈 Progress Report",
            text.toString()
        );
    }

    void studentProfile() {

        Student student =
            chooseStudent();

        if (student == null) {
            return;
        }

        int skillCount = 0;
        int internshipCount = 0;

        for (
            Skill skill :
            Main.skills
        ) {

            if (
                skill.studentId ==
                student.studentId
            ) {

                skillCount++;
            }
        }

        for (
            Internship internship :
            Main.internships
        ) {

            if (
                internship.studentId ==
                student.studentId
            ) {

                internshipCount++;
            }
        }

        String text =
            "========== STUDENT PROFILE ==========\n\n" +

            "🎓 Student ID\n" +
            student.studentId +
            "\n\n" +

            "👤 Name\n" +
            student.name +
            "\n\n" +

            "📧 Email\n" +
            student.email +
            "\n\n" +

            "🏫 Department\n" +
            student.department +
            "\n\n" +

            "⭐ Total Skills\n" +
            skillCount +
            "\n\n" +

            "💼 Total Internships\n" +
            internshipCount;

        showTextWindow(
            "👤 Student Profile",
            text
        );
    }

    void linkedRecords() {

        Student student =
            chooseStudent();

        if (student == null) {
            return;
        }

        StringBuilder text =
            new StringBuilder();

        text.append(
            "========== LINKED RECORDS ==========\n\n"
        );

        text.append(
            "Student : "
        ).append(
            student.name
        ).append("\n");

        text.append(
            "Student ID : "
        ).append(
            student.studentId
        ).append("\n\n");

        text.append(
            "⭐ LINKED SKILLS\n"
        );

        text.append(
            "--------------------------------------\n"
        );

        boolean skillFound = false;

        for (
            Skill skill :
            Main.skills
        ) {

            if (
                skill.studentId ==
                student.studentId
            ) {

                skillFound = true;

                text.append(
                    "• "
                ).append(
                    skill.skillName
                ).append(
                    " - "
                ).append(
                    skill.skillLevel
                ).append("\n");
            }
        }

        if (!skillFound) {

            text.append(
                "No linked skills.\n"
            );
        }

        text.append(
            "\n💼 LINKED INTERNSHIPS\n"
        );

        text.append(
            "--------------------------------------\n"
        );

        boolean internshipFound = false;

        for (
            Internship internship :
            Main.internships
        ) {

            if (
                internship.studentId ==
                student.studentId
            ) {

                internshipFound = true;

                text.append(
                    "• "
                ).append(
                    internship.companyName
                ).append(
                    " - "
                ).append(
                    internship.role
                ).append(
                    " - "
                ).append(
                    internship.status
                ).append("\n");
            }
        }

        if (!internshipFound) {

            text.append(
                "No linked internships.\n"
            );
        }

        showTextWindow(
            "🔗 Linked Records",
            text.toString()
        );
    }

    void deleteRecord() {

        String[] options = {
            "Delete Student",
            "Delete Skill",
            "Delete Internship"
        };

        String choice =
            (String)
            JOptionPane.showInputDialog(
                this,
                "What do you want to delete?",
                "Delete Record",
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]
            );

        if (choice == null) {
            return;
        }

        if (
            choice.equals(
                "Delete Student"
            )
        ) {

            deleteStudent();

        } else if (
            choice.equals(
                "Delete Skill"
            )
        ) {

            deleteSkill();

        } else {

            deleteInternship();
        }
    }

    void deleteStudent() {

        Student student =
            chooseStudent();

        if (student == null) {
            return;
        }

        int confirm =
            JOptionPane.showConfirmDialog(
                this,
                "Delete " +
                student.name +
                " and all linked records?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

        if (
            confirm !=
            JOptionPane.YES_OPTION
        ) {
            return;
        }

        Main.students.remove(student);

        Main.skills.removeIf(
            skill ->
                skill.studentId ==
                student.studentId
        );

        Main.internships.removeIf(
            internship ->
                internship.studentId ==
                student.studentId
        );

        Main.saveData();
        updateDashboard();

        showSuccess(
            "Student and linked records deleted."
        );
    }

    void deleteSkill() {

        if (Main.skills.isEmpty()) {

            showMessage(
                "No skills available."
            );

            return;
        }

        String[] options =
            new String[
                Main.skills.size()
            ];

        for (
            int i = 0;
            i < Main.skills.size();
            i++
        ) {

            Skill skill =
                Main.skills.get(i);

            Student student =
                Main.findStudentById(
                    skill.studentId
                );

            String studentName =
                student == null
                ? "Unknown"
                : student.name;

            options[i] =
                studentName +
                " - " +
                skill.skillName;
        }

        String selected =
            (String)
            JOptionPane.showInputDialog(
                this,
                "Select Skill:",
                "Delete Skill",
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]
            );

        if (selected == null) {
            return;
        }

        int index = 0;

        for (
            int i = 0;
            i < options.length;
            i++
        ) {

            if (
                options[i].equals(
                    selected
                )
            ) {

                index = i;
                break;
            }
        }

        Main.skills.remove(index);

        Main.saveData();
        updateDashboard();

        showSuccess(
            "Skill deleted successfully!"
        );
    }

    void deleteInternship() {

        if (
            Main.internships.isEmpty()
        ) {

            showMessage(
                "No internships available."
            );

            return;
        }

        String[] options =
            new String[
                Main.internships.size()
            ];

        for (
            int i = 0;
            i < Main.internships.size();
            i++
        ) {

            Internship internship =
                Main.internships.get(i);

            Student student =
                Main.findStudentById(
                    internship.studentId
                );

            String studentName =
                student == null
                ? "Unknown"
                : student.name;

            options[i] =
                studentName +
                " - " +
                internship.companyName +
                " - " +
                internship.role;
        }

        String selected =
            (String)
            JOptionPane.showInputDialog(
                this,
                "Select Internship:",
                "Delete Internship",
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]
            );

        if (selected == null) {
            return;
        }

        int index = 0;

        for (
            int i = 0;
            i < options.length;
            i++
        ) {

            if (
                options[i].equals(
                    selected
                )
            ) {

                index = i;
                break;
            }
        }

        Main.internships.remove(index);

        Main.saveData();
        updateDashboard();

        showSuccess(
            "Internship deleted successfully!"
        );
    }

    void saveData() {

        Main.saveData();

        showSuccess(
            "All data saved successfully!"
        );
    }

    void showAbout() {

        String message =
            "🎓 STUDENT SKILL & INTERNSHIP TRACKER\n\n" +

            "A Java-based student career management system.\n\n" +

            "FEATURES\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
            "👨‍🎓 Student Management\n" +
            "⭐ Skill Tracking\n" +
            "💼 Internship Tracking\n" +
            "📈 Progress Reports\n" +
            "👤 Student Profiles\n" +
            "🔗 Linked Records\n" +
            "💾 Data Persistence\n\n" +

            "Developed using Java Swing.";

        JOptionPane.showMessageDialog(
            this,
            message,
            "About Application",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    void exitApplication() {

        int result =
            JOptionPane.showConfirmDialog(
                this,
                "Do you want to exit the application?",
                "Exit Application",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

        if (
            result ==
            JOptionPane.YES_OPTION
        ) {

            Main.saveData();

            System.exit(0);
        }
    }

    JPanel createFormPanel() {

        JPanel panel =
            new JPanel(
                new GridLayout(
                    0,
                    2,
                    12,
                    12
                )
            );

        panel.setBorder(
            new EmptyBorder(
                10,
                10,
                10,
                10
            )
        );

        return panel;
    }

    JLabel createLabel(String text) {

        JLabel label =
            new JLabel(text);

        label.setFont(
            new Font(
                "Segoe UI",
                Font.BOLD,
                14
            )
        );

        return label;
    }

    void showSuccess(String message) {

        JOptionPane.showMessageDialog(
            this,
            message,
            "Success",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    void showWarning(String message) {

        JOptionPane.showMessageDialog(
            this,
            message,
            "Warning",
            JOptionPane.WARNING_MESSAGE
        );
    }

    void showMessage(String message) {

        JOptionPane.showMessageDialog(
            this,
            message,
            "Information",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    void showTextWindow(
        String title,
        String content
    ) {

        JTextArea textArea =
            new JTextArea(content);

        textArea.setFont(
            new Font(
                "Consolas",
                Font.PLAIN,
                14
            )
        );

        textArea.setEditable(false);
        textArea.setLineWrap(false);

        textArea.setBackground(
            new Color(248, 250, 253)
        );

        textArea.setBorder(
            new EmptyBorder(
                15,
                15,
                15,
                15
            )
        );

        JScrollPane scrollPane =
            new JScrollPane(textArea);

        scrollPane.setPreferredSize(
            new Dimension(
                800,
                520
            )
        );

        JOptionPane.showMessageDialog(
            this,
            scrollPane,
            title,
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {

        Main.loadData();

        SwingUtilities.invokeLater(
            () -> new TrackerGUI()
        );
    }
}

