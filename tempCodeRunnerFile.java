private void displayLoginRegisterWindow() {
        JFrame loginRegisterFrame = new JFrame("Login/Register");
        loginRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginRegisterFrame.setSize(300, 400);
        loginRegisterFrame.setLayout(new GridLayout(3, 1));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Color.decode("#A365AD"));
        JLabel titleLabel = new JLabel("Movie Database App");
        titleLabel.setForeground(Color.WHITE); // Set text color for the title
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        loginRegisterFrame.add(titlePanel, BorderLayout.NORTH);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        loginPanel.setBackground(Color.decode("#8BA443"));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.setForeground(Color.WHITE);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100,5));
        loginButton.setOpaque(true);
        loginButton.setBackground(Color.decode("#A365AD"));
        loginButton.setBorderPainted(false);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("example") && password.equals("password")) {
                    isLoggedIn = true;
                    loginRegisterFrame.dispose();
                    openMovieActionsWindow();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
            
        });
