package models;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 *  To-Do
 *
 * Created by ben-hx on 01.05.2016.
 */
public class ToDo {

    private String subject;
    private String content;

    public ToDo() {
    }

    /**
     * Value Constructor
     * @param subject subject
     * @param content content
     */
    public ToDo(String subject, String content) throws InvalidArgumentException {
        if(subject == null || subject.length() == 0)
            throw new InvalidArgumentException(new String[]{"The subject must not be empty"});

        if(content == null || content.length() == 0)
            throw new InvalidArgumentException(new String[]{"The content must not be empty"});

        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDo toDo = (ToDo) o;

        if (subject != null ? !subject.equals(toDo.subject) : toDo.subject != null) return false;
        return content != null ? content.equals(toDo.content) : toDo.content == null;

    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
