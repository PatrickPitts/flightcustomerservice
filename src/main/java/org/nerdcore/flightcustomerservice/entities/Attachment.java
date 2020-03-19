package org.nerdcore.flightcustomerservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="Attachments")
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    @NotBlank
    private String name;

    @NotBlank
    private String mimeContentType;

    @Size(min=1)
    private byte[] contents;

    public Attachment(Long id, @NotBlank String name, @NotBlank String mimeContentType, @Size(min = 1) byte[] contents) {
        this.attachmentId = id;
        this.name = name;
        this.mimeContentType = mimeContentType;
        this.contents = contents;
    }

    public Attachment() {
    }

    public Long getId() {
        return attachmentId;
    }

    public void setId(Long id) {
        this.attachmentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeContentType() {
        return mimeContentType;
    }

    public void setMimeContentType(String mimeContentType) {
        this.mimeContentType = mimeContentType;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attachment)) return false;
        Attachment that = (Attachment) o;
        return Arrays.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(contents);
    }
}
