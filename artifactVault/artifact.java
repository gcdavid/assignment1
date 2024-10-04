class Artifact {
    private String name;
    private int age;

    public Artifact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Artifact{name='" + name + "', age=" + age + "}";
    }
}
