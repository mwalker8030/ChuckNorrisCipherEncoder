class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle(){
        return title;
    }

    public void setTitle(String t){
        title = t;
    }

    public int getYearOfPublishing(){
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int y){
        yearOfPublishing = y;
    }

    public String[] getAuthors(){
        return authors;
    }

    public void setAuthors(String[] a){
        authors = a;
    }
}