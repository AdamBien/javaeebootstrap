package com.airhacks.di.presentation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author airhacks.com
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {

    @Id
    @GeneratedValue
    @XmlTransient
    private long id;

    @Size(min = 3, max = 6)
    private String content;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", content=" + content + '}';
    }

}
