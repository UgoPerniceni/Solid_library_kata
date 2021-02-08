package fr.esgi.model;

public class Book {
    private String title;
    private Author authorName;

    // Add default constructor for Jackson (JSON)
    public Book() {}

    public Book(String title, Author authorName) {
        this.title = title;
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthorName() {
        return authorName;
    }

    public void setAuthorName(Author authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Book) {
            Book bookInput = (Book) object;

            return this.getTitle().equals((bookInput.getTitle()));
        }

        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName=" + authorName +
                '}';
    }
}
