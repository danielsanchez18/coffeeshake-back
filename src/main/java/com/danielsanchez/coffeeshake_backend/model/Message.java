package com.danielsanchez.coffeeshake_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idMessage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sender", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receiver", nullable = false)
    private User receiver;

    private String content;
    private LocalDateTime sentDate;
    private boolean revised;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chat", nullable = false)
    private Chat chat;

    public Message() { }

    public Message(UUID idMessage, User sender, User receiver, String content, LocalDateTime sentDate, boolean revised, Chat chat) {
        this.idMessage = idMessage;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.sentDate = sentDate;
        this.revised = revised;
        this.chat = chat;
    }

    public UUID getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(UUID idMessage) {
        this.idMessage = idMessage;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public boolean isRevised() {
        return revised;
    }

    public void setRevised(boolean revised) {
        this.revised = revised;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
