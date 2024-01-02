private void displayWatchlist() {
        JFrame watchlistFrame = new JFrame("Watchlist");
        watchlistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        watchlistFrame.setSize(400, 300);
        watchlistFrame.setLayout(new BorderLayout());

        JPanel watchlistPanel = new JPanel(new BorderLayout());

        watchlistDisplayArea = new JTextArea();
        watchlistDisplayArea.setEditable(false);
        JScrollPane watchlistScrollPane = new JScrollPane(watchlistDisplayArea);

        JButton removeFromWatchlistButton = new JButton("Remove from Watchlist");
        removeFromWatchlistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = watchlistDisplayArea.getSelectedIndex();
                if (selectedIndex != -1) {
                    Movie selectedMovie = userWatchlist.getMoviesToWatch().get(selectedIndex);
                    userWatchlist.removeMovieFromWatchlist(selectedMovie);
                    refreshWatchlistDisplay();
                }
            }
        });