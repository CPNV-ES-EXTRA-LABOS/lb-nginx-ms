package ch.cpnv.tasks.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    private @Id @GeneratedValue Long id;
    private String description;
    private boolean completed;

    public Task() {}
    public Task(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setId(long id) { this.id = id; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }
}
