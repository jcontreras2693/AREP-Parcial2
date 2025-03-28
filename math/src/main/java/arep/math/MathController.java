package arep.math;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/lucasseq")
@CrossOrigin("*")
public class MathController {

    @GetMapping
    public String lucas(@RequestParam("value") String value){
        List<Integer> values = new ArrayList<>();

        int target = Integer.valueOf(value);

        for(int i = 0; i < target + 1; i++){
            if(i == 0){
                values.add(2);
            } else if (i == 1) {
                values.add(1);
            } else{
                values.add(values.get(i - 1) + values.get(i - 2));
            }
        }

        return values.toString();
    }

}
