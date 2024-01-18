package com.merean.spring.boot3.security.domain.user;

import com.merean.spring.boot3.security.enums.YesOrNo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;

    @Column(name = "user_password", length = 150, nullable = false)
    private String userPassword;

    @Column(name = "user_email", length = 100, nullable = false)
    private String userEmail;

    @Column(name = "user_address", length = 500, nullable = false)
    private String userAddress;

    @Column(name = "phone_number", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "user_roles", length = 50)
    private String userRoles;

    @Column(name = "user_image", length = 500)
    private String userImage;

    @Column(name = "del_yn", length = 1)
    @Convert(converter = YesOrNo.Converter.class)
    private YesOrNo deleteYN;

    @Builder
    public User(Long id, String userId, String userName, String userPassword, String userEmail, String userAddress, String phoneNumber, String userRoles, String userImage, YesOrNo deleteYN) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.phoneNumber = phoneNumber;
        this.userRoles = userRoles;
        this.userImage = userImage;
        this.deleteYN = deleteYN;
    }
}
