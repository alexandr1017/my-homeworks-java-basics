package org.example;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Subscriptions")

public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;

    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Course courses;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
