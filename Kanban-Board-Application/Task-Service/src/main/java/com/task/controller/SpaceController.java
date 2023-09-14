package com.task.controller;

import com.task.exception.SpaceNotFoundException;
import com.task.model.Space;
import com.task.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/space")
//@CrossOrigin(origins = "http://localhost:4200")
public class SpaceController {

    @Autowired
    SpaceService spaceService;


    @PostMapping("/createspace")
    public ResponseEntity<?> createSpace(@RequestBody Space space) throws SpaceNotFoundException{
        System.out.println("inside create Space method");
        return new ResponseEntity<>(spaceService.createSpace(space), HttpStatus.CREATED);
    }


    @GetMapping("/getSpacesByEmail/{email}")
    public ResponseEntity<?> getAllSpaceByEmail(@PathVariable String email) {
        return new ResponseEntity<>(spaceService.getAllSpacesByEmail(email), HttpStatus.OK);

    }

    @GetMapping("/getAllSpace")
    public ResponseEntity<List<Space>> getAllSpace(){
        return new ResponseEntity<List<Space>>(spaceService.getAllSpace(),HttpStatus.OK);
    }


    @DeleteMapping("/delete/{spaceName}")
    public ResponseEntity<String> deleteByIdAndEmail(@PathVariable String spaceName) throws SpaceNotFoundException {
        System.out.println(" inside deleteByIdAndEmail");
        return new ResponseEntity<>(spaceService.deleteByIdAndEmail(spaceName),HttpStatus.OK);
    }








//    @DeleteMapping("/delete/{email}/{spaceName}")
//    @DeleteMapping("/delete/{spaceName}")
//    public ResponseEntity<String> deleteByIdAndEmail(@PathVariable String email,@PathVariable String spaceName) throws SpaceNotFoundException {
//        System.out.println(" inside deleteByIdAndEmail");
//        return new ResponseEntity<>(spaceService.deleteByIdAndEmail(email,spaceName),HttpStatus.OK);
//    }


//    @PutMapping
//    public ResponseEntity<?> updateSpaceName(@PathVariable String email,@PathVariable String spaceName ){
//        return new ResponseEntity<>(spaceService.updateSpaceName(email,spaceName),HttpStatus.CREATED);
//    }





}