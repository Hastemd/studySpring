package basic.java8;

import java.util.*;

/**
 * list去除重复项
 *
 * @author lijie
 * @date 2022/3/19 17:01
 */
public class RemoveDuplicate {

    public static void main(String[] args) {
        PersonEntity p1 = new PersonEntity(1l, "jack");
        PersonEntity p2 = new PersonEntity(3l, "jack chou");
        PersonEntity p3 = new PersonEntity(2l, "tom");
        PersonEntity p4 = new PersonEntity(4l, "hanson");
        PersonEntity p5 = new PersonEntity(5l, "胶布虫");

        List<PersonEntity> persons = Arrays.asList(p1, p2, p3, p4, p5, p5, p1, p2, p2);
        List<PersonEntity> personEntities = removeDupliById(persons);
        System.out.println(personEntities);


    }









    public static List<PersonEntity> removeDupliById(List<PersonEntity> persons) {
        //Set<PersonEntity> personSet = new TreeSet<>((o1, o2) -> o1.getId().compareTo(o2.getId()));
        Set<PersonEntity> personSet = new TreeSet<>(Comparator.comparing(PersonEntity::getId));
        personSet.addAll(persons);
        return new ArrayList<>(personSet);
    }

    public static List<PersonEntity> removeDupliByIdJava8(List<PersonEntity> persons) {
        //List<PersonEntity> unique = persons.stream().collect(
        //        collectingAndThen(
        //                toCollection(() -> new TreeSet<>(comparingLong(Person::getId))), ArrayList::new)
        //);
        //return unique;
        return null;
    }

}


class PersonEntity {
    private Long id;

    private String name;

    public PersonEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity PersonEntity= (PersonEntity) o;

        if (!id.equals(PersonEntity.getId())) return false;
        return name.equals(PersonEntity.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}