package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CvJobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvJobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobExperiences")
public class CvJobExperienceController {
    private CvJobExperienceService cvJobExperienceService;

    @Autowired
    public CvJobExperienceController(CvJobExperienceService cvJobExperienceService) {
        this.cvJobExperienceService = cvJobExperienceService;
    }
    @GetMapping("/getAll")
    public DataResult<List<CvJobExperience>> getAll(){
        return this.cvJobExperienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CvJobExperience cvJobExperience){

        return this.cvJobExperienceService.add(cvJobExperience);
    }
    @PostMapping("/delete")
    public Result delete(CvJobExperience cvJobExperience){

        return this.cvJobExperienceService.delete(cvJobExperience);
    }

    @PostMapping("/update")
    public Result update(CvJobExperience cvJobExperience){

        return this.cvJobExperienceService.update(cvJobExperience);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors=new HashMap<>();

        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> error=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hatası");

        return error;
    }

}
