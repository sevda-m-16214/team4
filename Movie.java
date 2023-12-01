public class Movie {
    private String title;
    private String director;
    private int releaseYear;
    private int runningTime; 

    
    public Movie(String title, String director, int releaseYear, int runningTime) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.runningTime = runningTime;
    }

    //git test
    public String getTitle() {
        return title;
    }

    public String getdirector() {
        return director;
    }

    public int getreleaseYear() {
        return releaseYear;
    }

    public int getrunningTime() {
        return runningTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setreleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setrunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    @Override
    public String toString() {
        return "Movie: " + title + "\nDirector: " + director + "\nRelease Year: " + releaseYear + "\nRunning Time: " + runningTime + " minutes";
    }
}
