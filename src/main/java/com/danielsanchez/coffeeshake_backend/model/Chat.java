package com.danielsanchez.coffeeshake_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idChat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user1", nullable = false)
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user2", nullable = false)
    private User user2;

    private LocalDateTime lastMessageDate;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private Set<Message> messages = new HashSet<>();

    public Chat() { }

    public Chat(UUID idChat, User user1, User user2, LocalDateTime lastMessageDate, Set<Message> messages) {
        this.idChat = idChat;
        this.user1 = user1;
        this.user2 = user2;
        this.lastMessageDate = lastMessageDate;
        this.messages = messages;
    }

    public UUID getIdChat() {
        return idChat;
    }

    public void setIdChat(UUID idChat) {
        this.idChat = idChat;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public LocalDateTime getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(LocalDateTime lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
