/*
package com.github.tanveerprottoy.starterspringboot.modules.users.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

*/
/* Be careful when using Lombok with JPA
 * Avoid using @EqualsAndHashCode and @Data with JPA entities;
 * Always exclude lazy attributes when using @ToString;
 * Don’t forget to add @NoArgsConstructor to entities with
 * @Builder or @AllArgsConstructor.
 *//*

@Entity(name = "users")
public class UserLombok {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected UserLombok() {
    }

    public UserLombok(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
*/
