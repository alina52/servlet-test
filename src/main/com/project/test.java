import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class test {
    public static void main(String[] args) {
        FoodEntity food = new FoodEntity(0, "apple", 3, "fruit", 3);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(food);
//            JavaType javaType = mapper.getTypeFactory()
            System.out.println(json);
            food = mapper.readValue(json, FoodEntity.class);
            System.out.println("yes");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
