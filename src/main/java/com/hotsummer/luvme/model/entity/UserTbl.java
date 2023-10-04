package com.hotsummer.luvme.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UserTbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserTbl {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "email")
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "status")
    private String status;
    @Column(name = "birth_day")
    private Date birthDay;
    @Column(name = "bank_account")
    private String bankAccount;
    @Column(name = "is_premium")
    private Boolean isPremium;
    @Column(name = "start_premium_date")
    private Date startPremiumDate;
    @Column(name = "end_premium_date")
    private Date endPremiumDate;
    @Column(name = "is_test")
    private Boolean isTest;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TestHistory> testHistories;
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Routing> routings;
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transactions> transactions;
    @OneToMany(mappedBy = "userAct", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Favorite> favorites;
}
