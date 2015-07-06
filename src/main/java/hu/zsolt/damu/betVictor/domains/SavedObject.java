package hu.zsolt.damu.betVictor.domains;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by TamasZsolt on 30/06/2015.
 */

@Entity
public class SavedObject implements GenericDomain, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date insertDate = new Date();

    private String comment;

    public SavedObject() {}

    public SavedObject(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "SavedObject{" +
                "id: " + id+
                ", insertDate=" + insertDate +
                ", comment='" + comment + '\'' +
                '}';
    }
}
