package nl.YEA.TempFolder;

import jakarta.persistence.*;

@Table(name = "Test")
@Entity
public class TempTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name ;
    String gender;

    public TempTest(){}

    public TempTest(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
