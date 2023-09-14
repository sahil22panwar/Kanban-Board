package com.task.service;

import com.task.exception.SpaceNotFoundException;
import com.task.model.Notification;
import com.task.model.Space;
import com.task.proxy.UserProxy;
import com.task.repository.SpaceRepository;
import com.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceService {
    @Autowired
    SpaceRepository spaceRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserProxy userProxy;
    public Space createSpace(Space space) throws SpaceNotFoundException{

        List<String> emailList = space.getEmail();
        Notification notification = new Notification();

        for (String s:emailList){
            notification.setSpaceName(space.getSpaceName());
            notification.setEmail(s);
            notification.setCreaterName(space.getEmail().get(0));
            userProxy.saveNotification(notification);
        }
        emailList.forEach(i-> System.out.println(i));
        return  spaceRepository.save(space);
    }

    //added new
    public List<Space> getAllSpacesByEmail(String email){
        List<Space> list=new ArrayList<>();
        List<Space> spaces=spaceRepository.findAll();
        for(Space s:spaces)
        {
            if(s.getEmail().contains(email))
            {
                list.add(s);
            }
        }
        return list;
    }

    public List<Space> getAllSpace() {
        return spaceRepository.findAll();
    }


    public String deleteByIdAndEmail(String spaceName) throws SpaceNotFoundException {
        Space space = spaceRepository.findBySpaceName(spaceName);
            if (space.getSpaceName().equals(spaceName)){
                System.out.println("******** deleteByIdAndEmail *********");
                spaceRepository.delete(space);
                return "Space Deleted Successfully";
            }

        throw new SpaceNotFoundException("Space Not Found");
    }


}