package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue // sequence값을 씀.
    @Column(name="member_id")
    private Long id;

    private String name;

    @Embedded //내장타입
    private Address address;

    // Member와 order는 일대다 관계
    @OneToMany(mappedBy="member") //order table에 있는 member 필드에 의해서 매핑되었다는 뜻. (즉 매핑된 것일뿐이라는 뜻. 읽기전용. 여기에 값을 넣는다고 해서 foreign키 값이 변경되지 않음. )
    private List<Order> orders = new ArrayList<>();




}
