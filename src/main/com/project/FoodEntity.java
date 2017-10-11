class FoodEntity {
    public long id;
    public String name, category;
    public int calorie;
    public double weight;

    FoodEntity () {}

    FoodEntity (long id, String name, double weight, String category, int calorie) {
        this(name, weight, category, calorie);
        setId(id);
    }

    FoodEntity (String name, double weight, String category, int calorie) {
        this.name = name;
        this.weight = weight;
        this.category = category;
        this.calorie = calorie;
    }

    public long getId () { return this.id; }
    public void setId (long id) { this.id = id; }

    public String getName () { return this.name; }
    public void setName (String name) { this.name = name; }

    public String getCategory () { return this.category;}
    public void setCategory (String category) { this.category = category; }

    public double getWeight () { return this.weight; }
    public void setWeight (double weight) { this.weight = weight; }

    public int getCalorie () { return this.calorie; }
    public void setCalorie (int calorie) { this.calorie = calorie; }

    @Override
    public String toString() {
        return "Food { " +
                "name = '" + name + '\'' +
                ", category = " + category +
                ", calorie = '" + calorie + '\'' +
                '}';
    }
}
