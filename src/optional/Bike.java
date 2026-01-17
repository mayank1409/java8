package optional;

import java.util.StringJoiner;

/**
 * Bike POJO representing a vehicle with name and model.
 * Used in Optional demonstrations to show handling of null values.
 */
public class Bike {

    private String name;
    private String model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bike.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("model='" + model + "'")
                .toString();
    }
}
