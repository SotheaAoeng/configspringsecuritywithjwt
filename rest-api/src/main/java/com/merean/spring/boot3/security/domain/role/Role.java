package com.merean.spring.boot3.security.domain.role;

import com.merean.spring.boot3.security.enums.YesOrNo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    @Column(name = "ACTV_YN", length = 1, nullable = false)
    @Convert(converter = YesOrNo.Converter.class)
    @ColumnDefault("'Y'")
    private YesOrNo activeYN;

    @Builder
    public Role(Long id, String roleName, YesOrNo activeYN) {
        this.id = id;
        this.roleName = roleName;
        this.activeYN = activeYN;
    }
}
