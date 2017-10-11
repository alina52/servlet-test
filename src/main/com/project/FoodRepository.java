import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FoodRepository {
    private List<FoodEntity> foods;

    FoodRepository () {
        this.read();
    }

    void add (FoodEntity food) {
        Integer id = foods.size();
        food.setId(id);
        foods.add(food);
    }

    void save () {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String fileName = "/Users/alina/Documents/food.json";
            mapper.writeValue(new File(fileName), foods.getClass());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read () {
        try {
            String fileName = "/Users/alina/Documents/food.json";
//            File file = new File(fileName);
//            Long filelength = file.length();
//            byte[] filecontent = new byte[filelength.intValue()];
//
//            FileInputStream in = new FileInputStream(file);
//            in.read(filecontent);
//            in.close();
//
//            String content = new String(filecontent, "UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, FoodEntity.class);
            foods =  mapper.readValue(new File(fileName), javaType);

            for (FoodEntity food : foods) {
                System.out.println(food.getId() + " " + food.getName());
            }
        } catch (IOException e) {
            foods = new ArrayList<FoodEntity>();
        }
    }
}
