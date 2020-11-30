package annotation;


public class Person {

    @MyAnnotation(name = "nesty")
    private String name;
    @MyAnnotation(name = "nesty")
    private String soname;
    private int age;

    public Person(String name, String soname, int age) {
        this.name = name;
        this.soname = soname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person name : " + name + ", soname : " + soname + ", age : " + age + ';';
    }
}
